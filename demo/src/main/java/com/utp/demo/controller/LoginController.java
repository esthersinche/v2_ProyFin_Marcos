package com.utp.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

    @GetMapping("/Mantenimiento/login")
    public String loginpage() {
        return "Mantenimiento/login";
    }
    
    
}
