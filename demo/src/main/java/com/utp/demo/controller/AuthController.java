// src/main/java/com/utp/demo/controller/AuthController.java
package com.utp.demo.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utp.demo.DTO.LoginDTO;
import com.utp.demo.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO login) {
        try {
            UserDetails user = authService.authenticate(login);
            // Si quisieras devolver un JWT, lo generarías aquí.
            return ResponseEntity.ok().body(
                    Map.of(
                            "username", user.getUsername(),
                            "roles", user.getAuthorities()
                    )
            );
        } catch (Exception ex) {
            return ResponseEntity
                    .status(401)
                    .body(Map.of("error", "Usuario o contraseña inválidos"));
        }
    }
}
