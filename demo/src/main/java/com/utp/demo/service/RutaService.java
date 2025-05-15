package com.utp.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.utp.demo.model.Barcos;
import com.utp.demo.model.Ruta;

@Service
public class RutaService {

    private static final Map<String, Barcos.Modelobarco> RUTA_A_MODELO = Map.of(
            "Caribe Occidental", Barcos.Modelobarco.SMODEL,
            "Mediterráneo Clásico", Barcos.Modelobarco.SMODEL,
            "Alaska Inexplorada", Barcos.Modelobarco.MMODEL,
            "Escapada a Bahamas", Barcos.Modelobarco.LMODEL);

    public List<Ruta> obtenerTodoRutas() {
        // modificar datossss
        return List.of(
                crearRuta("Caribe Occidental",
                        "Visita Cozumel, Roatán y Costa Maya… playas de arena blanca y aguas cristalinas.",
                        "7 días",
                        1500.0, "Miami",
                        "https://acrobatadelcamino.com/wp-content/uploads/2022/10/mejores-islas-del-caribe.jpg"),
                crearRuta("Mediterráneo Clásico", "Italia, Grecia y España", "10 días", 2200.0,
                        "Barcelona",
                        "https://www.enroma.com/wp-content/uploads/2020/04/Porto-di-Civitavecchia.jpg"),
                crearRuta("Alaska Inexplorada", "Fiordos y glaciares", "8 días", 1800.0, "Seattle",
                        "https://www.viajes.cl/hs-fs/hubfs/Glaciar%20Hubbard%20en%20un%20Viaje%20en%20crucero%20por%20Alaska%20con%20Celebrity%20Cruises.jpg?width=2560&name=Glaciar%20Hubbard%20en%20un%20Viaje%20en%20crucero%20por%20Alaska%20con%20Celebrity%20Cruises.jpg"),
                crearRuta("Escapada a Bahamas", "Relax y playa", "4 días", 950.0, "Miami",
                        "https://www.ncl.com/sites/default/files/1000x667miamibahamas.jpg"));
    }

    private Ruta crearRuta(String nombre, String descripcion, String dias,
            double precio, String salida, String imagen) {
        Barcos.Modelobarco modelo = RUTA_A_MODELO.getOrDefault(
                nombre, Barcos.Modelobarco.SMODEL /* fallback */);
        return new Ruta(nombre, descripcion, dias, precio, salida, imagen, modelo);
    }

    // adicion, listado, consultas, eliminacion, busquedas
    // adicion puede ser
    // listado(arriba)
    // consultas
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

    // eliminacion(?)
}
