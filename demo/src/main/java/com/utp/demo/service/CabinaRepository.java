package com.utp.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utp.demo.model.Cabina_Inst;
import com.utp.demo.model.Cabina_tipo;

public interface CabinaRepository extends JpaRepository<Cabina_Inst, Long> {

    @Query("""
      SELECT c
      FROM Cabina_Inst c
      WHERE c.cab_tipo.cab_tipo_id = :cabTipoId
    """)
    List<Cabina_Inst> findByCabTipoId(@Param("cabTipoId") String cabTipoId);

    @Query("""
      SELECT c
      FROM Cabina_Inst c
      WHERE c.cab_tipo = :cabTipo
    """)
    Cabina_Inst findFirstByCabTipo(@Param("cabTipo") Cabina_tipo cabTipo);

    @Query("""
      SELECT c
      FROM Cabina_Inst c
      JOIN c.cab_tipo t
      WHERE t.cab_tipo_id IN :ids
    """)
    List<Cabina_Inst> findByCabTipoIdIn(@Param("ids") List<String> ids);

}
