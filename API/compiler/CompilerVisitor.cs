using System;
using System.Globalization;
using System.Collections.Generic;
using Antlr4.Runtime.Misc;
using Antlr4.Runtime.Tree;
using API.compiler;

namespace API.compiler
{
    public class CompilerVisitor : LanguageBaseVisitor<object>
    {
        private Stack<Dictionary<string, EntradaSimbolo>> pilaEntornos = new Stack<Dictionary<string, EntradaSimbolo>>();

        
        // Clase para representar una entrada en la tabla de símbolos
        public class EntradaSimbolo
        {
            public string Nombre { get; set; } = string.Empty;
            public string Tipo { get; set; } = "indefinido";
            public object Valor { get; set; } = "nulo";
            public string Contexto { get; set; } = "Global";
            public List<object> Lista { get; set; } = new List<object>(); 
        }

        // Clase para representar un nodo en el AST
        public class NodoAST
        {
            public string Tipo { get; set; } = "Desconocido";
            public string? Valor { get; set; }
            public List<NodoAST> Hijos { get; set; } = new List<NodoAST>();
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

        
        // Método para obtener el tipo de un valor
        private string ObtenerNombreTipo(object valor)
        {
            return valor switch
            {
                null => "nulo",
                long _ => "int",
                double _ => "float64",
                bool _ => "bool",
                string _ => "string",
                char _ => "rune",  
                _ => valor.GetType().Name
            };
        }


        // Método para convertir un valor a double
        private double? ConvertirADouble(object valor)
        {
            if (valor is int entero)
                return (double)entero;  
            if (valor is double flotante)
                return flotante;
            if (valor is string str && double.TryParse(str, NumberStyles.Any, CultureInfo.InvariantCulture, out double resultado))
                return resultado;

            return null; 
        }


        // Método para obtener el valor numérico de un objeto
        private double? ConvertirANumero(object valor)
        {
            if (valor is int entero)
                return (double)entero;
            if (valor is long enteroLargo) 
                return (double)enteroLargo;
            if (valor is double decimalNum)
                return decimalNum;
            if (valor is char rune)
                return (double)rune;
            if (valor is string str && double.TryParse(str, NumberStyles.Any, CultureInfo.InvariantCulture, out double resultado))
                return resultado;

            return null;
        }


        // visitor para la regla principal del programa
        public override object VisitPrograma(LanguageParser.ProgramaContext context)
        {
            var funcionMain = context.funcionMain();
            if (funcionMain == null)
            {
                AgregarError("No se encontró la función main().");
                return null;
            }

            Visit(funcionMain);

            if (mensajesSalida.Count > 0)
            {
                Console.WriteLine("\n===== ERRORES DETECTADOS =====");
                foreach (var error in mensajesSalida)
                {
                    Console.WriteLine(error);
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
                            AgregarError($"Error: Tipo no especificado para '{varName}'.");
                            return null;
                        }
                        value = null; 
                        break;
                }
            }

            if (string.IsNullOrEmpty(varType))
            {
                varType = ObtenerNombreTipo(value);
            }

            Dictionary<string, EntradaSimbolo> entornoActual = null;
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

            entornoActual[varName] = new EntradaSimbolo
            {
                Nombre = varName,
                Tipo = varType,
                Valor = value
            };

            return value;
        }     

        // visitor para una asignación de variable
        public override object VisitAsignar(LanguageParser.AsignarContext context)
        {
            var varName = context.IDENTIFICADOR().GetText();
            var value = Visit(context.expresion());

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

            AgregarError($"Error: La variable '{varName}' no está definida.");
            return "nulo";
        }

         // Visitor para el fmt.println
        public override object VisitImprime(LanguageParser.ImprimeContext context)
        {
            List<string> valores = new List<string>();

            if (context.expresion() != null)
            {
                foreach (var expr in context.expresion())
                {
                    var resultado = Visit(expr);

                    if (resultado is List<object> lista)
                    {
                        valores.Add("[" + string.Join(" ", lista) + "]");
                    }
                    else if (resultado is double d)
                    {
                        valores.Add(d.ToString("0.######", CultureInfo.InvariantCulture));
                    }
                    else if (resultado is string str)
                    {
                        valores.Add(str.Replace("\\n", "\n")); 
                    }
                    else if (resultado is bool b)
                    {
                        valores.Add(b ? "true" : "false");
                    }
                    else
                    {
                        valores.Add(resultado?.ToString() ?? "nulo");
                    }
                }
            }

            string salida = string.Join(" ", valores);
            Console.WriteLine(salida);  
            mensajesSalida.Add(salida);
            
            return null;
        }


