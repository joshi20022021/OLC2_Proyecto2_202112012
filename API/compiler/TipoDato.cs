using System;
using System.Globalization;
using System.Collections.Generic;
using System.Linq;

namespace API.compiler
{
    public static class TipoDato
    {
        // Obtiene el nombre del tipo de dato de un valor
        public static string ObtenerNombreTipo(object valor)
        {
            if (valor == null) return "void";
            
            return valor switch
            {
                List<object> lista => $"[]{ObtenerNombreTipo(lista.FirstOrDefault())}",
                StructInstance inst => inst.Definicion.Nombre,
                long _ => "int",
                double _ => "float64",
                bool _ => "bool",
                string s when s.Length == 1 => "char",
                string _ => "string",
                _ => valor.GetType().Name
            };
        }
        // Obtiene el tipo de dato de una lista
        private static string ObtenerTipoSlice(List<object> lista)
        {
            if (lista.Count == 0) return "[]indefinido";
            string tipoBase = ObtenerNombreTipo(lista[0]);
            return $"[]{tipoBase}";
        }

        // Convierte un valor a un tipo de dato double
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
        // Convierte un valor a un tipo de dato int
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
        // Convierte un valor a un tipo de dato string
        public static bool ValidarTipo(object valor, string tipoEsperado)
        {
            string tipoReal = ObtenerNombreTipo(valor);
            
            if (StructManager.ExisteStruct(tipoEsperado))
            {
                return valor is StructInstance instancia && 
                    instancia.Definicion.Nombre == tipoEsperado;
            }
            
            return tipoReal == tipoEsperado;
        }
        // Convierte un valor a un tipo de dato string

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