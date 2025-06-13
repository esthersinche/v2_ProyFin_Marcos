package com.utp.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utp.demo.model.Paquete;

@Service
public class PaqueteService {

    private final PaqueteRepository paqueteRepository;

    public PaqueteService(PaqueteRepository paqueteRepository) {
        this.paqueteRepository = paqueteRepository;
    }

    // Obtener todos los paquetes
    public List<Paquete> obtenerTodosLosPaquetes() {
        return paqueteRepository.findAll();
    }

    // Buscar paquete por nombre y ruta
    public Paquete buscarPorNombreYRuta(String nombrePaquete, String nombreRuta) {
        return paqueteRepository
                .findByNombrePaqAndRutaNombreIgnoreCase(nombrePaquete, nombreRuta)
                .orElse(null);
    }

    // Buscar paquetes por nombre de ruta
    public List<Paquete> obtenerPaquetesPorRuta(String nombreRuta) {
        return paqueteRepository.findByRutaNombreIgnoreCase(nombreRuta);
    }

    // Buscar paquetes por lista de nombres
    public List<Paquete> buscarPorNombrePaquetes(List<String> nombresPaquetes) {
        return paqueteRepository.findByNombrePaqInIgnoreCase(nombresPaquetes);
    }

    // Buscar paquetes por múltiples rutas
    public List<Paquete> buscarPorRutas(List<String> nombresRutas) {
        return paqueteRepository.findByRutaNombreInIgnoreCase(nombresRutas);
    }

    // Buscar paquetes por modelos de barco
    public List<Paquete> buscarPorModelos(List<String> modelos) {
        return paqueteRepository.findByModeloBarcoInIgnoreCase(modelos);
    }

    // Buscar paquetes por capacidades máximas
    public List<Paquete> buscarPorCapacidadMaxima(List<Integer> capacidades) {
        return paqueteRepository.findByCabinaCantMaxPerIn(capacidades);
    }
}
