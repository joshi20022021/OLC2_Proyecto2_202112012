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
                var funcionMain = context.funcionMain();

                if (funcionMain == null) {
                    AgregarError("No se encontró la función main().", context.Start.Line, context.Start.Column);
                    return null;
                }

                // Ejecutar la función main
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

        public override object VisitDeclaracion(LanguageParser.DeclaracionContext context)
        {
            string varName = context.IDENTIFICADOR().GetText();
            string varType = context.tipo()?.GetText();
            object value = context.expresion() != null ? Visit(context.expresion()) : null;

            // 1. Manejar inicialización por defecto si no hay valor
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
                                    errorToken.Column + 1); // Column es 0-based
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

            return value;
        }     

        // visitor para una asignación de variable
        public override object VisitAsignar(LanguageParser.AsignarContext context)
        {
            var varName = context.IDENTIFICADOR().GetText();
            var value = Visit(context.expresion());
            var token = context.IDENTIFICADOR().Symbol;
            // Buscar en todos los entornos (pila y global)
            foreach (var entorno in pilaEntornos)
            {
                if (entorno.ContainsKey(varName))
                {
                    entorno[varName].Valor = value;
                    Console.WriteLine($"DEBUG: Asignando {varName} = {value}");
                    return value;
                }
            }

            // Buscar en la tabla global
            var simboloGlobal = tablaSimbolos.Find(s => s.Nombre == varName);
            if (simboloGlobal != null)
            {
                simboloGlobal.Valor = value;
                Console.WriteLine($"DEBUG: Asignando {varName} = {value} (global)");
                return value;
            }

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
                Console.WriteLine($"DEBUG: Valor a imprimir - Tipo: {resultado?.GetType().Name}, Valor: {resultado}");
                valores.Add(FormatearValor(resultado));
            }
            string salida = string.Join(" ", valores);
            Console.WriteLine(salida);
            mensajesSalida.Add(salida);
            return null;
        }

        // Función auxiliar recursiva para formatear
        private string FormatearValor(object valor)
        {
            if (valor is List<object> lista)
            {
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
            return valor?.ToString() ?? "nulo";
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

            if (izq is long i && der is long j)
                return i * j;

            double? valIzq = TipoDato.ConvertirADouble(izq);
            double? valDer = TipoDato.ConvertirADouble(der);
            if (valIzq.HasValue && valDer.HasValue)
            {
                return valIzq.Value * valDer.Value;
            }
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

            double? numIzq = TipoDato.ConvertirANumero(izq);
            double? numDer = TipoDato.ConvertirANumero(der);

            if (numIzq.HasValue && numDer.HasValue)
            {
                return numIzq.Value == numDer.Value;
            }

            // Comparar otros tipos 
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
            if (valor is bool boolValor)
                return !boolValor;
             var token = context.Start;
            AgregarError($"Error: Operador '!' requiere un booleano, recibió {TipoDato.ObtenerNombreTipo(valor)}.", 
                token.Line, 
                token.Column + 1);
            return null; 
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
                    Visit(ctx.bloque(0));
                    pilaEntornos.Pop();
                }
                else if (ctx.bloque().Length > 1)
                {
                    pilaEntornos.Push(new Dictionary<string, EntradaSimbolo>());
                    Visit(ctx.bloque(1));
                    pilaEntornos.Pop();
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

            if (switchValue == null)
            {
            var token = context.expresion().Start;
            AgregarError("Error: La expresión del switch no puede ser nula.", 
                        token.Line, 
                        token.Column + 1);
            EnSwitch = false;
            return null;
            }

            foreach (var caseBlock in context.caseBlock())
            {
                var caseValue = Visit(caseBlock.expresion());

                if (switchValue.Equals(caseValue))
                {
                    object resultado = Visit(caseBlock);

                    // Si hay un break, salir del switch
                    if (resultado is BreakCommand)
                    {
                        EnSwitch = false;
                        return null;
                    }
                }
            }

            // Evaluar default si existe
            if (context.defaultBlock() != null)
            {
                object resultado = Visit(context.defaultBlock());

                // Si hay un break, salir del switch
                if (resultado is BreakCommand)
                {
                    EnSwitch = false;
                    return null;
                }
            }

            EnSwitch = false;
            return null;
        }


        //for con condicion
        public override object VisitForCondicion(LanguageParser.ForCondicionContext ctx)
        {
            EnCiclo = true;
            object cond = Visit(ctx.expresion());
            
            while (cond is bool bCond && bCond)
            {
                object resultado = Visit(ctx.bloque());

                // Si el bloque retornó un BreakCommand, salir del bucle
                if (resultado is BreakCommand)
                    break;

                // Si el bloque retornó un ContinueCommand, saltar a la siguiente iteración
                if (resultado is ContinueCommand)
                {
                    cond = Visit(ctx.expresion()); // Reevaluar la condición
                    continue;
                }

                // Reevaluar la condición del ciclo
                cond = Visit(ctx.expresion());
            }

            EnCiclo = false;
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

            var iterador = context.IDENTIFICADOR(0).GetText();
            var variable = context.IDENTIFICADOR(1).GetText();
            var coleccion = Visit(context.expresion());

            if (coleccion is List<object> lista)
            {
                for (int i = 0; i < lista.Count; i++)
                {
                    pilaEntornos.Peek()[iterador] = new EntradaSimbolo { Nombre = iterador, TipoDato = "int", Valor = i };
                    pilaEntornos.Peek()[variable] = new EntradaSimbolo { Nombre = variable, TipoDato = TipoDato.ObtenerNombreTipo(lista[i]), Valor = lista[i] };

                    Visit(context.bloque());
                }
            }
            else
            {
                var token = context.expresion().Start;
                AgregarError("Error: for range requiere una lista.", 
                            token.Line, 
                            token.Column + 1);
            }

            pilaEntornos.Pop();
            EnCiclo = false;
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
            // Se agrega el parámetro 'context'
            return ActualizarContador(varName, 1, context);
        }

        public override object VisitDecremento(LanguageParser.DecrementoContext context)
        {
            string varName = context.IDENTIFICADOR().GetText();
            // Se agrega el parámetro 'context'
            return ActualizarContador(varName, -1, context);
        }


        //implementacion break
        public override object VisitBreakStmt(LanguageParser.BreakStmtContext context)
        {
            Console.WriteLine("DEBUG: Se encontró un 'break'");

            // Validar si estamos dentro de un bucle o un switch
            if (!EnCiclo && !EnSwitch)
            {
                AgregarError("Error: 'break'...", context.Start.Line, context.Start.Column + 1);
                return null;
            }

            // Si estamos en un switch, retornamos BreakCommand
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
            AgregarError("Error: 'return'...", token.Line, token.Column + 1);
            return null;
            }

            object valorRetorno = null;
            if (context.expresion() != null)
            {
                valorRetorno = Visit(context.expresion());
            }

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
            string nombreFuncion = string.Join(".", context.IDENTIFICADOR().Select(id => id.GetText()));
            List<object> argumentos = new List<object>();
            
                switch (nombreFuncion)
            {
                case "slices.Index":
                    if (argumentos.Count != 2)
                    {
                        AgregarError("slices.Index requiere 2 argumentos", context.Start.Line, context.Start.Column);
                        return -1;
                    }
                    // Lógica de Index aquí
                    if (argumentos[0] is List<object> lista)
                    {
                        for (int i = 0; i < lista.Count; i++)
                        {
                            if (lista[i]?.Equals(argumentos[1]) == true) return i;
                        }
                        return -1;
                    }
                    AgregarError("slices.Index requiere un slice", context.Start.Line, context.Start.Column);
                    return -1;

                case "strings.Join":
                    if (argumentos.Count != 2)
                    {
                        AgregarError("strings.Join requiere 2 argumentos", context.Start.Line, context.Start.Column);
                        return "";
                    }
                    // Lógica de Join aquí
                    if (argumentos[0] is List<object> listaStrings && argumentos[1] is string separador)
                    {
                        return string.Join(separador, listaStrings.Cast<string>());
                    }
                    AgregarError("strings.Join requiere un slice de strings y un separador", context.Start.Line, context.Start.Column);
                    return "";

                default:
                    AgregarError($"Función no implementada: {nombreFuncion}", context.Start.Line, context.Start.Column);
                    return null;
            }
            foreach (var expr in context.expresion())
            {
                argumentos.Add(Visit(expr));
            }
        if (argumentos.Count > 0 && argumentos[0] is StructInstance instancia)
            {
                string key = $"{instancia.Definicion.Nombre}_{nombreFuncion}";
                if (_tablaFuncionesStruct.TryGetValue(key, out MetodoStruct metodo))
                {
                    // Validar parámetros
                    if (metodo.Parametros.Count != argumentos.Count - 1) // -1 porque el primero es la instancia
                    {
                        AgregarError($"Número incorrecto de parámetros para {nombreFuncion}", 
                                    context.Start.Line, 
                                    context.Start.Column + 1);
                    }

                    // Crear nuevo entorno
                    pilaEntornos.Push(new Dictionary<string, EntradaSimbolo>());
                    
                    // Agregar parámetros al entorno
                    for (int i = 0; i < metodo.Parametros.Count; i++)
                    {
                        string nombreParam = metodo.Parametros[i].Item2;
                        pilaEntornos.Peek()[nombreParam] = new EntradaSimbolo { 
                            Nombre = nombreParam,
                            Valor = argumentos[i + 1] // +1 para saltar la instancia
                        };
                    }

                    // Agregar la instancia como referencia
                    pilaEntornos.Peek()[metodo.Parametros[0].Item2] = new EntradaSimbolo {
                        Nombre = metodo.Parametros[0].Item2,
                        Valor = instancia
                    };

                    // Ejecutar el bloque
                    object resultado = Visit(metodo.Bloque);
                    
                    pilaEntornos.Pop();
                    return resultado;
                }
            }
        }

        public override object VisitStructDeclaracion(LanguageParser.StructDeclaracionContext context) {
            string nombreStruct = context.IDENTIFICADOR().GetText();
            
            // Validar ámbito global
            if (_ambitoActual.Count > 0) {
                AgregarError("Los structs solo pueden declararse en el ámbito global", context.Start.Line, context.Start.Column);
                return null;
            }

            var structDef = new StructDefinition { Nombre = nombreStruct };

            // Procesar atributos
            foreach (var attrCtx in context.atributoStruct()) {
                if (attrCtx is LanguageParser.AtributoContext atributo) {
                    string tipo = atributo.tipo().GetText();
                    string nombreAttr = atributo.IDENTIFICADOR().GetText();
                    
                    // Validar tipo
                    if (!TipoDato.EsTipoValido(tipo) && !StructManager.ExisteStruct(tipo)) {
                        AgregarError($"Tipo inválido '{tipo}'", atributo.Start.Line, atributo.Start.Column);
                        continue;
                    }
                    
                    structDef.Atributos.Add(nombreAttr, tipo);
                }
            }
            
            StructManager.RegistrarStruct(structDef);
            return null;
        }
        public override object VisitAtributo(LanguageParser.AtributoContext context)
        {
            string tipo = context.tipo().GetText();
            string nombre = context.IDENTIFICADOR().GetText();
            return Tuple.Create(tipo, nombre); // Devolver una tupla real
        }
        public override object VisitExpresionStructLiteral(LanguageParser.ExpresionStructLiteralContext context)
        {
            // Obtener el contexto interno de la regla expresionLiteralStruct
            var structLiteralCtx = context.expresionLiteralStruct();

            // 1. Obtener nombre del struct desde el IDENTIFICADOR
            string nombreStruct = structLiteralCtx.IDENTIFICADOR().GetText();
            var structDef = StructManager.ObtenerStruct(nombreStruct);
            if (structDef == null) {
                AgregarError($"Struct '{nombreStruct}' no definido", context.Start.Line, context.Start.Column);
                return null;
            }

            // 2. Crear instancia del struct
            var instancia = new StructInstance { Definicion = structDef };

            // 3. Procesar atributos inicializados (si existen)
            var atributosInitCtx = structLiteralCtx.atributosInicializacion();
            if (atributosInitCtx != null)
            {
                var ids = atributosInitCtx.IDENTIFICADOR(); 
                var exprs = atributosInitCtx.expresion();

                for (int i = 0; i < ids.Length; i++)
                {
                    string nombreAttr = ids[i].GetText();
                    object valor = Visit(exprs[i]);

                    // Validar que el atributo exista en el struct
                    if (!structDef.Atributos.ContainsKey(nombreAttr))
                    {
                        AgregarError($"Atributo '{nombreAttr}' no existe en el struct '{nombreStruct}'",
                            ids[i].Symbol.Line, ids[i].Symbol.Column + 1);
                        continue;
                    }

                    // Validar tipo del valor
                    string tipoEsperado = structDef.Atributos[nombreAttr];
                    if (!TipoDato.ValidarTipo(valor, tipoEsperado))
                    {
                        AgregarError($"Tipo incorrecto para '{nombreAttr}'. Esperado: {tipoEsperado}, Recibido: {TipoDato.ObtenerNombreTipo(valor)}",
                            exprs[i].Start.Line, exprs[i].Start.Column);
                    }

                    instancia.Valores[nombreAttr] = valor;
                }
                  return instancia;
            }

            // 4. Verificar que todos los atributos obligatorios estén inicializados
            foreach (var attr in structDef.Atributos)
            {
                if (!instancia.Valores.ContainsKey(attr.Key))
                {
                    AgregarError($"Falta inicializar el atributo obligatorio '{attr.Key}'", 
                        context.Start.Line, context.Start.Column);
                }
            }

            return instancia;
        }
        public override object VisitExpresionAccesoAtributo(LanguageParser.ExpresionAccesoAtributoContext context) {
            object padre = Visit(context.expresion());
            string nombreAttr = context.IDENTIFICADOR().GetText();
            
            if (!(padre is StructInstance instancia)) {
                AgregarError("Acceso a atributo en no instancia", context.Start.Line, context.Start.Column);
                return null;
            }

            if (!instancia.Definicion.Atributos.ContainsKey(nombreAttr)) {
                AgregarError($"Atributo '{nombreAttr}' no existe", context.Start.Line, context.Start.Column);
                return null;
            }

            return instancia.Valores.TryGetValue(nombreAttr, out object valor) ? valor : "nulo";
        }
        public override object VisitMetodoStruct(LanguageParser.MetodoStructContext context)
        {
            // 1. Obtener metadata
            string tipoStruct = context.IDENTIFICADOR(0).GetText();
            string paramReferencia = context.IDENTIFICADOR(1).GetText();
            string nombreMetodo = context.IDENTIFICADOR(2).GetText();
            
            // 2. Validar existencia del struct
            if (!StructManager.ExisteStruct(tipoStruct))
            {
                AgregarError($"Struct '{tipoStruct}' no existe", context.Start.Line, context.Start.Column);
                return null;
            }

            // 3. Procesar parámetros
            List<Tuple<string, string>> parametros = new List<Tuple<string, string>>();
            foreach (var paramCtx in context.parametros().parametro())
            {
                string tipo = paramCtx.tipo().GetText();
                string nombre = paramCtx.IDENTIFICADOR().GetText();
                parametros.Add(Tuple.Create(tipo, nombre));
            }

            // 4. Registrar método en tabla de símbolos
            string key = $"{tipoStruct}_{nombreMetodo}";
            _tablaFuncionesStruct[key] = new MetodoStruct {
                Nombre = nombreMetodo,
                Parametros = context.parametros().parametro().Select(p => 
                    Tuple.Create(p.tipo().GetText(), p.IDENTIFICADOR().GetText())).ToList(),
                Bloque = context.bloque()
            };

            return null;
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

        // Visitor para un identificador
        public override object VisitIdentificador(LanguageParser.IdentificadorContext context)
        {
            var id = context.IDENTIFICADOR().GetText();
            
            foreach (var entorno in pilaEntornos)
            {
                if (entorno.TryGetValue(id, out var entrada))
                {
                    return entrada.Valor ?? "nulo";
                }
            }

            var simbolo = tablaSimbolos.Find(s => s.Nombre == id);
            if (simbolo != null)
            {
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
            
            string texto = context.GetText().Trim('"');
            return texto;
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