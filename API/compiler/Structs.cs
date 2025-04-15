namespace API.compiler
{
    //Definición del struct
    public class StructDefinition
    {
        public string Nombre { get; set; } = "";
        public Dictionary<string, string> Atributos { get; } = new Dictionary<string, string>();
    }

    //Instancia de un struct
    public class StructInstance
    {
        public StructDefinition Definicion { get; set; }
        public Dictionary<string, object> Valores { get; set; } = new Dictionary<string, object>();
    }
    //Gestor centralizado de structs 
    public static class StructManager
    {
        private static readonly Dictionary<string, StructDefinition> _structs = new();

        public static void RegistrarStruct(StructDefinition structDef) 
            => _structs[structDef.Nombre] = structDef;

        public static bool ExisteStruct(string nombre) 
            => _structs.ContainsKey(nombre);

        public static StructDefinition? ObtenerStruct(string nombre) 
            => _structs.TryGetValue(nombre, out var s) ? s : null;
    }
    //Definición de un método de un struct
    public class MetodoStruct
    {
        public string Nombre { get; set; }
        public List<Tuple<string, string>> Parametros { get; set; } = new();
        public LanguageParser.BloqueContext Bloque { get; set; }
    }
} 