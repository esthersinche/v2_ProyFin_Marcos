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
public abstract class Barcos {

    @Id
    @Column(name = "id_barco")
    private String ID_barco;

    @Column(name = "nombre_barco")
    private String nombre_barco;

    @Column(name = "capitan_barco")
    private String capitan_barco;

    @ManyToOne
    @JoinColumn(name = "modelo", foreignKey = @ForeignKey(name = "FK_Barco_Modelo"))
    private Barcos_modelo modelo_barco;

    @Column(name = "descripcion_barco")
    private String descripcion_barco;

    @Column(name = "recreacion")
    private String recreacion;

    @Column(name = "imagen_barco")
    private String imagen_barco;

    public Barcos() {
    }

    public Barcos(String id_barco, String nombre_barco, String capitan_barco, Barcos_modelo modelo_barco,
            String descripcion_barco, String recreacion, String imagen_barco) {
        this.ID_barco = id_barco;
        this.nombre_barco = nombre_barco;
        this.capitan_barco = capitan_barco;
        this.modelo_barco = modelo_barco;
        this.descripcion_barco = descripcion_barco;
        this.recreacion = recreacion;
        this.imagen_barco = imagen_barco;
    }

    public String getID_barco() {
        return ID_barco;
    }

    public void setID_barco(String ID_barco) {
        this.ID_barco = ID_barco;
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

    public Barcos_modelo getModelo_barco() {
        return modelo_barco;
    }

    public void setModelo_barco(Barcos_modelo modelo_barco) {
        this.modelo_barco = modelo_barco;
    }

    public String getDescripcion_barco() {
        return descripcion_barco;
    }

    public void setDescripcion_barco(String descripcion_barco) {
        this.descripcion_barco = descripcion_barco;
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

    public int getCapacidadTotal() {
        return modelo_barco != null ? modelo_barco.getCapacidad() : 0;
    }

    public int getTotalCabinas() {
        return modelo_barco != null ? modelo_barco.getTotalcabinas() : 0;
    }

    // Método abstracto para obtener el nombre del modelo
    public abstract String getNombreModelo();
}
