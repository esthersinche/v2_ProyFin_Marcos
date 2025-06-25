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

    public Cabina_tipo(String cabTipoId, String nombreCab, int cantMaxPer, double precCabinaPer) {
        this.cabTipoId = cabTipoId;
        this.nombreCab = nombreCab;
        this.cantMaxPer = cantMaxPer;
        this.precCabinaPer = precCabinaPer;
    }

    public String getCabTipoId() {
        return cabTipoId;
    }

    public void setCabTipoId(String cabTipoId) {
        this.cabTipoId = cabTipoId;
    }

    public String getNombreCab() {
        return nombreCab;
    }

    public void setNombreCab(String nombreCab) {
        this.nombreCab = nombreCab;
    }

    public int getCantMaxPer() {
        return cantMaxPer;
    }

    public void setCantMaxPer(int cantMaxPer) {
        this.cantMaxPer = cantMaxPer;
    }

    public double getPrecCabinaPer() {
        return precCabinaPer;
    }

    public void setPrecCabinaPer(double precCabinaPer) {
        this.precCabinaPer = precCabinaPer;
    }
}
