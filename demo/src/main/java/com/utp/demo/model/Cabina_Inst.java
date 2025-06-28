package com.utp.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CABINA")
public class Cabina_Inst extends Cabina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cabina")
    private String cabinaId;

    //obtiene numadultos de Cabina
    @ManyToOne
    @JoinColumn(name = "cabinatipo")
    private Cabina_tipo cabTipo;

    public Cabina_Inst() {
    }

    public Cabina_Inst(int numadultos, Cabina_tipo cabTipo) {
        super(numadultos);
        this.cabTipo = cabTipo;
    }

    public String getCabinaId() {
        return cabinaId;
    }

    public void setCabinaId(String cabinaId) {
        this.cabinaId = cabinaId;

    }

    public Cabina_tipo getCabTipo() {
        return cabTipo;
    }

    public void setCabTipo(Cabina_tipo cabTipo) {
        this.cabTipo = cabTipo;
    }

    @Override
    public String getCabtipoid() {
        return cabTipo.getCabTipoId();
    }

    @Override
    public String getNombrecab() {
        return cabTipo.getNombreCab();
    }

    @Override
    public int getCantmaxper() {
        return cabTipo.getCantMaxPer();
    }

    @Override
    public double getPreccabinaper() {
        return cabTipo.getPrecCabinaPer();
    }
}
