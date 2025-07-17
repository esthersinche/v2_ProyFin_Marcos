package com.utp.demo.DTO;

import java.util.List;

public class PaqueteDTO {

    private String idPaquete;
    private String nomPaquete;
    private String descPaquete;
    private Double precPaqueteUni;
    private List<String> idsbeneficios;

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

    public List<String> getIdsbeneficios() {
        return idsbeneficios;
    }

    public void setIdsbeneficios(List<String> idsbeneficios) {
        this.idsbeneficios = idsbeneficios;
    }

    public Double getPrecPaqueteUni() {
        return precPaqueteUni;
    }

    public void setPrecPaqueteUni(Double precPaqueteUni) {
        this.precPaqueteUni = precPaqueteUni;
    }

}
