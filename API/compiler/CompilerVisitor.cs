using System;
using System.Globalization;
using System.Collections.Generic;
using Antlr4.Runtime.Misc;
using Antlr4.Runtime.Tree;
using Antlr4.Runtime;
using API.compiler;
using API.compiler.ARM64;

namespace API.compiler
{
    public partial class CompilerVisitor : LanguageBaseVisitor<object>
    {
        private Dictionary<string, Funcion> tablaFunciones = new Dictionary<string, Funcion>();
        
        private Dictionary<string, MetodoStruct> _tablaFuncionesStruct = new();
        private Stack<Dictionary<string, EntradaSimbolo>> pilaEntornos = new Stack<Dictionary<string, EntradaSimbolo>>();
        private Stack<string> _ambitoActual = new Stack<string>();
        //errores 
         public List<CustomError> ErroresSemanticos { get; } = new List<CustomError>();
          private void AgregarError(string mensaje, int line, int column)
            {
                ErroresSemanticos.Add(new CustomError
                {
                    Line = line,
                    Column = column,
                    Message = mensaje,
                    Type = "Semántico"
                });
                mensajesSalida.Add($"ERROR DETECTADO: {mensaje}");
            }

        private bool EnCiclo = false;
        private bool EnSwitch = false;
        private bool EnFuncion = false;

        private readonly List<EntradaSimbolo> tablaSimbolos = new List<EntradaSimbolo>();
        private readonly List<string> mensajesSalida = new List<string>();
        private readonly List<NodoAST> nodosAST = new List<NodoAST>();

        public List<EntradaSimbolo> ObtenerTablaSimbolos() => tablaSimbolos;
        public List<NodoAST> ObtenerAST() => nodosAST;
        public List<string> ObtenerSalida() => mensajesSalida;

        public class BreakCommand { }

        public class ContinueCommand { }

        public string GenerarASTDOT(NodoAST raiz)
        {
            var generador = new ASTGraphGenerator();
            string dot = generador.GenerarDOT(raiz);
            Console.WriteLine("DOT generado:\n" + dot); // Log para verificar el DOT generado
            return dot;
        }
        private object AsignarEnMatriz(string nombre, long fila, long columna, object nuevoValor)
        {
            foreach (var entorno in pilaEntornos)
            {
                if (entorno.TryGetValue(nombre, out var entrada) && entrada.Valor is List<object> matriz)
                {
                    if (matriz[(int)fila] is List<object> sublista)
                    {
                        if (columna >= 0 && columna < sublista.Count)
                        {
                            sublista[(int)columna] = nuevoValor;
                            return nuevoValor;
                        }
                        else
                        {
                            throw new Exception("Índice de columna fuera de rango.");
                        }
                    }
                    else
                    {
                        throw new Exception("Fila no es un slice.");
                    }
                }
            }

            throw new Exception($"Variable '{nombre}' no encontrada.");
        }


                // visitor para la regla principal del programa

        public override object VisitPrograma(LanguageParser.ProgramaContext context) {
            try {
                //Registrar los structs
                foreach (LanguageParser.StructDeclaracionContext structDecl in context.declaracionStruct()) {
                    string nombreStruct = structDecl.IDENTIFICADOR().GetText();
                    var structDef = new StructDefinition { Nombre = nombreStruct };
                    StructManager.RegistrarStruct(structDef);
                }

                // Procesar structs
                foreach (var structDecl in context.declaracionStruct()) {
                    Visit(structDecl);
                }

                // Registrar funciones globales
                foreach (var funcDecl in context.funcionDeclaracion()) {
                    Visit(funcDecl);
                }

                // Procesar funciones de structs
                foreach (var funcStruct in context.funcionStruct()) {
                    Visit(funcStruct);
                }

                // Procesar declaraciones
                foreach (var decl in context.declaracion()) {
                    Visit(decl);
                }

                //Ejecutar main
                var funcionMain = context.funcionMain();
                if (funcionMain == null) {
                    AgregarError("No se encontró la función main().", context.Start.Line, context.Start.Column);
                    return null;
                }
                Visit(funcionMain);
            }
            catch (Exception ex) {
                AgregarError($"Error de parsing: {ex.Message}", context.Start.Line, context.Start.Column);
            }

            // Mostrar errores si existen
            if (ErroresSemanticos.Any()) {
                Console.WriteLine("\n===== ERRORES SEMÁNTICOS =====");
                foreach (var error in ErroresSemanticos) {
                    Console.WriteLine($"[Línea {error.Line}] {error.Message}");
                }
            }
            return null;
        }

