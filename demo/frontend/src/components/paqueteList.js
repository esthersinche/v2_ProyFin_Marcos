import React, { useState, useEffect } from "react";
import { fetchPaquetes } from "../api/paqueteService";

export default function PaqueteList() {
  const [paquetes, setPaquetes] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetchPaquetes()
      .then((data) => {
        console.log('Datos recibidos del backend:', data);
        setPaquetes(data);

      })
      .catch((err) => {
        console.error('Error al cargar los paquetes', err);
        setError(err);
      });

  }, []);

  if (error) {
    return(
        <div className="alert alert-danger">
            Error cargando los paquetes : {error.message}
        </div>
    ); 
  }

  return (
    <main className="py-4">
            {/* Carrusel */}
            <div id="myCarousel" className="carousel slide" data-bs-ride="carousel">
                <div className="carousel-indicators">
                    {[0, 1, 2].map((i) => (
                        <button
                            key={i}
                            type="button"
                            data-bs-target="#myCarousel"
                            data-bs-slide-to={i}
                            className={i === 0 ? 'active' : ''}
                            aria-label={`Slide${i + 1}`}
                        />
                    ))}
                </div>
                <div className="carousel-inner">
                    <div className="carousel-item active">
                        <img
                            src="https://images.unsplash.com/photo-1507525428034-b723cf961d3e?auto=format&fit=crop&w=1950&q=80"
                            className="d-block w-100"
                            alt="Crucero al atardecer"
                        />
                        <div className="container">
                            <div className="carousel-caption bg-dark bg-opacity-75">
                                <h1>Tu aventura comienza aquí.</h1>
                                <p>Surca los mares con estilo y comodidad en nuestros exclusivos cruceros por el Caribe.</p>
                                <p><a className="btn btn-lg btn-ocean" href="#">Explora destinos</a></p>
                            </div>
                        </div>
                    </div>
                    <div className="carousel-item">
                        <img
                            src="https://images.unsplash.com/photo-1560264280-88b68371db39?auto=format&fit=crop&w=1950&q=80"
                            className="d-block w-100"
                            alt="Entretenimiento a bordo"
                        />
                        <div className="container">
                            <div className="carousel-caption bg-dark bg-opacity-75">
                                <h1>Lujo Flotante.</h1>
                                <p>Disfruta de experiencias únicas: gastronomía gourmet, piscinas infinitas y espectáculos de primer nivel.</p>
                                <p><a className="btn btn-lg btn-ocean" href="#">Vive la Experiencia</a></p>
                            </div>
                        </div>
                    </div>
                    <div className="carousel-item">
                        <img
                            src="https://st3.depositphotos.com/2643437/19300/i/450/depositphotos_193006672-stock-photo-family-beach-sunset.jpg"
                            className="d-block w-100"
                            alt="Destinos"
                        />
                        <div className="container">
                            <div className="carousel-caption bg-dark bg-opacity-75">
                                <h1>Destinos de Ensueño</h1>
                                <p>De las costas de Grecia a los glaciares de Alaska, el mundo te espera a bordo de TuCrucerito.</p>
                                <p><a className="btn btn-lg btn-ocean" href="#">Reserva ahora</a></p>
                            </div>
                        </div>
                    </div>
                </div>
                <button className="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
                    <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span className="visually-hidden">Anterior</span>
                </button>
                <button className="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
                    <span className="carousel-control-next-icon" aria-hidden="true"></span>
                    <span className="visually-hidden">Siguiente</span>
                </button>
            </div>

            {/* Tarjetas de Paquetes */}
            <div className="container px-4 py-3 rounded-2" id="paquetescards">
                <h2 className="pb-2 border-bottom">Nuestros Paquetes</h2>
                <div className="row row-cols-1 row-cols-lg-3 g-4 py-5">
                    {paquetes.map((paq, i) => (
                        <div className="col" key={i}>
                            <div className="card h-100 text-light bg-ocean rounded-4 shadow-lg">
                                <div className="card-body d-flex flex-column justify-content-between">
                                    <div>
                                        <h3 className="display-6 fw-bold fs-3">{paq.nomPaquete}</h3>
                                        <p>{paq.descPaquete}</p>
                                    </div>
                                    <ul className="list-unstyled d-flex mb-3">
                                        <li>
                                            <i className="bi bi-cash-stack"></i>
                                            <small className="ms-2">{paq.precPaqueteUni}</small>
                                        </li>
                                    </ul>
                                    <div>
                                        <strong>Beneficios:</strong>
                                        <ul>
                                            {paq.beneficios.map((b, j) => (
                                                <li key={j}>{b.beneficio.nombreBene}</li>
                                            ))}
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    ))}
                </div>
            </div>
        </main>
    
  );










}
