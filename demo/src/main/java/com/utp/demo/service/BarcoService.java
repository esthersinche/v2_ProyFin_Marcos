package com.utp.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utp.demo.model.Barcos;

@Service
public class BarcoService {

    @Autowired
    private BarcoRepository barcoRepository;

    // Listado completo
    public List<Barcos> obtenerBarcos() {
        return barcoRepository.findAll();
    }

    // Buscar por ID de barco
    public Barcos buscarPorIdBarco(String id) {
        return barcoRepository.findById(id).orElse(null);
    }

    // Obtener barcos disponibles para una ruta concreta
    public List<Barcos> obtenerPorRuta(String idRuta) {
        return barcoRepository.findAllByRutaId(idRuta);
    }

    // Buscar por nombre del barco
    public Barcos buscarPorNombreBarco(String nombre) {
        return barcoRepository.findByNombreBarcoIgnoreCase(nombre);
    }

    // Buscar por capitán
    public Barcos buscarPorCapitan(String nombre) {
        return barcoRepository.findByCapitanBarcoIgnoreCase(nombre);
    }

    // Buscar por modelo (nombre del modelo)
    public Barcos buscarPorNombreModelo(String modeloNombre) {
        return barcoRepository.findByModeloNombreIgnoreCase(modeloNombre);
    }

    // Guardar nuevo barco
    public Barcos guardarBarco(Barcos barco) {
        return barcoRepository.save(barco);
    }

    // Eliminar barco por ID
    public void eliminarBarco(String id) {
        barcoRepository.deleteById(id);
    }

    /** Devuelve solo los barcos que cubren la ruta indicada */
    public List<Barcos> obtenerPorRuta(String rutaId) {
        return barcoRepository.findAllByRutaId(rutaId);
    }

    /** Ya existente, renómbralo si quieres a buscarPorId */
    public Barcos buscarPorId(String id) {
        return barcoRepository.findById(id).orElse(null);
    }
}
