package com.utp.demo.modelo;

public class Barcos {

    private String id_barco;
    private String nombre;
    private String capitan;
    private int capacidad;
    private String recreacion;
    private String modelo;
    private String imagen;

    public Barcos(String id_barco, String nombre, String capitan, int capacidad, String recreacion, String modelo,
            String imagen) {
        this.id_barco = id_barco;
        this.nombre = nombre;
        this.capitan = capitan;
        this.capacidad = capacidad;
        this.recreacion = recreacion;
        this.modelo = modelo;
        this.imagen = imagen;
    }

    public String getId_barco() {
        return id_barco;
    }

    public void setId_barco(String id_barco) {
        this.id_barco = id_barco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCapitan() {
        return capitan;
    }

    public void setCapitan(String capitan) {
        this.capitan = capitan;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getRecreacion() {
        return recreacion;
    }

    public void setRecreacion(String recreacion) {
        this.recreacion = recreacion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