        //visitar declaracion
        public override object VisitDeclaracion(LanguageParser.DeclaracionContext context)
        {
            string varName = context.IDENTIFICADOR().GetText();
            string varType = context.tipo()?.GetText();
            object value = context.expresion() != null ? Visit(context.expresion()) : null;

            // Manejar inicialización por defecto si no hay valor
            if (value == null)
            {
                switch (varType?.ToLower())
                {
                    case "int": value = 0L; break;       
                    case "float64": value = 0.0; break;  
                    case "string": value = ""; break;    
                    case "bool": value = false; break;  
                    default: 
                        // Si no hay tipo, error
                        if (varType == null)
                        {
                        var errorToken = context.IDENTIFICADOR().Symbol;
                        AgregarError($"Error: Tipo no especificado para '{varName}'.",
                                    errorToken.Line,
                                    errorToken.Column + 1); 
                        return null;
                        }
                        value = null; 
                        break;
                }
            }

            if (string.IsNullOrEmpty(varType))
            {
                varType = TipoDato.ObtenerNombreTipo(value);
            }

            Dictionary<string, EntradaSimbolo> entornoActual = new Dictionary<string, EntradaSimbolo>();
            if (pilaEntornos.Count > 0)
            {
                entornoActual = pilaEntornos.Peek();
            }
            else
            {
                // Si no hay entorno, usar el global
                entornoActual = new Dictionary<string, EntradaSimbolo>();
                pilaEntornos.Push(entornoActual);
            }

            var token = context.IDENTIFICADOR().Symbol;
            
            entornoActual[varName] = new EntradaSimbolo
            {
                Nombre = varName,
                TipoDato = varType,
                Valor = value,
                Ambito = _ambitoActual.Count > 0 ? _ambitoActual.Peek() : "Global",
                Linea = token.Line,
                Columna = token.Column + 1
            };
            if (value is List<object> lista)
                {
                    // Inferir tipo multidimensional basado en la estructura
                    string tipoInferido = InferirTipoSlice(lista);
                    entornoActual[varName].TipoDato = tipoInferido;
                }
                pilaEntornos.Peek()[varName] = new EntradaSimbolo
                {
                    Nombre = varName,
                    TipoDato = TipoDato.ObtenerNombreTipo(value),
                    Valor = value
                };
                var entrada = new EntradaSimbolo
            {
                TipoSimbolo = "Variable",
                Nombre = varName,
                TipoDato = varType,
                Ambito = _ambitoActual.Count > 0 ? _ambitoActual.Peek() : "Global",
                Linea = token.Line,
                Columna = token.Column + 1,
                Valor = value
            };

            // Agregar a tabla de símbolos GLOBAL
            tablaSimbolos.Add(entrada);

            return value;
        }     

