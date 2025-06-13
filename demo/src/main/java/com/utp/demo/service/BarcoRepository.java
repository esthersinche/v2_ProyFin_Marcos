package com.utp.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.utp.demo.model.Barcos;

@Repository
public interface BarcoRepository extends JpaRepository<Barcos, String> {

    @Query("""
      SELECT b 
      FROM Barcos b
      WHERE LOWER(b.nombre_barco) = LOWER(:nombre)
    """)
    Barcos findByNombreBarcoIgnoreCase(@Param("nombre") String nombre);

    @Query("""
      SELECT b 
      FROM Barcos b
      WHERE LOWER(b.capitan_barco) = LOWER(:capitan)
    """)
    Barcos findByCapitanBarcoIgnoreCase(@Param("capitan") String capitan);

    @Query("""
      SELECT b 
      FROM Barcos b 
      WHERE LOWER(b.bar_model.modelo_barco) = LOWER(:modeloNombre)
    """)
    Barcos findByModeloNombreIgnoreCase(@Param("modeloNombre") String modeloNombre);
}
