// SliceManager.cs
using System;
using System.Collections.Generic;

namespace API.compiler
{
    public static class SliceManager
    {
        // 1. Función slices.Index
        public static int Index<T>(List<T> slice, T elemento)
        {
            return slice.IndexOf(elemento);
        }

        // 2. Función strings.Join
        public static string Join(List<string> slice, string separador)
        {
            return string.Join(separador, slice);
        }

        // 3. Función append
        public static List<T> Append<T>(List<T> slice, params T[] elementos)
        {
            slice.AddRange(elementos);
            return slice;
        }

        // 4. Acceso a elementos con validación de índices
        public static T GetElement<T>(List<T> slice, int indice, Action<string> manejarError)
        {
            if (indice < 0 || indice >= slice.Count)
            {
                manejarError($"Error: Índice {indice} fuera de rango");
                return default(T);
            }
            return slice[indice];
        }

        // 5. Validar tipo de slice
        public static bool ValidarTipoSlice(object slice, Type tipoElemento)
        {
            if (slice is List<object> lista)
            {
                return lista.All(e => e.GetType() == tipoElemento);
            }
            return false;
        }
    }
}