        // visitor para una asignación de variable
        public override object VisitAsignar(LanguageParser.AsignarContext context)
        {
            var varName = context.IDENTIFICADOR().GetText();
            var value = Visit(context.expresion());
            var token = context.IDENTIFICADOR().Symbol;
            
            // Buscar en todos los entornos (código existente)
            foreach (var entorno in pilaEntornos)
            {
                if (entorno.ContainsKey(varName))
                {
                    entorno[varName].Valor = value;
                    Console.WriteLine($"DEBUG: Asignando {varName} = {value}");
                    
                    // AÑADIR: Crear nodo AST para la asignación
                    nodosAST.Add(new NodoAST {
                        Tipo = "Asignacion",
                        Hijos = new List<NodoAST> {
                            new NodoAST { Tipo = "Identificador", Valor = varName },
                            new NodoAST { Tipo = "Literal", Valor = value?.ToString() }
                        }
                    });
                    
                    return value;
                }
            }

            // Si no existe, crear la variable en el entorno actual
            if (pilaEntornos.Count > 0)
            {
                Console.WriteLine($"DEBUG: Creando variable {varName} por asignación directa");
                pilaEntornos.Peek()[varName] = new EntradaSimbolo
                {
                    Nombre = varName,
                    TipoDato = TipoDato.ObtenerNombreTipo(value),
                    Valor = value,
                    Ambito = _ambitoActual.Count > 0 ? _ambitoActual.Peek() : "Global",
                    Linea = token.Line,
                    Columna = token.Column + 1
                };
                
                // También agregar a la tabla de símbolos
                tablaSimbolos.Add(new EntradaSimbolo
                {
                    TipoSimbolo = "Variable",
                    Nombre = varName,
                    TipoDato = TipoDato.ObtenerNombreTipo(value),
                    Valor = value,
                    Ambito = _ambitoActual.Count > 0 ? _ambitoActual.Peek() : "Global",
                    Linea = token.Line,
                    Columna = token.Column + 1
                });
                
                return value;
            }

            // Si llegamos aquí, es un error
            AgregarError($"Error: La variable '{varName}' no está definida.", 
                        token.Line, 
                        token.Column + 1);
            return null;
        }

         // Visitor para el fmt.println
        // Actualizar VisitImprime para guardar información en el AST
        public override object VisitImprime(LanguageParser.ImprimeContext context)
        {
            List<string> valores = new List<string>();
            List<NodoAST> argumentos = new List<NodoAST>();
            
            foreach (var expr in context.expresion())
            {
                var resultado = Visit(expr);
                string valorFormateado = FormatearValor(resultado);
                valores.Add(valorFormateado);
                
                // Guardar información para el AST
                string nombreVar = null;
                if (expr is LanguageParser.IdentificadorContext idCtx)
                {
                    nombreVar = idCtx.IDENTIFICADOR().GetText();
                }
                
                argumentos.Add(new NodoAST 
                { 
                    Tipo = "Argumento", 
                    Valor = nombreVar ?? valorFormateado
                });
            }
            
            // Crear nodo AST para la llamada a fmt.Println
            nodosAST.Add(new NodoAST
            {
                Tipo = "fmt.Println",
                Hijos = argumentos
            });
            
            string salida = string.Join(" ", valores);
            mensajesSalida.Add(salida);
            return null;
        }


        // Función auxiliar recursiva para formatear
        private string FormatearValor(object valor)
        {
            if (valor == null)
                return "nulo";
                
            if (valor is StructInstance instancia)
            {
                // Código existente para structs...
                List<string> atributos = new List<string>();
                foreach (var attr in instancia.Definicion.Atributos)
                {
                    if (instancia.Valores.TryGetValue(attr.Key, out object val))
                        atributos.Add($"{attr.Key}: {FormatearValor(val)}");
                }
                return $"{{{string.Join(", ", atributos)}}}";
            }
            else if (valor is List<object> lista)
            {
                // Para listas/slices
                List<string> elementos = new List<string>();
                foreach (var elem in lista)
                {
                    elementos.Add(FormatearValor(elem));
                }
                return "[" + string.Join(" ", elementos) + "]";
            }
            else if (valor is string str)
            {
                return str;
            }
            else if (valor is double d)
            {
                if (Math.Floor(d) == d)
                    return d.ToString("0", CultureInfo.InvariantCulture);
                return d.ToString("0.######", CultureInfo.InvariantCulture);
            }
            else if (valor is bool b)
            {
                return b ? "true" : "false";
            }
            else if (valor is long l)
            {
                return l.ToString();
            }
            else if (valor is char c)
            {
                return c.ToString();
            }
            
            return valor?.ToString() ?? "nulo";
        }
        private object ProcesarCadenaLiteral(string texto)
        {
            string contenido = texto.Substring(1, texto.Length - 2);
            
