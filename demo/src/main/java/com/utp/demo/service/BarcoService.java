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
        return barcoRepository.findAll().stream()
                .filter(b -> b.getNombre_barco().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    // Buscar por capitán
    public Barcos buscarPorCapitan(String capitan) {
        return barcoRepository.findAll().stream()
                .filter(b -> b.getCapitan_barco().equalsIgnoreCase(capitan))
                .findFirst()
                .orElse(null);
    }

    // Buscar por modelo (nombre del modelo)
    public Barcos buscarPorNombreModelo(String modeloNombre) {
        return barcoRepository.findAll().stream()
                .filter(b -> b.getModelo_barco().equalsIgnoreCase(modeloNombre))
                .findFirst()
                .orElse(null);
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
