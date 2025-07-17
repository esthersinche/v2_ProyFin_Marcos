package com.utp.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utp.demo.DTO.RutaDTO;
import com.utp.demo.model.Ruta;
import com.utp.demo.model.RutaBarco;

@Service
public class RutaService {

    @Autowired
    private RutaRepository rutaRepository;

    // Obtener todas las rutas
    public List<Ruta> obtenerTodasLasRutas() {
        return rutaRepository.findAll();
    }

    /**
     * Devuelve todas las rutas filtradas y convertidas en DTOs
     */
    public List<RutaDTO> listarRutasDTO(List<String> salida, List<String> modelo) {
        return rutaRepository.findAll().stream()
                // Filtrado por salida
                .filter(r -> salida == null || salida.isEmpty() || salida.contains(r.getSalida()))
                // Filtrado por modelo
                .filter(r -> modelo == null || modelo.isEmpty()
                || r.getRutaBarcos().stream()
                        .map(RutaBarco::getBarco)
                        .map(b -> b.getBarmodel().getModeloBarco())
                        .anyMatch(modelo::contains)
                )
                // Conversión a DTO
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Convierte una entidad Ruta en RutaDTO
     */
    private RutaDTO toDTO(Ruta r) {
        RutaDTO dto = new RutaDTO();
        dto.setIdruta(r.getIdruta());
        dto.setNombreruta(r.getNombreruta());
        dto.setDescripcionruta(r.getDescripcionruta());
        dto.setDiasruta(r.getDiasruta());
        dto.setPrecioruta(r.getPrecioruta());
        dto.setSalida(r.getSalida());
        dto.setImagen(r.getImagen());
        List<String> modelos = r.getRutaBarcos().stream()
                .map(RutaBarco::getBarco)
                .map(b -> b.getBarmodel().getModeloBarco())
                .distinct()
                .collect(Collectors.toList());
        dto.setModelos(modelos);
        return dto;
    }

    // Buscar por ID
    public Ruta buscarPorId(String idRuta) {
        return rutaRepository.findById(idRuta).orElse(null);
    }

    // Buscar por nombre de ruta
    public Ruta buscarPorNombreRuta(String nombre) {
        return rutaRepository.findByNombreRutaIgnoreCase(nombre);
    }

    // Buscar por salida (puede haber varias rutas con misma salida)
    public List<Ruta> buscarPorSalidaRuta(String salida) {
        return rutaRepository.findBySalidaIgnoreCase(salida);
    }

    // Agregar una nueva ruta
    public Ruta guardarRuta(Ruta ruta) {
        return rutaRepository.save(ruta);
    }

    // Eliminar una ruta por ID
    public void eliminarRuta(String idRuta) {
        rutaRepository.deleteById(idRuta);
    }

    public List<String> obtenerTodasLasSalidas() {
        return rutaRepository.Obtenertodaslassalidas();
    }

    /*
     * //convertir a ruta
    public Ruta convertiraRuta(RutaDTO rutadto, Ruta rutaa){
        rutaa.setIdruta(rutadto.getIdRuta());
        rutaa.setNombreruta(rutadto.getNombreRuta());
        rutaa.setDiasruta(rutadto.getDiasRuta());
        rutaa.setPrecioruta(rutadto.getPrecioRuta());
        rutaa.setSalida(rutadto.getSalidaRuta());
        rutaa.setDescripcionruta(rutadto.getDescripcionRuta());
        rutaa.setImagen(rutadto.getUrlRuta());

        return rutaa;

    }
    //convertir a dto

    public RutaDTO convertiraDTO(Ruta rutaaa, RutaDTO rutadtoo){
        rutadtoo.setIdRuta(rutaaa.getIdruta());
        rutadtoo.setNombreRuta(rutaaa.getNombreruta());
        rutadtoo.setDiasRuta(rutaaa.getDiasruta());
        rutadtoo.setPrecioRuta(rutaaa.getPrecioruta());
        rutadtoo.setSalidaRuta(rutaaa.getSalida());
        rutadtoo.setDescripcionRuta(rutaaa.getDescripcionruta());
        rutadtoo.setUrlRuta(rutaaa.getImagen());

        return rutadtoo;
    }
     */
}