            contenido = contenido.Replace("\\n", "\n")
                        .Replace("\\t", "\t")
                        .Replace("\\\"", "\"")
                        .Replace("\\'", "'");
                        
            Console.WriteLine($"DEBUG: Cadena procesada: '{contenido}'");
            
            return contenido;
        }
    
        // implementacion de slice basico
        public override object VisitSliceLiteral(LanguageParser.SliceLiteralContext context)
        {
            List<object> elementos = new List<object>();
            foreach (var elemCtx in context.sliceElemento())
            {
                var valor = Visit(elemCtx);
                if (valor != null)
                {
                    elementos.Add(valor);
                }
            }
            return elementos;
        }
        //visitar literales
        public override object VisitListLiteral(LanguageParser.ListLiteralContext context)
        {
            List<object> elementos = new List<object>();
            foreach (var expr in context.expresion())
            {
                var valor = Visit(expr);
                if (valor != null) 
                {
                    elementos.Add(valor);
                }
            }
            return elementos;
        }
        //tipo slice
        private string InferirTipoSlice(List<object> lista)
        {
            if (lista.Count == 0) return "[]indefinido";
            
            var primerElemento = lista[0];
            if (primerElemento is List<object>)
            {
                // Inferir tipo para matriz 2D
                string tipoSubLista = InferirTipoSlice((List<object>)primerElemento);
                return $"[]{tipoSubLista}";
            }
            return $"[]{TipoDato.ObtenerNombreTipo(primerElemento)}";
        }

        //visitar asignacion de slice
        public override object VisitAsignarSlice(LanguageParser.AsignarSliceContext context) {
            string nombre = context.IDENTIFICADOR().GetText();
            object indiceObj = Visit(context.expresion(0));
            object valor = Visit(context.expresion(1));

            if (indiceObj is long indice) {
                foreach (var entorno in pilaEntornos) {
                    if (entorno.TryGetValue(nombre, out var entrada) && entrada.Valor is List<object> lista) {
                        if (indice >= 0 && indice < lista.Count) {
                            lista[(int)indice] = valor;
                            return valor;
                        } else {
                            AgregarError("Índice fuera de rango", context.Start.Line, context.Start.Column);
                            return null; 
                        }
                    }
                }
                AgregarError($"Slice '{nombre}' no definido", context.Start.Line, context.Start.Column);
            } else {
                AgregarError("Índice no es un entero", context.Start.Line, context.Start.Column);
            }
            return null; 
        }


        //visitar acceso slice
        public override object VisitAccesoSlice(LanguageParser.AccesoSliceContext context)
        {
            string nombre = context.IDENTIFICADOR().GetText();
            object indice = Visit(context.expresion());

            foreach (var entorno in pilaEntornos)
            {
                if (entorno.ContainsKey(nombre))
                {
                    var valor = entorno[nombre].Valor;
                    if (valor is List<object> lista && indice is long idx)
                    {
                        try
                        {
                            return SliceHelper.AccesoSlice(lista, idx);
                        }
                        catch (Exception ex)
                        {
                            AgregarError($"Error: {ex.Message}", context.Start.Line, context.Start.Column);
                            return null; 
                        }
                    }
                }
            }

            AgregarError($"Error: la variable '{nombre}' no está definida o no es un slice.", context.Start.Line, context.Start.Column);
            return null; 
        }

        //visitar append
        public override object VisitFuncionAppend(LanguageParser.FuncionAppendContext context)
        {
            var slice = Visit(context.expresion(0));
            var nuevoElemento = Visit(context.expresion(1));

            if (slice is List<object> lista)
            {
                try
                {
                    return SliceHelper.Append(lista, nuevoElemento);
                }
                catch (Exception ex)
                {
                    AgregarError($"Error en append: {ex.Message}", context.Start.Line, context.Start.Column);
                    return null;
                }
            }

            AgregarError("Error: append solo se puede aplicar a slices.", context.Start.Line, context.Start.Column);
            return null;
        }


