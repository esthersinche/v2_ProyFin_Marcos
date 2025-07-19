package com.utp.demo.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.utp.demo.DTO.LoginDTO;

@Service
public class AuthService {

    private final AuthenticationManager authManager;
    private final UsuarioDetailsService userDetailsService;

    public AuthService(AuthenticationManager authManager,
            UsuarioDetailsService userDetailsService) {
        this.authManager = authManager;
        this.userDetailsService = userDetailsService;
    }

    public UserDetails authenticate(LoginDTO login) {
        // Lanza excepción si falla
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login.getUsername(), login.getPassword()
                )
        );
        // Si OK, devolvemos los detalles
        return userDetailsService.loadUserByUsername(login.getUsername());
    }
}
