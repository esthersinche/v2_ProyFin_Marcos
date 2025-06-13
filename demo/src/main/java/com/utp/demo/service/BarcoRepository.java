package com.utp.demo.service;

import java.util.List;

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

    // Para obtener barcos asociados a una ruta
    @Query("""
       SELECT b
       FROM Barcos b
       JOIN b.rutas rb
       WHERE rb.Id_ruta = :rutaId
    """)
    List<Barcos> findAllByRutaId(@Param("rutaId") String rutaId);
}