        //visit funcion len
        public override object VisitFuncionLen(LanguageParser.FuncionLenContext context) {
            var slice = Visit(context.expresion());
            if (slice is List<object> lista) {
                return lista.Count;
            }
            AgregarError("len requiere un slice", context.Start.Line, context.Start.Column);
            return 0;
        }

        //visit funcion Index
        public override object VisitFuncionIndex(LanguageParser.FuncionIndexContext context)
        {
            var slice = Visit(context.expresion(0));
            var valor = Visit(context.expresion(1));

            if (slice is List<object> lista)
            {
                for (int i = 0; i < lista.Count; i++)
                {
                    if (lista[i]?.Equals(valor) == true)
                    {
                        return i;
                    }
                }
                return -1; // No encontrado
            }
            AgregarError("slices.Index requiere un slice", context.Start.Line, context.Start.Column);
            return -1;
        }


                //visit join
        public override object VisitFuncionJoin(LanguageParser.FuncionJoinContext context)
        {
            var slice = Visit(context.expresion(0));
            var separador = Visit(context.expresion(1))?.ToString() ?? "";

            if (slice is List<object> lista && lista.All(x => x is string))
            {
                return string.Join(separador, lista.Cast<string>());
            }

            AgregarError("strings.Join requiere un slice de strings", context.Start.Line, context.Start.Column);
            return "";
        }

        //visitar acceso slice en 2D
        public override object VisitAccesoSlice2D(LanguageParser.AccesoSlice2DContext context) {
        string nombre = context.IDENTIFICADOR().GetText();
        object filaObj = Visit(context.expresion(0));
        object columnaObj = Visit(context.expresion(1));

        if (filaObj is long fila && columnaObj is long columna) {
            foreach (var entorno in pilaEntornos) {
                if (entorno.TryGetValue(nombre, out var entrada) && entrada.Valor is List<object> matriz) {
                    if (fila < 0 || fila >= matriz.Count) {
                        AgregarError($"Fila {fila} fuera de rango", context.Start.Line, context.Start.Column);
                        return null;
                    }
                    if (matriz[(int)fila] is List<object> filaLista) {
                        if (columna < 0 || columna >= filaLista.Count) {
                            AgregarError($"Columna {columna} fuera de rango", context.Start.Line, context.Start.Column);
                            return null;
                        }
                        return filaLista[(int)columna];
                    } else {
                        AgregarError("La fila no es un slice", context.Start.Line, context.Start.Column);
                        return null;
                    }
                }
            }
            AgregarError($"Variable '{nombre}' no definida", context.Start.Line, context.Start.Column);
            return null;
        } else {
            AgregarError("Índices deben ser enteros", context.Start.Line, context.Start.Column);
            return null;
        }
    }
        //visitar asignacion de matrices
        public override object VisitAsignarMatriz(LanguageParser.AsignarMatrizContext context)
        {
            string nombre = context.IDENTIFICADOR().GetText();
            var fila = Visit(context.expresion(0));
            var columna = Visit(context.expresion(1));
            var nuevoValor = Visit(context.expresion(2));

            if (fila is long f && columna is long c)
            {
                try
                {
                    return AsignarEnMatriz(nombre, f, c, nuevoValor);
                }
                catch (Exception ex)
                {
                    AgregarError($"Error: {ex.Message}", context.Start.Line, context.Start.Column);
                }
            }

            return null;
        }

       
     
        private StructInstance ObtenerOCrearAtributoAnidado(StructInstance instancia, string nombreAttr)
        {
            if (!instancia.Valores.TryGetValue(nombreAttr, out object valorActual) || valorActual == null)
            {
                // Si el atributo no existe o es null, verificar el tipo esperado
                if (!instancia.Definicion.Atributos.TryGetValue(nombreAttr, out string tipoEsperado))
                {
                    return null; // El atributo no existe en la definición
                }
                
                // Obtener la definición del struct para el tipo esperado
                var defStruct = StructManager.ObtenerStruct(tipoEsperado);
                if (defStruct == null)
                {
                    return null; // El tipo no es un struct
                }
                
                // Crear una nueva instancia vacía del tipo correcto
                var nuevaInstancia = new StructInstance { Definicion = defStruct };
                instancia.Valores[nombreAttr] = nuevaInstancia;
                return nuevaInstancia;
            }
            
            if (valorActual is StructInstance estructuraAnidada)
            {
                return estructuraAnidada;
            }
            
            return null; // El valor no es un struct
        }
      
