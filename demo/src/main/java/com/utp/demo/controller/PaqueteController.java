package com.utp.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.utp.demo.model.Paquete;
import com.utp.demo.service.PaqueteService;

@Controller
public class PaqueteController {

    // no es necesario el autowired debido a una versión del SpringBoot que lo
    // detecta automáticamente
    private final PaqueteService paqserv;

    public PaqueteController(PaqueteService paqserv) {
        this.paqserv = paqserv;
    }

    @GetMapping("/paquetes")
    public String listarpaquetes(
            @RequestParam(name = "ruta", required = false) List<String> rutas,
            @RequestParam(name = "cantmaxper", required = false) List<Integer> cantmaxpers,
            @RequestParam(name = "modelo", required = false) List<String> modelos,
            Model model) {

        // 1) Cargo todas las listas
        List<Paquete> todalalistapaq = paqserv.obtenerTodosLosPaquetes();
        boolean filtrosqm = false;

        // para recorrer la lista de paquetes
        // Stream<Paquete> stream = todalalistapaq.stream();

        // filtros ruta
        if (rutas != null && !rutas.isEmpty()) {
            // stream = stream.filter(r ->
            // rutas.contains(r.getRuta_paq().getNombre_ruta()));
            todalalistapaq = paqserv.buscarPorRutas(rutas);
            filtrosqm = true;
        }

        // filtro cantmaxper
        if (cantmaxpers != null && !cantmaxpers.isEmpty()) {
            // stream = stream.filter(c ->
            // cantmaxpers.contains(c.getCabinatipo_paq().getCant_max_per()));
            todalalistapaq = paqserv.buscarPorCapacidadMaxima(cantmaxpers);
            filtrosqm = true;
        }

        // filtro modelo de barco
        if (modelos != null && !modelos.isEmpty()) {
            // stream = stream.filter(m -> modelos.contains(m.getModelobarco_paq()));
            todalalistapaq = paqserv.buscarPorModelos(modelos);
            filtrosqm = true;
        }

        // añadir las cosas filtradas a una lista
        // List<Paquete> paq_filtrados = stream.collect(Collectors.toList());

        // mostrar 15 primeros paquetes si es que no hay filtros puestos
        // no se sabe cuántos paquetes son ni se quiere mostrar todos por defecto
        if (!filtrosqm) {
            todalalistapaq = todalalistapaq.stream().limit(15).collect(Collectors.toList());
        }

        // añadir al modelo los paquetes a mostrar
        model.addAttribute("paquetes", todalalistapaq);

        // opciones para los combobox
        // Lista de Rutas
        List<String> nom_rutas = paqserv.obtenerTodosLosPaquetes().stream()
                .map(p -> p.getRutaPaq())
                .filter(r -> r != null)
                .map(r -> r.getNombre_ruta())
                .distinct()
                .collect(Collectors.toList());

        // Lista de cant máxima de personas
        List<Integer> cantidad_pasajeros = paqserv.obtenerTodosLosPaquetes().stream()
                .map(p -> p.getCabinatipoPaq())
                .filter(c -> c != null)
                .map(c -> c.getCant_max_per())
                .distinct()
                .collect(Collectors.toList());

        // Lista de modelo de barcos
        List<String> modelos_barcos = paqserv.obtenerTodosLosPaquetes().stream()
                .map(p -> p.getModelobarcoPaq())
                .filter(m -> m != null)
                .map(m -> m.getModelo_barco())
                .distinct()
                .collect(Collectors.toList()); // devuelve lista string

        // agregar al model esa cosa de info y vista, no se
        model.addAttribute("nombre_rutas", nom_rutas);
        model.addAttribute("cant_personas", cantidad_pasajeros);
        model.addAttribute("modelos_barco", modelos_barcos);

        /*
         * List<Ruta> rutas_cbox_paq = rutserv.obtenerTodoRutas(); // obtiene los objs
         * ruta
         * // recién puede sacar los nombres
         * List<String> nom_rutas = rutas_cbox_paq.stream().map(Ruta::getNombre_ruta)
         * .distinct().collect(Collectors.toList());
         */

        return "paquetes";
    }
}
