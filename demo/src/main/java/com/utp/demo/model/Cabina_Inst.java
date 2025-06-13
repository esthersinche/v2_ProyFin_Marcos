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
    private Long cabina_id;

    @ManyToOne
    @JoinColumn(name = "cabinatipo")
    private Cabina_tipo cab_tipo;

    public Cabina_Inst() {
    }

    public Cabina_Inst(int numadultos, Cabina_tipo cab_tipo) {
        super(numadultos);
        this.cab_tipo = cab_tipo;
    }

    public Long getCabina_id() {
        return cabina_id;
    }

    public void setCabina_id(Long cabina_id) {
        this.cabina_id = cabina_id;
    }

    public Cabina_tipo getCab_tipo() {
        return cab_tipo;
    }

    public void setCab_tipo(Cabina_tipo cab_tipo) {
        this.cab_tipo = cab_tipo;
    }

    @Override
    public String getCab_tipo_id() {
        return cab_tipo.getCab_tipo_id();
    }

    @Override
    public String getNombre_cab() {
        return cab_tipo.getNombre_cab();
    }

    @Override
    public int getCant_max_per() {
        return cab_tipo.getCant_max_per();
    }

    @Override
    public double getPrec_cabina_per() {
        return cab_tipo.getPrec_cabina_per();
    }
}
