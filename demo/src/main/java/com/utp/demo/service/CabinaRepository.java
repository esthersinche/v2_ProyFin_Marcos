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
      WHERE c.cabTipo.cabTipoId = :cabTipoId
    """)
    List<Cabina_Inst> findByCabTipoId(@Param("cabTipoId") String cabTipoId);

    @Query("""
      SELECT c
      FROM Cabina_Inst c
      WHERE c.cabTipo = :cabTipo
    """)
    Cabina_Inst findFirstByCabTipo(@Param("cabTipo") Cabina_tipo cabTipo);

    // ya hay findByCabTipoId lol(?)
    @Query("""
      SELECT c
      FROM Cabina_Inst c
      JOIN c.cabTipo t
      WHERE t.cabTipoId IN :ids
    """)
    List<Cabina_Inst> findByCabTipoIdIn(@Param("ids") List<String> ids);

}
