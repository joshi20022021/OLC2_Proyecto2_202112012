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

    // solicitud de compilación
    public class CompileRequest
    {
        public string? Code { get; set; }
    }

  [HttpPost]
public IActionResult Post([FromBody] CompileRequest request)
{
    // Errores léxicos, sintácticos y semánticos
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

    // Genera el árbol de sintaxis
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
    var astEstructurado = visitor.ObtenerAST(); // Mantén solo esta declaración
    string arm64Code = visitor.GenerateARM64Code();
    var todosErrores = erroresLexicos
        .Concat(erroresSintacticos)
        .Concat(visitor.ErroresSemanticos)
        .ToList();

    Console.WriteLine("AST generado:");
    foreach (var nodo in astEstructurado)
    {
        Console.WriteLine($"Nodo: {nodo.Tipo}, Valor: {nodo.Valor}, Hijos: {nodo.Hijos.Count}");
        // Imprime también algunos hijos para verificar la estructura
        if (nodo.Hijos.Count > 0)
        {
            Console.WriteLine($"  Primer hijo: {nodo.Hijos[0].Tipo}");
        }
    }

    // Añade verificación antes de devolver
    if (astEstructurado == null || astEstructurado.Count == 0)
    {
        Console.WriteLine("ADVERTENCIA: AST vacío o nulo");
        // Crea un AST mínimo para pruebas
        astEstructurado = new List<NodoAST> { 
            new NodoAST { 
                Tipo = "Root", 
                Hijos = new List<NodoAST> { 
                    new NodoAST { Tipo = "Test" } 
                } 
            } 
        };
    }

    List<string> outputLines = visitor.ObtenerSalida();
    string salida = outputLines.Count > 0 ? string.Join("\n", outputLines) : "";

    // Compila el código y retorna las salidas de errores léxicos, sintácticos y semánticos
    return Ok(new
    {
        output = salida,
        errors = todosErrores.Select(e => new
        {
            e.Line,
            e.Column,
            message = e.Message,
            type = e.Type
        }),
        symbolTable = visitor.ObtenerTablaSimbolos().Select(s => new
        {
            s.Id,
            s.TipoSimbolo,
            s.TipoDato,
            s.Ambito,
            s.Linea,
            s.Columna,
            s.Valor
        }),
        ast = astEstructurado,
        arm64Code = arm64Code
    });
}
}