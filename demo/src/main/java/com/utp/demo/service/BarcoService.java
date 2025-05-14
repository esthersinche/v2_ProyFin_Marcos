package com.utp.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utp.demo.model.Barcos;

@Service
public class BarcoService {

    public List<Barcos> obtenerBarcos() {
        return List.of(
                new Barcos("B001", "Aurora Sea", "Elena Morales", 800, "Spa, Piscina infinita, Auditorio, Casino, Cafetería Elegante", "Small", "https://cdn-3.expansion.mx/dims4/default/e771a6a/2147483647/strip/true/crop/5995x4234+0+0/resize/1200x848!/format/webp/quality/60/?url=https%3A%2F%2Fcdn-3.expansion.mx%2Fc1%2Fec%2Fc371673b403a993283b6ff277687%2F1666103786-rci-ic-crowns-edge-cgi23-ret-crop-lr.JPG"),
                new Barcos("B002", "NorthStar", "Rodrigo Sánchez", 800, "Restaurante gourmet, Gimnasio panorámico, Centro de Jacuzzis", "Small", "https://upload.wikimedia.org/wikipedia/commons/b/b3/Queen_Mary_2_Boston_July_2015_01_%28cropped%29.jpg"),
                new Barcos("B003", "Cristal Ocean", "Jean-Luc Rousseau", 1200, "Teatro, Piscina con Toboganes, Centro de Yoga, Comedor en cubierta", "Large", "https://upload.wikimedia.org/wikipedia/commons/3/3b/Icon_of_the_Seas.jpg"),
                new Barcos("B004", "Titan Horizon", "Margaret O'Connell", 1200, "Pista de Patinaje, Piscina con Olas, Simulador de surf, Restaurante Buffet", "Large", "https://i.blogs.es/d82af3/12/1366_2000.jpeg"),
                new Barcos("B005", "Velero Celeste", "Francisco Navarro", 1800, "Zona Xtreme-kids, Amplio piano bar, Solarium, Cine 4D", "X-Large", "https://royalcaribbean.com.pe/img/barcos/222_imagen_2625.jpg"),
                new Barcos("B006", "Antonia Graza", "Alessandro Bianchi", 1800, "Club nocturno, Zona comercial, Zona de Buffets, Centro de Relajación, Zona Kids", "X-Large", "https://royalcaribbean.com.pe/img/barcos/222_imagen_2625.jpg"));
    }

    public Barcos buscarPorBarco(String id) {
        return obtenerBarcos().stream()
                .filter(r -> r.getId_barco().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }
}
