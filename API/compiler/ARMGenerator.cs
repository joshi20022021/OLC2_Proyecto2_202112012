using System;
using System.Collections.Generic;
using System.IO;
using System.Text;
using System.Text.RegularExpressions;
namespace API.compiler.ARM64
{
    public class ARM64Generator
    {
        private readonly StringBuilder _code = new StringBuilder();
        private int _labelCounter = 0;
        private Dictionary<string, string> _variables = new Dictionary<string, string>();
        private List<string> _dataSection = new List<string>();
        private Stack<string> _continueLabels = new Stack<string>();
        private Stack<string> _breakLabels = new Stack<string>();

        private string Sanitize(string s) =>
        s?.Replace("\r", "\\r")
        .Replace("\n", "\\n");
        public ARM64Generator()
        {
            _code.AppendLine("// ARM64 Assembly");
            _code.AppendLine(".text");
            _code.AppendLine(".global _start");
            _code.AppendLine("_start:");
        }

        public string Generate(List<EntradaSimbolo> tablaSimbolos, List<NodoAST> nodos)
        {
            _code.AppendLine("    stp x29, x30, [sp, #-16]!");
            _code.AppendLine("    mov x29, sp");
            _code.AppendLine("    sub sp, sp, #512"); 
            
            // Declaraciones de variables
            _code.AppendLine("\n    // Declaraciones de variables");
            _code.AppendLine($"    // Debug: Símbolos en tabla: {tablaSimbolos.Count}");

            foreach (var simbolo in tablaSimbolos)
            {
                _code.AppendLine($"    // Símbolo: '{simbolo.Id}', Tipo: '{simbolo.TipoSimbolo}', Dato: '{simbolo.TipoDato}'");
                if (simbolo.TipoSimbolo.Equals("variable", StringComparison.OrdinalIgnoreCase) || simbolo.TipoDato != null)
                {
                    GenerateVariableDeclaration(simbolo);
                }
            }
            
            // Procesar instrucciones del AST
            _code.AppendLine("\n    // Procesando instrucciones");
            ProcessInstructions(nodos, tablaSimbolos);
            
            return BuildFinalCode();
        }

        private void ProcessInstructions(List<NodoAST> nodos, List<EntradaSimbolo> tablaSimbolos)
        {
            foreach (var nodo in nodos)
            {
                // Depuración
                _code.AppendLine($"\n    // Procesando nodo: {nodo.Tipo}  Valor={nodo.Valor}");

                if (nodo.Tipo == "fmt.Println")
                {
                    var args = nodo.Hijos?.Where(h => h.Tipo == "Argumento" || h.Tipo == "string").ToList();
                    if (args != null && args.Count > 0)
                    {
                        List<string> varNames = new List<string>();
                        foreach (var arg in args)
                        {
                            if (arg.Valor != null)
                            {
                                string valArg = arg.Valor.ToString();
                                // Si es string literal y no tiene comillas, agregarlas
                                if (arg.Tipo == "string" && !valArg.StartsWith("\""))
                                {
                                    valArg = $"\"{valArg}\"";
                                }
                                varNames.Add(valArg);
                            }
                            // Si tiene hijos, procesar recursivamente
                            if (arg.Hijos != null && arg.Hijos.Count > 0)
                            {
                                RecursiveProcessArguments(arg.Hijos, varNames);
                            }
                        }
                        if (varNames.Count > 0) GeneratePrintln(varNames, tablaSimbolos);
                    }
                    else
                    {
                        // Solo un salto de línea
                        GenerateNewLine();
                    }
                }
                else if (nodo.Tipo == "Asignacion")
                {
                    // Asignación: destino = rhs
                    if (nodo.Hijos == null || nodo.Hijos.Count < 2) continue;
                    string destino = nodo.Hijos[0].Valor?.ToString();
                    if (string.IsNullOrEmpty(destino) || !_variables.ContainsKey(destino)) continue;

                    var sim = tablaSimbolos.FirstOrDefault(s => s.Nombre == destino);
                    if (sim == null) continue;
                    var rhs = nodo.Hijos[1];
                    string destinoMem = _variables[destino];

                    // Casos de asignación
                    if (rhs.Valor != null)
                    {
                        // Asignación directa si hay un valor
                        GenerateSimpleAssignment(destino, sim.TipoDato, rhs.Valor.ToString(), destinoMem);
                    }
                    else if (rhs.Tipo == "Literal" || rhs.Tipo == "Identificador")
                    {
                        // Asignación desde literal o variable
                        string val = rhs.Valor?.ToString() ?? "";
                        GenerateSimpleAssignment(destino, sim.TipoDato, val, destinoMem);
                    }
                    else if (rhs.Tipo == "Operacion")
                    {
                        // Operación: destino = operando1 operador operando2
                        string operador = rhs.Valor?.ToString();
                        if (rhs.Hijos != null)
                        {
                            if (rhs.Hijos.Count >= 2 && !string.IsNullOrEmpty(operador))
                            {
                                string operando1 = rhs.Hijos[0].Valor?.ToString();
                                string operando2 = rhs.Hijos[1].Valor?.ToString();
                                if (!string.IsNullOrEmpty(operando1) && !string.IsNullOrEmpty(operando2))
                                {
                                    GenerateOperation(destino, sim.TipoDato, operador, operando1, operando2, destinoMem);
                                }
                            }
                            else if (rhs.Hijos.Count == 1 && rhs.Hijos[0].Valor != null)
                            {
                                // Un único valor
                                GenerateSimpleAssignment(destino, sim.TipoDato, rhs.Hijos[0].Valor.ToString(), destinoMem);
                            }
                        }
                    }
                    else if (rhs.Tipo == "Negacion")
                    {
                        // Negación booleana
                        GenerateBoolNegation(destinoMem);
                    }
                    else
                    {
                        // Expresión más compleja
                        ProcessExpression(destino, sim.TipoDato, rhs, destinoMem);
                    }
                }
                else if (nodo.Tipo == "Operacion")
                {
                    // Operación aislada: destino = operando1 operador operando2
                    if (nodo.Hijos == null || nodo.Hijos.Count <= 2) continue;
                    string destino = nodo.Hijos[0].Valor?.ToString();
                    if (string.IsNullOrEmpty(destino) || !_variables.ContainsKey(destino)) continue;

                    var variable = tablaSimbolos.FirstOrDefault(x => x.Nombre == destino);
                    if (variable == null) continue;
                    string destinoMem = _variables[destino];
                    string operador = nodo.Valor?.ToString();
                    if (!string.IsNullOrEmpty(operador) && nodo.Hijos.Count > 2)
                    {
                        string operando1 = nodo.Hijos[1].Valor?.ToString();
                        string operando2 = nodo.Hijos[2].Valor?.ToString();
                        if (!string.IsNullOrEmpty(operando1) && !string.IsNullOrEmpty(operando2))
                        {
                            GenerateOperation(destino, variable.TipoDato, operador, operando1, operando2, destinoMem);
                        }
                    }
                }
                else if (nodo.Tipo == "IfStatement")
                {
                    GenerateIfStatement(nodo, tablaSimbolos);
                }
                // Procesar hijos anidados, excepto los ya manejados
                if (nodo.Hijos != null && nodo.Hijos.Count > 0 &&
                    nodo.Tipo != "fmt.Println" && nodo.Tipo != "Asignacion"
                    && nodo.Tipo != "Operacion" && nodo.Tipo != "Negacion")
                {
                    ProcessInstructions(nodo.Hijos, tablaSimbolos);
                }
                else if (nodo.Tipo == "ForLoop")
                {
                    GenerateForLoop(nodo, tablaSimbolos);
                }
                else if (nodo.Tipo == "ForClassicLoop")
                {
                    GenerateForClassicLoop(nodo, tablaSimbolos);
                }
                else if (nodo.Tipo == "ForRangeLoop")
                {
                    GenerateForRangeLoop(nodo, tablaSimbolos);
                }
                else if (nodo.Tipo == "break")
            {
                string breakLabel = GetBreakLabel();
                if (!string.IsNullOrEmpty(breakLabel))
                {
                    _code.AppendLine($"    // Sentencia break");
                    _code.AppendLine($"    b {breakLabel}");
                }
                else
                {
                    _code.AppendLine($"    // ADVERTENCIA: break fuera de un bucle");
                }
                continue; // Importante: no procesar nada más después del break
            }
            
            else if (nodo.Tipo == "continue")
            {
                string continueLabel = GetContinueLabel();
                if (!string.IsNullOrEmpty(continueLabel))
                {
                    _code.AppendLine($"    // Sentencia continue");
                    _code.AppendLine($"    b {continueLabel}");
                }
                else
                {
                    _code.AppendLine($"    // ADVERTENCIA: continue fuera de un bucle");
                }
                continue; // No procesar nada más después del continue
            }
            else if (nodo.Tipo == "Switch")
            {
                GenerateSwitch(nodo, tablaSimbolos);
            }
            }
        }

        // Métodos auxiliares nuevos

        private void GenerateSimpleAssignment(string destino, string tipo, string valor, string destinoMem)
        {
           _code.AppendLine($"    // Asignando {valor} a {destino} ({tipo}) en {destinoMem}");
            
            switch (tipo)
            {
                case "int":
                    if (_variables.TryGetValue(valor, out string intMem))
                    {
                        _code.AppendLine($"    ldr x9, {intMem}");
                    }
                    else if (int.TryParse(valor, out int intVal))
                    {
                        _code.AppendLine($"    mov x9, #{intVal}");
                    }
                    _code.AppendLine($"    str x9, {destinoMem}");
                    break;
                    
                case "float64":
                    if (_variables.TryGetValue(valor, out string floatMem))
                    {
                        _code.AppendLine($"    ldr d0, {floatMem}");
                    }
                    else if (double.TryParse(valor, out double floatVal))
                    {
                        string literalLabel = $"float_{_labelCounter++}";
                        _dataSection.Add($"{literalLabel}: .double {valor}");
                        _code.AppendLine($"    adr x9, {literalLabel}");
                        _code.AppendLine($"    ldr d0, [x9]");
                    }
                    _code.AppendLine($"    str d0, {destinoMem}");
                    break;
                            
                case "string":
                    // Si el valor es una variable, cargar su dirección
                    if (_variables.TryGetValue(valor, out string strMem))
                    {
                        _code.AppendLine($"    ldr x0, {strMem}");
                        _code.AppendLine($"    str x0, {destinoMem}");
                    }
                    // Si es un literal de string
                    else if ((valor.StartsWith("\"") && valor.EndsWith("\"")) || !valor.Contains("\""))
                    {
                        string cleanText = valor;
                        if (valor.StartsWith("\"") && valor.EndsWith("\""))
                        {
                            cleanText = valor.Substring(1, valor.Length - 2); // Quitar comillas
                        }
                        
                        // AÑADIR ESTA SECCIÓN: Escapar caracteres especiales
                        cleanText = cleanText
                            .Replace("=", "\\=")     // Escapar símbolo igual
                            .Replace("\n", "\\n")    // Saltos de línea
                            .Replace("\r", "\\r")    // Retorno de carro
                            .Replace("\t", "\\t")    // Tabulación
                            .Replace("\"", "\\\"");  // Comillas dobles
                        
                        string stringLabel = $"str_{_labelCounter++}";
                        _dataSection.Add($"{stringLabel}: .asciz \"{cleanText}\"");
                        _code.AppendLine($"    adr x0, {stringLabel}");
                        _code.AppendLine($"    str x0, {destinoMem}");
                    }
                    break;
                                    
                case "bool":
                    // Si el valor es una variable, cargar su valor
                    if (_variables.TryGetValue(valor, out string boolMem))
                    {
                        _code.AppendLine($"    ldr x0, {boolMem}");
                        _code.AppendLine($"    str x0, {destinoMem}");
                    }
                    // Si es true/false literal
                    else
                    {
                        bool boolValue = valor.ToLower() == "true";
                        _code.AppendLine($"    mov x0, #{(boolValue ? "1" : "0")}");
                        _code.AppendLine($"    str x0, {destinoMem}");
                    }
                    break;
            }
        }

        private void ProcessExpression(string destino, string tipo, NodoAST expresion, string destinoMem)
        {
            // Aquí implementar la lógica para evaluar expresiones complejas
            // Para este ejemplo básico, solo manejamos variables o literales simples
            if (expresion.Valor != null)
            {
                GenerateSimpleAssignment(destino, tipo, expresion.Valor.ToString(), destinoMem);
            }
        }

