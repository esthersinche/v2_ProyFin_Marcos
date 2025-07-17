import React from 'react';
import { Carousel, Button } from 'react-bootstrap';

const slides = [
  {
    img: "https://images.unsplash.com/photo-1507525428034-b723cf961d3e?auto=format&fit=crop&w=1950&q=80",
    title: "Tu aventura comienza aquí.",
    text: "Surca los mares con estilo y comodidad en nuestros exclusivos cruceros por el Caribe.",
    btnText: "Explora destinos",
    btnLink: "/destinos"
  },
  {
    img: "https://images.unsplash.com/photo-1560264280-88b68371db39?auto=format&fit=crop&w=1950&q=80",
    title: "Lujo flotante.",
    text: "Disfruta de experiencias únicas: gastronomía gourmet, piscinas infinitas y espectáculos de primer nivel gracias a nuestra perfectos inteninerarios",
    btnText: "Vive la experiencia",
    btnLink: "/experiencia"
  },
  {
    img: "https://st3.depositphotos.com/2643437/19300/i/450/depositphotos_193006672-stock-photo-family-beach-sunset.jpg",
    title: "Destinos de ensueño.",
    text: "De las costas de Grecia a los glaciares de Alaska, el mundo te espera a bordo de TuCrucerito.",
    btnText: "Reserva ahora",
    btnLink: "/reserva"
  }
];

export default function CarouselComponent() {
  return (
    <Carousel fade>
      {slides.map((slide, idx) => (
        <Carousel.Item key={idx} interval={4000}>
          <img className="d-block w-100" src={slide.img} alt={slide.title} />
          <Carousel.Caption className="bg-dark bg-opacity-75 p-3 rounded">
            <h1>{slide.title}</h1>
            <p>{slide.text}</p>
            <Button size="lg" className="btn-ocean" href={slide.btnLink}>
              {slide.btnText}
            </Button>
          </Carousel.Caption>
        </Carousel.Item>
      ))}
    </Carousel>
  );
}