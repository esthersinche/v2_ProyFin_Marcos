package com.utp.demo.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BARCO")
public class Barcos {

    @Id
    @Column(name = "id_barco")
    private String ID_barco;

    @Column(name = "nombre_barco")
    private String nombre_barco;

    @Column(name = "capitan_barco")
    private String capitan_barco;

    @ManyToOne
    @JoinColumn(name = "modelo")
    private Barcos_modelo bar_model;

    @Column(name = "descripcion_barco")
    private String descripcion_barco;

    @Column(name = "imagen_barco")
    private String imagen_barco;

    // --- RELACIÓN M:N INVERSA ---
    @ManyToMany(mappedBy = "barcos")
    private Set<Ruta> rutas = new HashSet<>();

    public Barcos() {
    }

    public Barcos(String iD_barco, String nombre_barco, String capitan_barco, Barcos_modelo bar_model,
            String descripcion_barco, String imagen_barco) {
        ID_barco = iD_barco;
        this.nombre_barco = nombre_barco;
        this.capitan_barco = capitan_barco;
        this.bar_model = bar_model;
        this.descripcion_barco = descripcion_barco;
        this.imagen_barco = imagen_barco;
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

    public Barcos_modelo getBar_model() {
        return bar_model;
    }

    public void setBar_model(Barcos_modelo bar_model) {
        this.bar_model = bar_model;
    }

    public String getDescripcion_barco() {
        return descripcion_barco;
    }

    public void setDescripcion_barco(String descripcion_barco) {
        this.descripcion_barco = descripcion_barco;
    }

    public String getImagen_barco() {
        return imagen_barco;
    }

    public void setImagen_barco(String imagen_barco) {
        this.imagen_barco = imagen_barco;
    }

    // auxiliares
    public int getCapacidadTotal() {
        return bar_model != null ? bar_model.getCapacidad() : 0;
    }

    public int getTotalCabinas() {
        return bar_model != null ? bar_model.getTotalcabinas() : 0;
    }

    public Set<Ruta> getRutas() {
        return rutas;
    }

    public void setRutas(Set<Ruta> rutas) {
        this.rutas = rutas;
    }

}
