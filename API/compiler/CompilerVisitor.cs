using System;
using System.Collections.Generic;
using Antlr4.Runtime.Misc;
using API.compiler;

namespace API.compiler
{
    public class CompilerVisitor : LanguageBaseVisitor<object>
    {
        public class EntradaSimbolo
        {
            public string Nombre { get; set; } = string.Empty;
            public string Tipo { get; set; } = "indefinido";
            public object Valor { get; set; } = "nulo";
            public string Contexto { get; set; } = "Global";
        }

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

        private string ObtenerNombreTipo(object valor)
        {
            return valor switch
            {
                null => "nulo",
                int _ => "entero",
                double _ => "decimal",
                bool _ => "booleano",
                string _ => "cadena",
                _ => valor.GetType().Name
            };
        }

        private double? ConvertirADouble(object valor)
        {
            if (valor is int valorEntero)
                return (double)valorEntero;
            if (valor is double valorDecimal)
                return valorDecimal;
            if (valor is NodoAST nodo && double.TryParse(nodo.Valor, out double resultado))
                return resultado;
            if (valor is string texto && double.TryParse(texto, out double resultadoTexto))
                return resultadoTexto;

            return null;
        }

        public override object VisitReglaPrograma(LanguageParser.ReglaProgramaContext context)
        {
            mensajesSalida.Clear();
            foreach (var sentencia in context.sentencia())
            {
                Visit(sentencia);
            }
            return string.Join("\n", mensajesSalida);
        }

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

        public override object VisitImprime(LanguageParser.ImprimeContext context)
        {
            List<string> valores = new List<string>();

            if (context.expresion() != null)
            {
                foreach (var expr in context.expresion())
                {
                    var resultado = Visit(expr);
                    valores.Add(resultado?.ToString() ?? "nulo");
                }
            }

            string salida = string.Join(" ", valores);
            mensajesSalida.Add(salida);
            return salida;
        }

        public override object VisitSuma(LanguageParser.SumaContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            if (izq is double valIzq && der is double valDer)
                return valIzq + valDer;

            return "Error: Tipos incompatibles en suma.";
        }

        public override object VisitResta(LanguageParser.RestaContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            if (izq is double valIzq && der is double valDer)
                return valIzq - valDer;

            return "Error: Tipos incompatibles en resta.";
        }

        public override object VisitMultiplicacion(LanguageParser.MultiplicacionContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            if (izq is double valIzq && der is double valDer)
                return valIzq * valDer;

            return "Error: Tipos incompatibles en multiplicación.";
        }

        public override object VisitDivision(LanguageParser.DivisionContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            if (izq is double valIzq && der is double valDer)
            {
                if (valDer == 0) return "Error: División por 0.";
                return valIzq / valDer;
            }
            return "Error: Tipos incompatibles en división.";
        }

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

        public override object VisitMayorQue(LanguageParser.MayorQueContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            if (izq is double valIzq && der is double valDer)
                return valIzq > valDer;

            return "Error: Tipos incompatibles en comparación.";
        }

        public override object VisitMenorQue(LanguageParser.MenorQueContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            if (izq is double valIzq && der is double valDer)
                return valIzq < valDer;

            return "Error: Tipos incompatibles en comparación.";
        }

        public override object VisitMayorOIgual(LanguageParser.MayorOIgualContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            if (izq is double valIzq && der is double valDer)
                return valIzq >= valDer;

            return "Error: Tipos incompatibles en comparación.";
        }

        public override object VisitMenorOIgual(LanguageParser.MenorOIgualContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));

            if (izq is double valIzq && der is double valDer)
                return valIzq <= valDer;

            return "Error: Tipos incompatibles en comparación.";
        }

        public override object VisitComparacionIgual(LanguageParser.ComparacionIgualContext context)
        {
            var izq = Visitar(contexto.expresion(0));
            var der = Visitar(contexto.expresion(1));

            // 🔹 Convertir números a double si es posible
            double? numIzq = ConvertirADouble(izq);
            double? numDer = ConvertirADouble(der);

            if (numIzq.HasValue && numDer.HasValue)
            {
                return numIzq.Value == numDer.Value;
            }

            // 🔹 Comparar cadenas
            if (izq is string strIzq && der is string strDer)
            {
                return strIzq == strDer;
            }

            // 🔹 Comparar booleanos
            if (izq is bool boolIzq && der is bool boolDer)
            {
                return boolIzq == boolDer;
            }

            // 🔹 Comparar caracteres (runas)
            if (izq is char charIzq && der is char charDer)
            {
                return charIzq == charDer;
            }

            return "Error: Tipos incompatibles en comparación de igualdad.";
        }

        public override object VisitComparacionDiferente(LanguageParser.ComparacionDiferenteContext context)
        {
            var izq = Visitar(contexto.expresion(0));
            var der = Visitar(contexto.expresion(1));

            // 🔹 Convertir números a double si es posible
            double? numIzq = ConvertirADouble(izq);
            double? numDer = ConvertirADouble(der);

            if (numIzq.HasValue && numDer.HasValue)
            {
                return numIzq.Value != numDer.Value;
            }

            // 🔹 Comparar cadenas
            if (izq is string strIzq && der is string strDer)
            {
                return strIzq != strDer;
            }

            // 🔹 Comparar booleanos
            if (izq is bool boolIzq && der is bool boolDer)
            {
                return boolIzq != boolDer;
            }

            // 🔹 Comparar caracteres (runas)
            if (izq is char charIzq && der is char charDer)
            {
                return charIzq != charDer;
            }

            return "Error: Tipos incompatibles en comparación de desigualdad.";
        }
        

        public override object VisitLiteralEntero(LanguageParser.LiteralEnteroContext context)
        {
            return double.Parse(context.GetText());
        }

        public override object VisitLiteralFlotante(LanguageParser.LiteralFlotanteContext context)
        {
            return double.Parse(context.GetText());
        }

        public override object VisitIdentificador(LanguageParser.IdentificadorContext context)
        {
            var id = context.IDENTIFICADOR().GetText();
            var simbolo = tablaSimbolos.Find(s => s.Nombre == id);
            return simbolo?.Valor ?? "nulo";
        }

        public override object VisitParentesis(LanguageParser.ParentesisContext context)
        {
            return Visit(context.expresion());
        }
    }
}
