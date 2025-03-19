using System.Collections.Generic;
using System.IO; 
using Antlr4.Runtime;

public class CustomError
{
    public int Line { get; set; }
    public int Column { get; set; }
    public required string Message { get; set; } 
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