        private void GenerateBoolNegation(string destinoMem)
        {
            _code.AppendLine($"    // Negación booleana");
            _code.AppendLine($"    ldr x0, {destinoMem}");
            _code.AppendLine($"    eor x0, x0, #1");  // XOR con 1 para invertir (0->1, 1->0)
            _code.AppendLine($"    str x0, {destinoMem}");
        }

        private void GenerateOperation(string destino, string tipo, string operador, string operando1, string operando2, string destinoMem)
        {
            _code.AppendLine($"    // Operación: {destino} = {operando1} {operador} {operando2}");
            
            switch (tipo)
            {
                case "int":
                    GenerateIntOperation(operando1, operando2, operador, destinoMem);
                    break;
                    
                case "float64":
                    GenerateFloatOperation(operando1, operando2, operador, destinoMem);
                    break;
                    
                case "string":
                    if (operador == "+") // Concatenación
                    {
                        GenerateStringConcatenation(operando1, operando2, destinoMem);
                    }
                    break;
                    
                case "bool":
                    if (operador == "!")  // Negación
                    {
                        GenerateBoolNegation(destinoMem);
                    }
                    break;
            }
        }

    private void GenerateIntOperation(string operando1, string operando2, string operador, string destinoMem)
    {
        _code.AppendLine($"    // Operación entera: {operando1} {operador} {operando2}");
        
        // CARGAR OPERANDOS CORRECTAMENTE
        if (_variables.TryGetValue(operando1, out string op1Mem))
        {
            _code.AppendLine($"    ldr x9, {op1Mem}");
        }
        else
        {
            _code.AppendLine($"    mov x9, #{operando1}");
        }
        
        if (_variables.TryGetValue(operando2, out string op2Mem))
        {
            _code.AppendLine($"    ldr x10, {op2Mem}");
        }
        else
        {
            _code.AppendLine($"    mov x10, #{operando2}");
        }
        
        // Realizar la operación
        switch (operador)
        {
            case "+":
                _code.AppendLine($"    add x9, x9, x10  // Sumar");  // CAMBIO: x0,x1 -> x9,x10
                break;
            case "-":
                _code.AppendLine($"    sub x9, x9, x10  // Restar");  // CAMBIO: x0,x1 -> x9,x10
                break;
            case "*":
                _code.AppendLine($"    mul x9, x9, x10  // Multiplicar");  // CAMBIO: x0,x1 -> x9,x10
                break;
            case "/":
                _code.AppendLine($"    udiv x9, x9, x10  // Dividir");  // CAMBIO: x0,x1 -> x9,x10
                break;
        }
        
        // Guardar resultado
        _code.AppendLine($"    str x9, {destinoMem}  // Guardar resultado");  // CAMBIO: x0 -> x9
    }
        private void GenerateFloatOperation(string operando1, string operando2, string operador, string destinoMem)
        {
            // Cargar operando1 en d0
            if (_variables.TryGetValue(operando1, out string op1Mem))
            {
                _code.AppendLine($"    ldr d0, {op1Mem}");
            }
            else if (double.TryParse(operando1, out double floatVal1))
            {
                string litLabel1 = $"float_{_labelCounter++}";
                _dataSection.Add($"{litLabel1}: .double {operando1}");
                _code.AppendLine($"    adr x0, {litLabel1}");
                _code.AppendLine($"    ldr d0, [x0]");
            }
            
            // Cargar operando2 en d1
            if (_variables.TryGetValue(operando2, out string op2Mem))
            {
                _code.AppendLine($"    ldr d1, {op2Mem}");
            }
            else if (double.TryParse(operando2, out double floatVal2))
            {
                string litLabel2 = $"float_{_labelCounter++}";
                _dataSection.Add($"{litLabel2}: .double {operando2}");
                _code.AppendLine($"    adr x0, {litLabel2}");
                _code.AppendLine($"    ldr d1, [x0]");
            }
            
            // Realizar operación
            switch (operador)
            {
                case "+":
                    _code.AppendLine($"    fadd d0, d0, d1");
                    break;
                case "-":
                    _code.AppendLine($"    fsub d0, d0, d1");
                    break;
                case "*":
                    _code.AppendLine($"    fmul d0, d0, d1");
                    break;
                case "/":
                    _code.AppendLine($"    fdiv d0, d0, d1");
                    break;
            }
            
            // Guardar resultado
            _code.AppendLine($"    str d0, {destinoMem}");
        }

        private void GenerateStringConcatenation(string operando1, string operando2, string destinoMem)
        {
            _code.AppendLine($"    // Concatenación de cadenas: {operando1} + {operando2}");
            
            // Crear un buffer para la nueva cadena concatenada
            string concatBuffer = $"str_concat_{_labelCounter++}";
            _dataSection.Add($"{concatBuffer}: .space 512");  // Espacio suficiente para la concatenación
            
            // Inicializar el buffer con una cadena vacía
            _code.AppendLine($"    adr x0, {concatBuffer}");
            _code.AppendLine($"    mov w1, #0");
            _code.AppendLine($"    strb w1, [x0]");  // Inicializar con string vacío (NULL-terminator)
            
            // Primer operando
            if (_variables.TryGetValue(operando1, out string op1Mem))
            {
                _code.AppendLine($"    ldr x1, {op1Mem}");
                // Verificar si es NULL
                _code.AppendLine($"    cmp x1, #0");
                _code.AppendLine($"    beq skip_op1_{_labelCounter}");
                _code.AppendLine($"    adr x0, {concatBuffer}");
                _code.AppendLine($"    bl string_copy");
                _code.AppendLine($"skip_op1_{_labelCounter}:");
            }
            else 
            {
                // Si es literal de string, crear etiqueta para ello
                string cleanText = operando1;
                if (operando1.StartsWith("\"") && operando1.EndsWith("\""))
                {
                    cleanText = operando1.Substring(1, operando1.Length - 2); // Quitar comillas
                }
                
                // Escapar adecuadamente
                cleanText = cleanText
                    .Replace("=", "\\=")
                    .Replace("\n", "\\n")
                    .Replace("\r", "\\r")
                    .Replace("\t", "\\t")
                    .Replace("\"", "\\\"");
                    
                string strLabel = $"str_{_labelCounter++}";
                _dataSection.Add($"{strLabel}: .asciz \"{cleanText}\"");
                _code.AppendLine($"    adr x1, {strLabel}");
                _code.AppendLine($"    adr x0, {concatBuffer}");
                _code.AppendLine($"    bl string_copy");
            }
            
            // Segundo operando
            if (_variables.TryGetValue(operando2, out string op2Mem))
            {
                _code.AppendLine($"    ldr x1, {op2Mem}");
                // Verificar si es NULL
                _code.AppendLine($"    cmp x1, #0");
                _code.AppendLine($"    beq skip_op2_{_labelCounter}");
                
                // Encontrar el final de la cadena actual
                _code.AppendLine($"    adr x0, {concatBuffer}");
                _code.AppendLine($"    bl string_length");
                _code.AppendLine($"    adr x2, {concatBuffer}");
                _code.AppendLine($"    add x0, x2, x0");  // Posición del null-terminator
                
                _code.AppendLine($"    ldr x1, {op2Mem}");
                _code.AppendLine($"    bl string_copy");
                _code.AppendLine($"skip_op2_{_labelCounter}:");
            }
            else 
            {
                // Similar al primer operando
                string cleanText = operando2;
                if (operando2.StartsWith("\"") && operando2.EndsWith("\""))
                {
                    cleanText = operando2.Substring(1, operando2.Length - 2);
                }
                
                cleanText = cleanText
                    .Replace("=", "\\=")
                    .Replace("\n", "\\n")
                    .Replace("\r", "\\r")
                    .Replace("\t", "\\t")
                    .Replace("\"", "\\\"");
                
                // Encontrar el final de la cadena actual
                _code.AppendLine($"    adr x0, {concatBuffer}");
                _code.AppendLine($"    bl string_length");
                _code.AppendLine($"    adr x2, {concatBuffer}");
                _code.AppendLine($"    add x0, x2, x0");  // Posición del null-terminator
                
                string strLabel = $"str_{_labelCounter++}";
                _dataSection.Add($"{strLabel}: .asciz \"{cleanText}\"");
                _code.AppendLine($"    adr x1, {strLabel}");
                _code.AppendLine($"    bl string_copy");
            }
            
            // Almacenar dirección del buffer concatenado en la variable destino
            _code.AppendLine($"    adr x0, {concatBuffer}");
            _code.AppendLine($"    str x0, {destinoMem}");
        }

        // Método auxiliar para procesar argumentos recursivamente
        private void RecursiveProcessArguments(List<NodoAST> nodos, List<string> varNames)
        {
            foreach (var nodo in nodos)
            {
                if (nodo.Valor != null)
                {
                    string valor = nodo.Valor.ToString();
                    
                    // String literal
                    if (nodo.Tipo == "string" && !valor.StartsWith("\""))
                    {
                        varNames.Add($"\"{valor}\"");
                    }
                    else
                    {
                        varNames.Add(valor);
                    }
                }
                
                if (nodo.Hijos != null && nodo.Hijos.Count > 0)
                {
                    RecursiveProcessArguments(nodo.Hijos, varNames);
                }
            }
        }

       
        private void GenerateVariableDeclaration(EntradaSimbolo simbolo)
        {
            string varName = !string.IsNullOrEmpty(simbolo.Nombre) ? simbolo.Nombre : simbolo.Id.ToString();
            _code.AppendLine($"\n    // Declaración de variable: {varName}");

            if (simbolo.TipoDato == "int")
            {
                int offset = GetVariableOffset(varName);
                string offsetStr = offset.ToString();
                string valorStr = simbolo.Valor != null ? simbolo.Valor.ToString() : "0"; // Valor por defecto: 0

                _code.AppendLine($"    mov x9, #{valorStr}");
                _code.AppendLine($"    str x9, [sp, #{offsetStr}]");
                _variables[varName] = $"[sp, #{offsetStr}]";
            }
            else if (simbolo.TipoDato == "float64")
            {
                int offset = GetVariableOffset(varName);
                string offsetStr = offset.ToString();
                string valorStr = simbolo.Valor != null ? simbolo.Valor.ToString() : "0.0";
                string literalLabel = $"float_{_labelCounter++}";
                _dataSection.Add($"{literalLabel}: .double {valorStr}");

                _code.AppendLine($"    adr x9, {literalLabel}");
                _code.AppendLine($"    ldr d0, [x9]");
                _code.AppendLine($"    str d0, [sp, #{offsetStr}]");
                _variables[varName] = $"[sp, #{offsetStr}]";
            }
            // En GenerateVariableDeclaration
            else if (simbolo.TipoDato == "string")
            {
                int offset = GetVariableOffset(varName);
                string offsetStr = offset.ToString();
                string valorStr = simbolo.Valor != null ? simbolo.Valor.ToString().Replace("\"", "") : string.Empty;
                string stringLabel = $"str_{_labelCounter++}";
                _dataSection.Add($"{stringLabel}: .asciz \"{valorStr}\"");

                _code.AppendLine($"    adr x9, {stringLabel}");
                _code.AppendLine($"    str x9, [sp, #{offsetStr}]");
                _variables[varName] = $"[sp, #{offsetStr}]";
            }
            else if (simbolo.TipoDato == "bool")
            {
                int offset = GetVariableOffset(varName);
                string offsetStr = offset.ToString();
                bool boolValue = false;
                bool.TryParse(simbolo.Valor?.ToString(), out boolValue);
                string valorStr = boolValue ? "1" : "0";

                _code.AppendLine($"    mov x9, #{valorStr}");
                _code.AppendLine($"    str x9, [sp, #{offsetStr}]");
                _variables[varName] = $"[sp, #{offsetStr}]";
            }
            else if (simbolo.TipoDato == "rune")
            {
                int offset = GetVariableOffset(varName);
                string offsetStr = offset.ToString();
                
                // Tratar de convertir el valor a char
                char ch = '\0';
                if (simbolo.Valor != null)
                {
                    string valorStr = simbolo.Valor.ToString();
                    if (valorStr.StartsWith("'") && valorStr.EndsWith("'") && valorStr.Length >= 3)
                    {
                        ch = valorStr[1]; // Extraer el carácter entre comillas simples
                    }
                    else
                    {
                        ch = Convert.ToChar(simbolo.Valor);
                    }
                }
                
                _code.AppendLine($"    mov w9, #{(int)ch}");   // código ASCII/Unicode
                _code.AppendLine($"    str w9, [sp, #{offsetStr}]");
                _variables[varName] = $"[sp, #{offsetStr}]";
            }
        }
        