        // Visitor para una operación de suma
        public override object VisitSuma(LanguageParser.SumaContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            double? valIzq = ConvertirANumero(izq);
            double? valDer = ConvertirANumero(der);

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

            double? valIzq = ConvertirANumero(izq);
            double? valDer = ConvertirANumero(der);

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

            double? valIzq = ConvertirADouble(izq);
            double? valDer = ConvertirADouble(der);
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

            double? valIzq = ConvertirADouble(izq);
            double? valDer = ConvertirADouble(der);
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

            double? numIzq = ConvertirANumero(izq);
            double? numDer = ConvertirANumero(der);

            return numIzq.HasValue && numDer.HasValue 
                ? numIzq.Value > numDer.Value 
                : false;
        }
        // Visita una comparación de menor que
        public override object VisitMenorQue(LanguageParser.MenorQueContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            double? numIzq = ConvertirANumero(izq);
            double? numDer = ConvertirANumero(der);

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

            double? numIzq = ConvertirANumero(izq);
            double? numDer = ConvertirANumero(der);

            if (numIzq.HasValue && numDer.HasValue)
                return numIzq.Value >= numDer.Value;

            return $"Error: Tipos incompatibles en '>=' (Recibidos: {ObtenerNombreTipo(izq)} y {ObtenerNombreTipo(der)}).";
        }

        // Visitor para una comparación de menor o igual que
        public override object VisitMenorOIgual(LanguageParser.MenorOIgualContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            double? numIzq = ConvertirANumero(izq);
            double? numDer = ConvertirANumero(der);

            if (numIzq.HasValue && numDer.HasValue)
                return numIzq.Value <= numDer.Value;

            return $"Error: Tipos incompatibles en comparación '<=' (Recibidos: {ObtenerNombreTipo(izq)} y {ObtenerNombreTipo(der)}).";
        }


        // visitor para una comparación de igualdad
        public override object VisitComparacionIgual(LanguageParser.ComparacionIgualContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            double? numIzq = ConvertirANumero(izq);
            double? numDer = ConvertirANumero(der);

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
            double? numIzq = ConvertirANumero(izq);
            double? numDer = ConvertirANumero(der);

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

            return $"Error: Operador '&&' requiere operandos booleanos, pero recibió '{ObtenerNombreTipo(izq)}' y '{ObtenerNombreTipo(der)}'.";
        }


        //visitor para la expresion OR
        public override object VisitOr(LanguageParser.OrContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            if (izq is bool boolIzq && der is bool boolDer)
                return boolIzq || boolDer;

            return $"Error: Operador '||' requiere operandos booleanos, pero recibió '{ObtenerNombreTipo(izq)}' y '{ObtenerNombreTipo(der)}'.";
        }


        //visitor para la expresion NOT
        public override object VisitNot(LanguageParser.NotContext context)
        {
            var valor = Visit(context.expresion());
            if (valor is bool boolValor)
                return !boolValor;
            AgregarError($"Error: Operador '!' requiere un booleano, recibió {ObtenerNombreTipo(valor)}.");
            return "nulo";
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
                AgregarError("Error: La condición del if debe ser booleana.");
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
                AgregarError("Error: La expresión del switch no puede ser nula.");
                EnSwitch = false;
                return null;
            }

            // Recorre los case
            foreach (var caseBlock in context.caseBlock())
            {
                var caseValue = Visit(caseBlock.expresion());
                if (switchValue.Equals(caseValue))
                {
                    // Ejecuta el bloque del case
                    object resultado = Visit(caseBlock);

                    // rompemos el switch
                    if (resultado is string comando && comando == "BREAK_SWITCH")
                    {
                        EnSwitch = false;
                        return null;  // Rompe el switch 
                    }
                }
            }

            // Default
            if (context.defaultBlock() != null)
            {
                object resultado = Visit(context.defaultBlock());
                if (resultado is string comando && comando == "BREAK_SWITCH")
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
                
                if (resultado is string comando && comando == "BREAK_LOOP")
                {
                    break; // Rompe el while 
                }
                
                cond = Visit(ctx.expresion()); //evalua de nuevo la condicion
            }
            
