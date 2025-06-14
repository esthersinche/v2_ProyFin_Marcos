package com.utp.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.utp.demo.model.DTO.PaqueteDTO;
import com.utp.demo.service.BeneficioService;
import com.utp.demo.service.PaqueteService;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("Mantenimiento/paqueteMant")
public class PaqueteMantController {
    private PaqueteService paqserv;
    private BeneficioService beneserv;
    
    public PaqueteMantController(PaqueteService paqserv, BeneficioService beneserv) {
        this.paqserv = paqserv;
        this.beneserv = beneserv;
    }

    @GetMapping
    public String mostrarlospaquetes(Model model) {
        model.addAttribute("paquete", new PaqueteDTO());
        model.addAttribute("beneficiosDisponibles", beneserv.ObtenertodoslosBeneficios());
        return "Mantenimiento/paqueteMant";
    }
    
    
}
