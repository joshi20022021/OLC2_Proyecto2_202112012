using System;

namespace API.compiler.ARM64
{
    public abstract class ARMInstruction
    {
        public abstract string Generate(int indentLevel = 1);
        
        protected string Indent(int level)
        {
            return new string(' ', level * 4);
        }
    }
    
    public class CommentInstruction : ARMInstruction
    {
        private readonly string _comment;
        
        public CommentInstruction(string comment)
        {
            _comment = comment;
        }
        
        public override string Generate(int indentLevel = 1)
        {
            return $"{Indent(indentLevel)}// {_comment}";
        }
    }
    
    public class LabelInstruction : ARMInstruction
    {
        private readonly string _label;
        
        public LabelInstruction(string label)
        {
            _label = label;
        }
        
        public override string Generate(int indentLevel = 1)
        {
            return $"{_label}:";
        }
    }
    
    public class MoveInstruction : ARMInstruction
    {
        private readonly string _destination;
        private readonly string _source;
        
        public MoveInstruction(string destination, string source)
        {
            _destination = destination;
            _source = source;
        }
        
        public override string Generate(int indentLevel = 1)
        {
            return $"{Indent(indentLevel)}mov {_destination}, {_source}";
        }
    }
    
    public class SystemCallInstruction : ARMInstruction
    {
        public override string Generate(int indentLevel = 1)
        {
            return $"{Indent(indentLevel)}svc #0";
        }
    }
}