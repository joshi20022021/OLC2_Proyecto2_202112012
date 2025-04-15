using System.Collections.Generic;
using System.IO; 
using Antlr4.Runtime;
using API.compiler; 
// Clase que representa un error personalizado
public class CustomError
{
    public int Line { get; set; }
    public int Column { get; set; }
    public required string Message { get; set; } 
    public required string Type { get; set; }
}   
// Clase que implementa la interfaz para manejar errores léxicos
public class LexerErrorListener : IAntlrErrorListener<int>
{
    private readonly List<CustomError> _errores;

    public LexerErrorListener(List<CustomError> errores)
    {
        _errores = errores;
    }

    public void SyntaxError(TextWriter output, IRecognizer recognizer, int offendingSymbol, 
        int line, int charPositionInLine, string msg, RecognitionException e)
    {
        _errores.Add(new CustomError
        {
            Line = line,
            Column = charPositionInLine,
            Message = msg,
            Type = "Léxico"
        });
    }
}
// Clase que implementa la interfaz para manejar errores sintácticos

public class CustomErrorListener : IAntlrErrorListener<IToken>
{
    private readonly List<CustomError> _errores;

    public CustomErrorListener(List<CustomError> errores)
    {
        _errores = errores;
    }

    public void SyntaxError(TextWriter output, IRecognizer recognizer, IToken offendingSymbol, 
        int line, int charPositionInLine, string msg, RecognitionException e)
    {
        _errores.Add(new CustomError
        {
            Line = line,
            Column = charPositionInLine,
            Message = msg,
            Type = "Sintáctico"
        });
    }
}