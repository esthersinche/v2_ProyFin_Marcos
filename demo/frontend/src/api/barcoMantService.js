import axios from "axios";

//url base de donde se llama a api rest
const API_URL= process.env.REACT_APP_API_URL || 'http://localhost:8083/api/barcoMant';

//metodos que se llaman  desde el rest, debido a q la logica de mant se movera
//a react

//para cargar los datos en los inputs
export const fetchBarcos = () =>
    axios.get( `${API_URL}/listarbarcos`).then(res => res.data);

export const fetchModelos = () =>
    axios.get( `${API_URL}/listarmodelos`).then(res => res.data);

export const fetchRutas = () =>
    axios.get( `${API_URL}/listarrutas`).then(res => res.data);

//buscar barco x id
export const fetchBarcoxId = id =>
    axios.get(`${API_URL}/buscar/${id}`).then(res => res.data);

//save barco
export const saveBarco = barco =>
    axios.post(`${API_URL}/save`, barco).then(res => res.data);

//actu barco
export const actuBarco = (id, barco) =>
    axios.put(`${API_URL}/editar/${id}`, barco).then(res => res.data);

//eliminar barco jnfwejf
export const killBarco = id =>
    axios.delete(`${API_URL}/delete/${id}`).then(res => res.data);

