package com.utp.demo.modelo;

public class Paquete {
    private String nombre_paq;
    private String descripcion_paq;
    private double precio_paq;

    public Paquete(String nombre_paq, String descripcion_paq, double precio_paq) {
        this.nombre_paq = nombre_paq;
        this.descripcion_paq = descripcion_paq;
        this.precio_paq = precio_paq;
    }

    public String getNombre_paq() {
        return nombre_paq;
    }

    public void setNombre_paq(String nombre_paq) {
        this.nombre_paq = nombre_paq;
    }

    public String getDescripcion_paq() {
        return descripcion_paq;
    }

    public void setDescripcion_paq(String descripcion_paq) {
        this.descripcion_paq = descripcion_paq;
    }

    public double getPrecio_paq() {
        return precio_paq;
    }

    public void setPrecio_paq(double precio_paq) {
        this.precio_paq = precio_paq;
    }

}
