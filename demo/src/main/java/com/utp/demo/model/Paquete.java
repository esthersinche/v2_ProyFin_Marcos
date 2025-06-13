package com.utp.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Paquete")
public class Paquete {

    @Id
    @Column(name = "Id_paquete")
    private String idPaquete;

    @Column(name = "nombre_paq")
    private String nomPaquete;

    @Column(name = "descripcion_paq")
    private String descPaquete;

    @Column(name = "precio_paq")
    private double precPaqueteUni;
    /* 
    @ManyToOne
    @JoinColumn(name = "cabinatipo")
    private Cabina_tipo cabinatipoPaq;

    @ManyToOne
    @JoinColumn(name = "id_ruta")
    private Ruta rutaPaq;

    @ManyToOne
    @JoinColumn(name = "id_modelo_barco")
    private Barcos_modelo modelobarcoPaq;
     */

    @OneToMany(mappedBy = "paquete")
    private List<PaqueteBeneficio> beneficios = new ArrayList<>();

    public Paquete() {
    }

    public Paquete(String id_paquete, String nom_paquete, String desc_paquete, double prec_paquete_uni) {
        this.idPaquete = id_paquete;
        this.nomPaquete = nom_paquete;
        this.descPaquete = desc_paquete;
        this.precPaqueteUni = prec_paquete_uni;
    }

    public String getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(String id_paquete) {
        this.idPaquete = id_paquete;
    }

    public String getNomPaquete() {
        return nomPaquete;
    }

    public void setNomPaquete(String nom_paquete) {
        this.nomPaquete = nom_paquete;
    }

    public String getDescPaquete() {
        return descPaquete;
    }

    public void setDescPaquete(String desc_paquete) {
        this.descPaquete = desc_paquete;
    }

    public double getPrecPaqueteUni() {
        return precPaqueteUni;
    }

    public void setPrecPaqueteUni(double prec_paquete_uni) {
        this.precPaqueteUni = prec_paquete_uni;
    }

    /* 
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
     */
    public List<PaqueteBeneficio> getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(List<PaqueteBeneficio> beneficios) {
        this.beneficios = beneficios;
    }
}
