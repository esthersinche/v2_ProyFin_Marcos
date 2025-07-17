package com.utp.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.utp.demo.DTO.BeneficioDTO;
import com.utp.demo.model.Beneficio;

@Service
public class BeneficioService {

    private BeneficioRepository benerepo;

    public BeneficioService(BeneficioRepository benerepo) {
        this.benerepo = benerepo;
    }

    private BeneficioDTO toDTO(Beneficio b) {
        return new BeneficioDTO(
                b.getIdBene(),
                b.getNombreBene(),
                b.getDescBene()
        );
    }

    public List<BeneficioDTO> obtenerBeneficiosDTO() {
        return benerepo.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    //lista de todos los beneficios
    public List<Beneficio> ObtenertodoslosBeneficios() {
        return benerepo.findAll();
    }

    public Beneficio BuscarBeneficioxID(String id) {
        return benerepo.findById(id).orElse(null);

    }

    public Beneficio guardarBeneficio(Beneficio bene) {
        return benerepo.save(bene);
    }

}
