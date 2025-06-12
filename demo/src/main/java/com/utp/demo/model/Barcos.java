package com.utp.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BARCO")
public abstract class Barcos {

    @Id
    @Column(name = "id_barco")
    private String ID_barco;
    @Column(name = "nombre_barco")
    private String nombre_barco;
    @Column(name = "capitan_barco")
    private String capitan_barco;
    //el nombre del modelo estara en las hijas
    //la capacidad es un metodo
    //ruta sera lista inicializada en cada modelo de barco
    @ManyToOne
    @JoinColumn(name= "modelo")
    private Barcos_modelo modelo;
    @Column(name = "imagen_barco")
    private String imagen_barco;

    @Column(name = "descripcion_barco")
    private String descripcion;

    public Barcos(String iD_barco, String nombre_barco, String capitan_barco, Barcos_modelo modelo, String imagen_barco,
            String descripcion) {
        ID_barco = iD_barco;
        this.nombre_barco = nombre_barco;
        this.capitan_barco = capitan_barco;
        this.modelo = modelo;
        this.imagen_barco = imagen_barco;
        this.descripcion = descripcion;
    }


    public String getID_barco() {
        return ID_barco;
    }


    public void setID_barco(String iD_barco) {
        ID_barco = iD_barco;
    }


    public String getNombre_barco() {
        return nombre_barco;
    }

    public void setNombre_barco(String nombre_barco) {
        this.nombre_barco = nombre_barco;
    }


    public String getCapitan_barco() {
        return capitan_barco;
    }

    public void setCapitan_barco(String capitan_barco) {
        this.capitan_barco = capitan_barco;
    }

    public Barcos_modelo getModelo() {
        return modelo;
    }

    public void setModelo(Barcos_modelo modelo) {
        this.modelo = modelo;
    }

    public String getImagen_barco() {
        return imagen_barco;
    }

    public void setImagen_barco(String imagen_barco) {
        this.imagen_barco = imagen_barco;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //metodos abstractos para modelos de barco (3)
    public abstract String getModelo_barco();

}