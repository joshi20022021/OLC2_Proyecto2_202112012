using API.Services;
using Microsoft.AspNetCore.Mvc;

// Controlador de la página principal
public class HomeController : Controller
{
    private readonly InterpreterService _interpreterService;

    public HomeController(InterpreterService interpreterService)
    {
        _interpreterService = interpreterService;
    }

    public IActionResult Interpreter()
    {
        return View();
    }

    [HttpPost]
    // Método para traducir el código
    public IActionResult Translate(string inputCode)
    {
        if (string.IsNullOrEmpty(inputCode))
        {
            ViewData["Output"] = "No se ingresó código.";
            return View("Interpreter");
        }

        // Interpretar el código
        string output = _interpreterService.Interpret(inputCode);

        ViewData["Output"] = output;
        return View("Interpreter");
    }
}
