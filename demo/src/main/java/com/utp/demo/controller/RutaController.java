package com.utp.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.utp.demo.model.Barcos;
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
            @RequestParam(name = "modelo", required = false) List<Barcos.Modelobarco> modelo,
            Model model) {

        // 1) Cargo todas las rutas
        List<Ruta> todas = rutaService.obtenerTodoRutas();

        // 2) Inicio el stream para aplicar filtros
        Stream<Ruta> stream = todas.stream();

        // 2.a) Filtro por 'salida' si vino algo
        if (salida != null && !salida.isEmpty()) {
            stream = stream.filter(r -> salida.contains(r.getSalida()));
        }

        // 2.b) Filtro por 'modelo' si vino algo
        if (modelo != null && !modelo.isEmpty()) {
            stream = stream.filter(r -> modelo.contains(r.getModelobarco()));
        }

        List<Ruta> filtradas = stream.collect(Collectors.toList());

        model.addAttribute("rutas", filtradas);

        // Si no llegaron params, inyecto listas vacías para Thymeleaf
        model.addAttribute("selectedSalida", salida == null ? List.<String>of() : salida);
        model.addAttribute("selectedModelos", modelo == null ? List.<Barcos.Modelobarco>of() : modelo);

        return "rutas";
    }

}
