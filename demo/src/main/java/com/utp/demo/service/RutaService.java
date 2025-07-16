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

    public List<String> obtenerTodasLasSalidas(){
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
