package com.utp.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.demo.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, String> {
    
}
