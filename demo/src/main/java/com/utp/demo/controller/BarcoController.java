package com.utp.demo.controller;

import org.springframework.stereotype.Controller;

import com.utp.demo.service.BarcoService;

@Controller
public class BarcoController {

    private final BarcoService barcoService;

    public BarcoController(BarcoService barcoService) {
        this.barcoService = barcoService;
    }

    @GetMapping("/barcos")
    public String listarBarcos(Model model) {
        model.addAttribute("barcos", barcoService.obtenerBarcos());
        return "barcos";
    }
}
