package com.utp.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.utp.demo.model.DTO.BarcoDTO;
import com.utp.demo.service.BarcoRepository;
import com.utp.demo.service.BarcoService;
import com.utp.demo.service.RutaService;



@Controller
@RequestMapping("/Mantenimiento/barcoMant")
public class BarcoMantController {
    private BarcoService barcoserv;
    private BarcoRepository barcorepo;
    private RutaService rutaserv;

    

    public BarcoMantController(BarcoService barcoserv, BarcoRepository barcorepo, RutaService rutaserv) {
        this.barcoserv = barcoserv;
        this.barcorepo = barcorepo;
        this.rutaserv = rutaserv;
    }



    @GetMapping
    public String mostrarlosbarcos(Model model) {
        model.addAttribute("barco", new BarcoDTO());
        model.addAttribute("modelos", barcorepo.findDistinctModelos());
        model.addAttribute("rutasDisponibles", rutaserv.obtenerTodasLasRutas());
        return "Mantenimiento/barcoMant";
    }

    
    



    


    

    
}
