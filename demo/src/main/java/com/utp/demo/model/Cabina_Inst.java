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

    @ManyToOne
    @JoinColumn(name = "cabinatipo")
    private Cabina_tipo cabTipo;

    public Cabina_Inst() {
    }

    public Cabina_Inst(int numadultos, Cabina_tipo cab_tipo) {
        super(numadultos);
        this.cabTipo = cab_tipo;
    }

    public String getCabinaId() {
        return cabinaId;
    }

    public void setCabinaId(String cabina_id) {
        this.cabinaId = cabina_id;
    }

    public Cabina_tipo getCabTipo() {
        return cabTipo;
    }

    public void setCabTipo(Cabina_tipo cab_tipo) {
        this.cabTipo = cab_tipo;
    }

    @Override
    public String getCab_tipo_id() {
        return cabTipo.getCabTipoId();
    }

    @Override
    public String getNombre_cab() {
        return cabTipo.getNombreCab();
    }

    @Override
    public int getCant_max_per() {
        return cabTipo.getCantMaxPer();
    }

    @Override
    public double getPrec_cabina_per() {
        return cabTipo.getPrecCabinaPer();
    }
}
