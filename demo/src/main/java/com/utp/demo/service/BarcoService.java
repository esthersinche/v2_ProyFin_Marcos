package com.utp.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.utp.demo.model.Barcos;
import com.utp.demo.repository.BarcosRepository;

@Service
public class BarcoService {

        @Autowired
        private BarcosRepository barcosRepository; // Repositorio de Barcos

        // Listado de barcos, ahora obtenidos desde la base de datos
        public List<Barcos> obtenerBarcos() {
                return barcosRepository.findAll(); // Obtiene todos los barcos de la base de datos
        }

        // Consultas
        public Barcos buscarPorIdBarco(String id) {
                return barcosRepository.findById(id).orElse(null); // Busca por id
        }

        public Barcos buscarPorNombreBarco(String nombre) {
                return barcosRepository.findAll().stream()
                                .filter(r -> r.getNombre_barco().equalsIgnoreCase(nombre))
                                .findFirst()
                                .orElse(null);
        }

        public Barcos buscarPorModeloBarco(String modelo) {
                return barcosRepository.findAll().stream()
                                .filter(r -> r.getId_barco().equalsIgnoreCase(modelo))
                                .findFirst().orElse(null);
        }

        public Barcos buscarPorCapitanBarco(String capi) {
                return barcosRepository.findAll().stream()
                                .filter(r -> r.getCapitan_barco().equalsIgnoreCase(capi))
                                .findFirst().orElse(null);
        }

        // Eliminación (si fuera necesario)
}
