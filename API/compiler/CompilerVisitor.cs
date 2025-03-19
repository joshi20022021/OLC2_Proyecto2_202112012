using System;
using System.Globalization;
using System.Collections.Generic;
using Antlr4.Runtime.Misc;
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
                int _ => "entero",
                double _ => "decimal",
                bool _ => "booleano",
                string _ => "cadena",
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
                return (double)rune;  // ✅ Convierte `rune` a su valor ASCII.
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


        // visitor para una asignación de variable
        public override object VisitAsignar(LanguageParser.AsignarContext context)
        {
            var valor = Visit(context.expresion());
            var simbolo = new EntradaSimbolo
            {
                Nombre = context.IDENTIFICADOR().GetText(),
                Valor = valor ?? "nulo",
                Tipo = ObtenerNombreTipo(valor)
            };
            tablaSimbolos.Add(simbolo);
            return valor;
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
                    if (resultado is double d) // 🔹 Si es double, formateamos correctamente
                    {
                        valores.Add(d.ToString("0.0", CultureInfo.InvariantCulture));
                    }
                    else
                    {
                        valores.Add(resultado?.ToString() ?? "nulo");
                    }
                }
            }

            string salida = string.Join(", ", valores);
            Console.WriteLine($"DEBUG - Print recibe: {salida}"); // 🔹 Debugging para verificar
            mensajesSalida.Add(salida);

            return null; 
        }



        // Visitor para una operación de suma
        public override object VisitSuma(LanguageParser.SumaContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            double? valIzq = ConvertirADouble(izq);
            double? valDer = ConvertirADouble(der);

            if (valIzq.HasValue && valDer.HasValue)
            {
                // 🔹 Si alguno es float, devolvemos un float
                return valIzq.Value + valDer.Value;
            }

            return "Error: Tipos incompatibles en suma.";
        }


        // Visitor para una operación de resta
        public override object VisitResta(LanguageParser.RestaContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            double? valIzq = ConvertirADouble(izq);
            double? valDer = ConvertirADouble(der);

            if (valIzq.HasValue && valDer.HasValue)
                return valIzq.Value - valDer.Value;

            return "Error: Tipos incompatibles en resta.";
        }

        // Visitor para una operación de multiplicación
        public override object VisitMultiplicacion(LanguageParser.MultiplicacionContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            double? valIzq = ConvertirADouble(izq);
            double? valDer = ConvertirADouble(der);

            if (valIzq.HasValue && valDer.HasValue)
                return valIzq.Value * valDer.Value;

            return "Error: Tipos incompatibles en multiplicación.";
        }

        // Visitor para una operación de división
        public override object VisitDivision(LanguageParser.DivisionContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

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

            if (izq is double valIzq && der is double valDer)
            {
                if (valDer == 0) return "Error: Módulo por 0.";
                return valIzq % valDer;
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
                return numIzq.Value > numDer.Value;  // ✅ Devuelve `bool`.

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

            double? numIzq = ConvertirADouble(izq);
            double? numDer = ConvertirADouble(der);

            if (numIzq.HasValue && numDer.HasValue)
            {
                return numIzq.Value == numDer.Value;
            }

            if (izq is string strIzq && der is string strDer)
            {
                return strIzq == strDer;
            }

            if (izq is bool boolIzq && der is bool boolDer)
            {
                return boolIzq == boolDer;
            }

            if (izq is char charIzq && der is char charDer)
            {
                return charIzq == charDer;
            }

            return "Error: Tipos incompatibles en comparación de igualdad.";
        }

        // Visitor una comparación de desigualdad
        public override object VisitComparacionDiferente(LanguageParser.ComparacionDiferenteContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            double? numIzq = ConvertirADouble(izq);
            double? numDer = ConvertirADouble(der);

            if (numIzq.HasValue && numDer.HasValue)
            {
                return numIzq.Value != numDer.Value;
            }

            if (izq is string strIzq && der is string strDer)
            {
                return strIzq != strDer;
            }

            if (izq is bool boolIzq && der is bool boolDer)
            {
                return boolIzq != boolDer;
            }

            if (izq is char charIzq && der is char charDer)
            {
                return charIzq != charDer;
            }

            return "Error: Tipos incompatibles en comparación de desigualdad.";
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

        // Visitor para un literal entero
        public override object VisitLiteralEntero(LanguageParser.LiteralEnteroContext context)
        {
            return double.Parse(context.GetText());
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
            return simbolo?.Valor ?? "nulo";
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

    }
}