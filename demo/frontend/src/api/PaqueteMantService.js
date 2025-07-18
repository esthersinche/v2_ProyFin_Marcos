import axios from "axios";

//url base de donde se llama a api rest
const API_URL= process.env.REACT_APP_API_URL || 'http://localhost:8083/api/paqueteMant';

//metodos que se llaman  desde el rest, debido a q la logica de mant se movera
//a react

export const fetchBeneficios = async () => {
  const response = await axios.get('/api/beneficio/listar');
  return response.data; // asume arreglo de beneficios
};

export const fetchPaqueteById = async (id) => {
  const response = await axios.get(`${API_URL}/buscar/${id}`);
  return response.data;
};

export const savePaquete = async (paquete) => {
  const response = await axios.post(`${API_URL}/save, paquete`);
  return response.data;
};

export const editPaquete = async (id, paquete) => {
  const response = await axios.put(`${API_URL}/editar/${id}`, paquete);
  return response.data;
};

export const deletePaquete = async (id) => {
  return axios.delete(`${API_URL}/delete/${id}`);
};