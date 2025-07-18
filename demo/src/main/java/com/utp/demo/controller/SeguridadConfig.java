package com.utp.demo.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.utp.demo.service.UsuarioDetailsService;

@Configuration
@EnableWebSecurity
public class SeguridadConfig {

    private final UsuarioDetailsService usuarioDetailsService;

    public SeguridadConfig(UsuarioDetailsService usuarioDetailsService) {
        this.usuarioDetailsService = usuarioDetailsService;
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authBuilder
                = http.getSharedObject(AuthenticationManagerBuilder.class);
        authBuilder
                .userDetailsService(usuarioDetailsService)
                .passwordEncoder(passwordEncoder());
        return authBuilder.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
          http
                // 1. Activa CORS usando tu CorsConfig
                .cors().and()
                // 2. Desactiva CSRF para las rutas /api/**
                .csrf(csrf -> csrf
                .ignoringRequestMatchers("/api/**")
                )
                // 3. Reglas de autorización
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()
                // después tu regla de Thymeleaf
                .requestMatchers("/Mantenimiento/barcoMant").hasRole("USER")
                .anyRequest().permitAll()
                )
                // 4. Form login / logout
                .formLogin(form -> form
                .loginPage("/Mantenimiento/login")
                .loginProcessingUrl("/Mantenimiento/login")
                .defaultSuccessUrl("/Mantenimiento/barcoMant", true)
                .permitAll()
                )
                .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/Mantenimiento/login?logout")
                .permitAll()
                );
        return http.build();
         
        
        
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
