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
  const [visibleReport, setVisibleReport] = useState(null);

  const API_URL = "http://localhost:5089/compile";

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

const handleExecute = async () => {
  const codeToSend = files[activeFileIndex].content.trim();

  // 📌 Verificar el código antes de enviarlo
  console.log("Código enviado al backend:\n", codeToSend);

  if (!codeToSend) {
    setConsoleOutput("El código no puede estar vacío.");
    return;
  }

  try {
    const response = await axios.post(API_URL, { Code: codeToSend });

    // 📌 Imprime la respuesta del backend completa
    console.log("Respuesta del backend:", response.data);

    setConsoleOutput(response.data.output || "Ejecución completada.");
    setReportErrors(response.data.errors || []);
    setSymbolTable(response.data.symbolTable || []);
    setAst(response.data.ast || null);
  } catch (error) {
    console.error("Error en la ejecución:", error);

    // 📌 Verificar si hay detalles en la respuesta del backend
    if (error.response) {
      console.log("Respuesta del backend en error:", error.response.data);
      setConsoleOutput(`Error en la ejecución: ${error.response.data.output || error.message}`);
      setReportErrors(error.response.data.errors || []);
    } else {
      setConsoleOutput(`Error en la ejecución: ${error.message}`);
      setReportErrors([error.message]);
    }
  }
};


  const renderReportContent = () => {
    switch (visibleReport) {
      case 'errors':
        return (
          <div className="table-responsive">
            <table className="table table-dark table-hover">
              <thead>
                <tr>
                  <th>Línea</th>
                  <th>Descripción</th>
                  <th>Tipo</th>
                </tr>
              </thead>
              <tbody>
            {reportErrors.map((error, idx) => (
              <tr key={idx}>
                <td>{error.line}</td>
                <td>{error.Message}</td>{/* <-- OJO: "description" no existe en tu backend */}
                <td>{error.type}</td>
              </tr>
            ))}
          </tbody>
            </table>
          </div>
        );
      
      case 'symbols':
        return (
          <div className="table-responsive">
            <table className="table table-dark table-hover">
              <thead>
                <tr>
                  <th>Nombre</th>
                  <th>Tipo</th>
                  <th>Ámbito</th>
                  <th>Valor</th>
                </tr>
              </thead>
              <tbody>
                {symbolTable.map((symbol, idx) => (
                  <tr key={idx}>
                    <td>{symbol.name}</td>
                    <td>{symbol.type}</td>
                    <td>{symbol.context}</td>
                    <td>{symbol.value}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        );
      
      case 'ast':
        return (
          <pre className="p-2 bg-dark text-light rounded border">
            {ast ? JSON.stringify(ast, null, 2) : 'AST no generado'}
          </pre>
        );
      
      default:
        return <div className="text-muted p-3">Selecciona un reporte para visualizarlo</div>;
    }
  };

  return (
    <div className="container-fluid vh-100 d-flex flex-column bg-dark text-light">
      {/* Barra de herramientas */}
      <div className="d-flex align-items-center p-2 bg-dark border-bottom border-secondary">
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
        </div>
      </div>

      {/* Pestañas de archivos */}
      <div className="d-flex border-bottom border-secondary">
        {files.map((file, index) => (
          <div key={index} 
            className={`d-flex align-items-center px-3 py-2 border-end border-secondary cursor-pointer ${index === activeFileIndex ? 'bg-primary text-white' : 'bg-secondary'}`}
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
          <div className="flex-grow-1 border-end border-secondary">
            <div className="h-100 position-relative">
              <div className="position-absolute line-numbers bg-secondary text-white pe-2">
                {files[activeFileIndex].content.split('\n').map((_, i) => (
                  <div key={i}>{i + 1}</div>
                ))}
              </div>
              <textarea
                className="w-100 h-100 ps-5 border-0 bg-dark text-light"
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
          <div className="border-top border-secondary" style={{ height: '200px' }}>
            <div className="p-2 bg-secondary border-bottom border-secondary">Consola</div>
            <pre className="m-0 p-2 bg-dark text-light" style={{ height: 'calc(200px - 38px)', overflowY: 'auto' }}>
              {consoleOutput}
            </pre>
          </div>
        </div>

        {/* Reportes */}
        <div className="col-md-4 p-0 bg-dark">
          <div className="h-100 d-flex flex-column">
            <div className="d-flex justify-content-around p-2 border-bottom border-secondary">
              <button 
                className={`btn btn-sm ${visibleReport === 'errors' ? 'btn-primary' : 'btn-outline-primary'}`}
                onClick={() => setVisibleReport(visibleReport === 'errors' ? null : 'errors')}
              >
                Errores
              </button>
              <button 
                className={`btn btn-sm ${visibleReport === 'symbols' ? 'btn-primary' : 'btn-outline-primary'}`}
                onClick={() => setVisibleReport(visibleReport === 'symbols' ? null : 'symbols')}
              >
                Símbolos
              </button>
              <button 
                className={`btn btn-sm ${visibleReport === 'ast' ? 'btn-primary' : 'btn-outline-primary'}`}
                onClick={() => setVisibleReport(visibleReport === 'ast' ? null : 'ast')}
              >
                AST
              </button>
            </div>
            <div className="flex-grow-1 overflow-auto">
              {renderReportContent()}
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

// Estilos adicionales (igual que antes)
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