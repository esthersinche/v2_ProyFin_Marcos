package com.utp.demo.servicio;

import com.utp.demo.modelo.Ruta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutaService {

    public List<Ruta> obtenerTodas() {
        // modificar datossss
        return List.of(
                new Ruta("Caribe Occidental", "Crucero por islas tropicales", "7 días", 1500.0, "Puerto Miami"),
                new Ruta("Mediterráneo Clásico", "Italia, Grecia y España", "10 días", 2200.0, "Barcelona"),
                new Ruta("Alaska Inexplorada", "Fiordos y glaciares", "8 días", 1800.0, "Seattle"),
                new Ruta("Escapada a Bahamas", "Relax y playa", "4 días", 950.0, "Miami"));
    }

    public Ruta buscarPorNombre(String nombre) {
        return obtenerTodas().stream()
                .filter(r -> r.getNombre_ruta().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }
}
