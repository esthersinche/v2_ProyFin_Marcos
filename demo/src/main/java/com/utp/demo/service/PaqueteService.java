package com.utp.demo.service;

import org.springframework.stereotype.Service;

import com.utp.demo.model.Paquete;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaqueteService {

    public List<Paquete> obtenerTodoPaquetes() {
        return List.of(
                new Paquete("Todo Incluido", "Todos los beneficios del crucero", 1200),
                new Paquete("Sin Paquetes", "Solo el crucero base", 0),
                new Paquete("Paquete de Bebidas", "Incluye bebidas ilimitadas", 300),
                new Paquete("Paquete de Internet", "Wi-Fi ilimitado en todo el barco", 250),
                new Paquete("Paquete de Restaurantes", "Acceso a restaurantes gourmet", 350),
                new Paquete("Paquete de Entretenimiento para Niños", "Actividades para menores", 200),
                new Paquete("Paquete de Entretenimiento para Adultos", "Shows y actividades nocturnas", 400),
                new Paquete("Paquete de Piscinas", "Acceso a piscinas premium", 150));
    }

    // 🔁 NUEVO método modificado
    public List<Paquete> buscarPorNombrePaquetes(List<String> nombres_paquetes) {
        return obtenerTodoPaquetes().stream()
                .filter(p -> nombres_paquetes.contains(p.getNombre_paq()))
                .collect(Collectors.toList());
    }
}
