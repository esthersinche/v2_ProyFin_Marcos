import { BrowserRouter, Navigate, Route, Routes } from 'react-router-dom';
import BarcosPage from './pages/BarcosPage';
import LoginPage from './pages/LoginPage';
import MainPage from './pages/MainPage';
import PaquetesPage from './pages/PaquetesPage';
import RutasPage from './pages/RutasPage';

import ComprarPage from './pages/ComprarPage';
import ElegirBarcoPage from './pages/ElegirBarcoPage';
import ElegirPaquetePage from './pages/ElegirPaquetePage';
import ElegirRutaPage from './pages/ElegirRutaPage';
import MetodosPagoPage from './pages/MetodosPagoPage';
import ResumenPage from './pages/ResumenPage';

import BarcosMantPage from './pages/BarcosMantPage';
import PaqueteMantPage from './pages/PaqueteMantPage';
import RutaMantPage from './pages/RutaMantPage';


function PrivateRoute({ children }) {
  const token = localStorage.getItem('USER'); // o el nombre que uses para guardar tus credenciales/jwt
  return token ? children : <Navigate to="/login" replace />;
}

function App() {
  return (
    <BrowserRouter>
      <Routes>
        {/* Pública */}
        <Route path="/login" element={<LoginPage />} />

        {/* Flujo de reservación */}
        <Route path="/comprar" element={<ComprarPage />} />
        <Route path="/elegir-ruta/:idReserva" element={<ElegirRutaPage />} />
        <Route path="/elegir-barco/:idReserva" element={<ElegirBarcoPage />} />
        <Route path="/elegir-paquete/:idReserva" element={<ElegirPaquetePage />} />
        <Route path="/metodos-pago/:idReserva" element={<MetodosPagoPage />} />
        <Route path="/resumen/:idReserva" element={<ResumenPage />} />

        {/* Otras páginas protegidas */}
        <Route path="/main" element={<MainPage />} />
        <Route path="/barcos" element={<BarcosPage />} />
        <Route path="/paquetes" element={<PaquetesPage />} />
        <Route path="/rutas" element={<RutasPage />} />

        {/* Fallback */}
        <Route path="*" element={<Navigate to="/main" replace />} />
        <Route path="/barcoMant" element={<BarcosMantPage />} />
        <Route path="/paqueteMant" element={<PaqueteMantPage />} />
        <Route path="/rutaMant" element={<RutaMantPage />} />
        {/* <Route path="/paquetes" element={<PaqueteList />} /> */}
      </Routes>
    </BrowserRouter>
  );
}

export default App;
