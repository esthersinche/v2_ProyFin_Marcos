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
    private String IDbarco;

    @Column(name = "nombre_barco")
    private String nombrebarco;

    @Column(name = "capitan_barco")
    private String capitanbarco;

    @ManyToOne
    @JoinColumn(name = "modelo")
    private Barcos_modelo barmodel;

    @Column(name = "descripcion_barco")
    private String descripcionbarco;

    @Column(name = "imagen_barco")
    private String imagenbarco;

    // --- RELACIÓN M:N INVERSA ---
    @ManyToMany(mappedBy = "barcos")
    private Set<Ruta> rutas = new HashSet<>();

    public Barcos() {
    }


    public Barcos(String iDbarco, String nombrebarco, String capitanbarco, Barcos_modelo barmodel,
            String descripcionbarco, String imagenbarco, Set<Ruta> rutas) {
        IDbarco = iDbarco;
        this.nombrebarco = nombrebarco;
        this.capitanbarco = capitanbarco;
        this.barmodel = barmodel;
        this.descripcionbarco = descripcionbarco;
        this.imagenbarco = imagenbarco;
        this.rutas = rutas;
    }
   


    public String getIDbarco() {
        return IDbarco;
    }

    public void setIDbarco(String iDbarco) {
        IDbarco = iDbarco;
    }

    public String getNombrebarco() {
        return nombrebarco;
    }

    public void setNombrebarco(String nombrebarco) {
        this.nombrebarco = nombrebarco;
    }

    public String getCapitanbarco() {
        return capitanbarco;
    }

    public void setCapitanbarco(String capitanbarco) {
        this.capitanbarco = capitanbarco;
    }

    public Barcos_modelo getBarmodel() {
        return barmodel;
    }

    public void setBarmodel(Barcos_modelo barmodel) {
        this.barmodel = barmodel;
    }

    public String getDescripcionbarco() {
        return descripcionbarco;
    }

    public void setDescripcionbarco(String descripcionbarco) {
        this.descripcionbarco = descripcionbarco;
    }

    public String getImagenbarco() {
        return imagenbarco;
    }

    public void setImagenbarco(String imagenbarco) {
        this.imagenbarco = imagenbarco;
    }

    // auxiliares
    public int getCapacidadTotal() {
        return barmodel != null ? barmodel.getCapacidad() : 0;
    }//si no es null da valor, si es null da 0

    public int getTotalCabinas() {
        return barmodel != null ? barmodel.getTotalcabinas() : 0;
    }

    public Set<Ruta> getRutas() {
        return rutas;
    }

    public void setRutas(Set<Ruta> rutas) {
        this.rutas = rutas;
    }

}
