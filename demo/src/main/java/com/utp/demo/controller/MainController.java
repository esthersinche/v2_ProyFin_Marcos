package com.utp.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String showMainPage() {
        return "main";
    }

    @GetMapping("/rutas")
    public String rutas() {
        return "rutas";
    }

    @GetMapping("/paquetes")
    public String paquetes() {
        return "paquetes";
    }

    @GetMapping("/barcos")
    public String barcos() {
        return "barcos";
    }

    @GetMapping("/comprar")
    public String comprar() {
        return "comprar";
    }

}
