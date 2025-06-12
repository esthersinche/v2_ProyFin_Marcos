package com.utp.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//cabina asignada a una reserva

@Entity
@Table(name= "Cabina")

public class Cabina_Inst extends Cabina{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name= "cabina_id")
    private Long cabina_id;//no tiene nada q ver con cabina_tipo_id solo sirve para conectar con reserva
    //y para diferenciar instancias concretas en JPA, no esta en el constructor pq se genera solo

    @ManyToOne
    @JoinColumn(name= "Cabina_tipo")
    private Cabina_tipo cab_tipo;

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
    public int getCant_max_per() {
        return cab_tipo.getCant_max_per();
    }

    @Override
    public String getNombre_cab() {
        return cab_tipo.getNombre_cab();
    }

    @Override
    public double getPrec_cabina_per() {
        return cab_tipo.getCant_max_per();
    }

//metodos abstractos


}