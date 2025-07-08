import React, { useState, useEffect } from 'react';
import { fetchBarcos } from '../api/barcoService';

export default function BarcoList() {
    const [barcos, setBarcos] = useState([]);
    const [error, setError] = useState(null);

    useEffect(() => {
        fetchBarcos()
            .then(data => {
                console.log('Datos recibidos del backend:', data);
                setBarcos(data);
            })
            .catch(err => {
                console.error('Error al cargar barcos:', err);
                setError(err);
            });
    }, []);

    if (error) {
        return (
            <div className="alert alert-danger">
                Error cargando barcos: {error.message}
            </div>
        );
    }


    return (
        <main className="py-4 container">
            <h1 className="text-dark text-center">Conoce a nuestra flota</h1>
            <br />
            {barcos.map((barco, i) => (
                <div key={barco.id} className="row featurette align-items-center">
                    {/* Texto */}
                    <div className={
                        `col-md-7 ${i % 2 === 1 ? 'order-md-2 text-start' : 'text-end'}`
                    }>
                        <h3 className="featurette-heading">
                            {barco.nombrebarco}<br />
                            <small className="text-ocean">{barco.barmodel.modeloBarco}</small>
                        </h3>
                        <p className="lead">
                            <strong>Capitán:</strong> {barco.capitanbarco}<br />
                            <strong>Camarotes y Suites:</strong> {barco.totalCabinas} Cabinas<br />
                            <strong>Capacidad:</strong> {barco.capacidadTotal} Pasajeros<br />
                            <strong>Descripción:</strong> {barco.descripcionbarco}
                        </p>
                        <a href="/paquetes" className="btn btn-dark btn-lg mt-3">
                            Ver destinos disponibles
                        </a>
                    </div>
                    {/* Imagen */}
                    <div className={`col-md-5 ${i % 2 === 1 ? 'order-md-1' : ''}`}>
                        <img
                            src={barco.imagenbarco}
                            alt={barco.nombrebarco}
                            className="img-fluid mx-auto d-block rounded shadow-sm"
                            style={{ maxHeight: '350px', objectFit: 'cover' }}
                        />
                    </div>
                    {/* Separador */}
                    {i < barcos.length - 1 && <hr className="featurette-divider" />}
                </div>
            ))}
        </main>
    );
}