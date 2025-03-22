namespace API.compiler
{
    public class EntradaSimbolo
    {
        public int Id { get; set; }
        public string TipoSimbolo { get; set; } = "Variable";
        public string Nombre { get; set; } = string.Empty;
        public string TipoDato { get; set; } = "indefinido";
        public object Valor { get; set; } = "nulo";
        public string Ambito { get; set; } = "Global";
        public int Linea { get; set; }
        public int Columna { get; set; }
        public List<object> Lista { get; set; } = new List<object>();

        private static int _contadorId = 1;
        public EntradaSimbolo() => Id = _contadorId++;
    }
}