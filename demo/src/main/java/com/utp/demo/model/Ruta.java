package com.utp.demo.model;

public class Ruta {

    private String nombre_ruta;
    private String descripcion_ruta;
    private String dias;
    private double precio_ruta;
    private String salida;
    private String imagen;

    public Ruta(String nombre_ruta, String descripcion_ruta, String dias, double precio_ruta, String salida,
            String imagen) {
        this.nombre_ruta = nombre_ruta;
        this.descripcion_ruta = descripcion_ruta;
        this.dias = dias;
        this.precio_ruta = precio_ruta;
        this.salida = salida;
        this.imagen = imagen;
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

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
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

}
