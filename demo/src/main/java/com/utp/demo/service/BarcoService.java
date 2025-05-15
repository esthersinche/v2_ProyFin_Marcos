package com.utp.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.utp.demo.model.Barcos;
import com.utp.demo.model.Barcos.Modelobarco;

@Service
public class BarcoService {


    //listado
    public List<Barcos> obtenerBarcos() {
        return List.of(
            new Barcos("B001", "Aurora Sea", "Elena Morales", 
            Modelobarco.SMODEL, "Spa, Piscina infinita, Auditorio, Casino, Cafetería Elegante", 
            "https://cdn-3.expansion.mx/dims4/default/e771a6a/2147483647/strip/true/crop/5995x4234+0+0/resize/1200x848!/format/webp/quality/60/?url=https%3A%2F%2Fcdn-3.expansion.mx%2Fc1%2Fec%2Fc371673b403a993283b6ff277687%2F1666103786-rci-ic-crowns-edge-cgi23-ret-crop-lr.JPG"),

            new Barcos("B002", "NorthStar", "Rodrigo Sánchez", 
            Modelobarco.SMODEL, "Restaurante gourmet, Gimnasio panorámico, Centro de Jacuzzis", 
            "https://upload.wikimedia.org/wikipedia/commons/b/b3/Queen_Mary_2_Boston_July_2015_01_%28cropped%29.jpg"),

            new Barcos("B003", "Cristal Ocean", "Jean-Luc Rousseau", 
            Modelobarco.MMODEL, "Teatro, Piscina con Toboganes, Centro de Yoga, Comedor en cubierta", 
            "https://upload.wikimedia.org/wikipedia/commons/3/3b/Icon_of_the_Seas.jpg"),

            new Barcos("B004", "Titan Horizon", "Margaret O'Connell", 
            Modelobarco.MMODEL, "Pista de Patinaje, Piscina con Olas, Simulador de surf, Restaurante Buffet", 
            "https://i.blogs.es/d82af3/12/1366_2000.jpeg"),

            new Barcos("B005", "Velero Celeste", "Francisco Navarro", 
            Modelobarco.LMODEL, "Zona Xtreme-kids, Amplio piano bar, Solarium, Cine 4D", 
            "https://royalcaribbean.com.pe/img/barcos/222_imagen_2625.jpg"),

            new Barcos("B006", "Antonia Graza", "Alessandro Bianchi", 
            Modelobarco.LMODEL, "Club nocturno, Zona comercial, Zona de Buffets, Centro de Relajación, Zona Kids", 
            "https://royalcaribbean.com.pe/img/barcos/222_imagen_2625.jpg")

        );         
    }

    //Adicion, listado, consultas, eliminación , busquedas
    //no adicion
    //Listado(arriba)
    //consultas
    public Barcos buscarPoridBarco(String id) {
        return obtenerBarcos().stream()
                .filter(r -> r.getId_barco().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    public Barcos buscarPornombreBarco(String nombre) {
        return obtenerBarcos().stream()
                .filter(r -> r.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    public Barcos buscarPormodeloBarco(String modelo) {
        return obtenerBarcos().stream()
                .filter(r -> r.getModelobarco().getModelo().equalsIgnoreCase(modelo))
                .findFirst().orElse(null);
    }

    public Barcos buscarPorcapiBarco(String capi) {
        return obtenerBarcos().stream()
                .filter(r -> r.getCapitan().equalsIgnoreCase(capi))
                .findFirst().orElse(null);
    }

    //eliminacion
    



    
}
