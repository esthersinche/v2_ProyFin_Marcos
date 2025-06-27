package com.utp.demo.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "BARCO")
public class Barcos {

    @Id
    @Column(name = "idbarco")
    private String IDbarco;

    @Column(name = "nombrebarco")
    private String nombrebarco;

    @Column(name = "capitanbarco")
    private String capitanbarco;

    @ManyToOne
    @JoinColumn(name = "modelo")
    private Barcos_modelo barmodel;

    @Column(name = "descripcionbarco")
    private String descripcionbarco;

    @Column(name = "imagenbarco")
    private String imagenbarco;

    // --- RELACIÓN M:N INVERSA ---
    @OneToMany(mappedBy = "barco", cascade = CascadeType.ALL)
    private Set<RutaBarco> rutas = new HashSet<>();

    public Barcos() {
    }


    public Barcos(String iDbarco, String nombrebarco, String capitanbarco, Barcos_modelo barmodel,
            String descripcionbarco, String imagenbarco, Set<RutaBarco> rutas) {
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

    public Set<RutaBarco> getRutas() {
        return rutas;
    }

    public void setRutas(Set<RutaBarco> rutas) {
        this.rutas = rutas;
    }

}
