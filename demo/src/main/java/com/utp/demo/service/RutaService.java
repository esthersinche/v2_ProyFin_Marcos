package com.utp.demo.service;

import org.springframework.stereotype.Service;

import com.utp.demo.model.Ruta;

import java.util.List;

@Service
public class RutaService {

    public List<Ruta> obtenerTodoRutas() {
        // modificar datossss
        return List.of(
                new Ruta("Caribe Occidental",
                        "Visita Cozumel, Roatán y Costa Maya… playas de arena blanca y aguas cristalinas.", "7 días",
                        1500.0, "Puerto Miami: 13 de Julio",
                        "https://acrobatadelcamino.com/wp-content/uploads/2022/10/mejores-islas-del-caribe.jpg"),
                new Ruta("Mediterráneo Clásico", "Italia, Grecia y España", "10 días", 2200.0, "Barcelona",
                        "https://www.enroma.com/wp-content/uploads/2020/04/Porto-di-Civitavecchia.jpg"),
                new Ruta("Alaska Inexplorada", "Fiordos y glaciares", "8 días", 1800.0, "Seattle",
                        "https://www.viajes.cl/hs-fs/hubfs/Glaciar%20Hubbard%20en%20un%20Viaje%20en%20crucero%20por%20Alaska%20con%20Celebrity%20Cruises.jpg?width=2560&name=Glaciar%20Hubbard%20en%20un%20Viaje%20en%20crucero%20por%20Alaska%20con%20Celebrity%20Cruises.jpg"),
                new Ruta("Escapada a Bahamas", "Relax y playa", "4 días", 950.0, "Miami",
                        "https://www.ncl.com/sites/default/files/1000x667miamibahamas.jpg"));
    }

    //adicion, listado, consultas, eliminacion, busquedas
    //adicion puede ser
    //listado(arriba)

    //consultas
    public Ruta buscarPorNombreRuta(String nombre) {
        return obtenerTodoRutas().stream()
                .filter(r -> r.getNombre_ruta().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    public Ruta buscarPorsalidaRuta(String salida) {
        return obtenerTodoRutas().stream()
                .filter(r -> r.getSalida().equalsIgnoreCase(salida))
                .findFirst()
                .orElse(null);
    }

    //eliminacion(?)

    
}
