package com.utp.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utp.demo.DTO.CabinaDTO;
import com.utp.demo.service.CabinaService;

@RestController
@RequestMapping("/api/cabinas")
public class CabinaController {

    private final CabinaService cabinaService;

    public CabinaController(CabinaService cabinaService) {
        this.cabinaService = cabinaService;
    }

    @GetMapping
    public List<CabinaDTO> obtenerCabinas() {
        return cabinaService.obtenerCabinasComoDTO();
    }
}