        public void GeneratePrintln(List<string> varNames, List<EntradaSimbolo> tablaSimbolos)
        {
            _code.AppendLine("\n    // fmt.Println");
            
                // Imprimir cada variable o literal
                foreach (var varName in varNames)
                {
                    // Primero ver si es una variable conocida
                    if (!_variables.ContainsKey(varName))
                    {
                        // No es una variable - trata como literal de texto, con o sin comillas
                        string cleanText = varName;
                        if (varName.StartsWith("\"") && varName.EndsWith("\""))
                        {
                            cleanText = varName.Substring(1, varName.Length - 2); // Quitar comillas
                        }

                        // Escapar adecuadamente los caracteres especiales para el ensamblador
                        cleanText = cleanText
                            .Replace("=", "\\=")     // Escapar símbolo igual (CRÍTICO para resolver el error)
                            .Replace("\n", "\\n")     // Reemplazar saltos de línea
                            .Replace("\r", "\\r")     // Retorno de carro
                            .Replace("\t", "\\t")     // Tabulación
                            .Replace("\"", "\\\"");   // Comillas dobles

                        string label = GenerateLabel("lit");
                        _dataSection.Add($"{label}: .asciz \"{cleanText}\"");
                        
                        _code.AppendLine($"    // Imprimir literal: {Sanitize(cleanText)}");
                        _code.AppendLine($"    adr x0, {label}");   // x0 = &literal (CORRECCIÓN: pasamos la dirección del literal)
                        _code.AppendLine("    bl string_length");   // Llamada a string_length
                        _code.AppendLine("    mov x2, x0");        // x2 = longitud devuelta por string_length
                        _code.AppendLine("    mov x0, #1");        // x0 = stdout (descriptor archivo)
                        _code.AppendLine($"    adr x1, {label}");  // x1 = puntero a la cadena literal
                        _code.AppendLine($"    mov x8, #64");      // write syscall
                        _code.AppendLine($"    svc #0");
                        
                        // espacio entre argumentos (si no es el último)
                        if (varName != varNames.Last())
                        {
                            string space = GenerateLabel("space");
                            _dataSection.Add($"{space}: .asciz \" \"");
                            _code.AppendLine($"    adr x0, {space}");  // x0 = &space (CORRECCIÓN)
                            _code.AppendLine("    bl string_length");   // obtener longitud
                            _code.AppendLine("    mov x2, x0");         // longitud como tercer parámetro
                            _code.AppendLine("    mov x0, #1");         // stdout
                            _code.AppendLine($"    adr x1, {space}");   // dirección del espacio
                            _code.AppendLine($"    mov x8, #64");
                            _code.AppendLine($"    svc #0");
                        }
                        continue;   // Ya lo imprimimos, pasar al siguiente
                    }
                    else
                    {
                        // Es una variable que conocemos - obtener su ubicación en memoria
                        string memoryLocation = _variables[varName];
                        
                        // Determinar el tipo de la variable
                        var variable = tablaSimbolos.FirstOrDefault(s => s.Nombre == varName);
                        if (variable == null) continue;
                        
                        switch (variable.TipoDato)
                        {
                            case "int":
                                GeneratePrintInt(memoryLocation, varName);
                                break;
                            case "float64":
                                GeneratePrintFloat(memoryLocation, varName);
                                break;
                            case "string":
                                GeneratePrintString(memoryLocation, varName);
                                break;
                            case "bool":
                                GeneratePrintBool(memoryLocation, varName);
                                break;
                            case "rune":
                                GeneratePrintRune(memoryLocation, varName);
                                break;
                            default:
                                _code.AppendLine($"    // No se puede imprimir variable de tipo {variable.TipoDato}");
                                break;
                        }
                        
                        // Imprimir un espacio después de la variable si no es la última
                        if (varName != varNames.Last())
                        {
                            string spaceLabel = GenerateLabel("space");
                            _dataSection.Add($"{spaceLabel}: .asciz \" \"");
                            
                            _code.AppendLine($"    mov x0, #1");
                            _code.AppendLine($"    adr x1, {spaceLabel}");
                            _code.AppendLine($"    mov x2, #1");
                            _code.AppendLine($"    mov x8, #64");
                            _code.AppendLine($"    svc #0");
                        }
            }
        }
            
            // Imprimir salto de línea final
            GenerateNewLine();
        }

        private void GeneratePrintInt(string memoryLocation, string varName)
        {
            string bufferLabel = $"int_buffer_{_labelCounter++}";
            _dataSection.Add($"{bufferLabel}: .space 20"); // Espacio para un número entero como string
            
            _code.AppendLine($"    // Imprimir entero: {varName}");
            _code.AppendLine($"    ldr x0, {memoryLocation}");
            _code.AppendLine($"    adr x1, {bufferLabel}");
            _code.AppendLine($"    bl int_to_string");
            _code.AppendLine($"    mov x2, x0"); // Longitud retornada
            _code.AppendLine($"    mov x0, #1"); // stdout
            _code.AppendLine($"    adr x1, {bufferLabel}");
            _code.AppendLine($"    mov x8, #64"); // write syscall
            _code.AppendLine($"    svc #0");
        }

        private void GeneratePrintString(string memoryLocation, string varName)
        {
            _code.AppendLine($"    // Imprimir string: {varName}");
            _code.AppendLine($"    ldr x0, {memoryLocation}");
            
            // AÑADIR ESTA LÍNEA: Define la cadena vacía en la sección de datos
            _dataSection.Add($"empty_str_{_labelCounter}: .asciz \"\"");
            
            // Añadir verificación de NULL
            _code.AppendLine($"    cmp x0, #0");
            _code.AppendLine($"    beq skip_print_{_labelCounter}");
            
            _code.AppendLine($"    bl string_length");
            _code.AppendLine($"    mov x2, x0"); // Longitud 
            _code.AppendLine($"    mov x0, #1"); // stdout
            _code.AppendLine($"    ldr x1, {memoryLocation}"); // Dirección de la cadena
            _code.AppendLine($"    mov x8, #64"); // write syscall
            _code.AppendLine($"    svc #0");
            _code.AppendLine($"    b end_print_{_labelCounter}");
            
            _code.AppendLine($"skip_print_{_labelCounter}:");
            _code.AppendLine($"    adr x0, empty_str_{_labelCounter}"); // CORRECCIÓN: cargar dirección en x0
            _code.AppendLine("    bl string_length");                   // obtener longitud real
            _code.AppendLine("    mov x2, x0");                         // usar longitud devuelta
            _code.AppendLine("    mov x0, #1");                         // stdout
            _code.AppendLine($"    adr x1, empty_str_{_labelCounter}"); // dirección en x1
            _code.AppendLine($"    mov x8, #64");
            _code.AppendLine($"    svc #0");
            _code.AppendLine($"end_print_{_labelCounter++}:");
        }
        private void GeneratePrintFloat(string memoryLocation, string varName)
        {
            string bufferLabel = $"float_buffer_{_labelCounter++}";
            _dataSection.Add($"{bufferLabel}: .space 30"); // Espacio para un número flotante como string
            
            _code.AppendLine($"    // Imprimir flotante: {varName}");
            _code.AppendLine($"    ldr d0, {memoryLocation}");
            _code.AppendLine($"    adr x0, {bufferLabel}");
            _code.AppendLine($"    bl float_to_string"); // funcion float a string
            _code.AppendLine($"    mov x2, x0");         // Longitud retornada
            _code.AppendLine($"    mov x0, #1");         // stdout
            _code.AppendLine($"    adr x1, {bufferLabel}");
            _code.AppendLine($"    mov x8, #64");        // write syscall
            _code.AppendLine($"    svc #0");
        }

        private void GeneratePrintBool(string memoryLocation, string varName)
        {
            string trueLabel = GenerateLabel("true_str");
            string falseLabel = GenerateLabel("false_str");
            int labelId = _labelCounter;
            
            _dataSection.Add($"{trueLabel}: .asciz \"true\"");
            _dataSection.Add($"{falseLabel}: .asciz \"false\"");
            
            _code.AppendLine($"    // Imprimir booleano: {varName}");
            _code.AppendLine($"    ldr x0, {memoryLocation}");
            _code.AppendLine($"    cmp x0, #0");
            _code.AppendLine($"    beq print_false_{labelId}");
            
            // Es true 
            _code.AppendLine($"    mov x0, #1");           
            _code.AppendLine($"    adr x1, {trueLabel}");
            _code.AppendLine($"    mov x2, #4");          
            _code.AppendLine($"    mov x8, #64");         
            _code.AppendLine($"    svc #0");
            _code.AppendLine($"    b end_print_bool_{labelId}");
            
            // Es false
            _code.AppendLine($"print_false_{labelId}:");
            _code.AppendLine($"    mov x0, #1");           
            _code.AppendLine($"    adr x1, {falseLabel}"); 
            _code.AppendLine($"    mov x2, #5");          // 5 caracteres para "false"
            _code.AppendLine($"    mov x8, #64");          
            _code.AppendLine($"    svc #0");
            
            _code.AppendLine($"end_print_bool_{labelId}:");
        }

        //metodo if else
        private void GenerateIfStatement(NodoAST nodo, List<EntradaSimbolo> tablaSimbolos)
        {
            _code.AppendLine("\n    // If Statement");
            
            // Obtener nodo de condición
            var condNodo = nodo.Hijos.FirstOrDefault(h => h.Tipo == "Condicion");
            string condExpr = condNodo?.Valor?.ToString() ?? "false";
            
            // Generar etiquetas únicas para saltos
            string elseLabel = $"else_{_labelCounter}";
            string endLabel = $"endif_{_labelCounter}";
            _labelCounter++;
            
            // Evaluar condición
            _code.AppendLine($"    // Evaluar condición: {condExpr}");
            GenerateConditionCheck(condNodo, elseLabel);
            
            // Bloque 'then'
            var bloqueIf = nodo.Hijos.FirstOrDefault(h => h.Tipo == "BloqueIf");
            if (bloqueIf?.Hijos != null)
            {
                _code.AppendLine("    // Bloque if (then)");
                ProcessInstructions(bloqueIf.Hijos, tablaSimbolos);
            }
            
            // Saltar al final después del bloque 'then'
            _code.AppendLine($"    b {endLabel}");
            
            // Bloque 'else'
            _code.AppendLine($"{elseLabel}:");
            var bloqueElse = nodo.Hijos.FirstOrDefault(h => h.Tipo == "BloqueElse");
            if (bloqueElse?.Hijos != null)
            {
                _code.AppendLine("    // Bloque else");
                ProcessInstructions(bloqueElse.Hijos, tablaSimbolos);
            }
            
            // Etiqueta de fin del if
            _code.AppendLine($"{endLabel}:");
        }

