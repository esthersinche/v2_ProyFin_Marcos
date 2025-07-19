package com.utp.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.utp.demo.model.Barcos;
import com.utp.demo.model.Barcos_modelo;

@Repository
public interface BarcoRepository extends JpaRepository<Barcos, String> {

    @Query("""
      SELECT b 
      FROM Barcos b
      WHERE LOWER(b.nombrebarco) = LOWER(:nombre)
    """)
    Barcos findByNombreBarcoIgnoreCase(String nombre);

    @Query("""
      SELECT b 
      FROM Barcos b
      WHERE LOWER(b.capitanbarco) = LOWER(:capitan)
    """)
    Barcos findByCapitanBarcoIgnoreCase(@Param("capitan") String capitan);

    @Query("""
      SELECT b 
      FROM Barcos b 
      WHERE LOWER(b.barmodel.modeloBarco) = LOWER(:modeloNombre)
    """)
    Barcos findByModeloNombreIgnoreCase(@Param("modeloNombre") String modeloNombre);

    @Query("""
        SELECT DISTINCT b.barmodel FROM Barcos b
        """)
    List<Barcos_modelo> findDistinctModelos();

    @Query("""
      SELECT b
      FROM Barcos b
      JOIN b.rutas r
      WHERE r.ruta.idruta = :rutaId
    """)
    List<Barcos> findAllByRutaId(@Param("rutaId") String rutaId);
}
