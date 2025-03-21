using System.IO;
using Microsoft.AspNetCore.Mvc;
using Antlr4.Runtime;
using API.compiler;
using System.Collections.Generic;
using Microsoft.Extensions.Logging;
using System.Linq; 
using API.compiler;


[ApiController]
[Route("[controller]")]
public class Compile : ControllerBase
{
    private readonly ILogger<Compile> _logger;

    public Compile(ILogger<Compile> logger)
    {
        _logger = logger;
    }

    public class CompileRequest
    {
        public string? Code { get; set; }
    }

    [HttpPost]
    public IActionResult Post([FromBody] CompileRequest request)
    {
        var errores = new List<CustomError>();
        var erroresLexicos = new List<CustomError>();
        var erroresSintacticos = new List<CustomError>();

        var inputStream = new AntlrInputStream(request.Code);
        
        var lexer = new LanguageLexer(inputStream);
        lexer.RemoveErrorListeners();
        lexer.AddErrorListener(new LexerErrorListener(erroresLexicos));
        var tokenStream = new CommonTokenStream(lexer);

        var parser = new LanguageParser(tokenStream);
        parser.RemoveErrorListeners();
        parser.AddErrorListener(new CustomErrorListener(erroresSintacticos)); 

        var tree = parser.programa(); 
        Console.WriteLine("\n===== ÁRBOL DE SINTAXIS GENERADO =====");
        Console.WriteLine(tree.ToStringTree(parser));
        Console.WriteLine("======================================\n");

        if (tree == null)
        {
            return BadRequest(new { output = "Error al generar el árbol de sintaxis.", errores });
        }

        if (errores.Count > 0)
        {
            return BadRequest(new { output = "Errores encontrados en el código.", errores });
        }

        var visitor = new CompilerVisitor();
        visitor.Visit(tree);

        var todosErrores = erroresLexicos
        .Concat(erroresSintacticos)
        .Concat(visitor.ErroresSemanticos)
        .ToList();


        List<string> outputLines = visitor.ObtenerSalida();
        string salida = outputLines.Count > 0 ? string.Join("\n", outputLines) : "";


        return Ok(new
        {
            output = salida,
            errors = todosErrores.Select(e => new { 
                e.Line, 
                e.Column, 
                message = e.Message, 
                type = e.Type 
            }),
            symbolTable = visitor.ObtenerTablaSimbolos().Select(s => new {
                s.Id,
                s.TipoSimbolo,
                s.TipoDato,
                s.Ambito,
                s.Linea,
                s.Columna,
                s.Valor
            }), 
            ast = tree.ToStringTree(parser)
        });
        }
}
