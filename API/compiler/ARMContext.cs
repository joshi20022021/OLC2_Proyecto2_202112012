using System;
using System.Collections.Generic;
using System.Linq;

namespace API.compiler.ARM64
{
    public class ARM64Context
    {
        // Registros de propósito general (x0-x30)
        private readonly List<string> _generalRegisters;
        private readonly List<string> _usedRegisters;

        // Contador de etiquetas para saltos
        private int _labelCounter = 0;

        // Tabla de variables en memoria
        private Dictionary<string, MemoryLocation> _variableLocations;

        // Desplazamiento actual en la pila (stack)
        private int _stackOffset = 0;

        public ARM64Context()
        {
            // Inicializar registros
            _generalRegisters = new List<string>();
            for (int i = 9; i <= 15; i++) // Registros x9-x15 son temporales
            {
                _generalRegisters.Add($"x{i}");
            }
            
            _usedRegisters = new List<string>();
            _variableLocations = new Dictionary<string, MemoryLocation>();
        }

        public string GetNextRegister()
        {
            // Obtiene el siguiente registro disponible
            if (_generalRegisters.Count == 0)
            {
                throw new Exception("No hay registros disponibles");
            }
            
            var register = _generalRegisters[0];
            _generalRegisters.RemoveAt(0);
            _usedRegisters.Add(register);
            
            return register;
        }

        public void ReleaseRegister(string register)
        {
            // Libera un registro para su reutilización
            if (_usedRegisters.Contains(register))
            {
                _usedRegisters.Remove(register);
                _generalRegisters.Add(register);
            }
        }

        public string GenerateUniqueLabel(string prefix)
        {
            // Genera una etiqueta única para saltos
            _labelCounter++;
            return $"{prefix}_{_labelCounter}";
        }

        public class MemoryLocation
        {
            public string LocationType { get; set; } // "register" o "memory"
            public string Register { get; set; }
            public int StackOffset { get; set; }
        }

        public MemoryLocation AllocateVariable(string variableName, int size)
        {
            // Asignar espacio en la pila para la variable
            _stackOffset += size;
            
            var location = new MemoryLocation
            {
                LocationType = "memory",
                StackOffset = _stackOffset
            };
            
            _variableLocations[variableName] = location;
            return location;
        }

        public MemoryLocation GetVariableLocation(string variableName)
        {
            if (_variableLocations.TryGetValue(variableName, out var location))
            {
                return location;
            }
            
            return null;
        }
    }
}