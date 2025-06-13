package com.utp.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.demo.model.Ruta;

public interface RutaRepository extends JpaRepository<Ruta, String> {
    Ruta findByNombreRutaIgnoreCase(String nombreRuta);

    List<Ruta> findBySalidaIgnoreCase(String salida);
}
