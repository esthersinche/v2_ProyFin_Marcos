package com.utp.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utp.demo.model.Barcos;

@Repository
public interface BarcoRepository extends JpaRepository<Barcos, String> {
    Barcos findByNombreBarcoIgnoreCase(String nombreBarco);

    Barcos findByCapitanBarcoIgnoreCase(String capitan);

    Barcos findByModeloBarco_ModeloBarcoIgnoreCase(String modeloNombre);
}
