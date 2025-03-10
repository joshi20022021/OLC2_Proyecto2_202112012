using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Threading.Tasks;
using Antlr4.Runtime;
using API.compiler;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;

namespace API.Controllers
{
    [Route("[controller]")]
    public class Compile : Controller
    {
        private readonly ILogger<Compile> _logger;

        public Compile(ILogger<Compile> logger)
        {
            _logger = logger;
        }

        public class CompileRequest
        {
            [Required]
            public required string Code { get; set; }
        }

        [HttpPost]
        public async Task<IActionResult> Post([FromBody] CompileRequest request)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            _logger.LogInformation("Compiling code: {0}", request.Code);

            var inputStream = new AntlrInputStream(request.Code);
            var lexer = new LanguageLexer(inputStream);
            var tokenStream = new CommonTokenStream(lexer);
            var parser = new LanguageParser(tokenStream);

            // Capturar errores
            var errors = new List<string>();
            parser.RemoveErrorListeners();
            parser.AddErrorListener(new CustomErrorListener(errors));

            // Analizar el código
            var tree = parser.program();

            var visitor = new CompilerVisitor();
            object result = visitor.Visit(tree);

            // Verificar si hay errores y registrar en consola
            if (errors.Count > 0)
            {
                _logger.LogWarning("Se encontraron errores durante la compilación:");
                foreach (var error in errors)
                {
                    _logger.LogWarning(error);
                }
            }

            // Obtener la tabla de símbolos del visitor
            var symbolTable = visitor.GetSymbolTable();

            // Opcional: Si tienes una forma de generar el AST real, reemplázalo aquí
            var ast = new { type = "Program", children = new List<object>() };

            return Ok(new
            {
                output = errors.Count > 0 ? "Errores encontrados en el código." : result?.ToString() ?? "Ejecución completada.",
                errors = errors,
                symbolTable = symbolTable,
                ast = ast
            });
        }
    }
}
