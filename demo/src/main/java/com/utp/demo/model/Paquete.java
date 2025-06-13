package com.utp.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Paquete")
public class Paquete {

    @Id
    @Column(name = "Id_paquete")
    private String id_paquete;

    @Column(name = "nombre_paq")
    private String nom_paquete;

    @Column(name = "descripcion_paq")
    private String desc_paquete;

    @Column(name = "precio_paq")
    private double prec_paquete_uni;

    @ManyToOne
    @JoinColumn(name = "cabinatipo")
    private Cabina_tipo cabinatipoPaq;

    @ManyToOne
    @JoinColumn(name = "id_ruta")
    private Ruta rutaPaq;

    @ManyToOne
    @JoinColumn(name = "id_modelo_barco")
    private Barcos_modelo modelobarcoPaq;

    @OneToMany(mappedBy = "paquete")
    private List<PaqueteBeneficio> beneficios = new ArrayList<>();

    public Paquete() {
    }

    public Paquete(String id_paquete, String nom_paquete, String desc_paquete, double prec_paquete_uni) {
        this.id_paquete = id_paquete;
        this.nom_paquete = nom_paquete;
        this.desc_paquete = desc_paquete;
        this.prec_paquete_uni = prec_paquete_uni;
    }

    public String getId_paquete() {
        return id_paquete;
    }

    public void setId_paquete(String id_paquete) {
        this.id_paquete = id_paquete;
    }

    public String getNom_paquete() {
        return nom_paquete;
    }

    public void setNom_paquete(String nom_paquete) {
        this.nom_paquete = nom_paquete;
    }

    public String getDesc_paquete() {
        return desc_paquete;
    }

    public void setDesc_paquete(String desc_paquete) {
        this.desc_paquete = desc_paquete;
    }

    public double getPrec_paquete_uni() {
        return prec_paquete_uni;
    }

    public void setPrec_paquete_uni(double prec_paquete_uni) {
        this.prec_paquete_uni = prec_paquete_uni;
    }

    public Cabina_tipo getCabinatipoPaq() {
        return cabinatipoPaq;
    }

    public void setCabinatipoPaq(Cabina_tipo cabinatipoPaq) {
        this.cabinatipoPaq = cabinatipoPaq;
    }

    public Ruta getRutaPaq() {
        return rutaPaq;
    }

    public void setRutaPaq(Ruta rutaPaq) {
        this.rutaPaq = rutaPaq;
    }

    public Barcos_modelo getModelobarcoPaq() {
        return modelobarcoPaq;
    }

    public void setModelobarcoPaq(Barcos_modelo modelobarcoPaq) {
        this.modelobarcoPaq = modelobarcoPaq;
    }

    public List<PaqueteBeneficio> getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(List<PaqueteBeneficio> beneficios) {
        this.beneficios = beneficios;
    }
}
