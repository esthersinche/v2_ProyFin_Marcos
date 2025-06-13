package com.utp.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.utp.demo.model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, String> {
    // para personalizadas, luegooo
}
