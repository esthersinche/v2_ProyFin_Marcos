import React from 'react';
import Header from '../components/Header';
import CarouselComponent from '../components/CarouselComponent';
import Footer from '../components/Footer';

export default function MainPage() {
    return (
        <>
            <Header />
            <main className="py-4">
                <CarouselComponent />

                {/* Secciones */}
                <div className="container marketing mt-5">
                    {[
                        {
                            title: <>Explora el Caribe como nunca antes. <span className="text-ocean">Tu paraíso en alta mar.</span></>,
                            text: "Embárcate en una aventura inolvidable con TuCrucerito Corp. y navega por las aguas cristalinas del Caribe. Disfruta de playas paradisíacas, actividades exclusivas y entretenimiento de clase mundial a bordo.",
                            img: "https://www.cruceristas.pe/wp-content/uploads/2023/11/cruceros.jpg",
                            reverse: false
                        }, {
                            title: <>Experiencias a bordo inolvidables. <span className="text-ocean">Lujo y diversión sin límites.</span></>,
                            text: "Desde cenas gourmet hasta espectáculos en vivo, nuestros cruceros están diseñados para ofrecerte el mejor confort y entretenimiento. Vive la experiencia de viajar con estilo, acompañado de un servicio excepcional.",
                            img: "https://www.cruceristas.pe/wp-content/uploads/2023/11/cruceros.jpg",
                            reverse: true
                        }, {
                            title: <>Destinos de ensueño. <span className="text-ocean">Todo empieza con TuCrucerito.</span></>,
                            text: "Descubre las maravillas del Mediterráneo, los paisajes de Alaska o la magia del norte de Europa. Con itinerarios diseñados para cada tipo de viajero, hacemos de cada viaje una historia que contar.",
                            img: "https://www.cruceristas.pe/wp-content/uploads/2023/11/cruceros.jpg",
                            reverse: false
                        }
                    ].map((feat, i) => (
                        <React.Fragment key={i}>
                            <hr className="featurette-divider" />
                            <div className="row featurette">
                                <div className={`col-md-7${feat.reverse ? ' order-md-2' : ''}`}>
                                    <h2 className="featurette-heading">{feat.title}</h2>
                                    <p className="lead">{feat.text}</p>
                                </div>
                                <div className={`col-md-5${feat.reverse ? ' order-md-1' : ''}`}>
                                    <img src={feat.img} className="img-fluid mx-auto" alt="" width="500" height="500" />
                                </div>
                            </div>
                        </React.Fragment>
                    ))}
                    <hr className="featurette-divider" />
                </div>
            </main>

            <Footer />
        </>
    );
}
