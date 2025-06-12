package com.utp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.utp.demo.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    // Mostramos Mantenimiento/login.html
    @GetMapping("/Mantenimiento/login")
    public String showLoginForm() {
        return "Mantenimiento/login";
    }

    @PostMapping("/Mantenimiento/login")
    public String processLogin(
            @RequestParam("username") String usuario,
            @RequestParam("password") String password,
            Model model,
            HttpSession session) {

        if (loginService.login(usuario, password)) {
            session.setAttribute("loggedUser", usuario);
            // Al validar bien, devolvemos barcoMant.html
            return "Mantenimiento/barcoMant";
        }

        model.addAttribute("error", "Credenciales inválidas");
        // Si hay error, volvemos a la misma vista de login
        return "Mantenimiento/login";
    }
}
