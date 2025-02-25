using Microsoft.AspNetCore.Mvc;

public class HomeController : Controller
{
    public IActionResult Interpreter()
    {
        return View();
    }

    [HttpPost]
    public IActionResult Translate(string inputCode)
    {
        
        string output = $"Traducción del código:\n{inputCode}";

        ViewData["Output"] = output;
        return View("Interpreter");
    }
}
