package com.utp.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;
import com.utp.demo.DTO.RutaDTO;
import com.utp.demo.model.Ruta;
import com.utp.demo.model.RutaBarco;
import com.utp.demo.service.RutaService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/rutas")
public class RutaController {

    private final RutaService rutaService;

    public RutaController(RutaService rutaService) {
        this.rutaService = rutaService;
    }

    @GetMapping
    public List<RutaDTO> listarRutas(
            @RequestParam(name = "salida", required = false) List<String> salida,
            @RequestParam(name = "modelo", required = false) List<String> modelo
    ) {
        return rutaService.listarRutasDTO(salida, modelo);
    }

    /* 
    @GetMapping("/rutas")
    public String listarRutas(
            @RequestParam(name = "salida", required = false) List<String> salida,
            @RequestParam(name = "modelo", required = false) List<String> modelo,
            Model model) {

        // 1. Obtener todas las rutas
        List<Ruta> todas = rutaService.obtenerTodasLasRutas();

        // 2. Aplicar filtros
        Stream<Ruta> stream = todas.stream();

        // Filtrar por puerto de salida (igual que antes)
        if (salida != null && !salida.isEmpty()) {
            stream = stream.filter(r -> salida.contains(r.getSalida()));
        }

        // Filtrar por modelo de barco: comprobamos si ALGÚN barco de la ruta
        // tiene un modelo en la lista de modelos seleccionados
        if (modelo != null && !modelo.isEmpty()) {
            stream = stream.filter(r -> r.getRutaBarcos().stream().map(RutaBarco::getBarco) // saca el barco
                    .map(Barcos::getBarmodel) // saca el modelo del barco
                    .map(Barcos_modelo::getModeloBarco) // agarra el código string
                    .anyMatch(modelo::contains)
            /*
             * .map(Barcos::getBarmodel) // de Barcos obtenemos Barcos_modelo
             * .map(Barcos_modelo::getModeloBarco) // y de ahí el código de modelo
             * .anyMatch(modelo::contains)
     *//* 
            );
        }

        List<Ruta> filtradas = stream.collect(Collectors.toList());

        // 3. Enviar resultados a la vista
        model.addAttribute("rutas", filtradas);
        model.addAttribute("selectedSalida", salida == null ? List.of() : salida);
        model.addAttribute("selectedModelos", modelo == null ? List.of() : modelo);

        return "rutas";
}
     */

}
