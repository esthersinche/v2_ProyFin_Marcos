import axios from "axios";

//url base de donde se llama a api rest
const API_URL= process.env.REACT_APP_API_URL || 'http://localhost:8083/api/paqueteMant';

//metodos que se llaman  desde el rest, debido a q la logica de mant se movera
//a react

