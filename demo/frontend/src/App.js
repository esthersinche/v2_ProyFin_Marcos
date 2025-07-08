import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import BarcoList from './components/barcoList';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<BarcoList />} />
        {/* <Route path="/paquetes" element={<PaqueteList />} /> */}
      </Routes>
    </BrowserRouter>
  );
}

export default App;
