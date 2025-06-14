package com.utp.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.utp.demo.model.DTO.RutaDTO;
import com.utp.demo.service.RutaService;
import org.springframework.web.bind.annotation.GetMapping;



@Controller

@RequestMapping("/Mantenimiento/rutaMant")
public class RutaMantController {
    private RutaService rutaserv;

    public RutaMantController(RutaService rutaserv) {
        this.rutaserv = rutaserv;
    }

    @GetMapping
    public String mostrarlasrutas(Model model) {
        model.addAttribute("ruta", new RutaDTO());
        model.addAttribute("puertos", rutaserv.obtenerTodasLasSalidas());
        return "Mantenimiento/rutaMant";
    }
    
    
}
