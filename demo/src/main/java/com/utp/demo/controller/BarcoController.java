package com.utp.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utp.demo.DTO.BarcoDTO;
import com.utp.demo.service.BarcoService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/barcos")
public class BarcoController {

    private final BarcoService barcoService;

    public BarcoController(BarcoService barcoService) {
        this.barcoService = barcoService;
    }

    @GetMapping
    public List<BarcoDTO> findAll() {
        return barcoService.obtenerBarcosDTO();
    }
    /* ESO ES DEL THYMELEAF, LO DEJO COMENTADO POR SI ACASO
    @GetMapping("/barcos")
    public String listarBarcos(Model model) {
        model.addAttribute("barcos", barcoService.obtenerBarcos());
        return "barcos";
    }
     */
}
