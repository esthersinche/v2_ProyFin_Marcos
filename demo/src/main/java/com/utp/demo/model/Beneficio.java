package com.utp.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "BENEFICIO")
public class Beneficio {

    @Id
    @Column(name = "idbeneficio")
    private String idBene;

    @Column(name = "nombrebeneficio")
    private String nombreBene;

    @Column(name = "descripcionbeneficio")
    private String descBene;

    @OneToMany(mappedBy = "beneficio")
    private List<PaqueteBeneficio> beneficiosPorPaquete = new ArrayList<>();

    public Beneficio() {
    }

    public Beneficio(String id_bene, String nombre_bene, String desc_bene) {
        this.idBene = id_bene;
        this.nombreBene = nombre_bene;
        this.descBene = desc_bene;
    }

    public String getIdBene() {
        return idBene;
    }

    public void setIdBene(String id_bene) {
        this.idBene = id_bene;
    }

    public String getNombreBene() {
        return nombreBene;
    }

    public void setNombreBene(String nombre_bene) {
        this.nombreBene = nombre_bene;
    }

    public String getDescBene() {
        return descBene;
    }

    public void setDescBene(String desc_bene) {
        this.descBene = desc_bene;
    }

    public List<PaqueteBeneficio> getBeneficiosPorPaquete() {
        return beneficiosPorPaquete;
    }

    public void setBeneficiosPorPaquete(List<PaqueteBeneficio> beneficiosPorPaquete) {
        this.beneficiosPorPaquete = beneficiosPorPaquete;
    }
}
