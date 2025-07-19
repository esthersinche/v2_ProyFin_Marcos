import axios from 'axios';

const API_URL= process.env.REACT_APP_API_URL || 'http://localhost:8083/api';

export const fetchRutas = () =>
    axios.get(`${API_URL}/rutas`).then(res => res.data);