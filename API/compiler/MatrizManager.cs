// MatrizManager.cs
using System;
using System.Collections.Generic;

namespace API.compiler
{
    public static class MatrizManager
    {
        // Acceso a elementos en matrices multidimensionales
        public static object GetElementMulti(List<object> matriz, int[] indices, Action<string> manejarError)
        {
            object current = matriz;
            for (int i = 0; i < indices.Length; i++)
            {
                if (current is List<object> slice)
                {
                    int idx = indices[i];
                    if (idx < 0 || idx >= slice.Count)
                    {
                        manejarError($"Índice {idx} fuera de rango en dimensión {i + 1}");
                        return null;
                    }
                    current = slice[idx];
                }
                else
                {
                    manejarError("Intento de acceder a un elemento no-slice");
                    return null;
                }
            }
            return current;
        }

        // Validar estructura de matriz
        public static bool EsMatrizValida(List<object> matriz, int dimensiones)
        {
            // Implementar lógica recursiva para validar dimensiones
            // ...
            return true;
        }
    }
}