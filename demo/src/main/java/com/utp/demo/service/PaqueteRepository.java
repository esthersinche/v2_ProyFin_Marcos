package com.utp.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.demo.model.Paquete;

public interface PaqueteRepository extends JpaRepository<Paquete, String> {

    Optional<Paquete> findByNombrePaqIgnoreCaseAndRutaPaq_NombreRutaIgnoreCase(String nombrePaq, String nombreRuta);

    List<Paquete> findByRutaPaq_NombreRutaIgnoreCase(String nombreRuta);

    List<Paquete> findByNombrePaqIn(List<String> nombres);

    List<Paquete> findByRutaPaq_NombreRutaIn(List<String> nombresRutas);

    List<Paquete> findByModelobarcoPaq_ModeloIn(List<String> modelos);

    List<Paquete> findByCabinatipoPaq_CantMaxPerIn(List<Integer> cantMaxPer);
}
