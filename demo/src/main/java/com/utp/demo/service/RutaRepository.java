package com.utp.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utp.demo.model.Ruta;

public interface RutaRepository extends JpaRepository<Ruta, String> {

    /**
     * Busca ruta por nombre_ruta ignorando mayúsculas/minúsculas
     */
    @Query("""
      SELECT r
      FROM Ruta r
      WHERE LOWER(r.nombreruta) = LOWER(:nombreRuta)
    """)
    Ruta findByNombreRutaIgnoreCase(@Param("nombreRuta") String nombreRuta);

    /**
     * Lista rutas filtrando por salida ignorando mayúsculas/minúsculas
     */
    @Query("""
      SELECT r
      FROM Ruta r
      WHERE LOWER(r.salida) = LOWER(:salida)
    """)
    List<Ruta> findBySalidaIgnoreCase(@Param("salida") String salida);
}
