using System.IO;
using Microsoft.AspNetCore.Mvc;
using Antlr4.Runtime;
using API.compiler;
using System.Collections.Generic;
using Microsoft.Extensions.Logging;
using System.Linq; // Agregar para usar Select()

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
        public string Code { get; set; }
    }

    [HttpPost]
    public IActionResult Post([FromBody] CompileRequest request)
    {
        var errores = new List<CustomError>();

        var inputStream = new AntlrInputStream(request.Code);
        var lexer = new LanguageLexer(inputStream);
        var tokenStream = new CommonTokenStream(lexer);
        var parser = new LanguageParser(tokenStream);

        parser.RemoveErrorListeners();
        parser.AddErrorListener(new CustomErrorListener(errores));

        var tree = parser.programa(); // 🔹 CAMBIO AQUÍ: `programa()` en lugar de `program()`

        // 📌 Depuración extra: Imprimir el árbol de sintaxis
        Console.WriteLine("\n===== ÁRBOL DE SINTAXIS GENERADO =====");
        Console.WriteLine(tree.ToStringTree(parser));
        Console.WriteLine("======================================\n");

        if (tree == null)
        {
            return BadRequest(new { output = "Error al generar el árbol de sintaxis.", errores });
        }

        var visitor = new CompilerVisitor();
        object result = visitor.Visit(tree);

        // 📌 Capturar la salida generada por print()
        string salida = string.Join("\n", visitor.ObtenerSalida()); // 🔹 CAMBIO AQUÍ: `ObtenerSalida()`

        return Ok(new
        {
            output = salida,  
            errors = errores.Select(e => new { e.Line, e.Column, e.Message, e.Type }),
            symbolTable = visitor.ObtenerTablaSimbolos(), // 🔹 CAMBIO AQUÍ: `ObtenerTablaSimbolos()`
            ast = tree.ToStringTree(parser)
        });
    }
}
