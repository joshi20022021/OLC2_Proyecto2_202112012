public static class SliceHelper
{
    //acceso a un slice
    public static object AccesoSlice(List<object> slice, long index)
    {
        if (index < 0 || index >= slice.Count)
            throw new IndexOutOfRangeException($"Índice fuera de rango: {index}");
        return slice[(int)index];
    }
    public static List<object> Append(List<object> slice, object nuevo)
    {
        var nuevaLista = new List<object>(slice) { nuevo };
        return nuevaLista;
    }
    public static int Len(List<object> slice) => slice.Count;

    public static int Index(List<object> slice, object valor)
    {
        for (int i = 0; i < slice.Count; i++)
            if (Equals(slice[i], valor)) return i;
        return -1;
    }

    //unir un elemento
    public static string Join(List<object> slice, string separador)
    {
        if (!slice.All(e => e is string))
            throw new InvalidOperationException("Todos los elementos deben ser strings.");
        return string.Join(separador, slice.Cast<string>());
    }
    //Accesos de slice 2 dimensiones
    public static object AccesoSlice2D(List<object> matriz, long fila, long columna)
    {
        if (fila < 0 || fila >= matriz.Count)
            throw new Exception($"Índice de fila fuera de rango: {fila}");

        if (matriz[(int)fila] is List<object> sublista)
        {
            if (columna < 0 || columna >= sublista.Count)
                throw new Exception($"Índice de columna fuera de rango: {columna}");

            return sublista[(int)columna];
        }

        throw new Exception("La fila especificada no es un slice.");
    }

    //Modificar un slice 2D
    public static void ModificarSlice2D(List<object> matriz, long fila, long columna, object nuevoValor)
    {
        if (fila < 0 || columna < 0)
            throw new Exception("Los índices no pueden ser negativos.");

        if (fila >= matriz.Count)
            throw new Exception($"Índice de fila fuera de rango: {fila}");

        if (matriz[(int)fila] is List<object> filaInterna)
        {
            if (columna >= filaInterna.Count)
                throw new Exception($"Índice de columna fuera de rango: {columna}");
            filaInterna[(int)columna] = nuevoValor;
        }
        else
        {
            throw new Exception("La fila especificada no es un slice.");
        }
    }
}