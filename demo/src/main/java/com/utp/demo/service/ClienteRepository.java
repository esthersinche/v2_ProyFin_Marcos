package com.utp.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.demo.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}
