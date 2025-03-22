using System.Globalization;

namespace API.compiler
{
    public static class TipoDato
    {
        public static string ObtenerNombreTipo(object valor)
        {
            return valor switch
            {
                null => "nulo",
                long _ => "int",
                double _ => "float64",
                bool _ => "bool",
                string _ => "string",
                char _ => "rune",
                _ => valor.GetType().Name
            };
        }

        public static double? ConvertirADouble(object valor)
        {
            if (valor is int entero)
                return (double)entero;
            if (valor is double flotante)
                return flotante;
            if (valor is string str && double.TryParse(str, NumberStyles.Any, CultureInfo.InvariantCulture, out double resultado))
                return resultado;
            return null;
        }

        public static double? ConvertirANumero(object valor)
        {
            if (valor is int entero)
                return (double)entero;
            if (valor is long enteroLargo)
                return (double)enteroLargo;
            if (valor is double decimalNum)
                return decimalNum;
            if (valor is char rune)
                return (double)rune;
            if (valor is string str && double.TryParse(str, NumberStyles.Any, CultureInfo.InvariantCulture, out double resultado))
                return resultado;
            return null;
        }
        public static bool ValidarTipo(object valor, string tipoEsperado)
        {
            string tipoReal = TipoDato.ObtenerNombreTipo(valor);
            
            // Manejar structs
            if (StructManager.ExisteStruct(tipoEsperado))
            {
                return valor is StructInstance instancia && 
                    instancia.Definicion.Nombre == tipoEsperado;
            }
            
            return tipoReal == tipoEsperado;
        }
         public static bool EsTipoValido(string tipo)
        {
            return tipo switch
            {
                "int" or "float64" or "string" or "bool" => true,
                _ => StructManager.ExisteStruct(tipo)
            };
        }
    }
}