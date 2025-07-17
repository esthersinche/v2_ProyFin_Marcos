package com.utp.demo.DTO;

public class BeneficioDTO {

    private String idBene;
    private String nombreBene;
    private String descBene;

    public BeneficioDTO() {
    }

    public BeneficioDTO(String idBene, String nombreBene, String descBene) {
        this.idBene = idBene;
        this.nombreBene = nombreBene;
        this.descBene = descBene;
    }

    public String getIdBene() {
        return idBene;
    }

    public void setIdBene(String idBene) {
        this.idBene = idBene;
    }

    public String getNombreBene() {
        return nombreBene;
    }

    public void setNombreBene(String nombreBene) {
        this.nombreBene = nombreBene;
    }

    public String getDescBene() {
        return descBene;
    }

    public void setDescBene(String descBene) {
        this.descBene = descBene;
    }
}
