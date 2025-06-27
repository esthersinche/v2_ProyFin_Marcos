package com.utp.demo.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ruta")
public class Ruta {

    @Id
    @Column(name = "idruta")
    private String idruta;

    @Column(name = "nombreruta", nullable = false)
    private String nombreruta;

    @Column(name = "descripcionruta", length = 800)
    private String descripcionruta;

    @Column(name = "dias")
    private String diasruta;

    @Column(name = "precioruta")
    private double precioruta;

    @Column(name = "salida") //puerto
    private String salida;

    @Column(name = "imagen")
    private String imagen;

    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RutaBarco> rutaBarcos = new HashSet<>();

    // --- RELACIÓN M:N CON BARCO ---
    /* @ManyToMany
    @JoinTable(
            name = "RUTA_BARCO",
            joinColumns = @JoinColumn(name = "idruta"),
            inverseJoinColumns = @JoinColumn(name = "idbarco")
    )
    private Set<Barcos> barcos = new HashSet<>();*/
    

    public Ruta() {
    }

    public Ruta(String idruta, String nombreruta, String descripcionruta, String diasruta, double precioruta,
            String salida, String imagen, Set<RutaBarco> rutaBarcos) {
        this.idruta = idruta;
        this.nombreruta = nombreruta;
        this.descripcionruta = descripcionruta;
        this.diasruta = diasruta;
        this.precioruta = precioruta;
        this.salida = salida;
        this.imagen = imagen;
        this.rutaBarcos = rutaBarcos;
    }

    public String getIdruta() {
        return idruta;
    }

    public void setIdruta(String idruta) {
        this.idruta = idruta;
    }

    public String getNombreruta() {
        return nombreruta;
    }

    public void setNombreruta(String nombreruta) {
        this.nombreruta = nombreruta;
    }

    public String getDescripcionruta() {
        return descripcionruta;
    }

    public void setDescripcionruta(String descripcionruta) {
        this.descripcionruta = descripcionruta;
    }

    public String getDiasruta() {
        return diasruta;
    }

    public void setDiasruta(String diasruta) {
        this.diasruta = diasruta;
    }

    public double getPrecioruta() {
        return precioruta;
    }

    public void setPrecioruta(double precioruta) {
        this.precioruta = precioruta;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Set<RutaBarco> getRutaBarcos() {
        return rutaBarcos;
    }

    public void setRutaBarcos(Set<RutaBarco> rutaBarcos) {
        this.rutaBarcos = rutaBarcos;
    }

}
