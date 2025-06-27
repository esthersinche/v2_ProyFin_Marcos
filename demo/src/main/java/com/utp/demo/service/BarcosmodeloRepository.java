package com.utp.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.demo.model.Barcos_modelo;

public interface BarcosmodeloRepository extends JpaRepository<Barcos_modelo, String>{
    //namas para tener los metodos q necesito del id y nombre
    
}
