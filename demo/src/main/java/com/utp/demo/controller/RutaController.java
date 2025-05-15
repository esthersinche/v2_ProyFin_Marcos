package com.utp.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.utp.demo.service.RutaService;

@Controller
public class RutaController {

    private final RutaService rutaService;

    public RutaController(RutaService rutaService) {
        this.rutaService = rutaService;
    }

    @GetMapping("/rutas")
    public String listarRutas(Model model) {
        model.addAttribute("rutas", rutaService.obtenerTodoRutas());
        return "rutas";
    }

}
