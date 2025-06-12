package com.utp.demo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Paquete")
public class Paquete {

    @Id
    @Column(name = "Id_paquete")
    private String id_paquete;

    @Column(name = "nom_paquete")
    private String nom_paquete;

    @Column(name = "desc_paquete")
    private String desc_paquete;

    @Column(name = "prec_paquete_uni")
    private double prec_paquete_uni;

    // Relación con Cabina_tipo
    @ManyToOne
    @JoinColumn(name = "cabinatipo") // FK en la tabla Paquete
    private Cabina_tipo cabinatipoPaq;

    // Relación con Ruta
    @ManyToOne
    @JoinColumn(name = "id_ruta") // FK en la tabla Paquete
    private Ruta rutaPaq;

    // Relación con Barcos_modelo
    @ManyToOne
    @JoinColumn(name = "id_modelo_barco") // FK en la tabla Paquete
    private Barcos_modelo modelobarcoPaq;

    // Relación con Beneficios (muchos a muchos)
    @ManyToMany
    @JoinTable(
        name = "Paq_Beneficios",
        joinColumns = @JoinColumn(name = "Id_paquete"),
        inverseJoinColumns = @JoinColumn(name = "id_bene")
    )
    private List<Beneficio> listabeneficiosxpaq;

    public Paquete() {}

    public Paquete(String id_paquete, String nom_paquete, String desc_paquete, double prec_paquete_uni) {
        this.id_paquete = id_paquete;
        this.nom_paquete = nom_paquete;
        this.desc_paquete = desc_paquete;
        this.prec_paquete_uni = prec_paquete_uni;
    }

    // Getters y Setters

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

    public List<Beneficio> getListabeneficiosxpaq() {
        return listabeneficiosxpaq;
    }

    public void setListabeneficiosxpaq(List<Beneficio> listabeneficiosxpaq) {
        this.listabeneficiosxpaq = listabeneficiosxpaq;
    }

    public void addbene(Beneficio benef) {
        this.listabeneficiosxpaq.add(benef);
    }
}
