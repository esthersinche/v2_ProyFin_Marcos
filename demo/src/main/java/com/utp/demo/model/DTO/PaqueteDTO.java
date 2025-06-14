package com.utp.demo.model.DTO;

import java.util.List;

import com.utp.demo.model.Beneficio;

public class PaqueteDTO {
    private String idPaquete;
    private String nomPaquete;
    private String descPaquete;
    private List<Beneficio> beneficios;

    public PaqueteDTO() {
    }



public String getIdPaquete() {
    return idPaquete;
}

public void setIdPaquete(String idPaquete) {
    this.idPaquete = idPaquete;
}

public String getNomPaquete() {
    return nomPaquete;
}

public void setNomPaquete(String nomPaquete) {
    this.nomPaquete = nomPaquete;
}

public String getDescPaquete() {
    return descPaquete;
}

public void setDescPaquete(String descPaquete) {
    this.descPaquete = descPaquete;
}

public List<Beneficio> getBeneficios() {
    return beneficios;
}

public void setBeneficios(List<Beneficio> beneficios) {
    this.beneficios = beneficios;
}    

    

    
    
}
