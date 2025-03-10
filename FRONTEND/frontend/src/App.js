import React, { useState } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-icons/font/bootstrap-icons.css';

function App() {
  const [files, setFiles] = useState([{ name: 'Untitled.glt', content: '', saved: false }]);
  const [activeFileIndex, setActiveFileIndex] = useState(0);
  const [consoleOutput, setConsoleOutput] = useState('');
  const [reportErrors, setReportErrors] = useState([]);
  const [symbolTable, setSymbolTable] = useState([]);
  const [ast, setAst] = useState(null);
  const [darkMode, setDarkMode] = useState(false);

  const API_URL = "http://localhost:5089/compile";

  // Funciones para manejo de archivos
  const createNewFile = () => {
    const newFile = {
      name: `Untitled-${files.length + 1}.glt`,
      content: '',
      saved: false
    };
    setFiles([...files, newFile]);
    setActiveFileIndex(files.length);
  };

  const openFile = async (e) => {
    const file = e.target.files[0];
    if (file?.name.endsWith('.glt')) {
      const content = await file.text();
      setFiles([...files, {
        name: file.name,
        content,
        saved: true
      }]);
      setActiveFileIndex(files.length);
    }
  };

  const saveFile = () => {
    const blob = new Blob([files[activeFileIndex].content], { type: 'text/plain' });
    const url = URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = files[activeFileIndex].name;
    a.click();
    URL.revokeObjectURL(url);
  };

  // Función para ejecutar el código
  const handleExecute = async () => {
    try {
      const response = await axios.post(API_URL, { Code: files[activeFileIndex].content });
      
      if (typeof response.data === "object") {
        setConsoleOutput(response.data.output || "Ejecución completada.");
        setReportErrors(response.data.errors || []);
        setSymbolTable(response.data.symbolTable || []);
        setAst(response.data.ast || null);
      } else {
        setConsoleOutput(response.data);
      }
    } catch (error) {
      setConsoleOutput(`Error en la ejecución: ${error.response?.data || error.message}`);
    }
  };

  return (
    <div className={`container-fluid vh-100 d-flex flex-column ${darkMode ? "bg-dark text-light" : ""}`}>
      {/* Barra de herramientas */}
      <div className={`d-flex align-items-center p-2 ${darkMode ? "bg-dark text-light" : "bg-light"} border-bottom`}>
        <div className="d-flex gap-2">
          <button className="btn btn-sm btn-outline-primary" onClick={createNewFile}>
            <i className="bi bi-file-earmark-plus"></i> Nuevo
          </button>
          <label className="btn btn-sm btn-outline-success">
            <i className="bi bi-folder2-open"></i> Abrir
            <input type="file" hidden accept=".glt" onChange={openFile} />
          </label>
          <button className="btn btn-sm btn-outline-warning" onClick={saveFile}>
            <i className="bi bi-save"></i> Guardar
          </button>
          <button className="btn btn-sm btn-outline-danger" onClick={handleExecute}>
            <i className="bi bi-play-circle"></i> Ejecutar
          </button>
          <button 
            className={`btn btn-sm ${darkMode ? "btn-outline-light" : "btn-outline-secondary"}`} 
            onClick={() => setDarkMode(!darkMode)}
          >
            {darkMode ? (<><i className="bi bi-sun"></i> Modo Claro</>) : (<><i className="bi bi-moon"></i> Modo Oscuro</>)}
          </button>
        </div>
      </div>

      {/* Pestañas de archivos */}
      <div className="d-flex border-bottom">
        {files.map((file, index) => (
          <div key={index} 
            className={`d-flex align-items-center px-3 py-2 border-end cursor-pointer ${index === activeFileIndex ? 'bg-primary text-white' : (darkMode ? 'bg-secondary text-white' : 'bg-light text-dark')}`}
            onClick={() => setActiveFileIndex(index)}
          >
            <span className="me-2">{file.name}</span>
            <i className="bi bi-x" onClick={(e) => {
              e.stopPropagation();
              setFiles(files.filter((_, i) => i !== index));
              if (index === activeFileIndex) setActiveFileIndex(Math.max(0, index - 1));
            }}></i>
          </div>
        ))}
      </div>

      {/* Contenido principal */}
      <div className="row flex-grow-1 m-0">
        {/* Editor y Consola */}
        <div className="col-md-8 d-flex flex-column p-0">
          <div className="flex-grow-1 border-end">
            <div className="h-100 position-relative">
              <div className={`position-absolute line-numbers ${darkMode ? "bg-secondary text-white" : "bg-light text-end"} pe-2`}>
                {files[activeFileIndex].content.split('\n').map((_, i) => (
                  <div key={i}>{i + 1}</div>
                ))}
              </div>
              <textarea
                className={`w-100 h-100 ps-5 border-0 ${darkMode ? "bg-dark text-light" : ""}`}
                style={{ fontFamily: 'monospace', outline: 'none', resize: 'none' }}
                value={files[activeFileIndex].content}
                onChange={(e) => {
                  const newFiles = [...files];
                  newFiles[activeFileIndex].content = e.target.value;
                  newFiles[activeFileIndex].saved = false;
                  setFiles(newFiles);
                }}
              />
            </div>
          </div>
          <div className="border-top" style={{ height: '200px' }}>
            <div className={`p-2 ${darkMode ? "bg-secondary text-white" : "bg-light"} border-bottom`}>Consola</div>
            <pre className={`m-0 p-2 ${darkMode ? "bg-dark text-light" : ""}`} style={{ height: 'calc(200px - 38px)', overflowY: 'auto' }}>
              {consoleOutput}
            </pre>
          </div>
        </div>

        {/* Reportes */}
        <div className={`col-md-4 p-0 ${darkMode ? "bg-dark text-light" : "bg-light"}`}>
          <div className="h-100 d-flex flex-column">
            <div className="tab-content flex-grow-1 overflow-auto">
              {/* Reporte de Errores */}
              <div className={`p-3 border-bottom ${darkMode ? "border-light" : ""}`}>
                <h5 className="mb-3">Errores</h5>
                {reportErrors.length > 0 ? (
                  <div className="list-group">
                    {reportErrors.map((error, idx) => (
                      <div key={idx} className="list-group-item list-group-item-danger">
                        {error}
                      </div>
                    ))}
                  </div>
                ) : <span className="text-muted">Sin errores</span>}
              </div>

              {/* Tabla de Símbolos */}
              <div className={`p-3 border-bottom ${darkMode ? "border-light" : ""}`}>
                <h5 className="mb-3">Tabla de Símbolos</h5>
                {symbolTable.length > 0 ? (
                  <div className="list-group">
                    {symbolTable.map((symbol, idx) => (
                      <div key={idx} className={`list-group-item ${darkMode ? "bg-secondary text-white" : ""}`}>
                        <div className="d-flex justify-content-between">
                          <span>{symbol.name}</span>
                          <span className="badge bg-primary">{symbol.type}</span>
                        </div>
                        {symbol.context && <small className="text-muted">{symbol.context}</small>}
                      </div>
                    ))}
                  </div>
                ) : <span className="text-muted">Sin símbolos</span>}
              </div>

              {/* AST */}
              <div className={`p-3 ${darkMode ? "border-light" : ""}`}>
                <h5 className="mb-3">AST</h5>
                {ast ? (
                  <pre className={`p-2 ${darkMode ? "bg-dark text-light" : "bg-white"} rounded border`}>
                    {JSON.stringify(ast, null, 2)}
                  </pre>
                ) : <span className="text-muted">AST no generado</span>}
              </div>
            </div>
          </div>
        </div>
      </div>

      {/* Estado del archivo */}
      <div className="position-fixed bottom-0 end-0 m-3">
        <span className="badge bg-secondary">
          {files[activeFileIndex]?.saved ? 'Guardado' : 'No guardado'}
        </span>
      </div>
    </div>
  );
}

export default App;

// Estilos adicionales
const styles = `
  .line-numbers {
    width: 40px;
    user-select: none;
    color: #666;
    font-family: monospace;
    font-size: 14px;
  }
  
  textarea {
    font-size: 14px;
    line-height: 1.5;
    padding-left: 45px !important;
  }
  
  .cursor-pointer {
    cursor: pointer;
  }
`;

const styleSheet = document.createElement('style');
styleSheet.innerText = styles;
document.head.appendChild(styleSheet);
