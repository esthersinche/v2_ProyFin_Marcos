package com.utp.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.demo.model.Cabina_Inst;
import com.utp.demo.model.Cabina_tipo;

public interface CabinaRepository extends JpaRepository<Cabina_Inst, Long> {
    List<Cabina_Inst> findByCab_tipo_Cab_tipo_id(String cab_tipo_id);

    Cabina_Inst findFirstByCab_tipo(Cabina_tipo cabTipo);

}
