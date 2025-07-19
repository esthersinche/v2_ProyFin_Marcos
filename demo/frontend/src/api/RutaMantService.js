import axios from "axios";

const API_URL =
  process.env.REACT_APP_API_URL || "http://localhost:8083/api/rutaMant";

export const fetchRutas = async () => {
  const res = await axios.get(`${API_URL}/listar`);
  return res.data;
};

export const fetchRutaById = async (id) => {
  const res = await axios.get(`${API_URL}/buscar/${id}`);
  return res.data;
};

export const saveRuta = async (ruta) => {
  const res = await axios.post(`${API_URL}/save`, ruta);
  return res.data;
};

export const updateRuta = async (id, ruta) => {
  const res = await axios.put(`${API_URL}/editar/${id}`, ruta);
  return res.data;
};

export const deleteRuta = async (id) => {
  await axios.delete(`${API_URL}/delete/${id}`);
};
