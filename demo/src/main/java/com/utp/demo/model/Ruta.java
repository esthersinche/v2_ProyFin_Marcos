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
    private String Id_ruta;

    @Column(name = "nombre_ruta", nullable = false)
    private String nombre_ruta;

    @Column(name = "descripcion_ruta", length = 800)
    private String descripcion_ruta;

    @Column(name = "dias")
    private String dias_ruta;

    @Column(name = "precio_ruta")
    private double precio_ruta;

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

    public Ruta(String id_ruta, String nombre_ruta, String descripcion_ruta, String dias_ruta, double precio_ruta,
            String salida, String imagen) {
        Id_ruta = id_ruta;
        this.nombre_ruta = nombre_ruta;
        this.descripcion_ruta = descripcion_ruta;
        this.dias_ruta = dias_ruta;
        this.precio_ruta = precio_ruta;
        this.salida = salida;
        this.imagen = imagen;
    }

    public String getId_ruta() {
        return Id_ruta;
    }

    public void setId_ruta(String id_ruta) {
        Id_ruta = id_ruta;
    }

    public String getNombre_ruta() {
        return nombre_ruta;
    }

    public void setNombre_ruta(String nombre_ruta) {
        this.nombre_ruta = nombre_ruta;
    }

    public String getDescripcion_ruta() {
        return descripcion_ruta;
    }

    public void setDescripcion_ruta(String descripcion_ruta) {
        this.descripcion_ruta = descripcion_ruta;
    }

    public String getDias_ruta() {
        return dias_ruta;
    }

    public void setDias_ruta(String dias_ruta) {
        this.dias_ruta = dias_ruta;
    }

    public double getPrecio_ruta() {
        return precio_ruta;
    }

    public void setPrecio_ruta(double precio_ruta) {
        this.precio_ruta = precio_ruta;
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
