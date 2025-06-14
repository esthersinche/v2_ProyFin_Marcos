package com.utp.demo.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ruta")
public class Ruta {

    @Id
    @Column(name = "id_ruta")
    private String idruta;

    @Column(name = "nombre_ruta", nullable = false)
    private String nombreruta;

    @Column(name = "descripcion_ruta", length = 800)
    private String descripcionruta;

    @Column(name = "dias")
    private String diasruta;

    @Column(name = "precio_ruta")
    private double precioruta;

    @Column(name = "salida")
    private String salida;

    @Column(name = "imagen")
    private String imagen;

    // --- RELACIÓN M:N CON BARCO ---
    @ManyToMany
    @JoinTable(
            name = "RUTA_BARCO",
            joinColumns = @JoinColumn(name = "id_ruta"),
            inverseJoinColumns = @JoinColumn(name = "id_barco")
    )
    private Set<Barcos> barcos = new HashSet<>();

    public Ruta() {
    }

    public Ruta(String idruta, String nombreruta, String descripcionruta, String diasruta, double precioruta,
            String salida, String imagen, Set<Barcos> barcos) {
        this.idruta = idruta;
        this.nombreruta = nombreruta;
        this.descripcionruta = descripcionruta;
        this.diasruta = diasruta;
        this.precioruta = precioruta;
        this.salida = salida;
        this.imagen = imagen;
        this.barcos = barcos;
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

    public Set<Barcos> getBarcos() {
        return barcos;
    }

    public void setBarcos(Set<Barcos> barcos) {
        this.barcos = barcos;
    }

}
