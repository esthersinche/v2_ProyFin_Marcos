package com.utp.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BARCO")
public class Barcos {

    @Id
    @Column(name = "id_barco")
    private String id_barco; // ID único del barco
    @Column(name = "nombre")
    private String nombre_barco; // Nombre del barco
    @Column(name = "capitan")
    private String capitan_barco; // Nombre del capitán del barco

    @ManyToOne
    @JoinColumn(name = "modelo", foreignKey = @ForeignKey(name = "FK_Barco_Modelo")) // Relación con MODELOBARCO
    private Modelobarco modelo; // Relación con el modelo del barco
    @Column(name = "recreacion")
    private String recreacion; // Actividades recreativas a bordo del barco
    @Column(name = "imagen")
    private String imagen_barco; // URL de la imagen del barco

    // Constructor vacío
    public Barcos() {
    }

    // Constructor con parámetros
    public Barcos(String id_barco, String nombre_barco, String capitan_barco, Modelobarco modelo, String recreacion,
            String imagen_barco) {
        this.id_barco = id_barco;
        this.nombre_barco = nombre_barco;
        this.capitan_barco = capitan_barco;
        this.modelo = modelo;
        this.recreacion = recreacion;
        this.imagen_barco = imagen_barco;
    }

    // Getters y Setters
    public String getId_barco() {
        return id_barco;
    }

    public void setId_barco(String id_barco) {
        this.id_barco = id_barco;
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

    public Modelobarco getModelo() {
        return modelo;
    }

    public void setModelo(Modelobarco modelo) {
        this.modelo = modelo;
    }

    public String getRecreacion() {
        return recreacion;
    }

    public void setRecreacion(String recreacion) {
        this.recreacion = recreacion;
    }

    public String getImagen_barco() {
        return imagen_barco;
    }

    public void setImagen_barco(String imagen_barco) {
        this.imagen_barco = imagen_barco;
    }
}