        private void GenerateForLoop(NodoAST nodo, List<EntradaSimbolo> tablaSimbolos)
        {
            _code.AppendLine("\n    // Bucle For");
            
            string loopStartLabel = $"loop_start_{_labelCounter}";
            string loopEndLabel = $"loop_end_{_labelCounter}";
            string loopContinueLabel = $"loop_cont_{_labelCounter}";
            _labelCounter++;
            
            // Etiqueta para el inicio del bucle
            _code.AppendLine($"{loopStartLabel}:");
            
            // Evaluar condición
            var condNodo = nodo.Hijos.FirstOrDefault(h => h.Tipo == "Condicion");
            if (condNodo != null)
            {
                _code.AppendLine($"    // Evaluar condición del bucle");
                GenerateConditionCheck(condNodo, loopEndLabel);
            }
            
            // Generar el cuerpo del bucle
            var bloqueFor = nodo.Hijos.FirstOrDefault(h => h.Tipo == "BloqueFor");
            if (bloqueFor?.Hijos != null)
            {
                _code.AppendLine("    // Cuerpo del bucle");
                PushLoopLabels(loopContinueLabel, loopEndLabel);
                ProcessInstructions(bloqueFor.Hijos, tablaSimbolos);
                PopLoopLabels();
            }
            
            // Etiqueta para continue
            _code.AppendLine($"{loopContinueLabel}:");
            
            // Volver al inicio del bucle
            _code.AppendLine($"    b {loopStartLabel}");
            
            // Etiqueta para el final del bucle
            _code.AppendLine($"{loopEndLabel}:");
        }
        private void GenerateForClassicLoop(NodoAST nodo, List<EntradaSimbolo> tablaSimbolos)
        {
            _code.AppendLine("\n    // Bucle For Clásico");
            
            // Generar etiquetas únicas para los saltos
            string loopStartLabel = $"loop_start_{_labelCounter}";
            string loopCondLabel = $"loop_cond_{_labelCounter}";
            string loopEndLabel = $"loop_end_{_labelCounter}";
            string loopIncLabel = $"loop_inc_{_labelCounter}";
            _labelCounter++;
            
            // Procesar inicialización (si existe)
            var inicializacionNodo = nodo.Hijos.FirstOrDefault(h => h.Tipo == "Inicializacion");
            if (inicializacionNodo != null)
            {
                _code.AppendLine("    // Inicialización");
                ProcessInstructions(new List<NodoAST> { inicializacionNodo }, tablaSimbolos);
            }
            
            // Ir directamente a evaluar la condición primero
            _code.AppendLine($"    b {loopCondLabel}");
            
            // Etiqueta para el inicio del bucle (cuerpo)
            _code.AppendLine($"{loopStartLabel}:");
            
            // Generar el cuerpo del bucle
            var bloqueFor = nodo.Hijos.FirstOrDefault(h => h.Tipo == "BloqueFor");
            if (bloqueFor?.Hijos != null)
            {
                _code.AppendLine("    // Cuerpo del bucle");
                // IMPORTANTE: Agregar etiquetas para break y continue
                PushLoopLabels(loopIncLabel, loopEndLabel);
                ProcessInstructions(bloqueFor.Hijos, tablaSimbolos);
                PopLoopLabels();
            }
            
            // Incremento después del cuerpo - etiquetar para continue
            _code.AppendLine($"{loopIncLabel}:");
            var incrementoNodo = nodo.Hijos.FirstOrDefault(h => h.Tipo == "Incremento");
            if (incrementoNodo != null)
            {
                _code.AppendLine("    // Incremento/Actualización");
                ProcessInstructions(new List<NodoAST> { incrementoNodo }, tablaSimbolos);
            }
            
            // Evaluar condición al final del ciclo
            _code.AppendLine($"{loopCondLabel}:");
            var condNodo = nodo.Hijos.FirstOrDefault(h => h.Tipo == "Condicion");
            if (condNodo != null)
            {
                _code.AppendLine($"    // Evaluar condición del bucle");
                GenerateConditionCheck(condNodo, loopEndLabel);
                
                // Si la condición se cumple (no saltar a loopEndLabel), volver al inicio del bucle
                _code.AppendLine($"    b {loopStartLabel}");
            }
            
            // Etiqueta para el final del bucle
            _code.AppendLine($"{loopEndLabel}:");
        }

        private void GenerateForRangeLoop(NodoAST nodo, List<EntradaSimbolo> tablaSimbolos)
        {
            _code.AppendLine("\n    // Bucle For Range");
            
            // Generar etiquetas únicas para los saltos
            string loopStartLabel = $"range_start_{_labelCounter}";
            string loopEndLabel = $"range_end_{_labelCounter}";
            string loopCondLabel = $"range_cond_{_labelCounter}";
            string loopIncLabel = $"range_inc_{_labelCounter}";
            _labelCounter++;
            
            // Obtener componentes del for range
            var iteradorNodo = nodo.Hijos.FirstOrDefault(h => h.Tipo == "Iterador");
            var variableNodo = nodo.Hijos.FirstOrDefault(h => h.Tipo == "Variable");
            var coleccionNodo = nodo.Hijos.FirstOrDefault(h => h.Tipo == "Coleccion");
            var bloqueFor = nodo.Hijos.FirstOrDefault(h => h.Tipo == "BloqueFor");
            
            string iteradorNombre = iteradorNodo?.Valor?.ToString();
            string variableNombre = variableNodo?.Valor?.ToString();
            
            if (string.IsNullOrEmpty(iteradorNombre) || string.IsNullOrEmpty(variableNombre) || 
                coleccionNodo == null || bloqueFor == null)
            {
                _code.AppendLine("    // Error: Información incompleta para bucle for range");
                return;
            }
            
            // 1. Inicializar iterador (índice) a 0
            if (!_variables.TryGetValue(iteradorNombre, out string iteradorMem))
            {
                _code.AppendLine($"    // Advertencia: Variable índice '{iteradorNombre}' no declarada");
                return;
            }
            
            _code.AppendLine($"    // Inicializar índice {iteradorNombre} a 0");
            _code.AppendLine($"    mov x0, #0");
            _code.AppendLine($"    str x0, {iteradorMem}");
            
            // 2. Calcular la longitud de la colección y almacenarla
            string coleccionTemp = $"coleccion_long_{_labelCounter++}";
            int coleccionOffset = GetVariableOffset(coleccionTemp);
            string coleccionMem = $"[sp, #{coleccionOffset}]";
            
            _code.AppendLine($"    // Obtener longitud de la colección");
            // Esto supone que la longitud ya está disponible o se puede calcular
            // En un caso real necesitarías una lógica más compleja según el tipo de colección
            _code.AppendLine($"    mov x0, #10");  // Suponiendo una longitud fija para este ejemplo
            _code.AppendLine($"    str x0, {coleccionMem}");
            
            // 3. Ir a evaluación de condición
            _code.AppendLine($"    b {loopCondLabel}");
            
            // 4. Etiqueta de inicio de bucle
            _code.AppendLine($"{loopStartLabel}:");
            
            // 5. Cargar el valor del elemento actual basado en el índice
            // Aquí necesitarías una lógica específica según el tipo de colección
            _code.AppendLine($"    // Cargar valor para el elemento actual");
            if (_variables.TryGetValue(variableNombre, out string variableMem))
            {
                _code.AppendLine($"    ldr x0, {iteradorMem}");  // Cargar índice actual
                // Aquí se necesitaría más código para acceder al elemento de la colección
                // Este es un ejemplo simplificado que usa el índice como valor
                _code.AppendLine($"    str x0, {variableMem}");  // Guardar valor en variable
            }
            
            // 6. Ejecutar el cuerpo del bucle
            if (bloqueFor.Hijos != null)
            {
                _code.AppendLine("    // Cuerpo del bucle");
                ProcessInstructions(bloqueFor.Hijos, tablaSimbolos);
            }
            
            // 7. Incrementar índice
            _code.AppendLine($"{loopIncLabel}:");
            _code.AppendLine($"    // Incrementar índice");
            _code.AppendLine($"    ldr x0, {iteradorMem}");
            _code.AppendLine($"    add x0, x0, #1");
            _code.AppendLine($"    str x0, {iteradorMem}");
            
            // 8. Comprobar condición
            _code.AppendLine($"{loopCondLabel}:");
            _code.AppendLine($"    // Comprobar si índice < longitud colección");
            _code.AppendLine($"    ldr x0, {iteradorMem}");
            _code.AppendLine($"    ldr x1, {coleccionMem}");
            _code.AppendLine($"    cmp x0, x1");
            _code.AppendLine($"    blt {loopStartLabel}");  // Si índice < longitud, continuar bucle
            
            // 9. Fin del bucle
            _code.AppendLine($"{loopEndLabel}:");
        }

        private void GenerateSwitch(NodoAST nodo, List<EntradaSimbolo> tablaSimbolos)
        {
            _code.AppendLine("\n    // Switch Statement");
            
            // Obtener el nodo de expresión del switch
            var exprNodo = nodo.Hijos.FirstOrDefault(h => h.Tipo == "Expresion");
            if (exprNodo == null)
            {
                _code.AppendLine("    // Error: Switch sin expresión");
                return;
            }
            
            string switchExpr = exprNodo.Valor?.ToString() ?? "";
            _code.AppendLine($"    // Evaluando expresión: {switchExpr}");
            
            // Cargar el valor de la expresión switch
            string switchValue = $"switch_val_{_labelCounter++}";
            int switchOffset = GetVariableOffset(switchValue);
            string switchMem = $"[sp, #{switchOffset}]";
            
            // Si la expresión es una variable
            if (_variables.TryGetValue(switchExpr, out string exprMem))
            {
                _code.AppendLine($"    ldr x0, {exprMem}");
                _code.AppendLine($"    str x0, {switchMem}");
            }
            else if (int.TryParse(switchExpr, out int exprVal))
            {
                // Si la expresión es un literal entero
                _code.AppendLine($"    mov x0, #{exprVal}");
                _code.AppendLine($"    str x0, {switchMem}");
            }
            else
            {
                _code.AppendLine($"    // No se pudo evaluar la expresión del switch");
                _code.AppendLine($"    mov x0, #0");  // Valor por defecto
                _code.AppendLine($"    str x0, {switchMem}");
            }
            
            // Generar etiqueta para el final del switch
            string endSwitchLabel = $"endswitch_{_labelCounter++}";
            
            // Obtener los nodos case y default
            var caseNodos = nodo.Hijos.Where(h => h.Tipo == "Case").ToList();
            var defaultNodo = nodo.Hijos.FirstOrDefault(h => h.Tipo == "Default");
            
            // Si hay pocos cases o están dispersos, usar comparaciones secuenciales
            if (caseNodos.Count <= 8)
            {
                // Para cada nodo case
                foreach (var caseNodo in caseNodos)
                {
                    string caseValue = caseNodo.Valor?.ToString() ?? "";
                    string caseLabel = $"case_{_labelCounter++}";
                    string nextCaseLabel = $"next_case_{_labelCounter}";
                    
                    _code.AppendLine($"\n    // Case: {caseValue}");
                    _code.AppendLine($"    ldr x0, {switchMem}");
                    
                    // Si el valor del case es un número
                    if (int.TryParse(caseValue, out int caseVal))
                    {
                        _code.AppendLine($"    cmp x0, #{caseVal}");
                        _code.AppendLine($"    bne {nextCaseLabel}");
                    }
                    else if (_variables.TryGetValue(caseValue, out string caseMem))
                    {
                        _code.AppendLine($"    ldr x1, {caseMem}");
                        _code.AppendLine($"    cmp x0, x1");
                        _code.AppendLine($"    bne {nextCaseLabel}");
                    }
                    else
                    {
                        // No se pudo determinar el valor, saltar al siguiente case
                        _code.AppendLine($"    b {nextCaseLabel}");
                    }
                    
                    // Si el case coincide, ejecutar su código
                    _code.AppendLine($"{caseLabel}:");
                    
                    // Procesar instrucciones del case
                    if (caseNodo.Hijos != null && caseNodo.Hijos.Count > 0)
                    {
                        // En switch, los breaks deben saltar al final del switch
                        PushLoopLabels("", endSwitchLabel);
                        ProcessInstructions(caseNodo.Hijos, tablaSimbolos);
                        PopLoopLabels();
                    }
                    
                    // Si no hay break explícito, continuamos con el siguiente case (fall-through)
                    _code.AppendLine($"{nextCaseLabel}:");
                }
                
                // Bloque default (si existe)
                if (defaultNodo != null)
                {
                    _code.AppendLine($"\n    // Default case");
                    
                    // Procesar instrucciones del default
                    if (defaultNodo.Hijos != null && defaultNodo.Hijos.Count > 0)
                    {
                        PushLoopLabels("", endSwitchLabel);
                        ProcessInstructions(defaultNodo.Hijos, tablaSimbolos);
                        PopLoopLabels();
                    }
                }
            }
            else
            {
                // Si hay muchos cases consecutivos, considerar usar una tabla de saltos
                // Aquí iría una implementación más compleja con tablas de salto
                // Para casos como enteros consecutivos
                _code.AppendLine("    // Switch con muchos casos - usando comparaciones secuenciales");
                
                // Implementación similar a la anterior para este caso
                // (igual que el bloque anterior pero con mensaje diferente)
                
                // Para cada nodo case
                foreach (var caseNodo in caseNodos)
                {
                    string caseValue = caseNodo.Valor?.ToString() ?? "";
                    string caseLabel = $"case_{_labelCounter++}";
                    string nextCaseLabel = $"next_case_{_labelCounter}";
                    
                    _code.AppendLine($"\n    // Case: {caseValue}");
                    _code.AppendLine($"    ldr x0, {switchMem}");
                    
                    // Si el valor del case es un número
                    if (int.TryParse(caseValue, out int caseVal))
                    {
                        _code.AppendLine($"    cmp x0, #{caseVal}");
                        _code.AppendLine($"    bne {nextCaseLabel}");
                    }
                    else if (_variables.TryGetValue(caseValue, out string caseMem))
                    {
                        _code.AppendLine($"    ldr x1, {caseMem}");
                        _code.AppendLine($"    cmp x0, x1");
                        _code.AppendLine($"    bne {nextCaseLabel}");
                    }
                    else
                    {
                        // No se pudo determinar el valor, saltar al siguiente case
                        _code.AppendLine($"    b {nextCaseLabel}");
                    }
                    
                    // Si el case coincide, ejecutar su código
                    _code.AppendLine($"{caseLabel}:");
                    
                    // Procesar instrucciones del case
                    if (caseNodo.Hijos != null && caseNodo.Hijos.Count > 0)
                    {
                        PushLoopLabels("", endSwitchLabel);
                        ProcessInstructions(caseNodo.Hijos, tablaSimbolos);
                        PopLoopLabels();
                    }
                    
                    // Si no hay break explícito, continuamos con el siguiente case (fall-through)
                    _code.AppendLine($"{nextCaseLabel}:");
                }
                
                // Bloque default (si existe)
                if (defaultNodo != null)
                {
                    _code.AppendLine($"\n    // Default case");
                    
                    // Procesar instrucciones del default
                    if (defaultNodo.Hijos != null && defaultNodo.Hijos.Count > 0)
                    {
                        PushLoopLabels("", endSwitchLabel);
                        ProcessInstructions(defaultNodo.Hijos, tablaSimbolos);
                        PopLoopLabels();
                    }
                }
            }
            
            // Etiqueta de fin del switch
            _code.AppendLine($"\n{endSwitchLabel}:");
            _code.AppendLine("    // Fin del switch");
        }

