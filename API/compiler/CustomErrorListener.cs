using System.Collections.Generic;
using System.IO; // ✅ Importar TextWriter
using Antlr4.Runtime;

public class CustomErrorListener : IAntlrErrorListener<IToken>
{
    private readonly List<string> errors;

    public CustomErrorListener(List<string> errors)
    {
        this.errors = errors;
    }

    // ✅ Corrige la firma del método para incluir TextWriter
    public void SyntaxError(TextWriter output, IRecognizer recognizer, IToken offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
    {
        errors.Add($"Error en línea {line}, posición {charPositionInLine}: {msg}");
    }
}
