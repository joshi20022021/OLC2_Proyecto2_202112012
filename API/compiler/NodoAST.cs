namespace API.compiler
{
    public class NodoAST
    {
        public string Tipo { get; set; } = "Desconocido";
        public string? Valor { get; set; }
        public List<NodoAST> Hijos { get; set; } = new List<NodoAST>();
    }
}