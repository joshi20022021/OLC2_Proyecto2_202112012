using System;
using System.Globalization;
using System.Collections.Generic;
using Antlr4.Runtime.Misc;
using Antlr4.Runtime.Tree;
using Antlr4.Runtime;
using API.compiler;

namespace API.compiler
{
    public class CompilerVisitor : LanguageBaseVisitor<object>
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
            
            // Buscar en todos los entornos 
            foreach (var entorno in pilaEntornos)
            {
                if (entorno.ContainsKey(varName))
                {
                    entorno[varName].Valor = value;
                    Console.WriteLine($"DEBUG: Asignando {varName} = {value}");
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
        public override object VisitImprime(LanguageParser.ImprimeContext context)
        {
            List<string> valores = new List<string>();
            foreach (var expr in context.expresion())
            {
                var resultado = Visit(expr);
                Console.WriteLine($"DEBUG: Imprimiendo valor de tipo {resultado?.GetType().Name}, valor: {resultado}");

                string valorFormateado = FormatearValor(resultado);
                valores.Add(valorFormateado);
            }
            
            string salida = string.Join(" ", valores);
            Console.WriteLine($"DEBUG: Salida formateada: '{salida}'");
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

        // Visitor para una operación de suma
        public override object VisitSuma(LanguageParser.SumaContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            // Si alguno es cadena, realizar concatenación
            if (izq is string || der is string)
            {
                return (izq?.ToString() ?? "") + (der?.ToString() ?? "");
            }

            double? valIzq = TipoDato.ConvertirANumero(izq);
            double? valDer = TipoDato.ConvertirANumero(der);

            if (valIzq.HasValue && valDer.HasValue)
            {
                return valIzq.Value + valDer.Value;
            }

            return "Error: Tipos incompatibles en suma.";
        }


        // Visitor para una operación de resta
        public override object VisitResta(LanguageParser.RestaContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            double? valIzq = TipoDato.ConvertirANumero(izq);
            double? valDer = TipoDato.ConvertirANumero(der);

            if (valIzq.HasValue && valDer.HasValue)
            {
                return valIzq.Value - valDer.Value;
            }

            return "Error: Tipos incompatibles en resta.";
        }


        // Visitor para una operación de multiplicación
        public override object VisitMultiplicacion(LanguageParser.MultiplicacionContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            // Mejorar el manejo de tipos para la recursión
            // Convertir explícitamente para asegurar compatibilidad de tipos
            if (izq is long lizq && der is long lder)
                return lizq * lder;
            else if (izq is long liz && der is double dd)
                return liz * dd;
            else if (izq is double di && der is long ld)
                return di * ld;
            else if (izq is double dizq && der is double dder)
                return dizq * dder;

            // Si son otros tipos numéricos, intentar conversión
            double? valIzq = TipoDato.ConvertirANumero(izq);
            double? valDer = TipoDato.ConvertirANumero(der);
            
            if (valIzq.HasValue && valDer.HasValue)
            {
                return valIzq.Value * valDer.Value;
            }
            
            Console.WriteLine($"DEBUG Multiplicación: izq={izq?.GetType().Name ?? "null"}, der={der?.GetType().Name ?? "null"}");
            return "Error: Tipos incompatibles en multiplicación.";
        }


        // Visitor para una operación de división
        public override object VisitDivision(LanguageParser.DivisionContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            if (der is long d && d == 0)
                return "Error: División por 0.";

            if (izq is long i && der is long j)
                return (double)i / j; 

            double? valIzq = TipoDato.ConvertirADouble(izq);
            double? valDer = TipoDato.ConvertirADouble(der);
            if (valIzq.HasValue && valDer.HasValue)
            {
                if (valDer.Value == 0) return "Error: División por 0.";
                return valIzq.Value / valDer.Value;
            }
            return "Error: Tipos incompatibles en división.";
        }

        // Visitor para una operación de módulo
        public override object VisitModulo(LanguageParser.ModuloContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            if (izq is long i && der is long j)
            {
                if (j == 0) return "Error: Módulo por 0.";
                return i % j;
            }

            return "Error: Tipos incompatibles en módulo.";
        }

        // Visitor para una comparación de mayor que
        public override object VisitMayorQue(LanguageParser.MayorQueContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            double? numIzq = TipoDato.ConvertirANumero(izq);
            double? numDer = TipoDato.ConvertirANumero(der);

            return numIzq.HasValue && numDer.HasValue 
                ? numIzq.Value > numDer.Value 
                : false;
        }
        // Visita una comparación de menor que
        public override object VisitMenorQue(LanguageParser.MenorQueContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            double? numIzq = TipoDato.ConvertirANumero(izq);
            double? numDer = TipoDato.ConvertirANumero(der);

            if (numIzq.HasValue && numDer.HasValue)
                return numIzq.Value < numDer.Value;

            return "Error: Tipos incompatibles en comparación '<'.";
        }


        // Visitor para una comparación de mayor o igual que
        public override object VisitMayorOIgual(LanguageParser.MayorOIgualContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            if (izq is long lValIzq && der is long lValDer)
                return lValIzq >= lValDer;

            double? numIzq = TipoDato.ConvertirANumero(izq);
            double? numDer = TipoDato.ConvertirANumero(der);

            if (numIzq.HasValue && numDer.HasValue)
                return numIzq.Value >= numDer.Value;

            return $"Error: Tipos incompatibles en '>=' (Recibidos: {TipoDato.ObtenerNombreTipo(izq)} y {TipoDato.ObtenerNombreTipo(der)}).";
        }

        // Visitor para una comparación de menor o igual que
        public override object VisitMenorOIgual(LanguageParser.MenorOIgualContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            double? numIzq = TipoDato.ConvertirANumero(izq);
            double? numDer = TipoDato.ConvertirANumero(der);

            if (numIzq.HasValue && numDer.HasValue)
                return numIzq.Value <= numDer.Value;

            return $"Error: Tipos incompatibles en comparación '<=' (Recibidos: {TipoDato.ObtenerNombreTipo(izq)} y {TipoDato.ObtenerNombreTipo(der)}).";
        }


        // visitor para una comparación de igualdad
        public override object VisitComparacionIgual(LanguageParser.ComparacionIgualContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            // Caso especial: comparación con nil
            if (izq == null || der == null)
                return izq == der;

            // Resto de tu código de comparación existente...
            double? numIzq = TipoDato.ConvertirANumero(izq);
            double? numDer = TipoDato.ConvertirANumero(der);

            if (numIzq.HasValue && numDer.HasValue)
                return numIzq.Value == numDer.Value;

            return izq.Equals(der);
        }

        public override object VisitComparacionDiferente(LanguageParser.ComparacionDiferenteContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            // Convertir a números 
            double? numIzq = TipoDato.ConvertirANumero(izq);
            double? numDer = TipoDato.ConvertirANumero(der);

            if (numIzq.HasValue && numDer.HasValue)
            {
                return numIzq.Value != numDer.Value;
            }

            return !izq.Equals(der);
        }

        //visitor para la expresion AND
        public override object VisitAnd(LanguageParser.AndContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            if (izq is bool boolIzq && der is bool boolDer)
                return boolIzq && boolDer;

            return $"Error: Operador '&&' requiere operandos booleanos, pero recibió '{TipoDato.ObtenerNombreTipo(izq)}' y '{TipoDato.ObtenerNombreTipo(der)}'.";
        }


        //visitor para la expresion OR
        public override object VisitOr(LanguageParser.OrContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            if (izq is bool boolIzq && der is bool boolDer)
                return boolIzq || boolDer;

            return $"Error: Operador '||' requiere operandos booleanos, pero recibió '{TipoDato.ObtenerNombreTipo(izq)}' y '{TipoDato.ObtenerNombreTipo(der)}'.";
        }


        //visitor para la expresion NOT
        public override object VisitNot(LanguageParser.NotContext context)
        {
            var valor = Visit(context.expresion());
            
            Console.WriteLine($"DEBUG: Operando de ! es: {valor} de tipo {valor?.GetType().Name ?? "null"}");
            
            if (valor is bool boolValor)
            {
                return !boolValor;
            }
            
            var token = context.Start;
            AgregarError($"Error: Operador '!' requiere un booleano, recibió {TipoDato.ObtenerNombreTipo(valor)}.", 
                token.Line, 
                token.Column + 1);
            
            return false; 
        }

        //sentencia if y else

        public override object VisitIfElse(LanguageParser.IfElseContext ctx)
        {
            object cond = Visit(ctx.expresion());
            
            if (cond is bool boolCond)
            {
                if (boolCond)
                {
                    pilaEntornos.Push(new Dictionary<string, EntradaSimbolo>());
                    var resultado = Visit(ctx.bloque(0));  // Capturar el resultado
                    pilaEntornos.Pop();
                    return resultado;  // Devolver el resultado del bloque
                }
                else if (ctx.bloque().Length > 1)
                {
                    pilaEntornos.Push(new Dictionary<string, EntradaSimbolo>());
                    var resultado = Visit(ctx.bloque(1));  // Capturar el resultado
                    pilaEntornos.Pop();
                    return resultado;  // Devolver el resultado del bloque
                }
            }
            else
            {
                var token = ctx.expresion().Start;
                AgregarError("Error: La condición del if debe ser booleana.", 
                        token.Line, 
                        token.Column + 1);
            }
                            
            return null;
        }

        //switch case        
        public override object VisitSwitch(LanguageParser.SwitchContext context)
        {
            EnSwitch = true;
            var switchValue = Visit(context.expresion());

            // Verificar que switchValue no sea nulo, etc.

            foreach (var caseBlock in context.caseBlock())
            {
                var caseValue = Visit(caseBlock.expresion());
                if (switchValue.Equals(caseValue))
                {
                    // Entramos al bloque de ese case
                    object resultado = Visit(caseBlock);

                    // Si hay un BreakCommand, salimos del switch
                    if (resultado is BreakCommand)
                    {
                        EnSwitch = false;
                        return null; 
                    }
                    EnSwitch = false;
                    return null;
                }
            }

            // Si no se cumplió ningún case verificar si break existe
            if (context.defaultBlock() != null)
            {
                object resultado = Visit(context.defaultBlock());
                if (resultado is BreakCommand)
                {
                    EnSwitch = false;
                    return null;
                }
            }

            EnSwitch = false;
            return null;
        }


        public override object VisitCaseBlock(LanguageParser.CaseBlockContext ctx)
        {
            // Primero visitamos las sentencias
            foreach (var st in ctx.sentencia())
            {
                var result = Visit(st);
                if (result is BreakCommand || result is ContinueCommand)
                {
                    return result;
                }
                if (result is Tuple<string, object> ret && ret.Item1 == "RETURN")
                {
                    return ret;
                }
            }

            if (ctx.breakStmt() != null)
            {
                var breakResult = VisitBreakStmt(ctx.breakStmt());
                return breakResult; // Esto retornará BreakCommand
            }

            return null;
        }


        //for con condicion
        public override object VisitForCondicion(LanguageParser.ForCondicionContext ctx)
        {
            EnCiclo = true;
            pilaEntornos.Push(new Dictionary<string, EntradaSimbolo>(pilaEntornos.Count > 0 
                ? pilaEntornos.Peek() 
                : new Dictionary<string, EntradaSimbolo>()));

            try
            {
                object cond = Visit(ctx.expresion());

                while (cond is bool bCond && bCond)
                {
                    // Quitar referencia a ctx.contador()
                    // if (ctx.contador() != null)
                    //     Visit(ctx.contador());

                    object resultado = Visit(ctx.bloque());

                    if (resultado is BreakCommand)
                        break;

                    if (resultado is ContinueCommand)
                    {
                        cond = Visit(ctx.expresion());
                        continue;
                    }

                    // Reevaluar la condición
                    cond = Visit(ctx.expresion());
                }
            }
            finally
            {
                pilaEntornos.Pop();
                EnCiclo = false;
            }
            return null;
        }
        //for clasico con contador
        public override object VisitForClasico(LanguageParser.ForClasicoContext ctx)
        {
            EnCiclo = true;
            pilaEntornos.Push(new Dictionary<string, EntradaSimbolo>());

            // Inicialización
            if (ctx.declaracion() != null)
                Visit(ctx.declaracion());
            else if (ctx.asignacion().Length > 0)
                Visit(ctx.asignacion(0));

            // Bucle
            while (true)
            {
                // Evaluar condición
                object cond = Visit(ctx.expresion());
                if (!(cond is bool bCond) || !bCond)
                    break;

                // Ejecutar bloque
                object resultado = Visit(ctx.bloque());
                
                // Si hay un break, salir del bucle
                if (resultado is BreakCommand)
                    break;
                
                // Si hay un continue, saltar la iteración
                if (resultado is ContinueCommand)
                {
                    // Aplicar incremento si existe
                    if (ctx.contador() != null)
                        Visit(ctx.contador());
                    else if (ctx.asignacion().Length > 1)
                        Visit(ctx.asignacion(1));
                    
                    continue;
                }

                // Aplicar incremento si existe
                if (ctx.contador() != null)
                    Visit(ctx.contador());
                else if (ctx.asignacion().Length > 1)
                    Visit(ctx.asignacion(1));
            }

            pilaEntornos.Pop();
            EnCiclo = false;
            return null;
        }


        //manejo de for range
        public override object VisitForRange(LanguageParser.ForRangeContext context)
        {
            EnCiclo = true;
            pilaEntornos.Push(new Dictionary<string, EntradaSimbolo>());

            // Obtener los nombres del iterador y variable del contexto
            string iterador = context.IDENTIFICADOR(0).GetText();
            string variable = context.IDENTIFICADOR(1).GetText();
            
            // Obtener la colección a iterar
            object coleccion = Visit(context.expresion());
            
            // Verificar si es una lista (slice)
            if (!(coleccion is List<object> lista))
            {
                AgregarError($"Error: range requiere un slice, obtuvo {TipoDato.ObtenerNombreTipo(coleccion)}", 
                            context.Start.Line, context.Start.Column);
                pilaEntornos.Pop();
                EnCiclo = false;
                return null;
            }

            // Iterar sobre la lista
            for (int i = 0; i < lista.Count; i++)
            {
                pilaEntornos.Peek()[iterador] = new EntradaSimbolo { Nombre = iterador, TipoDato = "int", Valor = i };
                pilaEntornos.Peek()[variable] = new EntradaSimbolo { Nombre = variable, TipoDato = TipoDato.ObtenerNombreTipo(lista[i]), Valor = lista[i] };

                // Ejecutar el bloque y verificar si devuelve un break o continue
                var resultado = Visit(context.bloque());
                if (resultado is BreakCommand)
                    break;
                if (resultado is ContinueCommand)
                    continue;
            }

            pilaEntornos.Pop();
            EnCiclo = false;
            return null;
        }

        public override object VisitBloque(LanguageParser.BloqueContext context)
        {
            // Recorremos
            foreach (var stmt in context.sentencia())
            {
                // Visitamos la sentencia concreta
                var result = Visit(stmt);

                if (result is BreakCommand || result is ContinueCommand)
                {
                    return result; 
                }
                // IMPORTANTE: Buscar "RETURN" en lugar de "return"
                else if (result is Tuple<string, object> retorno && retorno.Item1 == "RETURN")
                {
                    return retorno; 
                }
            }
            // devolvemos null
            return null;
        }



        // Método común para actualizar el contador
            private object ActualizarContador(string varName, int delta, ParserRuleContext context)
        {
            // Buscar la variable
            object valorActual = null;
            foreach (var env in pilaEntornos)
            {
                if (env.ContainsKey(varName))
                {
                    valorActual = env[varName].Valor;
                    break;
                }
            }
            
            if (valorActual == null)
            {
                var simboloGlobal = tablaSimbolos.Find(s => s.Nombre == varName);
                if (simboloGlobal != null)
                    valorActual = simboloGlobal.Valor;
            }

            if (valorActual is long longVal)
            {
                long nuevoValor = longVal + delta;
                // Actualizar en el entorno
                foreach (var env in pilaEntornos)
                {
                    if (env.ContainsKey(varName))
                    {
                        env[varName].Valor = nuevoValor;
                        return nuevoValor;
                    }
                }
                // Actualizar global si no está en la pila
                var simbolo = tablaSimbolos.Find(s => s.Nombre == varName);
                if (simbolo != null)
                    simbolo.Valor = nuevoValor;
                return nuevoValor;
            }
            else
            {
                AgregarError($"Error: '{varName}' no es un entero.", context.Start.Line, context.Start.Column + 1);
                return valorActual;
            }
        }

        // Visitor para el incremento
        public override object VisitIncremento(LanguageParser.IncrementoContext context)
        {
            string varName = context.IDENTIFICADOR().GetText();
            // parámetro 'context'
            return ActualizarContador(varName, 1, context);
        }

        public override object VisitDecremento(LanguageParser.DecrementoContext context)
        {
            string varName = context.IDENTIFICADOR().GetText();
            // parámetro 'context'
            return ActualizarContador(varName, -1, context);
        }


        //implementacion break
        public override object VisitBreakStmt(LanguageParser.BreakStmtContext context)
        {
            Console.WriteLine("DEBUG: Se encontró un 'break'");

            // Validar si estamos dentro de un bucle o un switch
            if (!EnCiclo && !EnSwitch)
            {
                AgregarError("Error: 'break' solo puede usarse dentro de un ciclo o switch.", 
                            context.Start.Line, 
                            context.Start.Column + 1);
                return null;
            }

            // Retornar el comando de break
            return new BreakCommand();
        }


        //implementacion continue
        public override object VisitContinueStmt(LanguageParser.ContinueStmtContext context)
        {
            Console.WriteLine("DEBUG: Se encontró un 'continue'");

            // Validar si estamos dentro de un bucle
            if (!EnCiclo)
            {
            AgregarError("Error: 'continue'...", context.Start.Line, context.Start.Column + 1);
                return null;
            }

            // Retornar el objeto ContinueCommand
            return new ContinueCommand();
        }



        //implementacion return
        public override object VisitReturnStmt(LanguageParser.ReturnStmtContext context)
        {
            if (!EnFuncion)
            {
                var token = context.Start;
                AgregarError("Error: 'return' solo puede usarse dentro de una función.", token.Line, token.Column + 1);
                return null;
            }

            object valorRetorno = null;
            if (context.expresion() != null)
            {
                valorRetorno = Visit(context.expresion());
            }

            // Usar "RETURN" en mayúsculas para ser consistente
            return new Tuple<string, object>("RETURN", valorRetorno ?? "nulo");
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
        //llamada funcion
            
        public override object VisitFuncionCall(LanguageParser.FuncionCallContext context)
        {
            // Obtener el nombre de la función
            string nombreFuncion = string.Join(".", context.IDENTIFICADOR().Select(id => id.GetText()));
            
            // Evaluar argumentos
            List<object> argumentos = new List<object>();
            if (context.expresion() != null)
            {
                foreach (var expr in context.expresion())
                {
                    argumentos.Add(Visit(expr));
                }
            }
            
            // --- Verificar funciones del sistema ---
            // fmt.Println y otras funciones nativas
            if (nombreFuncion == "fmt.Println")
            {
                // Tu código actual para fmt.Println
                List<string> valores = new List<string>();
                foreach (var arg in argumentos)
                {
                    Console.WriteLine($"DEBUG: Valor a imprimir - Tipo: {arg?.GetType().Name}, Valor: {arg}");
                    valores.Add(FormatearValor(arg));
                }
                string salida = string.Join(" ", valores);
                Console.WriteLine($"DEBUG: Salida formateada: '{salida}'");
                mensajesSalida.Add(salida);
                return null;
            }
            else if (nombreFuncion == "strconv.Atoi")
            {
                if (argumentos.Count != 1 || !(argumentos[0] is string s))
                {
                    AgregarError("strconv.Atoi requiere una cadena de texto.", context.Start.Line, context.Start.Column);
                    return null;
                }
                
                if (s.Contains("."))
                {
                    AgregarError("strconv.Atoi no puede convertir un número decimal.", context.Start.Line, context.Start.Column);
                    return null;
                }
                
                if (long.TryParse(s, out long resultado))
                {
                    return resultado;
                }
                else
                {
                    AgregarError("strconv.Atoi: cadena no convertible a entero.", context.Start.Line, context.Start.Column);
                    return null;
                }
            }
            else if (nombreFuncion == "strconv.ParseFloat")
            {
                if (argumentos.Count != 1 || !(argumentos[0] is string s))
                {
                    AgregarError("strconv.ParseFloat requiere una cadena de texto.", context.Start.Line, context.Start.Column);
                    return null;
                }
                
                if (double.TryParse(s, NumberStyles.Any, CultureInfo.InvariantCulture, out double resultado))
                {
                    return resultado;
                }
                else
                {
                    AgregarError("strconv.ParseFloat: cadena no convertible a float64.", context.Start.Line, context.Start.Column);
                    return null;
                }
            }
            else if (nombreFuncion == "slices.Index")
            {
                if (argumentos.Count != 2)
                {
                    AgregarError("slices.Index requiere dos argumentos: un slice y un valor a buscar.", context.Start.Line, context.Start.Column);
                    return null;
                }
                
                if (!(argumentos[0] is List<object> lista))
                {
                    AgregarError("El primer argumento de slices.Index debe ser un slice.", context.Start.Line, context.Start.Column);
                    return null;
                }
                
                object valorBuscado = argumentos[1];
                
                // Buscar el valor en la lista
                for (int i = 0; i < lista.Count; i++)
                {
                    if (lista[i]?.Equals(valorBuscado) == true)
                    {
                        return i;
                    }
                }
                
                // Si no se encuentra, retornar -1
                return -1;
            }
            else if (nombreFuncion == "strings.Join")
            {
                if (argumentos.Count != 2)
                {
                    AgregarError("strings.Join requiere dos argumentos: un slice de strings y un separador.", context.Start.Line, context.Start.Column);
                    return null;
                }
                
                if (!(argumentos[0] is List<object> lista))
                {
                    AgregarError("El primer argumento de strings.Join debe ser un slice.", context.Start.Line, context.Start.Column);
                    return null;
                }
                
                string separador = argumentos[1]?.ToString() ?? "";
                
                // Convertir todos los elementos a string
                List<string> strings = new List<string>();
                foreach (var item in lista)
                {
                    strings.Add(item?.ToString() ?? "nulo");
                }
                
                return string.Join(separador, strings);
            }
            else if (nombreFuncion == "reflect.TypeOf")
            {
                if (argumentos.Count != 1)
                {
                    AgregarError("reflect.TypeOf requiere un argumento.", context.Start.Line, context.Start.Column);
                    return null;
                }
                
                object valor = argumentos[0];
                
                if (valor == null)
                    return "nil";
                
                // Determinar el tipo de forma correcta para Go
                string tipo;
                if (valor is long)
                    tipo = "int";
                else if (valor is double)
                    tipo = "float64";
                else if (valor is string)
                    tipo = "string";
                else if (valor is bool)
                    tipo = "bool";
                else if (valor is List<object>)
                {
                    // Para slices, intentamos inferir el tipo basado en el primer elemento
                    var lista = (List<object>)valor;
                    if (lista.Count > 0 && lista[0] is long)
                        tipo = "[]int";
                    else if (lista.Count > 0 && lista[0] is double)
                        tipo = "[]float64";
                    else if (lista.Count > 0 && lista[0] is string)
                        tipo = "[]string";
                    else if (lista.Count > 0 && lista[0] is bool)
                        tipo = "[]bool";
                    else
                        tipo = "[]interface{}";
                }
                else if (valor is StructInstance si)
                    tipo = si.Definicion.Nombre;
                else
                    tipo = "interface{}";
                
                return tipo;
            }

            // SI es un struct, métodos
            else if (argumentos.Count > 0 && argumentos[0] is StructInstance instancia)
            {
                string key = $"{instancia.Definicion.Nombre}_{nombreFuncion}";
                if (_tablaFuncionesStruct.TryGetValue(key, out MetodoStruct metodo))
                {
                    // Verificar número de parámetros
                    if (metodo.Parametros.Count != argumentos.Count - 1)
                    {
                        AgregarError($"Número incorrecto de parámetros para {nombreFuncion}",
                                    context.Start.Line, context.Start.Column + 1);
                        return null;
                    }
                    
                    // Crear nuevo entorno
                    _ambitoActual.Push(nombreFuncion);
                    EnFuncion = true;
                    pilaEntornos.Push(new Dictionary<string, EntradaSimbolo>());
                    
                    // Registrar parámetros en el entorno
                    for (int i = 0; i < metodo.Parametros.Count; i++)
                    {
                        string nombreParam = metodo.Parametros[i].Item2;
                        pilaEntornos.Peek()[nombreParam] = new EntradaSimbolo { 
                            Nombre = nombreParam,
                            Valor = argumentos[i + 1] 
                        };
                    }
                    
                    // Agregar la instancia 
                    pilaEntornos.Peek()["this"] = new EntradaSimbolo {
                        Nombre = "this",
                        Valor = instancia
                    };
                    
                    // Ejecutar el bloque del método
                    object resultado = Visit(metodo.Bloque);
                    
                    // Manejar el valor de retorno
                    if (resultado is Tuple<string, object> retVal && retVal.Item1 == "RETURN")
                    {
                        pilaEntornos.Pop();
                        EnFuncion = false;
                        _ambitoActual.Pop();
                        return retVal.Item2;
                    }
                    
                    pilaEntornos.Pop();
                    EnFuncion = false;
                    _ambitoActual.Pop();
                    return null;
                }
            }
        else if (nombreFuncion == "ObtenerSiguienteNombre" && argumentos.Count > 0 && 
        argumentos[0] is StructInstance instanciaOSN && instanciaOSN.Definicion.Nombre == "Nodo")
    {
        // Verificar primero si existe el atributo Siguiente
        if (!instanciaOSN.Valores.TryGetValue("Siguiente", out object siguiente) || siguiente == null)
        {
            Console.WriteLine("DEBUG: ObtenerSiguienteNombre - No hay siguiente nodo");
            return "No hay siguiente nodo";
        }
        
        // Si el siguiente existe, buscar su nombre
        if (siguiente is StructInstance siguienteStruct && 
            siguienteStruct.Valores.TryGetValue("Nombre", out object nombreSiguiente))
        {
            Console.WriteLine($"DEBUG: ObtenerSiguienteNombre - Nombre del siguiente: {nombreSiguiente}");
            return nombreSiguiente?.ToString() ?? "nulo";
        }
        
        Console.WriteLine("DEBUG: ObtenerSiguienteNombre - Estructura incorrecta");
        return "No hay siguiente nodo";
    }
        else if (nombreFuncion == "CambiarValor" && argumentos.Count > 0 && 
                argumentos[0] is StructInstance instanciaCV && instanciaCV.Definicion.Nombre == "Nodo")
        {
            // Asegurarse de que hay un parámetro
            if (argumentos.Count != 2) 
            {
                AgregarError("CambiarValor requiere un valor entero", context.Start.Line, context.Start.Column);
                return null;
            }
            
            // Asignar el nuevo valor directamente
            instanciaCV.Valores["Valor"] = argumentos[1];
            
            return null;
        }
            if (tablaFunciones.TryGetValue(nombreFuncion, out Funcion funcion))
            {
                // Crear nuevo entorno para la función
                _ambitoActual.Push(nombreFuncion);
                EnFuncion = true;
                pilaEntornos.Push(new Dictionary<string, EntradaSimbolo>());
                
                // Verificar número de parámetros
                if (funcion.Parametros.Count != argumentos.Count)
                {
                    AgregarError($"Error: La función '{nombreFuncion}' espera {funcion.Parametros.Count} parámetros, pero recibió {argumentos.Count}.",
                                context.Start.Line, context.Start.Column);
                    pilaEntornos.Pop();
                    EnFuncion = false;
                    _ambitoActual.Pop();
                    return null;
                }
                
                // Registrar parámetros en el entorno de la función
                for (int i = 0; i < funcion.Parametros.Count; i++)
                {
                    string tipoParam = funcion.Parametros[i].Item1;
                    string nombreParam = funcion.Parametros[i].Item2;
                    object valorParam = argumentos[i];
                    
                    // Agregar al entorno
                    pilaEntornos.Peek()[nombreParam] = new EntradaSimbolo
                    {
                        Nombre = nombreParam,
                        TipoDato = tipoParam,
                        Valor = valorParam,
                        Ambito = nombreFuncion,
                        Linea = context.Start.Line,
                        Columna = context.Start.Column
                    };
                }
                
                // Ejecutar el bloque de la función
                object resultado = Visit(funcion.Bloque);
                
                // Manejar el valor de retorno
                if (resultado is Tuple<string, object> retVal && retVal.Item1 == "RETURN")
                {
                    pilaEntornos.Pop();
                    EnFuncion = false;
                    _ambitoActual.Pop();
                    return retVal.Item2;
                }
            
                pilaEntornos.Pop();
                EnFuncion = false;
                _ambitoActual.Pop();
                return null;
            }
            
            AgregarError($"Función no implementada: {nombreFuncion}", context.Start.Line, context.Start.Column);
            return null;
        }

        public override object VisitStructDeclaracion(LanguageParser.StructDeclaracionContext context)
        { 
        string nombreStruct = context.IDENTIFICADOR().GetText();
        var structDef = StructManager.ObtenerStruct(nombreStruct);

        foreach (var attrCtx in context.atributoStruct()) {
            if (attrCtx is LanguageParser.AtributoContext atributo) {
                var resultado = Visit(atributo) as Tuple<string, string>;
                string tipoAttr = resultado.Item1;
                string nombreAttr = resultado.Item2;

                // Validar tipo 
                if (!TipoDato.EsTipoValido(tipoAttr) && !StructManager.ExisteStruct(tipoAttr)) {
                    AgregarError($"Tipo inválido '{tipoAttr}'", atributo.Start.Line, atributo.Start.Column);
                    continue;
                }

                    structDef.Atributos.Add(nombreAttr, tipoAttr);
                }
            }
            tablaSimbolos.Add(new EntradaSimbolo
            {
                TipoSimbolo = "Struct",
                Nombre = nombreStruct,
                TipoDato = "Struct",
                Ambito = "Global",
                Linea = context.Start.Line,
                Columna = context.Start.Column + 1
            });
            return null;
        }
        public override object VisitAtributo(LanguageParser.AtributoContext context)
        {
            string nombreAttr = context.IDENTIFICADOR().GetText(); 
            string tipo = context.tipo().GetText(); 
            
            return Tuple.Create(tipo, nombreAttr);
        }
        public override object VisitExpresionLiteralStruct(LanguageParser.ExpresionLiteralStructContext context)
        {
            string nombreStruct = context.IDENTIFICADOR().GetText();
            var structDef = StructManager.ObtenerStruct(nombreStruct);
            
            var instancia = new StructInstance { Definicion = structDef };

            var atributosInitCtx = context.atributosInicializacion();
            if (atributosInitCtx != null)
            {
                var ids = atributosInitCtx.IDENTIFICADOR();
                var exprs = atributosInitCtx.expresion();

                for (int i = 0; i < ids.Length; i++)
                {
                    string nombreAttr = ids[i].GetText();
                    object valor = Visit(exprs[i]);

                    // Validar existencia del atributo
                    if (!structDef.Atributos.ContainsKey(nombreAttr)) 
                    {
                        AgregarError($"Atributo '{nombreAttr}' no existe en el struct '{nombreStruct}'",
                        ids[i].Symbol.Line, 
                        ids[i].Symbol.Column + 1);
                        continue;
                    }

                    instancia.Valores[nombreAttr] = valor;
                }
            }
            
            return instancia;
        }
        public override object VisitExpresionAccesoAtributo(LanguageParser.ExpresionAccesoAtributoContext context) 
        {
            object padre = Visit(context.expresion());
            string nombreAttr = context.IDENTIFICADOR().GetText();
            
            // Manejar correctamente el caso cuando el padre es null
            if (padre == null) 
            {
                AgregarError($"Error: No se puede acceder al atributo '{nombreAttr}' de un valor nil", 
                        context.Start.Line, context.Start.Column);
                return null;
            }
            
            if (!(padre is StructInstance instancia)) 
            {
                AgregarError($"Error: No se puede acceder al atributo '{nombreAttr}' de un valor de tipo {TipoDato.ObtenerNombreTipo(padre)}", 
                        context.Start.Line, context.Start.Column);
                return null;
            }

            if (!instancia.Definicion.Atributos.ContainsKey(nombreAttr)) 
            {
                AgregarError($"Error: El atributo '{nombreAttr}' no existe en el struct '{instancia.Definicion.Nombre}'", 
                            context.Start.Line, context.Start.Column);
                return null;
            }

            return instancia.Valores.TryGetValue(nombreAttr, out object valor) ? valor : null;
        }

        public override object VisitAsignacionAtributo(LanguageParser.AsignacionAtributoContext context)
        {
            object padre = Visit(context.expresion(0));
            string nombreAttr = context.IDENTIFICADOR().GetText();
            object nuevoValor = Visit(context.expresion(1));
            
            Console.WriteLine($"DEBUG: Asignación de atributo - Padre: {padre?.GetType().Name}, Atributo: {nombreAttr}, Valor: {nuevoValor}");
            
            if (padre == null)
            {
                AgregarError("No se puede asignar un atributo a un valor nil", context.Start.Line, context.Start.Column);
                return null;
            }
            
            if (!(padre is StructInstance instancia))
            {
                AgregarError($"Error: No se puede acceder al atributo '{nombreAttr}' de un valor de tipo {TipoDato.ObtenerNombreTipo(padre)}", 
                            context.Start.Line, context.Start.Column);
                return null;
            }
            
            // Verificar existencia del atributo
            if (!instancia.Definicion.Atributos.ContainsKey(nombreAttr))
            {
                AgregarError($"El atributo '{nombreAttr}' no existe en el struct '{instancia.Definicion.Nombre}'", 
                            context.Start.Line, context.Start.Column);
                return null;
            }
            
            // Verificar compatibilidad de tipo para asignaciones de struct
            string tipoAtributo = instancia.Definicion.Atributos[nombreAttr];
            if (StructManager.ExisteStruct(tipoAtributo) && !(nuevoValor is StructInstance || nuevoValor == null))
            {
                AgregarError($"El atributo '{nombreAttr}' espera un valor de tipo '{tipoAtributo}'", 
                            context.Start.Line, context.Start.Column);
                return null;
            }
            
            // Actualizar el valor del atributo
            instancia.Valores[nombreAttr] = nuevoValor;
            Console.WriteLine($"DEBUG: Atributo actualizado correctamente: {nombreAttr} = {nuevoValor}");
            return nuevoValor;
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
        //visitar el metodo struct
        public override object VisitMetodoStruct(LanguageParser.MetodoStructContext context)
        {
            // Obtener el receptor y el tipo del receptor
            string receptor = context.IDENTIFICADOR(0).GetText();         
            string tipoStruct = context.IDENTIFICADOR(1).GetText();      
            string nombreMetodo = context.IDENTIFICADOR(2).GetText();        

            // Validar existencia del struct usando el tipo correcto
            if (!StructManager.ExisteStruct(tipoStruct))
            {
                AgregarError($"Struct '{tipoStruct}' no existe", context.Start.Line, context.Start.Column);
                return null;
            }

            // Procesar parámetros 
            List<Tuple<string, string>> parametros = new List<Tuple<string, string>>();
            var parametrosContext = context.parametros();
            if (parametrosContext != null)
            {
                foreach (var paramCtx in parametrosContext.parametro())
                {
                    string tipo = paramCtx.tipo().GetText();
                    string nombre = paramCtx.IDENTIFICADOR().GetText();
                    parametros.Add(Tuple.Create(tipo, nombre));
                }
            }

            // Registrar el método en la tabla de funciones del struct
            string key = $"{tipoStruct}_{nombreMetodo}";
            _tablaFuncionesStruct[key] = new MetodoStruct
            {
                Nombre = nombreMetodo,
                Parametros = parametros,
                Bloque = context.bloque()
            };

            return null;
        }
        //visitar la declaracion de la funcion
        public override object VisitFuncionDeclaracion(LanguageParser.FuncionDeclaracionContext context)
        {
            // Validar que se esté declarando en ámbito global
            if (_ambitoActual.Count > 0 && _ambitoActual.Peek() != "Global")
            {
                AgregarError("Las funciones solo pueden declararse en el ámbito global", context.Start.Line, context.Start.Column);
                return null;
            }

            string nombreFuncion = context.IDENTIFICADOR().GetText();
            
            // Validar unicidad del nombre
            if (tablaFunciones.ContainsKey(nombreFuncion))
            {
                AgregarError($"La función '{nombreFuncion}' ya está definida", context.Start.Line, context.Start.Column);
                return null;
            }

            // Procesar parámetros, si existen
            List<Tuple<string, string>> parametros = new List<Tuple<string, string>>();
            if (context.parametros() != null)
            {
                foreach (var paramCtx in context.parametros().parametro())
                {
                    string nombreParam = paramCtx.IDENTIFICADOR().GetText();
                    string tipoParam = paramCtx.tipo().GetText();
                    if (parametros.Any(p => p.Item2 == nombreParam))
                    {
                        AgregarError($"Parámetro duplicado: '{nombreParam}'", paramCtx.Start.Line, paramCtx.Start.Column);
                        continue;
                    }
                    parametros.Add(Tuple.Create(tipoParam, nombreParam));
                }
            }

            // Determinar tipo de retorno (si no se especifica, es "void")
            string tipoRetorno = "void";
            if (context.tipo() != null)
            {
                tipoRetorno = context.tipo().GetText();
            }

            // Registrar la función
            Funcion f = new Funcion
            {
                Nombre = nombreFuncion,
                Parametros = parametros,
                TipoRetorno = tipoRetorno,
                Bloque = context.bloque()
            };
            tablaFunciones.Add(nombreFuncion, f);

            tablaSimbolos.Add(new EntradaSimbolo
            {
                TipoSimbolo = "Función",
                Nombre = nombreFuncion,
                TipoDato = tipoRetorno,
                Ambito = "Global",
                Linea = context.Start.Line,
                Columna = context.Start.Column + 1
            });

            return null;
        }
        //visitar la funcion Atoi
        public override object VisitFuncionAtoi(LanguageParser.FuncionAtoiContext context)
        {
            object valor = Visit(context.expresion());

            // Agregar logging para depuración
            Console.WriteLine($"DEBUG: strconv.Atoi recibió: {valor} de tipo {valor?.GetType().Name ?? "null"}");

            if (valor is string s)
            {
                if (s.Contains("."))
                {
                    AgregarError("strconv.Atoi no puede convertir un número decimal.", context.Start.Line, context.Start.Column);
                    return null;
                }
                
                if (long.TryParse(s, out long resultado))
                {
                    Console.WriteLine($"DEBUG: strconv.Atoi convertido exitosamente a: {resultado}");
                    return resultado;
                }
                else
                {
                    AgregarError("strconv.Atoi: cadena no convertible a entero.", context.Start.Line, context.Start.Column);
                    return null;
                }
            }
            else
            {
                AgregarError("strconv.Atoi requiere una cadena de texto.", context.Start.Line, context.Start.Column);
                return null;
            }
        }
        //convertir a parsefloat
        public override object VisitFuncionParseFloat(LanguageParser.FuncionParseFloatContext context)
        {
            object valor = Visit(context.expresion());
            
            if (!(valor is string s))
            {
                AgregarError("strconv.ParseFloat requiere una cadena de texto.", context.Start.Line, context.Start.Column);
                return null;
            }
            
            if (double.TryParse(s, NumberStyles.Any, CultureInfo.InvariantCulture, out double resultado))
            {
                return resultado;
            }
            else
            {
                AgregarError("strconv.ParseFloat: cadena no convertible a float64.", context.Start.Line, context.Start.Column);
                return null;
            }
        }

        public override object VisitFuncionTypeOf(LanguageParser.FuncionTypeOfContext context)
        {
            object valor = Visit(context.expresion());
            
            Console.WriteLine($"DEBUG: reflect.TypeOf recibió: {valor} de tipo {valor?.GetType().Name ?? "null"}");
            
            // Determinar el tipo de forma correcta para Go
            string tipo;
            if (valor == null)
                tipo = "nil";
            else if (valor is long)
                tipo = "int";
            else if (valor is double)
                tipo = "float64";
            else if (valor is string)
                tipo = "string";
            else if (valor is bool)
                tipo = "bool";
            else if (valor is List<object> lista)
            {
                // Mejorado el manejo de slices
                if (lista.Count == 0)
                    tipo = "[]interface{}";
                else if (lista.All(i => i is long))
                    tipo = "[]int";
                else if (lista.All(i => i is double))
                    tipo = "[]float64";
                else if (lista.All(i => i is string))
                    tipo = "[]string";
                else if (lista.All(i => i is bool))
                    tipo = "[]bool";
                else
                    tipo = "[]interface{}";
            }
            else if (valor is StructInstance si)
                tipo = si.Definicion.Nombre;
            else
                tipo = "interface{}";
            
            Console.WriteLine($"DEBUG: reflect.TypeOf de {valor} devolvió: {tipo}");
            return tipo;
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
        //visitor para la funcion main
        public override object VisitFuncionMain(LanguageParser.FuncionMainContext context)
        {
            var funcionSymbol = new EntradaSimbolo
            {
                TipoSimbolo = "Función",
                Nombre = "main",
                TipoDato = "void",
                Ambito = "Global",
                Linea = context.Start.Line,
                Columna = context.Start.Column + 1
            };
            
            tablaSimbolos.Add(funcionSymbol);
            _ambitoActual.Push("main");
            pilaEntornos.Push(new Dictionary<string, EntradaSimbolo>()); // Iniciar entorno global
            var resultado = Visit(context.bloque());
            pilaEntornos.Pop(); // Eliminar el entorno al salir
            _ambitoActual.Pop();
            return resultado;
        }


    }
}