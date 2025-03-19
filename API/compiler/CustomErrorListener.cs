using System.Collections.Generic;
using System.IO; // ✅ Importar TextWriter
using Antlr4.Runtime;

// En CustomErrorListener.cs modifica
public class CustomError
{
    public int Line { get; set; }
    public int Column { get; set; }
    public required string Message { get; set; } // Usar "required" en .NET 7+
    public required string Type { get; set; }
}   
public class CustomErrorListener : IAntlrErrorListener<IToken>
{
    private readonly List<CustomError> errors;

    public CustomErrorListener(List<CustomError> errorList)
    {
        this.errors = errorList;
    }

    public void SyntaxError(TextWriter output, IRecognizer recognizer, IToken offendingSymbol,
        int line, int charPositionInLine, string msg, RecognitionException e)
    {
        errors.Add(new CustomError
        {
            Line = line,
            Column = charPositionInLine,
            Message = msg,
            Type = "Sintáctico"
        });
    }
}