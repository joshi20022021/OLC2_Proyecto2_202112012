using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace API.compiler.ARM64
{
    public class ARM64Generator
    {
        private readonly StringBuilder _code = new StringBuilder();
        private int _labelCounter = 0;
        private Dictionary<string, string> _variables = new Dictionary<string, string>();
        private List<string> _dataSection = new List<string>();

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
            _code.AppendLine("    sub sp, sp, #128");
            
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
                // Depuración - ver la estructura del nodo
                _code.AppendLine($"\n    // Procesando nodo tipo: {nodo.Tipo}");
                
                // Buscar nodos de tipo "fmt.Println"
                if (nodo.Tipo == "fmt.Println")
                {
                    _code.AppendLine("\n    // fmt.Println detectado");
                    
                    // Procesar los argumentos de la llamada
                    var args = nodo.Hijos?.Where(h => h.Tipo == "Argumento" || h.Tipo == "string").ToList();
                    if (args != null && args.Count > 0)
                    {
                        List<string> varNames = new List<string>();
                        
                        // Debug - imprimir todos los argumentos
                        foreach (var arg in args)
                        {
                            _code.AppendLine($"    // Argumento: tipo={arg.Tipo}, valor={arg.Valor}");
                            
                            // Si es un literal directo
                            if (arg.Valor != null)
                            {
                                string valor = arg.Valor.ToString();
                                
                                // Asegurar que los literales de string tienen comillas
                                if (arg.Tipo == "string" && !valor.StartsWith("\""))
                                {
                                    varNames.Add($"\"{valor}\"");
                                }
                                else
                                {
                                    varNames.Add(valor);
                                }
                            }
                            
                            // Procesar hijos recursivamente
                            if (arg.Hijos != null && arg.Hijos.Count > 0)
                            {
                                RecursiveProcessArguments(arg.Hijos, varNames);
                            }
                        }
                        
                        // Generar código para imprimir estas variables
                        if (varNames.Count > 0)
                        {
                            _code.AppendLine($"    // Generando código para imprimir: {string.Join(", ", varNames)}");
                            GeneratePrintln(varNames, tablaSimbolos);
                        }
                    }
                    else
                    {
                        // fmt.Println sin argumentos - solo imprime salto de línea
                        GenerateNewLine();
                    }
                }
            }
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
                string valorStr = simbolo.Valor != null ? simbolo.Valor.ToString() : "0";

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
                    .Replace("\n", "\\n")     // Reemplazar saltos de línea
                    .Replace("\r", "\\r")     // Retorno de carro
                    .Replace("\t", "\\t")     // Tabulación
                    .Replace("\"", "\\\"");   // Comillas dobles

                    string label = GenerateLabel("lit");
                    _dataSection.Add($"{label}: .asciz \"{cleanText}\"");
                    
                    _code.AppendLine($"    // Imprimir literal: {cleanText}");
                    _code.AppendLine($"    mov x0, #1");
                    _code.AppendLine($"    adr x1, {label}");
                    _code.AppendLine($"    mov x2, #{cleanText.Length}");
                    _code.AppendLine($"    mov x8, #64");
                    _code.AppendLine($"    svc #0");
                    
                    // espacio entre argumentos (si no es el último)
                    if (varName != varNames.Last())
                    {
                        string space = GenerateLabel("space");
                        _dataSection.Add($"{space}: .asciz \" \"");
                        _code.AppendLine($"    mov x0, #1");
                        _code.AppendLine($"    adr x1, {space}");
                        _code.AppendLine($"    mov x2, #1");
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
            _code.AppendLine($"    bl string_length");
            _code.AppendLine($"    mov x2, x0"); // Longitud 
            _code.AppendLine($"    mov x0, #1"); // stdout
            _code.AppendLine($"    ldr x1, {memoryLocation}"); // Dirección de la cadena
            _code.AppendLine($"    mov x8, #64"); // write syscall
            _code.AppendLine($"    svc #0");
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


        private void GenerateNewLine()
        {
            string newlineLabel = $"newline_{_labelCounter++}";
            _dataSection.Add($"{newlineLabel}: .asciz \"\\n\"");
            
            _code.AppendLine("    // Imprimir salto de línea");
            _code.AppendLine($"    mov x0, #1"); // stdout
            _code.AppendLine($"    adr x1, {newlineLabel}");
            _code.AppendLine($"    mov x2, #1"); // Longitud 1
            _code.AppendLine($"    mov x8, #64"); // write syscall
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
            
            // Función para obtener la longitud de una cadena
            sb.AppendLine("\nstring_length:");
            sb.AppendLine("    // x0 = dirección de la cadena");
            sb.AppendLine("    mov x2, x0     // guardar dirección original");
            sb.AppendLine("length_loop:");
            sb.AppendLine("    ldrb w1, [x0], #1  // cargar byte y avanzar");
            sb.AppendLine("    cmp w1, #0         // comparar con null");
            sb.AppendLine("    bne length_loop    // continuar si no es null");
            sb.AppendLine("    sub x0, x0, x2     // calcular longitud");
            sb.AppendLine("    sub x0, x0, #1     // ajustar por null");
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
            sb.AppendLine("    mov x22, #6               // 6 dígitos decimales");
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
            return 16 + (_variables.Count * 8);
        }

        private string BuildFinalCode()
        {
            StringBuilder fullCode = new StringBuilder();
            
            // Sección .data
            if (_dataSection.Count > 0)
            {
                fullCode.AppendLine(".data");
                foreach (var dataLine in _dataSection)
                {
                    string formattedLine = dataLine.Replace(",", ".");
                    fullCode.AppendLine(formattedLine);
                }
                fullCode.AppendLine();
            }
            
            // Código principal completo 
            fullCode.Append(_code.ToString());
            
            // Saltar al final del programa antes de las rutinas auxiliares
            fullCode.AppendLine("\n    // Saltar directamente al final del programa");
            fullCode.AppendLine("    b program_exit");
            
            // Añadir rutinas auxiliares
            fullCode.AppendLine("\n// Rutinas auxiliares");
            StringBuilder auxiliaryCode = new StringBuilder();
            GenerateHelperFunctions(auxiliaryCode);
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