        private void PushLoopLabels(string continueLabel, string breakLabel)
        {
            _continueLabels.Push(continueLabel);
            _breakLabels.Push(breakLabel);
        }

// Sacar las etiquetas del bucle más reciente
        private void PopLoopLabels()
        {
            if (_continueLabels.Count > 0) _continueLabels.Pop();
            if (_breakLabels.Count > 0) _breakLabels.Pop();
        }

        // Obtener la etiqueta para break
        private string GetBreakLabel()
        {
            return _breakLabels.Count > 0 ? _breakLabels.Peek() : null;
        }

        // Obtener la etiqueta para continue
        private string GetContinueLabel()
        {
            return _continueLabels.Count > 0 ? _continueLabels.Peek() : null;
        }


        private void GenerateConditionCheck(NodoAST condNodo, string falseLabel)
        {
            if (condNodo?.Hijos == null || condNodo.Hijos.Count == 0) 
            {
                _code.AppendLine($"    // Condición vacía, salto incondicional");
                _code.AppendLine($"    b {falseLabel}");
                return;
            }
            
            // Extraer expresión
            var expr = condNodo.Hijos[0];
            
            // Manejar diferentes operaciones de comparación
            if (expr.Tipo == "Operacion")
            {
                string operador = expr.Valor?.ToString();
                if (expr.Hijos != null && expr.Hijos.Count >= 2 && !string.IsNullOrEmpty(operador))
                {
                    var izq = expr.Hijos[0];
                    var der = expr.Hijos[1];
                    string izqVal = izq.Valor?.ToString();
                    string derVal = der.Valor?.ToString();
                    
                    bool esInt = int.TryParse(izqVal, out _) || int.TryParse(derVal, out _);
                    bool esFloat = izqVal?.Contains(".") == true || derVal?.Contains(".") == true;
                    bool esBool = izqVal == "true" || izqVal == "false" || derVal == "true" || derVal == "false";
                    bool esString = izqVal?.StartsWith("\"") == true || derVal?.StartsWith("\"") == true;

                    switch (operador)
                    {
                        case "==":
                            _code.AppendLine($"    // Comparación de igualdad");
                            if (esInt || esBool)
                                GenerateIntComparison(izqVal, derVal, falseLabel);
                            else if (esFloat)
                                GenerateFloatComparison(izqVal, derVal, falseLabel);
                            else if (esString)
                                GenerateStringComparison(izqVal, derVal, falseLabel);
                            else
                                GenerateGenericComparison(izqVal, derVal, falseLabel);
                            return;
                            
                        case ">":
                            _code.AppendLine($"    // Comparación mayor que");
                            if (esInt)
                                GenerateIntGreaterThan(izqVal, derVal, falseLabel);
                            else if (esFloat)
                                GenerateFloatGreaterThan(izqVal, derVal, falseLabel);
                            else
                                GenerateGenericComparison(izqVal, derVal, falseLabel);
                            return;
                            
                        case "<":
                            _code.AppendLine($"    // Comparación menor que");
                            if (esInt)
                                GenerateIntLessThan(izqVal, derVal, falseLabel);
                            else if (esFloat)
                                GenerateFloatLessThan(izqVal, derVal, falseLabel);
                            else
                                GenerateGenericComparison(izqVal, derVal, falseLabel);
                            return;
                        case ">=":
                            _code.AppendLine($"    // Comparación mayor o igual que");
                            if (esInt)
                                GenerateIntGreaterOrEqual(izqVal, derVal, falseLabel);
                            else if (esFloat)
                                GenerateFloatGreaterOrEqual(izqVal, derVal, falseLabel);
                            else
                                GenerateGenericComparison(izqVal, derVal, falseLabel);
                            return;
                        
                        case "<=":
                            _code.AppendLine($"    // Comparación menor o igual que");
                            if (esInt)
                                GenerateIntLessOrEqual(izqVal, derVal, falseLabel);
                            else if (esFloat)
                                GenerateFloatLessOrEqual(izqVal, derVal, falseLabel);
                            else
                                GenerateGenericComparison(izqVal, derVal, falseLabel);
                            return;
                        case "&&":
                            _code.AppendLine($"    // Operación AND lógica");
                            GenerateLogicalAnd(izq, der, falseLabel);
                            return;
                        case "||":
                            _code.AppendLine($"    // Operación OR lógica");
                            GenerateLogicalOr(izq, der, falseLabel);
                            return;
                    }
                }
            }else if (expr.Tipo == "Operacion" && expr.Valor?.ToString() == "!")
            {
                _code.AppendLine($"    // Operación NOT");
                if (expr.Hijos != null && expr.Hijos.Count >= 1)
                {
                    // Para operación NOT, invertimos el sentido del salto
                    var operandoNot = expr.Hijos[0];
                    var subCondicion = new NodoAST
                    {
                        Tipo = "Condicion",
                        Hijos = new List<NodoAST> { operandoNot }
                    };
                    
                    // Invertimos la lógica: si operandoNot es verdadero, saltamos al falseLabel
                    GenerateModifiedCondCheck(subCondicion, falseLabel, true);
                }
                return;
            }
            
            // Resto del código original para otros tipos de condiciones
            string exprValue = expr.Valor?.ToString() ?? "false";
            
            if (exprValue == "true")
            {
                _code.AppendLine($"    // Condición siempre verdadera, no se salta");
                return;
            }
            else if (exprValue == "false")
            {
                _code.AppendLine($"    // Condición siempre falsa, salto incondicional");
                _code.AppendLine($"    b {falseLabel}");
                return;
            }
            
            // Variable booleana
            if (_variables.TryGetValue(exprValue, out string memLoc))
            {
                _code.AppendLine($"    // Cargar variable booleana {exprValue}");
                _code.AppendLine($"    ldr x0, {memLoc}");
                _code.AppendLine($"    cmp x0, #0");
                _code.AppendLine($"    beq {falseLabel}");
            }
            else
            {
                _code.AppendLine($"    // ADVERTENCIA: No se pudo evaluar condición '{exprValue}'");
                _code.AppendLine($"    mov x0, #0");
                _code.AppendLine($"    cmp x0, #0");
                _code.AppendLine($"    beq {falseLabel}");
            }
        }

        private void GenerateModifiedCondCheck(NodoAST condNodo, string targetLabel, bool invertResult)
        {
            if (condNodo?.Hijos == null || condNodo.Hijos.Count == 0) return;
            
            var expr = condNodo.Hijos[0];
            string exprValue = expr.Valor?.ToString() ?? "false";
            
            if (exprValue == "true")
            {
                if (invertResult)
                    _code.AppendLine($"    b {targetLabel}");
                return;
            }
            else if (exprValue == "false")
            {
                if (!invertResult)
                    _code.AppendLine($"    b {targetLabel}");
                return;
            }
            
            // Variable booleana
            if (_variables.TryGetValue(exprValue, out string memLoc))
            {
                _code.AppendLine($"    ldr x0, {memLoc}");
                _code.AppendLine($"    cmp x0, #0");
                if (invertResult)
                    _code.AppendLine($"    bne {targetLabel}"); // Saltar si NO es cero (es verdadero)
                else
                    _code.AppendLine($"    beq {targetLabel}"); // Saltar si es cero (es falso)
            }
        }

        // Método auxiliar para comparación de enteros o booleanos
        private void GenerateIntComparison(string izqVal, string derVal, string falseLabel)
        {
            // Cargar primer operando
            if (_variables.TryGetValue(izqVal, out string izqMem))
            {
                _code.AppendLine($"    ldr x0, {izqMem}");
            }
            else
            {
                int valor = izqVal == "true" ? 1 : (izqVal == "false" ? 0 : int.Parse(izqVal));
                _code.AppendLine($"    mov x0, #{valor}");
            }
            
            // Cargar segundo operando
            if (_variables.TryGetValue(derVal, out string derMem))
            {
                _code.AppendLine($"    ldr x1, {derMem}");
            }
            else
            {
                int valor = derVal == "true" ? 1 : (derVal == "false" ? 0 : int.Parse(derVal));
                _code.AppendLine($"    mov x1, #{valor}");
            }
            
            // Comparar y saltar si no son iguales
            _code.AppendLine($"    cmp x0, x1");
            _code.AppendLine($"    bne {falseLabel}");
        }

        // Método auxiliar para comparación de flotantes
        private void GenerateFloatComparison(string izqVal, string derVal, string falseLabel)
        {
            // Cargar primer operando
            if (_variables.TryGetValue(izqVal, out string izqMem))
            {
                _code.AppendLine($"    ldr d0, {izqMem}");
            }
            else if (double.TryParse(izqVal, out double floatVal1))
            {
                string litLabel1 = $"float_{_labelCounter++}";
                _dataSection.Add($"{litLabel1}: .double {izqVal.Replace(',', '.')}");
                _code.AppendLine($"    adr x0, {litLabel1}");
                _code.AppendLine($"    ldr d0, [x0]");
            }
            
            // Cargar segundo operando
            if (_variables.TryGetValue(derVal, out string derMem))
            {
                _code.AppendLine($"    ldr d1, {derMem}");
            }
            else if (double.TryParse(derVal, out double floatVal2))
            {
                string litLabel2 = $"float_{_labelCounter++}";
                _dataSection.Add($"{litLabel2}: .double {derVal.Replace(',', '.')}");
                _code.AppendLine($"    adr x0, {litLabel2}");
                _code.AppendLine($"    ldr d1, [x0]");
            }
            
            // Comparar flotantes y saltar si no son iguales
            _code.AppendLine($"    fcmp d0, d1");
            _code.AppendLine($"    bne {falseLabel}");
        }

