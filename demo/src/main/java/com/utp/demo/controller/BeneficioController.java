package com.utp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utp.demo.DTO.BeneficioDTO;
import com.utp.demo.service.BeneficioService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/beneficios")

public class BeneficioController {

    private final BeneficioService beneSev;

    @Autowired
    public BeneficioController(BeneficioService beneSev) {
        this.beneSev = beneSev;
    }

    @GetMapping
    public List<BeneficioDTO> findAll() {
        return beneSev.obtenerBeneficiosDTO();
    }

}
