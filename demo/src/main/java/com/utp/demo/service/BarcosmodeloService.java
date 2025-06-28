package com.utp.demo.service;

import org.springframework.stereotype.Service;

import com.utp.demo.model.Barcos_modelo;

@Service
public class BarcosmodeloService {
    private BarcosmodeloRepository barcmoderepo;

    public BarcosmodeloService(BarcosmodeloRepository barcmoderepo) {
        this.barcmoderepo = barcmoderepo;
    }

    public Barcos_modelo buscarxId(String modelo){
        return barcmoderepo.findById(modelo).orElse(null);

    }
    
}