        private void GenerateStringComparison(string izqVal, string derVal, string falseLabel)
        {
            _code.AppendLine($"    // Comparación de cadenas: {izqVal} == {derVal}");
            
            // Cargar dirección de la primera cadena
            if (_variables.TryGetValue(izqVal, out string izqMem))
            {
                _code.AppendLine($"    ldr x0, {izqMem}");
            }
            else if (izqVal?.StartsWith("\"") == true && izqVal?.EndsWith("\"") == true)
            {
                // Es un literal de cadena
                string cleanText = izqVal.Substring(1, izqVal.Length - 2);
                string litLabel = $"strlit_{_labelCounter++}";
                _dataSection.Add($"{litLabel}: .asciz \"{cleanText}\"");
                _code.AppendLine($"    adr x0, {litLabel}");
            }
            else
            {
                _code.AppendLine($"    mov x0, #0  // NULL si no hay valor");
            }
            
            // Cargar dirección de la segunda cadena
            if (_variables.TryGetValue(derVal, out string derMem))
            {
                _code.AppendLine($"    ldr x1, {derMem}");
            }
            else if (derVal?.StartsWith("\"") == true && derVal?.EndsWith("\"") == true)
            {
                // Es un literal de cadena
                string cleanText = derVal.Substring(1, derVal.Length - 2);
                string litLabel = $"strlit_{_labelCounter++}";
                _dataSection.Add($"{litLabel}: .asciz \"{cleanText}\"");
                _code.AppendLine($"    adr x1, {litLabel}");
            }
            else
            {
                _code.AppendLine($"    mov x1, #0  // NULL si no hay valor");
            }
            
            // Llamar a función auxiliar para comparar cadenas
            _code.AppendLine($"    bl string_compare");
            
            // Si el resultado es 0, las cadenas son iguales
            _code.AppendLine($"    cmp x0, #0");
            _code.AppendLine($"    bne {falseLabel}");
        }

        // Método auxiliar para comparación genérica (variables cuyo tipo no se conoce estáticamente)
        private void GenerateGenericComparison(string izqVal, string derVal, string falseLabel)
        {
            // Aproximación simplificada - asumimos que son enteros
            if (_variables.TryGetValue(izqVal, out string izqMem))
            {
                _code.AppendLine($"    ldr x0, {izqMem}");
            }
            else
            {
                _code.AppendLine($"    mov x0, #0  // Valor por defecto");
            }
            
            if (_variables.TryGetValue(derVal, out string derMem))
            {
                _code.AppendLine($"    ldr x1, {derMem}");
            }
            else
            {
                _code.AppendLine($"    mov x1, #0  // Valor por defecto");
            }
            
            _code.AppendLine($"    cmp x0, x1");
            _code.AppendLine($"    bne {falseLabel}");
        }

        //operacion de mayor y menor que
        private void GenerateIntGreaterThan(string izqVal, string derVal, string falseLabel)
        {
            // Cargar primer operando
            if (_variables.TryGetValue(izqVal, out string izqMem))
            {
                _code.AppendLine($"    ldr x0, {izqMem}");
            }
            else if (int.TryParse(izqVal, out int i))
            {
                _code.AppendLine($"    mov x0, #{i}");
            }
            else
            {
                _code.AppendLine($"    mov x0, #0");  // Valor por defecto
            }
            
            // Cargar segundo operando
            if (_variables.TryGetValue(derVal, out string derMem))
            {
                _code.AppendLine($"    ldr x1, {derMem}");
            }
            else if (int.TryParse(derVal, out int i))
            {
                _code.AppendLine($"    mov x1, #{i}");
            }
            else
            {
                _code.AppendLine($"    mov x1, #0");  // Valor por defecto
            }
            
            // Comparar: saltar si izq <= der (inverso de >)
            _code.AppendLine($"    cmp x0, x1");
            _code.AppendLine($"    ble {falseLabel}");
        }

        private void GenerateIntLessThan(string izqVal, string derVal, string falseLabel)
        {
            // Cargar primer operando
            if (_variables.TryGetValue(izqVal, out string izqMem))
            {
                _code.AppendLine($"    ldr x0, {izqMem}");
            }
            else if (int.TryParse(izqVal, out int i))
            {
                _code.AppendLine($"    mov x0, #{i}");
            }
            else
            {
                _code.AppendLine($"    mov x0, #0");  // Valor por defecto
            }
            
            // Cargar segundo operando
            if (_variables.TryGetValue(derVal, out string derMem))
            {
                _code.AppendLine($"    ldr x1, {derMem}");
            }
            else if (int.TryParse(derVal, out int i))
            {
                _code.AppendLine($"    mov x1, #{i}");
            }
            else
            {
                _code.AppendLine($"    mov x1, #0");  // Valor por defecto
            }
            
            // Comparar: saltar si izq >= der (inverso de <)
            _code.AppendLine($"    cmp x0, x1");
            _code.AppendLine($"    bge {falseLabel}");
        }

        private void GenerateFloatGreaterThan(string izqVal, string derVal, string falseLabel)
        {
            // Cargar primer operando
            if (_variables.TryGetValue(izqVal, out string izqMem))
            {
                _code.AppendLine($"    ldr d0, {izqMem}");
            }
            else if (double.TryParse(izqVal, out double floatVal1))
            {
                string litLabel1 = $"float_{_labelCounter++}";
                _dataSection.Add($"{litLabel1}: .double {izqVal.Replace(',', '.')}");
                _code.AppendLine($"    adr x0, {litLabel1}");
                _code.AppendLine($"    ldr d0, [x0]");
            }
            
            // Cargar segundo operando
            if (_variables.TryGetValue(derVal, out string derMem))
            {
                _code.AppendLine($"    ldr d1, {derMem}");
            }
            else if (double.TryParse(derVal, out double floatVal2))
            {
                string litLabel2 = $"float_{_labelCounter++}";
                _dataSection.Add($"{litLabel2}: .double {derVal.Replace(',', '.')}");
                _code.AppendLine($"    adr x0, {litLabel2}");
                _code.AppendLine($"    ldr d1, [x0]");
            }
            
            // Comparar flotantes: saltar si NO cumple la condición
            _code.AppendLine($"    fcmp d0, d1");
            _code.AppendLine($"    ble {falseLabel}");  // Si es menor o igual, saltar (no es mayor)
        }

        private void GenerateFloatLessThan(string izqVal, string derVal, string falseLabel)
        {
            // Cargar primer operando
            if (_variables.TryGetValue(izqVal, out string izqMem))
            {
                _code.AppendLine($"    ldr d0, {izqMem}");
            }
            else if (double.TryParse(izqVal, out double floatVal1))
            {
                string litLabel1 = $"float_{_labelCounter++}";
                _dataSection.Add($"{litLabel1}: .double {izqVal.Replace(',', '.')}");
                _code.AppendLine($"    adr x0, {litLabel1}");
                _code.AppendLine($"    ldr d0, [x0]");
            }
            
            // Cargar segundo operando
            if (_variables.TryGetValue(derVal, out string derMem))
            {
                _code.AppendLine($"    ldr d1, {derMem}");
            }
            else if (double.TryParse(derVal, out double floatVal2))
            {
                string litLabel2 = $"float_{_labelCounter++}";
                _dataSection.Add($"{litLabel2}: .double {derVal.Replace(',', '.')}");
                _code.AppendLine($"    adr x0, {litLabel2}");
                _code.AppendLine($"    ldr d1, [x0]");
            }
            
            // Comparar flotantes
            _code.AppendLine($"    fcmp d0, d1");
            _code.AppendLine($"    bge {falseLabel}");  // Si es mayor o igual, saltar (no es menor)
        }

        private void GenerateIntGreaterOrEqual(string izqVal, string derVal, string falseLabel)
        {
            // Cargar primer operando
            if (_variables.TryGetValue(izqVal, out string izqMem))
            {
                _code.AppendLine($"    ldr x0, {izqMem}");
            }
            else if (int.TryParse(izqVal, out int i))
            {
                _code.AppendLine($"    mov x0, #{i}");
            }
            else
            {
                _code.AppendLine($"    mov x0, #0");  // Valor por defecto
            }
            
            // Cargar segundo operando
            if (_variables.TryGetValue(derVal, out string derMem))
            {
                _code.AppendLine($"    ldr x1, {derMem}");
            }
            else if (int.TryParse(derVal, out int i))
            {
                _code.AppendLine($"    mov x1, #{i}");
            }
            else
            {
                _code.AppendLine($"    mov x1, #0");  // Valor por defecto
            }
            
            // Comparar: saltar si izq < der (inverso de >=)
            _code.AppendLine($"    cmp x0, x1");
            _code.AppendLine($"    blt {falseLabel}");
        }

        private void GenerateIntLessOrEqual(string izqVal, string derVal, string falseLabel)
        {
            // Cargar primer operando
            if (_variables.TryGetValue(izqVal, out string izqMem))
            {
                _code.AppendLine($"    ldr x0, {izqMem}");
            }
            else if (int.TryParse(izqVal, out int i))
            {
                _code.AppendLine($"    mov x0, #{i}");
            }
            else
            {
                _code.AppendLine($"    mov x0, #0");  // Valor por defecto
            }
            
            // Cargar segundo operando
            if (_variables.TryGetValue(derVal, out string derMem))
            {
                _code.AppendLine($"    ldr x1, {derMem}");
            }
            else if (int.TryParse(derVal, out int i))
            {
                _code.AppendLine($"    mov x1, #{i}");
            }
            else
            {
                _code.AppendLine($"    mov x1, #0");  // Valor por defecto
            }
            
            // Comparar: saltar si izq > der (inverso de <=)
            _code.AppendLine($"    cmp x0, x1");
            _code.AppendLine($"    bgt {falseLabel}");
        }

        private void GenerateFloatGreaterOrEqual(string izqVal, string derVal, string falseLabel)
        {
            // Cargar primer operando
            if (_variables.TryGetValue(izqVal, out string izqMem))
            {
                _code.AppendLine($"    ldr d0, {izqMem}");
            }
            else if (double.TryParse(izqVal, out double floatVal1))
            {
                string litLabel1 = $"float_{_labelCounter++}";
                _dataSection.Add($"{litLabel1}: .double {izqVal.Replace(',', '.')}");
                _code.AppendLine($"    adr x0, {litLabel1}");
                _code.AppendLine($"    ldr d0, [x0]");
            }
            
            // Cargar segundo operando
            if (_variables.TryGetValue(derVal, out string derMem))
            {
                _code.AppendLine($"    ldr d1, {derMem}");
            }
            else if (double.TryParse(derVal, out double floatVal2))
            {
                string litLabel2 = $"float_{_labelCounter++}";
                _dataSection.Add($"{litLabel2}: .double {derVal.Replace(',', '.')}");
                _code.AppendLine($"    adr x0, {litLabel2}");
                _code.AppendLine($"    ldr d1, [x0]");
            }
            
            // Comparar flotantes: saltar si no cumple la condición
            _code.AppendLine($"    fcmp d0, d1");
            _code.AppendLine($"    blt {falseLabel}");  // Si es menor, saltar (no es mayor o igual)
        }

        private void GenerateFloatLessOrEqual(string izqVal, string derVal, string falseLabel)
        {
            // Cargar primer operando
            if (_variables.TryGetValue(izqVal, out string izqMem))
            {
                _code.AppendLine($"    ldr d0, {izqMem}");
            }
            else if (double.TryParse(izqVal, out double floatVal1))
            {
                string litLabel1 = $"float_{_labelCounter++}";
                _dataSection.Add($"{litLabel1}: .double {izqVal.Replace(',', '.')}");
                _code.AppendLine($"    adr x0, {litLabel1}");
                _code.AppendLine($"    ldr d0, [x0]");
            }
            
            // Cargar segundo operando
            if (_variables.TryGetValue(derVal, out string derMem))
            {
                _code.AppendLine($"    ldr d1, {derMem}");
            }
            else if (double.TryParse(derVal, out double floatVal2))
            {
                string litLabel2 = $"float_{_labelCounter++}";
                _dataSection.Add($"{litLabel2}: .double {derVal.Replace(',', '.')}");
                _code.AppendLine($"    adr x0, {litLabel2}");
                _code.AppendLine($"    ldr d1, [x0]");
            }
            
            // Comparar flotantes
            _code.AppendLine($"    fcmp d0, d1");
            _code.AppendLine($"    bgt {falseLabel}");  // Si es mayor, saltar (no es menor o igual)
        
        }

