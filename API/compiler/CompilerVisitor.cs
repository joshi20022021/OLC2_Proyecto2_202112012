using System;
using System.Collections.Generic;
using Antlr4.Runtime.Misc;
using API.compiler;  
namespace API.compiler
{
    public class CompilerVisitor : LanguageBaseVisitor<object>
    {
        private readonly Dictionary<string, object> symbolTable = new Dictionary<string, object>();
        //operacion suma    
        public override object VisitAdd(LanguageParser.AddContext context)
        {
            object left = Visit(context.expr(0));
            object right = Visit(context.expr(1));

            // 🔥 Si alguno de los operandos es una cadena, concatenar en lugar de sumar
            if (left is string || right is string)
            {
                return left.ToString() + right.ToString();
            }

            // ✅ Si ambos son números, hacer suma normal
            if (left is double leftNum && right is double rightNum)
            {
                return leftNum + rightNum;
            }

            throw new Exception($"Error: No se puede sumar {left} y {right}");
        }

        //operacion resta   
        public override object VisitSubtract(LanguageParser.SubtractContext context)
        {
            object left = Visit(context.expr(0));
            object right = Visit(context.expr(1));

            if (left is double leftNum && right is double rightNum)
            {
                return leftNum - rightNum;
            }
            throw new Exception($"Error: No se puede restar {left} y {right}");
        }
        //operacion multiplicacion
        public override object VisitMultiply(LanguageParser.MultiplyContext context)
        {
            object left = Visit(context.expr(0));
            object right = Visit(context.expr(1));
            if (left is double leftNum && right is double rightNum)
            {
                return leftNum * rightNum;
            }
            throw new Exception($"Error: No se puede multiplicar {left} y {right}");
        }
        //operacion division
        public override object VisitDivide(LanguageParser.DivideContext context)
        {
            object left = Visit(context.expr(0));
            object right = Visit(context.expr(1));
            if (left is double leftNum && right is double rightNum)
            {
                return leftNum / rightNum;
            }
            throw new Exception($"Error: No se puede dividir {left} y {right}");
        }
        //operacion modulo
        public override object VisitModulus(LanguageParser.ModulusContext context)
        {
            object left = Visit(context.expr(0));
            object right = Visit(context.expr(1));
            if (left is double leftNum && right is double rightNum)
            {
                return leftNum % rightNum;
            }
            throw new Exception($"Error: No se puede hacer modulo de {left} y {right}");
        }
        //parentesis
        public override object VisitParentheses(LanguageParser.ParenthesesContext context)
        {
            return Visit(context.expr());
        }
        //entero
        public override object VisitIntegerLiteral(LanguageParser.IntegerLiteralContext context)
        {
            return double.Parse(context.INT_LIT().GetText());
        }
        //flotante
        public override object VisitFloatLiteral(LanguageParser.FloatLiteralContext context)
        {
            return double.Parse(context.FLOAT_LIT().GetText());
        }
        //variable
        public override object VisitIdentifier(LanguageParser.IdentifierContext context)
        {
            string id = context.ID().GetText();
            return symbolTable.ContainsKey(id) ? symbolTable[id] : "nil"; // 🔥 Evita errores
        }


        //asignacion
        public override object VisitAssignmentStatement(LanguageParser.AssignmentStatementContext context)
        {
            var assignCtx = context.assignmentStmt() as LanguageParser.AssignmentContext;
            if (assignCtx == null)
                throw new Exception("Error: assignmentStmt() no se pudo convertir a AssignmentContext.");

            string id = assignCtx.ID().GetText();
            object value = Visit(assignCtx.expr()) ?? "nil"; // 🔥 Si es nulo, guarda "nil"

            symbolTable[id] = value; // ✅ Ahora `symbolTable` acepta cualquier tipo de dato

            return value;
        }


        //imprimir
        public override object VisitPrintStatement(LanguageParser.PrintStatementContext context)
        {
            var printCtx = context.printStmt() as LanguageParser.PrintContext;
            if (printCtx == null)
                throw new Exception("Error: printStmt() no se pudo convertir a PrintContext.");

            object value = Visit(printCtx.expr()) ?? "nil"; // 🔥 Si es null, asigna "nil"

            Console.WriteLine("Output: " + value); // ✅ Asegura una única impresión
            return null; // 🔥 No lo devuelve a `VisitProgramRule`, solo lo imprime
        }

        //expresion
        public override object VisitExpressionStatement(LanguageParser.ExpressionStatementContext context)
        {
            return Visit(context.expr());
        }
        //cadena
        public override object VisitStringLiteral(LanguageParser.StringLiteralContext context)
        {
            return context.STRING_LIT().GetText().Trim('"'); // 🔥 Remueve solo comillas dobles
        }
        //programa
public override object VisitProgramRule(LanguageParser.ProgramRuleContext context)
{
    HashSet<object> uniqueResults = new HashSet<object>(); // 🔥 Usamos un HashSet para evitar duplicados

    foreach (var stmt in context.statement())
    {
        var result = Visit(stmt);
        if (result != null && uniqueResults.Add(result))  // 🔥 Solo agregamos si no está en el conjunto
        {
            Console.WriteLine("DEBUG Output: " + result); // 👀 Verifica qué valores se están procesando
        }
    }

    return string.Join("\n", uniqueResults); // ✅ Devuelve valores sin duplicados
}

public List<object> GetSymbolTable()
{
    var symbols = new List<object>();
    foreach (var entry in symbolTable)
    {
        // Aquí definimos 'name' y 'type'. Ajusta 'type' según tus necesidades.
        symbols.Add(new { name = entry.Key, type = entry.Value?.GetType().Name ?? "undefined", value = entry.Value });
    }
    return symbols;

    }
}
}
