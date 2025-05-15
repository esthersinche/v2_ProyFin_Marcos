package com.utp.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
