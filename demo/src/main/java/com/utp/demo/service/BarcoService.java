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

    // Buscar por nombre del barco
    public Barcos buscarPorNombreBarco(String nombre) {
        return barcoRepository.findByNombreBarcoIgnoreCase(nombre);
    }

    // Buscar por capitán
    public Barcos buscarPorCapitan(String nombre) {
        return barcoRepository.findByCapitan_barcoIgnoreCase(nombre);
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
}
