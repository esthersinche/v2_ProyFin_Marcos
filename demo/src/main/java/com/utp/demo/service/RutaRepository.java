package com.utp.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.demo.model.Ruta;



public interface RutaRepository extends JpaRepository<Ruta, String> {
    
}
