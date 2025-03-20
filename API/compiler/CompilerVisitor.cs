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
                int _ => "int",
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


        // Método para obtener el valor numérico de un objeto si es int, float64 o rune
        private double? ConvertirANumero(object valor)
        {
            if (valor is int entero)
                return (double)entero;
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
                Console.WriteLine("Error: No se encontró la función main().");
                return null;
            }

            Visit(funcionMain);
            return null;
        }

    public override object VisitDeclaracion(LanguageParser.DeclaracionContext context)
    {
        string varName = context.IDENTIFICADOR().GetText();
        string varType = null;
        object value = null;

        if (context.GetChild(0).GetText() == "var")
        {
            if (context.tipo() != null)
            {
                varType = context.tipo().GetText();
            }

            if (context.expresion() != null)
            {
                value = Visit(context.expresion());
            }
        }
        else
        {
            value = Visit(context.expresion());
        }

        if (value == null)
        {
            switch (varType)
            {
                case "int": value = 0; break;
                case "float64": value = 0.0; break;
                case "string": value = ""; break;
                case "bool": value = false; break;
                default: value = "nulo"; break;
            }
        }

        if (varType == null)
        {
            varType = ObtenerNombreTipo(value);
        }

        // Guardamos en la tabla de símbolos correctamente
        var simbolo = new EntradaSimbolo { Nombre = varName, Tipo = varType, Valor = value };
        tablaSimbolos.Add(simbolo);

        Console.WriteLine($"DEBUG - Variable '{varName}' almacenada con valor: {value}");

        return value;
    }



        public override object VisitLiteralVerdadero(LanguageParser.LiteralVerdaderoContext context)
        {
            return true;
        }

        public override object VisitLiteralFalso(LanguageParser.LiteralFalsoContext context)
        {
            return false;
        }

        // visitor para una asignación de variable
        public override object VisitAsignar(LanguageParser.AsignarContext context)
        {
            var varName = context.IDENTIFICADOR().GetText();
            var value = Visit(context.expresion());

            // Verificamos si la variable ya existe en la tabla de símbolos
            var simboloExistente = tablaSimbolos.Find(s => s.Nombre == varName);

            if (simboloExistente != null)
            {
                // 🔹 Validamos que el tipo sea el mismo antes de actualizar
                if (ObtenerNombreTipo(value) == simboloExistente.Tipo)
                {
                    simboloExistente.Valor = value;
                }
                else
                {
                    AgregarError($"Error: No se puede asignar un valor de tipo {ObtenerNombreTipo(value)} a '{varName}' de tipo {simboloExistente.Tipo}.");
                }
            }
            else
            {
                // Si la variable no existe, la creamos
                var simbolo = new EntradaSimbolo
                {
                    Nombre = varName,
                    Valor = value ?? "nulo",
                    Tipo = ObtenerNombreTipo(value)
                };
                tablaSimbolos.Add(simbolo);
            }

            return value;
        }

         // Visitor para un print
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

            if (izq is int i && der is int j)
                return i + j;

            double? valIzq = ConvertirADouble(izq);
            double? valDer = ConvertirADouble(der);
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

            if (izq is int i && der is int j)
                return i - j;

            double? valIzq = ConvertirADouble(izq);
            double? valDer = ConvertirADouble(der);
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

            if (izq is int i && der is int j)
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

            if (der is int d && d == 0)
                return "Error: División por 0.";

            if (izq is int i && der is int j)
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

            if (izq is int i && der is int j)
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

            if (numIzq.HasValue && numDer.HasValue)
                return numIzq.Value > numDer.Value;  

            return "Error: Tipos incompatibles en comparación '>'."; 
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

            double? numIzq = ConvertirANumero(izq);
            double? numDer = ConvertirANumero(der);

            if (numIzq.HasValue && numDer.HasValue)
                return numIzq.Value >= numDer.Value;

            return "Error: Tipos incompatibles en comparación '>='.";
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
                return numIzq.Value == numDer.Value;

            if (izq is string strIzq && der is string strDer)
                return strIzq == strDer;

            if (izq is bool boolIzq && der is bool boolDer)
                return boolIzq == boolDer;

            if (izq is char charIzq && der is char charDer)
                return charIzq == charDer;

            return $"Error: Tipos incompatibles en comparación de igualdad. (Recibidos: {ObtenerNombreTipo(izq)} y {ObtenerNombreTipo(der)})";
        }


        // Visitor una comparación de desigualdad
        public override object VisitComparacionDiferente(LanguageParser.ComparacionDiferenteContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            double? numIzq = ConvertirANumero(izq);
            double? numDer = ConvertirANumero(der);

            if (numIzq.HasValue && numDer.HasValue)
                return numIzq.Value != numDer.Value;

            if (izq is string strIzq && der is string strDer)
                return strIzq != strDer;

            if (izq is bool boolIzq && der is bool boolDer)
                return boolIzq != boolDer;

            if (izq is char charIzq && der is char charDer)
                return charIzq != charDer;

            return $"Error: Tipos incompatibles en comparación de desigualdad. (Recibidos: {ObtenerNombreTipo(izq)} y {ObtenerNombreTipo(der)})";
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

            return $"Error: Operador '!' solo se aplica a booleanos, pero recibió '{ObtenerNombreTipo(valor)}'.";
        }


        //sentencia if y else

        public override object VisitIfElse(LanguageParser.IfElseContext context)
        {
            var condicion = Visit(context.expresion());

            if (condicion is bool condicionBooleana)
            {
                if (condicionBooleana)
                {
                    return Visit(context.bloque(0)); 
                }
                else if (context.ifStmt() != null) 
                {
                    return Visit(context.ifStmt());
                }
                else if (context.bloque(1) != null) 
                {
                    return Visit(context.bloque(1));
                }
            }
            else
            {
                return "Error: La condición del if debe ser de tipo booleano.";
            }

            return null;
        }
        //switch case
        public override object VisitSwitchCase(LanguageParser.SwitchCaseContext context)
        {
            var switchValue = Visit(context.expresion());

            if (switchValue == null)
            {
                AgregarError("Error: La expresión del switch no puede ser nula.");
                return null;
            }

            Console.WriteLine($"DEBUG - Evaluando switch con valor: {switchValue}");

            foreach (var caseBlock in context.caseBlock())
            {
                var caseValue = Visit(caseBlock.expresion());
                Console.WriteLine($"DEBUG - Comparando con case: {caseValue}");

                if (switchValue != null && caseValue != null && switchValue.Equals(caseValue))
                {
                    Console.WriteLine($"DEBUG - Coincidencia encontrada en case {caseValue}, ejecutando...");
                    Visit(caseBlock); 
                    return null; 
                }
            }

            if (context.defaultBlock() != null)
            {
                Console.WriteLine("DEBUG - No hubo coincidencias, ejecutando default.");
                Visit(context.defaultBlock());
            }

            return null;
        }
        //for con condicion
        public override object VisitForCondicion(LanguageParser.ForCondicionContext context)
        {
            object cond = Visit(context.expresion());

            if (cond is not bool)
            {
                AgregarError("Error: La condición del for debe ser booleana.");
                return null;
            }

            while ((bool)cond) 
            {
                Visit(context.bloque());  
                cond = Visit(context.expresion());  
            }

            return null;
        }
        //for clasico con contador        
        public override object VisitForClasico(LanguageParser.ForClasicoContext context)
        {
            if (context.declaracion() != null)
            {
                Visit(context.declaracion());
            }
            else if (context.asignacion().Length > 0)
            {
                Visit(context.asignacion(0));  ¡
            }

            while (true)
            {
                var cond = Visit(context.expresion());
                if (cond is not bool || !(bool)cond) break;

                Visit(context.bloque());

                if (context.contador() != null)
                {
                    Visit(context.contador());
                }
                else if (context.asignacion().Length > 1)
                {
                    Visit(context.asignacion(1));  
                }
            }

            return null;
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
            return int.Parse(context.GetText());
        }


        // Visitor para un literal flotante
        public override object VisitLiteralFlotante(LanguageParser.LiteralFlotanteContext context)
        {
            return double.Parse(context.GetText(), CultureInfo.InvariantCulture);
        }


        // Visitor para un identificador
        public override object VisitIdentificador(LanguageParser.IdentificadorContext context)
        {
            var id = context.IDENTIFICADOR().GetText();
            var simbolo = tablaSimbolos.Find(s => s.Nombre == id);
            
            if (simbolo != null)
            {
                return simbolo.Valor;
            }
            
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
            return Visit(context.bloque());
        }
        // Método para agregar errores a la lista de salida
        private void AgregarError(string mensaje)
        {
            Console.WriteLine($"ERROR: {mensaje}"); 
            mensajesSalida.Add($"ERROR: {mensaje}"); 
        }


    }
}