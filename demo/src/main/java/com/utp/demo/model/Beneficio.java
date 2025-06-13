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
    @Column(name = "id_beneficio")
    private String id_bene;

    @Column(name = "nombre_beneficio")
    private String nombre_bene;

    @Column(name = "descripcion_beneficio")
    private String desc_bene;

    @OneToMany(mappedBy = "beneficio")
    private List<PaqueteBeneficio> beneficiosPorPaquete = new ArrayList<>();

    public Beneficio() {
    }

    public Beneficio(String id_bene, String nombre_bene, String desc_bene) {
        this.id_bene = id_bene;
        this.nombre_bene = nombre_bene;
        this.desc_bene = desc_bene;
    }

    public String getId_bene() {
        return id_bene;
    }

    public void setId_bene(String id_bene) {
        this.id_bene = id_bene;
    }

    public String getNombre_bene() {
        return nombre_bene;
    }

    public void setNombre_bene(String nombre_bene) {
        this.nombre_bene = nombre_bene;
    }

    public String getDesc_bene() {
        return desc_bene;
    }

    public void setDesc_bene(String desc_bene) {
        this.desc_bene = desc_bene;
    }

    public List<PaqueteBeneficio> getBeneficiosPorPaquete() {
        return beneficiosPorPaquete;
    }

    public void setBeneficiosPorPaquete(List<PaqueteBeneficio> beneficiosPorPaquete) {
        this.beneficiosPorPaquete = beneficiosPorPaquete;
    }
}
