using System.Collections.Generic;
using System.Globalization;
using System.Linq;

namespace API.compiler
{
    public partial class CompilerVisitor
    {
        // Visitor para una operación de suma
        public override object VisitSuma(LanguageParser.SumaContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));
            object result;

            // Si alguno es cadena, realizar concatenación
            if (izq is string || der is string)
            {
                result = (izq?.ToString() ?? "") + (der?.ToString() ?? "");
            }
            else
            {
                double? valIzq = TipoDato.ConvertirANumero(izq);
                double? valDer = TipoDato.ConvertirANumero(der);

                if (valIzq.HasValue && valDer.HasValue)
                {
                    result = valIzq.Value + valDer.Value;
                }
                else
                {
                    result = "Error: Tipos incompatibles en suma.";
                }
            }

            // Añadir nodo AST ANTES del return
            nodosAST.Add(new NodoAST {
                Tipo = "Operacion",
                Valor = "+",
                Hijos = new List<NodoAST> {
                    new NodoAST { Tipo = "Identificador", Valor = context.expresion(0).GetText() },
                    new NodoAST { Tipo = "Literal", Valor = context.expresion(1).GetText() }
                }
            });
            
            return result;
        }

        // Visitor para una operación de resta
        public override object VisitResta(LanguageParser.RestaContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));
            object result;

            double? valIzq = TipoDato.ConvertirANumero(izq);
            double? valDer = TipoDato.ConvertirANumero(der);

            if (valIzq.HasValue && valDer.HasValue)
            {
                result = valIzq.Value - valDer.Value;
            }
            else
            {
                result = "Error: Tipos incompatibles en resta.";
            }
            
            nodosAST.Add(new NodoAST {
                Tipo = "Operacion",
                Valor = "-",
                Hijos = new List<NodoAST> {
                    new NodoAST { Tipo = "Identificador", Valor = context.expresion(0).GetText() },
                    new NodoAST { Tipo = "Literal", Valor = context.expresion(1).GetText() }
                }
            });
            
            return result;
        }

                // Visitor para una operación de multiplicación
        public override object VisitMultiplicacion(LanguageParser.MultiplicacionContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));
            object result;

            // Mejorar el manejo de tipos para la recursión
            // Convertir explícitamente para asegurar compatibilidad de tipos
            if (izq is long lizq && der is long lder)
                result = lizq * lder;
            else if (izq is long liz && der is double dd)
                result = liz * dd;
            else if (izq is double di && der is long ld)
                result = di * ld;
            else if (izq is double dizq && der is double dder)
                result = dizq * dder;
            else 
            {
                // Si son otros tipos numéricos, intentar conversión
                double? valIzq = TipoDato.ConvertirANumero(izq);
                double? valDer = TipoDato.ConvertirANumero(der);
                
                if (valIzq.HasValue && valDer.HasValue)
                {
                    result = valIzq.Value * valDer.Value;
                }
                else
                {
                    Console.WriteLine($"DEBUG Multiplicación: izq={izq?.GetType().Name ?? "null"}, der={der?.GetType().Name ?? "null"}");
                    result = "Error: Tipos incompatibles en multiplicación.";
                }
            }
            
            nodosAST.Add(new NodoAST {
                Tipo = "Operacion",
                Valor = "*",
                Hijos = new List<NodoAST> {
                    new NodoAST { Tipo = "Identificador", Valor = context.expresion(0).GetText() },
                    new NodoAST { Tipo = "Literal", Valor = context.expresion(1).GetText() }
                }
            });
            
            return result;
        }

        // Visitor para una operación de división
        public override object VisitDivision(LanguageParser.DivisionContext context)
        {
            var izq = Visit(context.expresion(0));
            var der = Visit(context.expresion(1));
            object result;

            // Verificar división por cero
            if ((der is long dl && dl == 0) || (der is double dd && dd == 0))
                result = "Error: División por 0.";
            else if (izq is long lizq1 && der is long lder1)
                result = (double)lizq1 / lder1;
            else if (izq is long lizq2 && der is double dder1)
                result = lizq2 / dder1;  // Conversión implícita a double
            else if (izq is double dizq1 && der is long lder2)
                result = dizq1 / lder2;  // Conversión implícita a double
            else if (izq is double dizq2 && der is double dder2)
                result = dizq2 / dder2;
            else
            {
                // Si llegamos aquí, intentar convertir de forma genérica
                double? valIzq = TipoDato.ConvertirADouble(izq);
                double? valDer = TipoDato.ConvertirADouble(der);
                
                if (valIzq.HasValue && valDer.HasValue)
                {
                    if (valDer.Value == 0) 
                        result = "Error: División por 0.";
                    else
                        result = valIzq.Value / valDer.Value;
                }
                else
                {
                    result = "Error: Tipos incompatibles en división.";
                }
            }
            
            nodosAST.Add(new NodoAST {
                Tipo = "Operacion",
                Valor = "/",
                Hijos = new List<NodoAST> {
                    new NodoAST { Tipo = "Identificador", Valor = context.expresion(0).GetText() },
                    new NodoAST { Tipo = "Literal", Valor = context.expresion(1).GetText() }
                }
            });
            
            return result;
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
            
            // Caso especial: comparación de cadenas literales
            if (izq is string strIzq && der is string strDer)
                return strIzq == strDer;

            // Caso numérico
            double? numIzq = TipoDato.ConvertirANumero(izq);
            double? numDer = TipoDato.ConvertirANumero(der);

            if (numIzq.HasValue && numDer.HasValue)
                return numIzq.Value == numDer.Value;

            // Caso general
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
            object result;
            
            Console.WriteLine($"DEBUG: Operando de ! es: {valor} de tipo {valor?.GetType().Name ?? "null"}");
            
            if (valor is bool boolValor)
            {
                result = !boolValor;
            }
            else
            { 
                var token = context.Start;
                AgregarError($"Error: Operador '!' requiere un booleano, recibió {TipoDato.ObtenerNombreTipo(valor)}.", 
                    token.Line, 
                    token.Column + 1);
                result = false; 
            }
            
            nodosAST.Add(new NodoAST {
                Tipo = "Negacion",
                Valor = "!",
                Hijos = new List<NodoAST> {
                    new NodoAST { Tipo = "Identificador", Valor = context.expresion().GetText() }
                }
            });
            
            return result;
        }
    }
}