        private void GenerateLogicalOr(NodoAST izqNodo, NodoAST derNodo, string falseLabel)
        {
            string trueLabel = $"true_or_{_labelCounter++}";
            _code.AppendLine($"    // Evaluar primer operando del OR");
            
            // Si el primer operando es un valor directo como true/false
            if (izqNodo.Valor?.ToString() == "true")
            {
                // Si es true, cortocircuito - resultado es true
                _code.AppendLine($"    // Primer operando es true, resultado es true (cortocircuito)");
                return; // No saltamos al falseLabel, significa que la condición se cumplió
            }
            else if (izqNodo.Valor?.ToString() == "false")
            {
                // Si es false, evaluar segundo operando
                _code.AppendLine($"    // Primer operando es false, evaluar segundo operando");
                var subCondicion = new NodoAST
                {
                    Tipo = "Condicion",
                    Hijos = new List<NodoAST> { derNodo }
                };
                GenerateConditionCheck(subCondicion, falseLabel);
            }
            else if (izqNodo.Tipo == "Operacion")
            {
                // Si el primer operando es una operación, evaluarla
                
                // Crear un nodo condición temporal para el operando izquierdo
                var izqCondicion = new NodoAST
                {
                    Tipo = "Condicion",
                    Hijos = new List<NodoAST> { izqNodo }
                };
                
                // Crear una etiqueta para saltar si el primer operando es verdadero
                _code.AppendLine($"    // Evaluando primer operando del OR");
                
                // Evaluar izquierdo invertido: saltamos a la etiqueta true si es verdadero
                string skipRightOperand = $"skip_right_{_labelCounter++}";
                
                // Para operaciones, generamos código específico
                _code.AppendLine($"    // Evaluando operación izquierda del OR");
                
                // Aquí invertimos la lógica: saltamos a skipRightOperand si es verdadero
                GenerateModifiedCondCheck(izqCondicion, skipRightOperand, true);
                
                // Si llegamos aquí, el primer operando es falso, evaluar el segundo
                _code.AppendLine($"    // Primer operando es falso, evaluar segundo operando");
                var derCondicion = new NodoAST
                {
                    Tipo = "Condicion",
                    Hijos = new List<NodoAST> { derNodo }
                };
                GenerateConditionCheck(derCondicion, falseLabel);
                
                // Saltamos aquí si el primer operando es verdadero
                _code.AppendLine($"{skipRightOperand}:");
            }
            else if (_variables.TryGetValue(izqNodo.Valor?.ToString(), out string izqMem))
            {
                // Si es una variable, cargar su valor y comprobar
                _code.AppendLine($"    // Cargar y comprobar variable booleana {izqNodo.Valor}");
                _code.AppendLine($"    ldr x0, {izqMem}");
                _code.AppendLine($"    cmp x0, #0");
                
                // Si la variable es verdadera (no es 0), saltar a la etiqueta de verdadero
                string skipRightOperand = $"skip_right_{_labelCounter++}";
                _code.AppendLine($"    bne {skipRightOperand}");
                
                // Si llegamos aquí, el primer operando es falso, evaluar el segundo
                _code.AppendLine($"    // Primer operando es falso, evaluar segundo operando");
                var derCondicion = new NodoAST
                {
                    Tipo = "Condicion",
                    Hijos = new List<NodoAST> { derNodo }
                };
                GenerateConditionCheck(derCondicion, falseLabel);
                
                // Etiqueta para saltar si el primer operando es verdadero
                _code.AppendLine($"{skipRightOperand}:");
            }
            else
            {
                // Caso genérico - intentamos evaluar ambos operandos
                _code.AppendLine($"    // Evaluando operación OR genérica");
                
                // Crear etiqueta para saltar si primer operando es verdadero
                string skipRightOperand = $"skip_right_{_labelCounter++}";
                
                // Evaluar primer operando - si es verdadero, saltamos a skipRightOperand
                var izqCondicion = new NodoAST
                {
                    Tipo = "Condicion",
                    Hijos = new List<NodoAST> { izqNodo }
                };
                GenerateModifiedCondCheck(izqCondicion, skipRightOperand, true);
                
                // Si llegamos aquí, el primer operando es falso, evaluar segundo operando
                var derCondicion = new NodoAST
                {
                    Tipo = "Condicion",
                    Hijos = new List<NodoAST> { derNodo }
                };
                GenerateConditionCheck(derCondicion, falseLabel);
                
                // Etiqueta donde saltamos si primer operando es verdadero
                _code.AppendLine($"{skipRightOperand}:");
            }
        }
        private void GeneratePrintRune(string memoryLocation, string varName)
        {
            _code.AppendLine($"    // Imprimir rune: {varName}");
            _code.AppendLine($"    mov x0, #1");                 // stdout
            _code.AppendLine($"    sub sp, sp, #1");              // reservar 1 byte
            _code.AppendLine($"    ldr w1, {memoryLocation}");    // cargar carácter
            _code.AppendLine($"    strb w1, [sp]");               // escribirlo en el stack
            _code.AppendLine($"    mov x1, sp");                  // puntero al byte
            _code.AppendLine($"    mov x2, #1");                  // longitud
            _code.AppendLine($"    mov x8, #64");                 // write syscall
            _code.AppendLine($"    svc #0");
            _code.AppendLine($"    add sp, sp, #1");              // limpiar stack
        }

        private void GenerateLogicalAnd(NodoAST izqNodo, NodoAST derNodo, string falseLabel)
        {
            _code.AppendLine($"    // Evaluar primer operando del AND");
            
            // Si el primer operando es un valor directo como true/false
            if (izqNodo.Valor?.ToString() == "true")
            {
                // Si es true, evaluar el segundo operando
                _code.AppendLine($"    // Primer operando es true, evaluar segundo operando");
                var subCondicion = new NodoAST
                {
                    Tipo = "Condicion",
                    Hijos = new List<NodoAST> { derNodo }
                };
                GenerateConditionCheck(subCondicion, falseLabel);
            }
            else if (izqNodo.Valor?.ToString() == "false")
            {
                // Si es false, corto circuito directo a falseLabel
                _code.AppendLine($"    // Primer operando es false, resultado es false");
                _code.AppendLine($"    b {falseLabel}");
            }
            else if (izqNodo.Tipo == "Operacion")
            {
                // Si el primer operando es una operación, evaluarla
                string evalLabel = $"eval_right_{_labelCounter++}";
                
                // Crear un nodo condición temporal para el operando izquierdo
                var izqCondicion = new NodoAST
                {
                    Tipo = "Condicion",
                    Hijos = new List<NodoAST> { izqNodo }
                };
                
                // Evaluar izquierdo - si es falso, saltar a falseLabel
                GenerateConditionCheck(izqCondicion, falseLabel);
                
                // Si llegamos aquí, es verdadero. Evaluar derecho
                _code.AppendLine($"    // Primer operando es true, evaluar segundo operando");
                var derCondicion = new NodoAST
                {
                    Tipo = "Condicion",
                    Hijos = new List<NodoAST> { derNodo }
                };
                GenerateConditionCheck(derCondicion, falseLabel);
            }
            else if (_variables.TryGetValue(izqNodo.Valor?.ToString(), out string izqMem))
            {
                // Si es una variable, cargar su valor y comprobar
                _code.AppendLine($"    // Cargar y comprobar variable booleana {izqNodo.Valor}");
                _code.AppendLine($"    ldr x0, {izqMem}");
                _code.AppendLine($"    cmp x0, #0");
                _code.AppendLine($"    beq {falseLabel}");
                
                // Si primer operando es true, evaluar el segundo
                var derCondicion = new NodoAST
                {
                    Tipo = "Condicion",
                    Hijos = new List<NodoAST> { derNodo }
                };
                GenerateConditionCheck(derCondicion, falseLabel);
            }
            else
            {
                // Caso genérico - siempre realizar ambas evaluaciones
                _code.AppendLine($"    // Evaluando operación AND compleja");
                
                // Crear condiciones temporales
                var izqCondicion = new NodoAST
                {
                    Tipo = "Condicion",
                    Hijos = new List<NodoAST> { izqNodo }
                };
                var derCondicion = new NodoAST
                {
                    Tipo = "Condicion",
                    Hijos = new List<NodoAST> { derNodo }
                };
                
                // Evaluar izquierda - si es falso, saltar a falseLabel
                GenerateConditionCheck(izqCondicion, falseLabel);
                
                // Evaluar derecha
                GenerateConditionCheck(derCondicion, falseLabel);
            }
        }

        private void GenerateNewLine()
        {
            string newlineLabel = $"newline_{_labelCounter++}";
            _dataSection.Add($"{newlineLabel}: .asciz \"\\n\"");
            
            _code.AppendLine("    // Imprimir salto de línea");
            _code.AppendLine($"    adr x0, {newlineLabel}");  // CORRECCIÓN: adr en vez de mov
            _code.AppendLine($"    bl string_length");         // Obtener longitud real
            _code.AppendLine($"    mov x2, x0");               // Usar longitud devuelta
            _code.AppendLine($"    mov x0, #1");               // stdout
            _code.AppendLine($"    adr x1, {newlineLabel}");
            _code.AppendLine($"    mov x8, #64");              // write syscall
            _code.AppendLine($"    svc #0");
        }
        private void GenerateHelperFunctions()
        {
            // llama a la versión con parámetros, pasando _code
            GenerateHelperFunctions(_code);
        }


