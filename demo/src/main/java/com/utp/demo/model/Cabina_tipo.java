package com.utp.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CABINATIPO")
public class Cabina_tipo {

    @Id
    @Column(name = "cabinatipo")
    private String cabTipoId;

    @Column(name = "nombre_cabina")
    private String nombreCab;

    @Column(name = "cant_max_per")
    private int cantMaxPer;

    @Column(name = "prec_cabina_per")
    private double precCabinaPer;

    public Cabina_tipo() {
    }

    public Cabina_tipo(String cab_tipo_id, String nombre_cab, int cant_max_per, double prec_cabina_per) {
        this.cabTipoId = cab_tipo_id;
        this.nombreCab = nombre_cab;
        this.cantMaxPer = cant_max_per;
        this.precCabinaPer = prec_cabina_per;
    }

    public String getCabTipoId() {
        return cabTipoId;
    }

    public void setCabTipoId(String cab_tipo_id) {
        this.cabTipoId = cab_tipo_id;
    }

    public String getNombreCab() {
        return nombreCab;
    }

    public void setNombreCab(String nombre_cab) {
        this.nombreCab = nombre_cab;
    }

    public int getCantMaxPer() {
        return cantMaxPer;
    }

    public void setCantMaxPer(int cant_max_per) {
        this.cantMaxPer = cant_max_per;
    }

    public double getPrecCabinaPer() {
        return precCabinaPer;
    }

    public void setPrecCabinaPer(double prec_cabina_per) {
        this.precCabinaPer = prec_cabina_per;
    }
}
