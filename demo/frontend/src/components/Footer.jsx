import React from 'react';
export default function Footer() {
  return (
    <footer className="row row-cols-5 py-5 mt-5 p-2 border-top bg-header text-white">
      <div className="col">
        <a href="/main" className="d-flex align-items-center mb-3 text-white text-decoration-none">
          <p className="mb-0">©{new Date().getFullYear()} TuCrucerito Corp.</p>
        </a>
      </div>
      <div className="col"></div>
      <div className="col">
        <h5>Info</h5>
        <ul className="nav flex-column">
          {['Términos y condiciones','Más sobre nosotros','Contáctanos','FAQs'].map(item => (
            <li key={item} className="nav-item mb-2">
              <a href="/main" className="nav-link p-0 text-muted">{item}</a>
            </li>
          ))}
        </ul>
      </div>
      <div className="col">
        <h5>Redes Sociales</h5>
        <ul className="nav flex-column">
          {[
            {name:'Instagram',url:'https://www.instagram.com'},
            {name:'Facebook',url:'https://www.facebook.com'},
            {name:'X',url:'https://x.com'}
          ].map(soc => (
            <li key={soc.name} className="nav-item mb-2">
              <a href={soc.url} target="_blank" rel="noopener" className="nav-link p-0 text-muted">{soc.name}</a>
            </li>
          ))}
        </ul>
      </div>
    </footer>
  );
}