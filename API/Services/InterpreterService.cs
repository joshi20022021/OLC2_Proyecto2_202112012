using Antlr4.Runtime;
using API.compiler;                   // <-- Importa el visitor

namespace API.Services

{
    public class InterpreterService
    {
        public string Interpret(string inputCode)
{
    try
    {
        var inputStream = new AntlrInputStream(inputCode);
        var lexer = new LanguageLexer(inputStream);
        var tokenStream = new CommonTokenStream(lexer);
        var parser = new LanguageParser(tokenStream);

        var tree = parser.program(); // Asegurar que se usa la regla "program"

        var visitor = new CompilerVisitor();
        object result = visitor.Visit(tree);

        return $"Resultado:\n{result}";
    }
    catch (Exception ex)
    {
        return $"Error: {ex.Message}";
    }
}

    }
}
