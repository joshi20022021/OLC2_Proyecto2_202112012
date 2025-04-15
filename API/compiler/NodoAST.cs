using System.Text;

namespace API.compiler
{
    // Nodo del árbol de sintaxis abstracta    
    public class NodoAST
    {
        public string Tipo { get; set; } = "Desconocido";
        public string? Valor { get; set; }
        public List<NodoAST> Hijos { get; set; } = new List<NodoAST>();
    }

    public class ASTGraphGenerator
    {
    private int _contador = 0;
    private StringBuilder _dot = new StringBuilder();

    public string GenerarDOT(NodoAST raiz)
    {
        _contador = 0;
        _dot.Clear();
        _dot.AppendLine("digraph AST {");
        _dot.AppendLine("  node [shape=box, fontname=\"Arial\"];");
        RecorrerNodo(raiz, null);
        _dot.AppendLine("}");
        return _dot.ToString();
    }

    private void RecorrerNodo(NodoAST nodo, int? idPadre)
    {
        int idActual = _contador++;
        // Escapar las comillas en el valor si es necesario
        string label = $"{nodo.Tipo}" + (nodo.Valor != null ? $"\\n{nodo.Valor}" : "");
        _dot.AppendLine($"  node{idActual} [label=\"{label}\"];");
        
        if (idPadre.HasValue)
        {
            _dot.AppendLine($"  node{idPadre.Value} -> node{idActual};");
        }
        
        foreach (var hijo in nodo.Hijos)
        {
            RecorrerNodo(hijo, idActual);
        }
    }
}

}