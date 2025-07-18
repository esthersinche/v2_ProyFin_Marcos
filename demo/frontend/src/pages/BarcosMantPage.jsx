import React, { useState, useEffect } from "react";
import AdminHeader from "../components/AdminHeader";
import {
  fetchBarcos,
  fetchModelos,
  fetchRutas,
  fetchBarcoxId,
  actuBarco,
  saveBarco,
  killBarco,
} from "../api/barcoMantService";

export default function BarcosMantPage() {
  const [barco, setBarco] = useState({
    idBarco: "",
    nombreBarco: "",
    capitanBarco: "",
    modeloBarco: "",
    imgURLbarco: "",
    descripcionBarco: "",
    idsrutasbarco: [],
  }); //lista de barcos
  const [modelos, setModelos] = useState([]); //lista de modelos
  const [rutas, setRutas] = useState([]); //lista de rutas
  const [errorMsg, setErrorMsg] = useState(null); //guarda errores

  //cargar los datos
  /*
  useEffect(() => {
    fetchModelos().then(setModelos);
    fetchRutas().then(setRutas);
  }, []);*/
  useEffect(() => {
    /*
    fetchModelos()
      .then((data) => {
        console.log("Modelos recibidos:", data); // 🔍 revisa en consola
        setModelos(data);
      })
      .catch((err) => {
        console.error("Error al obtener modelos", err);
        setModelos([]); // por si acaso
      });*/
    fetchModelos()
      .then((data) => {
        // 1. Extrae sólo los strings de modelo
        const nombres = data.map((m) => m.modeloBarco);
        // 2. Crea un Set para eliminar duplicados
        const únicos = Array.from(new Set(nombres));
        // 3. Reconstruye un array de objetos (si sólo necesitas el string, puedes quedarte con 'únicos')
        const modelosFiltrados = únicos.map((nom) => ({ modeloBarco: nom }));
        setModelos(modelosFiltrados);
      })
      .catch((err) => {
        console.error(err);
        setModelos([]);
      });

    fetchRutas()
      .then((data) => {
        console.log("Rutas recibidas:", data, typeof data);
        setRutas(Array.isArray(data) ? data : []);
      })
      .catch((err) => {
        console.error("Error al obtener rutas", err);
        setRutas([]);
      });
  }, []);

  //inputsfjnuwqefnqlkfnaef
  const handleCambios = (e) => {
    const { name, value } = e.target;
    setBarco((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  //
  const handlelosoptions = (e) => {
    const seleccionado = Array.from(
      e.target.selectedOptions,
      (option) => option.value
    );
    setBarco((prev) => ({
      ...prev,
      idsrutasbarco: seleccionado,
    }));
  };

  //
  const handlebuscar = async (e) => {
    /*
    e.preventDefault();
    if (!barco.idBarco) {
      return;
    }
    fetchBarcoxId(barco.idBarco)
      .then(setBarco)
      .catch(() =>
        setErrorMsg("No se encontro un barco con ID " + barco.idBarco)
      );*/
    e.preventDefault();
    if (!barco.idBarco) return;

    try {
      const data = await fetchBarcoxId(barco.idBarco);
      setBarco({
        idBarco: data.idBarco ?? "",
        nombreBarco: data.nombreBarco ?? "",
        capitanBarco: data.capitanBarco ?? "",
        modeloBarco: data.modeloBarco ?? "",
        imgURLbarco: data.imgURLbarco ?? "",
        descripcionBarco: data.descripcionBarco ?? "",
        idsrutasbarco: Array.isArray(data.idsrutasbarco)
          ? data.idsrutasbarco
          : [],
      });
      setErrorMsg(null);
    } catch {
      setErrorMsg("No se encontró un barco con ID " + barco.idBarco);
    }
  };

  //
  const handlesaveboat = (e) => {
    e.preventDefault();
    saveBarco(barco)
      .then(() => alert("Barco guardado con éxito"))
      .catch(() => setErrorMsg("Faltan datos para creación de Barco."));
  };

  //
  const handleeditarboat = (e) => {
    e.preventDefault();
    actuBarco(barco.idBarco, barco)
      .then(() => alert("Barco editado con éxito."))
      .catch(() => setErrorMsg("Error al editar Barco."));
  };

  //
  const handlekillboat = (e) => {
    e.preventDefault();
    killBarco(barco.idBarco)
      .then(() => {
        alert("Barco eliminado con éxito.");
        setBarco({
          idBarco: "",
          nombreBarco: "",
          capitanBarco: "",
          modeloBarco: "",
          imgURLbarco: "",
          descripcionBarco: "",
          idsrutasbarco: [],
        });
      })
      .catch(() => setErrorMsg("Error al eliminar Barco."));
  };

  return (
    <>
      <AdminHeader />
      <div className="container py-5">
        <h2 className="mb-4">Mantenimiento de Barcos</h2>
        {errorMsg && <div className="alert alert-danger">{errorMsg}</div>}
        <div className="card shadow">
          <div className="card-body">
            <form>
              <div className="row g-3">
                <div className="col-md-3">
                  <label className="form-label">ID Barco</label>
                  <input
                    type="text"
                    className="form-control"
                    name="idBarco"
                    value={barco.idBarco}
                    onChange={handleCambios}
                    placeholder="Código"
                    required
                  />
                  <button className="btn btn-ocean mt-2" onClick={handlebuscar}>
                    Buscar
                  </button>
                </div>

                <div className="col-md-5">
                  <label className="form-label">Nombre</label>
                  <input
                    type="text"
                    className="form-control"
                    name="nombreBarco"
                    value={barco.nombreBarco}
                    onChange={handleCambios}
                    placeholder="Nombre del barco"
                  />
                </div>

                <div className="col-md-4">
                  <label className="form-label">Capitán</label>
                  <input
                    type="text"
                    className="form-control"
                    name="capitanBarco"
                    value={barco.capitanBarco}
                    onChange={handleCambios}
                    placeholder="Nombre del capitán"
                  />
                </div>

                <div className="col-md-6">
                  <label className="form-label">Modelo</label>
                  <select
                    className="form-select"
                    name="modeloBarco"
                    value={barco.modeloBarco}
                    onChange={handleCambios}
                    required
                  >
                    <option value="">Seleccione un modelo</option>
                    {modelos.map((m) => (
                      <option key={m.modeloBarco} value={m.modeloBarco}>
                        {m.modeloBarco}
                      </option>
                    ))}
                  </select>
                </div>

                <div className="col-md-6">
                  <label className="form-label">Imagen URL</label>
                  <input
                    type="text"
                    className="form-control"
                    name="imgURLbarco"
                    value={barco.imgURLbarco}
                    onChange={handleCambios}
                    placeholder="Imagen URL del barco"
                  />
                </div>

                <div className="col-md-9">
                  <label className="form-label">Descripción</label>
                  <input
                    type="text"
                    className="form-control"
                    name="descripcionBarco"
                    value={barco.descripcionBarco}
                    onChange={handleCambios}
                    placeholder="Descripción pequeña del Barco."
                  />
                </div>

                <div className="col-12">
                  <label className="form-label">Rutas Asignadas</label>
                  <select
                    className="form-select"
                    name="idsrutasbarco"
                    value={barco.idsrutasbarco}
                    onChange={handlelosoptions}
                    multiple
                    size="5"
                  >
                    {Array.isArray(rutas) &&
                      rutas.map((r) => (
                        <option key={r.idruta} value={r.idruta}>
                          {r.nombreruta}
                        </option>
                      ))}
                  </select>
                  <small className="form-text text-muted">
                    Mantén Ctrl (o Cmd) para seleccionar múltiples rutas.
                  </small>
                </div>
              </div>

              <div className="mt-4 d-flex justify-content-between">
                <div>
                  <button
                    type="button"
                    className="btn btn-warning me-2"
                    onClick={handleeditarboat}
                  >
                    Editar
                  </button>
                  <button
                    type="button"
                    className="btn btn-danger"
                    onClick={handlekillboat}
                  >
                    Eliminar
                  </button>
                </div>
                <button
                  type="button"
                  className="btn btn-apple"
                  onClick={handlesaveboat}
                >
                  Guardar
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </>
  );
}
