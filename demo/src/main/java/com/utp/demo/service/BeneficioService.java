package com.utp.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utp.demo.model.Beneficio;

@Service
public class BeneficioService {
    private BeneficioRepository benerepo;

    public BeneficioService(BeneficioRepository benerepo) {
        this.benerepo = benerepo;
    }

    //lista de todos los beneficios
    public List<Beneficio> ObtenertodoslosBeneficios(){
        return benerepo.findAll();
    }

     


}
