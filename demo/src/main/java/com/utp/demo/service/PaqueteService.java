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

    // para obtener todos los paquetes
    public List<Paquete> ObtenertodoPaquetes() {
        return paqueteRepository.findAll();
    }

    // para buscar paquete por nombre y ruta
    public Paquete buscarPorNombreYRuta(String nombrePaquete, String nombreRuta) {
        return paqueteRepository
                .findByNombrePaqIgnoreCaseAndRutaPaq_NombreRutaIgnoreCase(nombrePaquete, nombreRuta)
                .orElse(null);
    }

    // para buscar paquetes por ruta
    public List<Paquete> obtenerPaquetesPorRuta(String nombreRuta) {
        return paqueteRepository.findByRutaPaq_NombreRutaIgnoreCase(nombreRuta);
    }

    // para buscar paquetes por nombres
    public List<Paquete> buscarPorNombrePaquetes(List<String> nombres_paquetes) {
        return paqueteRepository.findByNombrePaqIn(nombres_paquetes);
    }

    // para filtrar paquetes por nombre de ruta
    public List<Paquete> buscarPorRutaPaquetes(List<Paquete> listafilteroforiginal, List<String> nom_ruta_paquetes) {
        return listafilteroforiginal.stream()
                .filter(p -> nom_ruta_paquetes.contains(p.getRutaPaq().getNombre_ruta()))
                .toList();
    }

    // para filtrar paquetes por modelo de barco
    public List<Paquete> buscarPorModeloPaquetes(List<Paquete> listafilteroforiginal, List<String> nom_modelo_paquetes) {
        return listafilteroforiginal.stream()
                .filter(p -> nom_modelo_paquetes.contains(p.getModelobarcoPaq().getModelo_barco()))
                .toList();
    }

    // para filtrar paquetes por cantidad máxima de personas
    public List<Paquete> buscarPorCantMaxPerPaquetes(List<Paquete> listafilteroforiginal, List<Integer> num_personas_paquetes) {
        return listafilteroforiginal.stream()
                .filter(p -> num_personas_paquetes.contains(p.getCabinatipoPaq().getCant_max_per()))
                .toList();
    }
}
