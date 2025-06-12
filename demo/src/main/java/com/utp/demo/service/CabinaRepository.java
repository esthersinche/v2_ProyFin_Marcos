package com.utp.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.demo.model.Cabina;


public interface CabinaRepository extends JpaRepository<Cabina, Object>{
    List<Cabina> findByCab_tipo_id(String cab_tipo_id);
}