        private void GenerateHelperFunctions(StringBuilder sb)
        {
            // Agregar al final de la sección de código

            _code.AppendLine("\n// Rutinas auxiliares");

            // Función para convertir float a string
            sb.AppendLine("\nstring_copy:");
            sb.AppendLine("    // x0 = destino, x1 = origen");
            sb.AppendLine("    cmp x1, #0");           // Verificar si origen es NULL
            sb.AppendLine("    beq string_copy_null");  // Saltar si es NULL
            sb.AppendLine("    mov x2, x0");           // Guardar dirección de destino
            sb.AppendLine("string_copy_loop:");
            sb.AppendLine("    ldrb w3, [x1], #1");    // Cargar byte de origen y avanzar
            sb.AppendLine("    strb w3, [x0], #1");    // Guardar en destino y avanzar
            sb.AppendLine("    cmp w3, #0");           // ¿Fin de cadena?
            sb.AppendLine("    bne string_copy_loop");  // Continuar si no es fin
            sb.AppendLine("    sub x0, x0, #1");       // Retroceder para sobrescribir el nulo
            sb.AppendLine("    ret");
            sb.AppendLine("string_copy_null:");
            sb.AppendLine("    // Si origen es NULL, simplemente poner terminador nulo en destino");
            sb.AppendLine("    mov w3, #0");
            sb.AppendLine("    strb w3, [x0]");
            sb.AppendLine("    ret");
                        
            // Función para convertir entero a string
            sb.AppendLine("int_to_string:");
            sb.AppendLine("    // x0 = número, x1 = buffer");
            sb.AppendLine("    mov x9, x0        // Guardar número original");
            sb.AppendLine("    mov x10, x1       // Guardar dirección original del buffer");
            sb.AppendLine("    mov x11, #0       // Contador de dígitos");
            sb.AppendLine("    mov x12, #0       // Para contar dígitos totales");
            sb.AppendLine("    mov x14, #0       // Flag para indicar si es negativo");

            // Caso especial para el cero
            sb.AppendLine("    cmp x9, #0");
            sb.AppendLine("    bne count_digits");
            sb.AppendLine("    mov w2, #48       // '0'");
            sb.AppendLine("    strb w2, [x10]");
            sb.AppendLine("    mov w2, #0        // Null-terminator");
            sb.AppendLine("    strb w2, [x10, #1]");
            sb.AppendLine("    mov x0, #1");
            sb.AppendLine("    ret");

            sb.AppendLine("    // Verificar si es negativo");
            sb.AppendLine("    cmp x9, #0");
            sb.AppendLine("    bge positive_number");
            sb.AppendLine("    // Es negativo, imprimir '-'");
            sb.AppendLine("    neg x9, x9     // Convertir a positivo");
            sb.AppendLine("    mov w2, #45    // '-' en ASCII");
            sb.AppendLine("    strb w2, [x10], #1");
            sb.AppendLine("    mov x14, #1    // Flag para indicar que es negativo (afectará a la longitud final)");
            sb.AppendLine("positive_number:");

            // Primero contar dígitos
            sb.AppendLine("count_digits:");
            sb.AppendLine("    mov x2, x9        // Copiar número");
            sb.AppendLine("    mov x13, #10      // Constante 10 para división");  // Añade esta línea
            sb.AppendLine("digit_count_loop:");
            sb.AppendLine("    cbz x2, gen_digits");
            sb.AppendLine("    udiv x2, x2, x13  // Dividir por 10 usando registro");  // Modificada
            sb.AppendLine("    add x12, x12, #1  // Incrementar contador");
            sb.AppendLine("    b digit_count_loop");

            // Generar dígitos de izquierda a derecha
            sb.AppendLine("gen_digits:");
            sb.AppendLine("    mov x11, x12      // Longitud total");
            sb.AppendLine("    mov x2, #1        // Potencia de 10");
            sb.AppendLine("    mov x13, #10      // Base 10");

            sb.AppendLine("calc_power_loop:");
            sb.AppendLine("    cmp x12, #1       // Si solo queda 1 dígito, salir");
            sb.AppendLine("    ble extract_digits");
            sb.AppendLine("    mul x2, x2, x13   // Multiplicar por 10");
            sb.AppendLine("    sub x12, x12, #1  // Decrementar contador");
            sb.AppendLine("    b calc_power_loop");

            sb.AppendLine("extract_digits:");
            sb.AppendLine("    mov x3, x9        // Restaurar número");
            sb.AppendLine("    mov x12, x11      // Restaurar contador total");

            sb.AppendLine("extract_loop:");
            sb.AppendLine("    cbz x12, finish_str");
            sb.AppendLine("    udiv x4, x3, x2   // x4 = número / potencia");
            sb.AppendLine("    msub x3, x4, x2, x3 // x3 = x3 - (x4 * x2) (resto)");
            sb.AppendLine("    add w4, w4, #48   // Convertir a ASCII");
            sb.AppendLine("    strb w4, [x10], #1// Almacenar y avanzar");
            sb.AppendLine("    udiv x2, x2, x13  // Reducir potencia por 10 (x13=10)");
            sb.AppendLine("    sub x12, x12, #1  // Decrementar contador");
            sb.AppendLine("    b extract_loop");

            sb.AppendLine("finish_str:");
            sb.AppendLine("    mov w2, #0        // Null-terminator");
            sb.AppendLine("    strb w2, [x10]");
            sb.AppendLine("    // Si era negativo, incrementar longitud por el signo");
            sb.AppendLine("    cbz x14, return_length");
            sb.AppendLine("    add x11, x11, #1  // Ajustar longitud por el signo '-'");
            sb.AppendLine("return_length:");
            sb.AppendLine("    mov x0, x11       // Retornar longitud");
            sb.AppendLine("    ret");
            
            // Función para comparar cadenas (añadir en GenerateHelperFunctions)
            sb.AppendLine("\nstring_compare:");
            sb.AppendLine("    // x0 = primera cadena, x1 = segunda cadena");
            sb.AppendLine("    // Devuelve 0 si son iguales, no-0 si son diferentes");
            sb.AppendLine("    // Verificar si alguna es NULL");
            sb.AppendLine("    cmp x0, #0");
            sb.AppendLine("    beq check_second_null");
            sb.AppendLine("    cmp x1, #0");
            sb.AppendLine("    beq strings_not_equal");
            sb.AppendLine("    // Ambas no son NULL, comparar");
            sb.AppendLine("compare_loop:");
            sb.AppendLine("    ldrb w2, [x0], #1");
            sb.AppendLine("    ldrb w3, [x1], #1");
            sb.AppendLine("    cmp w2, w3");
            sb.AppendLine("    bne strings_not_equal");
            sb.AppendLine("    cbz w2, strings_equal"); // Si llegamos al terminador nulo y son iguales
            sb.AppendLine("    b compare_loop");
            sb.AppendLine("check_second_null:");
            sb.AppendLine("    cmp x1, #0");
            sb.AppendLine("    beq strings_equal");     // Si ambas son NULL son iguales
            sb.AppendLine("strings_not_equal:");
            sb.AppendLine("    mov x0, #1");           // No son iguales
            sb.AppendLine("    ret");
            sb.AppendLine("strings_equal:");
            sb.AppendLine("    mov x0, #0");           // Son iguales
            sb.AppendLine("    ret");

            // Función para obtener la longitud de una cadena
            // Función para obtener la longitud de una cadena
            sb.AppendLine("\nstring_length:");
            sb.AppendLine("    // x0 = dirección de la cadena");
            sb.AppendLine("    cmp x0, #0");           // Verificar si es NULL
            sb.AppendLine("    beq string_length_null"); // Saltar si es NULL
            sb.AppendLine("    mov x2, x0");           // Guardar dirección original
            sb.AppendLine("length_loop:");
            sb.AppendLine("    ldrb w1, [x0], #1  // cargar byte y avanzar");
            sb.AppendLine("    cmp w1, #0         // comparar con null");
            sb.AppendLine("    bne length_loop    // continuar si no es null");
            sb.AppendLine("    sub x0, x0, x2     // calcular longitud");
            sb.AppendLine("    sub x0, x0, #1     // ajustar por null");
            sb.AppendLine("    ret");
            // AÑADIR ESTA SECCIÓN:
            sb.AppendLine("string_length_null:");
            sb.AppendLine("    mov x0, #0         // Retornar 0 para cadenas NULL");
            sb.AppendLine("    ret");

            // Función para convertir float a string
            sb.AppendLine("\nfloat_to_string:");
            sb.AppendLine("    // Implementación mejorada");
            sb.AppendLine("    stp x29, x30, [sp, #-16]!");
            sb.AppendLine("    mov x29, sp");
            sb.AppendLine("    stp x19, x20, [sp, #-16]!");
            sb.AppendLine("    mov x19, x0                // Buffer address");
            sb.AppendLine("");
            sb.AppendLine("    // Extraer signo");
            sb.AppendLine("    mov x21, #0               // Flag para negativo");
            sb.AppendLine("    fcmpe d0, #0.0");
            sb.AppendLine("    bpl convert_integer");
            sb.AppendLine("    mov x21, #1               // Es negativo");
            sb.AppendLine("    fneg d0, d0               // Convertir a positivo");
            sb.AppendLine("    mov w1, #45               // '-'");
            sb.AppendLine("    strb w1, [x19], #1");
            sb.AppendLine("convert_integer:");
            sb.AppendLine("    // Convertir parte entera");
            sb.AppendLine("    fcvtzs x0, d0             // Convertir a entero");
            sb.AppendLine("    mov x1, x19               // Buffer para la parte entera");
            sb.AppendLine("    bl int_to_string          // Convertir entero");
            sb.AppendLine("    mov x20, x0               // Guardar longitud");
            sb.AppendLine("    cmp x21, #1               // Si era negativo");
            sb.AppendLine("    beq was_negative");
            sb.AppendLine("    add x19, x19, x0          // Avanzar buffer");
            sb.AppendLine("    b add_decimal");
            sb.AppendLine("was_negative:");
            sb.AppendLine("    add x19, x19, x0          // Avanzar buffer");
            sb.AppendLine("    add x20, x20, #1          // +1 por el signo");
            sb.AppendLine("add_decimal:");
            sb.AppendLine("    // Añadir punto");
            sb.AppendLine("    mov w1, #'.'");
            sb.AppendLine("    strb w1, [x19], #1");
            sb.AppendLine("    add x20, x20, #1");
            sb.AppendLine("");
            sb.AppendLine("    // Convertir 6 dígitos decimales");
            sb.AppendLine("    fcvtzs x0, d0             // Volver a convertir a entero");
            sb.AppendLine("    scvtf d1, x0              // Convertir entero a float");
            sb.AppendLine("    fsub d1, d0, d1           // Parte decimal = float - entero");
            sb.AppendLine("    mov x22, #2               // 6 dígitos decimales");
            sb.AppendLine("    fmov d2, #10.0            // Constante 10.0");
            sb.AppendLine("decimal_loop:");
            sb.AppendLine("    fmul d1, d1, d2           // d1 = d1 * 10");
            sb.AppendLine("    fcvtzs x0, d1             // Entero = int(d1)");
            sb.AppendLine("    add w0, w0, #48           // Convertir a ASCII");
            sb.AppendLine("    strb w0, [x19], #1        // Guardar y avanzar");
            sb.AppendLine("    add x20, x20, #1          // Incrementar longitud");
            sb.AppendLine("    scvtf d3, x0              // Convertir dígito a flotante");
            sb.AppendLine("    mov x0, #48               // Valor ASCII '0'");
            sb.AppendLine("    scvtf d4, x0              // Convertir 48 a float");
            sb.AppendLine("    fsub d3, d3, d4           // Restar ASCII offset");
            sb.AppendLine("    fsub d1, d1, d3           // Restar dígito");
            sb.AppendLine("    subs x22, x22, #1         // Decrementar contador");
            sb.AppendLine("    bne decimal_loop          // Continuar si no hemos terminado");
            sb.AppendLine("    // Terminar cadena");
            sb.AppendLine("    mov w1, #0");
            sb.AppendLine("    strb w1, [x19]");
            sb.AppendLine("");
            sb.AppendLine("    // Retornar longitud total");
            sb.AppendLine("    mov x0, x20");
            sb.AppendLine("    ldp x19, x20, [sp], #16");
            sb.AppendLine("    ldp x29, x30, [sp], #16");
            sb.AppendLine("    ret");
        }


        private int GetVariableOffset(string variableName)
        {
            // Calcular un offset único para cada variable
            int index = _variables.Count;
            if (_variables.ContainsKey(variableName))
            {
                // Obtener el índice específico para esta variable si ya existe
                index = _variables.Keys.ToList().IndexOf(variableName);
            }
            return 16 + (index * 8);
        }


        private string BuildFinalCode()
        {
            StringBuilder fullCode = new StringBuilder();
            
            // Sección .data - SOLO UNA VEZ al principio
            if (_dataSection.Count > 0)
            {
                fullCode.AppendLine(".data");
                foreach (var dataLine in _dataSection)
                {
                    // Escapar todos los caracteres = que no estén ya escapados
                    string formattedLine = dataLine;
                    if (formattedLine.Contains(": .asciz \"") && formattedLine.Contains("="))
                    {
                        int startIdx = formattedLine.IndexOf(": .asciz \"") + 10;
                        int endIdx = formattedLine.LastIndexOf("\"");
                        if (startIdx < endIdx)
                        {
                            string prefix = formattedLine.Substring(0, startIdx);
                            string content = formattedLine.Substring(startIdx, endIdx - startIdx);
                            string suffix = formattedLine.Substring(endIdx);
                            
                            // Escapar = que no estén precedidos por \
                            content = Regex.Replace(content, "(?<!\\\\)=", "\\\\=");
                            
                            formattedLine = prefix + content + suffix;
                        }
                    }
                    
                    formattedLine = formattedLine.Replace(",", ".");
                    fullCode.AppendLine(formattedLine);
                }
                fullCode.AppendLine();
            }
            
            // NO DUPLICAR LAS SECCIONES .text, .global _start - están ya en _code
            fullCode.Append(_code.ToString());
            
            // Saltar al final antes de rutinas auxiliares
            fullCode.AppendLine("\n    // Saltar directamente al final del programa");
            fullCode.AppendLine("    b program_exit");
            
            // Añadir rutinas auxiliares - SIN GENERAR LA SECCIÓN .data otra vez
            fullCode.AppendLine("\n// Rutinas auxiliares");
            
            // Usamos un StringBuilder limpio para generar las rutinas sin afectar _code
            StringBuilder auxiliaryCode = new StringBuilder();
            GenerateHelperFunctions(auxiliaryCode);
            
            // Solo añadimos el contenido de las funciones auxiliares, no la sección .data
            fullCode.Append(auxiliaryCode.ToString());
            
            // Etiqueta para el final del programa
            fullCode.AppendLine("\nprogram_exit:");
            fullCode.AppendLine("    // Terminar programa");
            fullCode.AppendLine("    mov sp, x29");
            fullCode.AppendLine("    ldp x29, x30, [sp], #16");
            fullCode.AppendLine("    mov x8, #93     // exit syscall");
            fullCode.AppendLine("    mov x0, #0      // exit code 0");
            fullCode.AppendLine("    svc #0          // supervisor call");
            
            return fullCode.ToString();
        }
        public void SaveToFile(string path)
        {
            File.WriteAllText(path, BuildFinalCode());
        }

        public string GenerateLabel(string prefix)
        {
            _labelCounter++;
            return $"{prefix}_{_labelCounter}";
        }
    }
}
//java -jar antlr-4.13.2-complete.jar -Dlanguage=CSharp -visitor -listener Language.g4

//aarch64-linux-gnu-as pruebas.s -o pruebas.o
//aarch64-linux-gnu-ld pruebas.o -o pruebas
//qemu-aarch64 ./pruebas