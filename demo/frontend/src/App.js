import React from 'react';
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import MainPage from './pages/MainPage';
import BarcosPage from './pages/BarcosPage';
import PaquetesPage from './pages/PaquetesPage';
import RutasPage from './pages/RutasPage';
import LoginPage from './pages/LoginPage';

function PrivateRoute({ children }) {
  const token = localStorage.getItem('user'); // o el nombre que uses para guardar tus credenciales/jwt
  return token ? children : <Navigate to="/login" replace />;
}

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/login" element={<LoginPage  />} />
        <Route path="/main" element={<MainPage />} />
        <Route path="/barcos" element={<BarcosPage />} />
        <Route path="/paquetes" element={<PaquetesPage />} />
        <Route path="/rutas" element={<RutasPage />} />
        <Route path="*" element={<Navigate to="/main" replace />} />
        {/* <Route path="/paquetes" element={<PaqueteList />} /> */}
      </Routes>
    </BrowserRouter>
  );
}

export default App;