        // Visitor para un literal entero
        public override object VisitLiteralEntero(LanguageParser.LiteralEnteroContext context)
        {
            return long.Parse(context.GetText()); 
        }

        // Visitor para un literal flotante
        public override object VisitLiteralFlotante(LanguageParser.LiteralFlotanteContext context)
        {
            return double.Parse(context.GetText(), CultureInfo.InvariantCulture);
        }

        // Visitor para 'true'
        public override object VisitLiteralVerdadero(LanguageParser.LiteralVerdaderoContext context)
        {
            return true;
        }

        // Visitor para 'false'
        public override object VisitLiteralFalso(LanguageParser.LiteralFalsoContext context)
        {
            return false;
        }
        public override object VisitLiteralNulo(LanguageParser.LiteralNuloContext context)
        {
            // Devolver un objeto especial para representar nil en Go
            return null;
        }

        // Visitor para un identificador
        public override object VisitIdentificador(LanguageParser.IdentificadorContext context)
        {
            var id = context.IDENTIFICADOR().GetText();
            
            if (id.Contains(" "))
            {
                Console.WriteLine($"DEBUG: Identificador contiene espacios: '{id}'");
            }
            
            foreach (var entorno in pilaEntornos)
            {
                if (entorno.TryGetValue(id, out var entrada))
                {
                    Console.WriteLine($"DEBUG: Encontrado '{id}' en entorno, valor: {entrada.Valor}");
                    return entrada.Valor ?? "nulo";
                }
            }

            var simbolo = tablaSimbolos.Find(s => s.Nombre == id);
            if (simbolo != null)
            {
                Console.WriteLine($"DEBUG: Encontrado '{id}' en tabla global, valor: {simbolo.Valor}");
                return simbolo.Valor ?? "nulo";
            }

            var token = context.IDENTIFICADOR().Symbol;
            AgregarError($"Error: La variable '{id}' no está definida.", 
                token.Line, token.Column + 1);
            
            return null;
        }
        
        //visitor para una cadena o string
        public override object VisitLiteralCadena(LanguageParser.LiteralCadenaContext context)
        {
            string textoConComillas = context.GetText();
            
            // Eliminar comillas del principio y final
            string texto = textoConComillas.Substring(1, textoConComillas.Length - 2);
            
            // Procesar secuencias de escape
            texto = texto.Replace("\\n", "\n")
                        .Replace("\\t", "\t")
                        .Replace("\\\"", "\"")
                        .Replace("\\'", "'");
            
            Console.WriteLine($"DEBUG: Cadena literal procesada: '{texto}'");
            
            return texto;
        }

        public override object VisitLiteralRune(LanguageParser.LiteralRuneContext context)
        {
            string textoConComillas = context.GetText();

            string caracterRune = textoConComillas.Substring(1, textoConComillas.Length - 2);

            if (caracterRune.StartsWith("\\"))
            {
                switch (caracterRune)
                {
                    case "\\n": caracterRune = "\n"; break;
                    case "\\t": caracterRune = "\t"; break;
                    case "\\\"": caracterRune = "\""; break;
                    case "\\'": caracterRune = "'"; break;
                }
            }
            
            return caracterRune;
        }

        // Visitor para una expresión entre paréntesis
        public override object VisitParentesis(LanguageParser.ParentesisContext context)
        {
            return Visit(context.expresion());
        }
         // Método para generar código ARM64
        public string GenerateARM64Code()
        {
            var generator = new ARM64Generator();
            return generator.Generate(tablaSimbolos, ObtenerAST());
        }

        public void SaveARM64CodeToFile(string filePath)
        {
            var generator = new ARM64Generator();
            string code = generator.Generate(tablaSimbolos, ObtenerAST());  // Pasar también los nodos AST
            generator.SaveToFile(filePath);
        }
            
    }
}