            EnCiclo = false;
            return null;
        }
        //for clasico con contador
        public override object VisitForClasico(LanguageParser.ForClasicoContext ctx)
        {
            EnCiclo = true;
            pilaEntornos.Push(new Dictionary<string, EntradaSimbolo>());
            
            //Inicialización 
            if (ctx.declaracion() != null)
                Visit(ctx.declaracion());
            else if (ctx.asignacion().Length > 0)
                Visit(ctx.asignacion(0));

            //Bucle
            while (true)
            {
                // Evaluar condición
                object cond = Visit(ctx.expresion());
                if (!(cond is bool bCond) || !bCond)
                    break;

                // Ejecutar bloque
                object resultado = Visit(ctx.bloque());
                if (resultado is string comando)
                {
                    if (comando == "BREAK_LOOP") break;
                    if (comando == "CONTINUE") 
                    {
                    }
                }
                // Incremento
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
                    pilaEntornos.Peek()[iterador] = new EntradaSimbolo { Nombre = iterador, Tipo = "int", Valor = i };
                    pilaEntornos.Peek()[variable] = new EntradaSimbolo { Nombre = variable, Tipo = ObtenerNombreTipo(lista[i]), Valor = lista[i] };

                    Visit(context.bloque());
                }
            }
            else
            {
                AgregarError("Error: for range requiere una lista.");
            }

            pilaEntornos.Pop();
            EnCiclo = false;
            return null;
        }

        // Método común para actualizar el contador
        private object ActualizarContador(string varName, int delta)
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
                if (simboloGlobal != null) valorActual = simboloGlobal.Valor;
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
                if (simbolo != null) simbolo.Valor = nuevoValor;
                return nuevoValor;
            }
            else
            {
                AgregarError($"Error: '{varName}' no es un entero.");
                return valorActual;
            }
        }

        // Visitor para el incremento
        public override object VisitIncremento(LanguageParser.IncrementoContext context)
        {
            string varName = context.IDENTIFICADOR().GetText();
            return ActualizarContador(varName, 1);
        }

        // Visitor para el decremento
        public override object VisitDecremento(LanguageParser.DecrementoContext context)
        {
            string varName = context.IDENTIFICADOR().GetText();
            return ActualizarContador(varName, -1);
        }

        //implementacion break
        public override object VisitBreakStmt(LanguageParser.BreakStmtContext context)
        {
            Console.WriteLine("DEBUG: Se encontró un 'break'");
            // Validar si estamos en un for o un switch
            if (!EnCiclo && !EnSwitch)
            {
                AgregarError("Error: 'break' solo puede usarse dentro de un bucle o switch.");
                return null;
            }
            if (EnSwitch)
            {
                return "BREAK_SWITCH";
            }
            else 
            {
                return "BREAK_LOOP";
            }
        }


        //implementacion continue
        public override object VisitContinueStmt(LanguageParser.ContinueStmtContext context)
        {
            Console.WriteLine("DEBUG: Se encontró un 'continue'");
            if (!EnCiclo)
            {
                AgregarError("Error: 'continue' solo puede usarse dentro de un bucle.");
                return null;
            }
            return "CONTINUE";
        }



        //implementacion return
        public override object VisitReturnStmt(LanguageParser.ReturnStmtContext context)
        {
            if (!EnFuncion)
            {
                AgregarError("Error: 'return' solo puede usarse dentro de una función.");
                return null;
            }

            object valorRetorno = null;
            if (context.expresion() != null)
            {
                valorRetorno = Visit(context.expresion());
            }

            return new Tuple<string, object>("RETURN", valorRetorno);
        }



        // implementacion de slice basico
        public override object VisitSliceLiteral(LanguageParser.SliceLiteralContext context)
        {
            List<object> elementos = new List<object>();

            if (context.expresion() != null)
            {
                foreach (var expr in context.expresion())
                {
                    elementos.Add(Visit(expr));
                }
            }
            
            return elementos;
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
            // Buscar en la pila de entornos 
            foreach (var env in pilaEntornos)
            {
                if (env.ContainsKey(id))
                    return env[id].Valor;
            }
            // Si no se encuentra en la pila, buscar en la tabla global
            var simbolo = tablaSimbolos.Find(s => s.Nombre == id);
            if (simbolo != null)
                return simbolo.Valor;
            AgregarError($"Error: La variable '{id}' no está definida.");
            return "nulo";
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
            pilaEntornos.Push(new Dictionary<string, EntradaSimbolo>()); // Iniciar entorno global
            var resultado = Visit(context.bloque());
            pilaEntornos.Pop(); // Eliminar el entorno al salir
            return resultado;
        }


        // Método errores
        private void AgregarError(string mensaje)
        {
            Console.WriteLine($"ERROR DETECTADO: {mensaje}"); 
            mensajesSalida.Add($"ERROR DETECTADO: {mensaje}"); 
        }


    }
}