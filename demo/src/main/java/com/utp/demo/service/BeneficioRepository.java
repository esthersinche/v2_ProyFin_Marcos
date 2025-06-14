package com.utp.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utp.demo.model.Beneficio;

@Repository
public interface BeneficioRepository extends JpaRepository<Beneficio, String>{
    
    
}
