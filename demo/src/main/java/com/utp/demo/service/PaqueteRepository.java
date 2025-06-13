package com.utp.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utp.demo.model.Paquete;

public interface PaqueteRepository extends JpaRepository<Paquete, String> {

    @Query("""
      SELECT p
      FROM Paquete p
      WHERE LOWER(p.nom_paquete) = LOWER(:nombrePaq)
        AND LOWER(p.rutaPaq.nombreruta) = LOWER(:nombreRuta)
    """)
    Optional<Paquete> findByNombrePaqAndRutaNombreIgnoreCase(
            @Param("nombrePaq") String nombrePaq,
            @Param("nombreRuta") String nombreRuta
    );

    @Query("""
      SELECT p
      FROM Paquete p
      WHERE LOWER(p.rutaPaq.nombreruta) = LOWER(:nombreRuta)
    """)
    List<Paquete> findByRutaNombreIgnoreCase(@Param("nombreRuta") String nombreRuta);
    // MULTIPLES : LIST<STRING>

    @Query("""
      SELECT p
      FROM Paquete p
      WHERE LOWER(p.nom_paquete) IN :nombres
    """)
    List<Paquete> findByNombrePaqInIgnoreCase(@Param("nombres") List<String> nombres);

    @Query("""
      SELECT p
      FROM Paquete p
      WHERE LOWER(p.rutaPaq.nombreruta) IN :nombresRutas
    """)
    List<Paquete> findByRutaNombreInIgnoreCase(@Param("nombresRutas") List<String> nombresRutas);

    @Query("""
      SELECT p
      FROM Paquete p
      WHERE LOWER(p.modelobarcoPaq.modelo_barco) IN :modelos
    """)
    List<Paquete> findByModeloBarcoInIgnoreCase(@Param("modelos") List<String> modelos);

    @Query("""
      SELECT p
      FROM Paquete p
      WHERE p.cabinatipoPaq.cant_max_per IN :cantidades
    """)
    List<Paquete> findByCabinaCantMaxPerIn(@Param("cantidades") List<Integer> cantidades);

}
