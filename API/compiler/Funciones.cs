using System;
using System.Collections.Generic;
using Antlr4.Runtime;

namespace API.compiler
{
    // representa una función
    public class Funcion
    {
        public string Nombre { get; set; }
        public List<Tuple<string, string>> Parametros { get; set; } = new List<Tuple<string, string>>();
        public string TipoRetorno { get; set; } = "void"; // Se usa "void" si no hay retorno
        public ParserRuleContext Bloque { get; set; }
    }
}
