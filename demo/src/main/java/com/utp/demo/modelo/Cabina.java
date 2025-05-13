package com.utp.demo.modelo;

public class Cabina {
    private String nombre_cab;
    private double precio;
    private int cantidad_personas;
    private int cantidad_niños;

    public Cabina(String nombre_cab, double precio, int cantidad_personas, int cantidad_niños) {
        this.nombre_cab = nombre_cab;
        this.precio = precio;
        this.cantidad_personas = cantidad_personas;
        this.cantidad_niños = cantidad_niños;
    }

    public String getNombre_cab() {
        return nombre_cab;
    }

    public void setNombre_cab(String nombre_cab) {
        this.nombre_cab = nombre_cab;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad_personas() {
        return cantidad_personas;
    }

    public void setCantidad_personas(int cantidad_personas) {
        this.cantidad_personas = cantidad_personas;
    }

    public int getCantidad_niños() {
        return cantidad_niños;
    }

    public void setCantidad_niños(int cantidad_niños) {
        this.cantidad_niños = cantidad_niños;
    }

}
