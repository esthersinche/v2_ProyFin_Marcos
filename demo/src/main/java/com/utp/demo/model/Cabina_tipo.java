package com.utp.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "Cabina_tipo")
public class Cabina_tipo {//metadata
    @Id
    @Column(name= "cabinatipo")
    private String cab_tipo_id;//inf, ext, cbal, suit, fam
    @Column(name= "nombre_cabina")
    private String nombre_cab;
    @Column(name= "cant_max_per")
    private int cant_max_per;
    @Column(name= "prec_cabina_per")
    private double prec_cabina_per;

    //para el jpa
    public Cabina_tipo() {
    }

    public Cabina_tipo(String cab_tipo_id, String nombre_cab, int cant_max_per, double prec_cabina_per) {
        this.cab_tipo_id = cab_tipo_id;
        this.nombre_cab = nombre_cab;
        this.cant_max_per = cant_max_per;
        this.prec_cabina_per = prec_cabina_per;
    }

    public String getCab_tipo_id() {
        return cab_tipo_id;
    }

    public void setCab_tipo_id(String cab_tipo_id) {
        this.cab_tipo_id = cab_tipo_id;
    }

    public String getNombre_cab() {
        return nombre_cab;
    }

    public void setNombre_cab(String nombre_cab) {
        this.nombre_cab = nombre_cab;
    }

    public int getCant_max_per() {
        return cant_max_per;
    }

    public void setCant_max_per(int cant_max_per) {
        this.cant_max_per = cant_max_per;
    }

    public double getPrec_cabina_per() {
        return prec_cabina_per;
    }

    public void setPrec_cabina_per(double prec_cabina_per) {
        this.prec_cabina_per = prec_cabina_per;
    }

    //metodos adicionales?


}