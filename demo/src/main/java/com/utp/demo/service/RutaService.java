package com.utp.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utp.demo.model.Ruta;

@Service
public class RutaService {

    @Autowired
    private RutaRepository rutaRepository;

    // Obtener todas las rutas
    public List<Ruta> obtenerTodasLasRutas() {
        return rutaRepository.findAll();
    }

    // Buscar por nombre de ruta
    public Ruta buscarPorNombreRuta(String nombre) {
        return rutaRepository.findAll().stream()
                .filter(r -> r.getNombre_ruta().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    // Buscar por salida
    public Ruta buscarPorSalidaRuta(String salida) {
        return rutaRepository.findAll().stream()
                .filter(r -> r.getSalida().equalsIgnoreCase(salida))
                .findFirst()
                .orElse(null);
    }

    // Agregar una nueva ruta
    public Ruta guardarRuta(Ruta ruta) {
        return rutaRepository.save(ruta);
    }

    // Eliminar una ruta por ID
    public void eliminarRuta(String idRuta) {
        rutaRepository.deleteById(idRuta);
    }

    // Buscar por ID (opcional)
    public Ruta buscarPorId(String idRuta) {
        return rutaRepository.findById(idRuta).orElse(null);
    }
}
