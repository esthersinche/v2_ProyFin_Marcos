import axios from 'axios';

const API_URL = process.env.REACT_APP_API_URL || 'http://localhost:8083/api';

export const fetchPaquetes = () =>
    axios.get(`${API_URL}/paquetes`).then(res => res.data);