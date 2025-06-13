package com.utp.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.utp.demo.model.Ruta;
import com.utp.demo.service.RutaService;

@Controller
public class RutaController {

    private final RutaService rutaService;

    public RutaController(RutaService rutaService) {
        this.rutaService = rutaService;
    }

    @GetMapping("/rutas")
    public String listarRutas(
            @RequestParam(name = "salida", required = false) List<String> salida,
            @RequestParam(name = "modelo", required = false) List<String> modelo,
            Model model) {

        // 1. Obtener todas las rutas
        List<Ruta> todas = rutaService.obtenerTodasLasRutas();

        // 2. Aplicar filtros
        Stream<Ruta> stream = todas.stream();

        if (salida != null && !salida.isEmpty()) {
            stream = stream.filter(r -> salida.contains(r.getSalida()));
        }

        if (modelo != null && !modelo.isEmpty()) {
            stream = stream.filter(r -> modelo.contains(r.getModeloBarco().getModelo_barco()));
        }

        List<Ruta> filtradas = stream.collect(Collectors.toList());

        // 3. Enviar resultados a la vista
        model.addAttribute("rutas", filtradas);
        model.addAttribute("selectedSalida", salida == null ? List.of() : salida);
        model.addAttribute("selectedModelos", modelo == null ? List.of() : modelo);

        return "rutas";
    }
}
