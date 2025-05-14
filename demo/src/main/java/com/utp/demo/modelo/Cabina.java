package com.utp.demo.modelo;

public class Cabina {
    private String nombre_cab;
    private double precio;
    private int maximoAdultos;
    private int maximoNinos;

    public Cabina(String nombre_cab, double precio, int maximoAdultos, int maximoNinos) {
        this.nombre_cab = nombre_cab;
        this.precio = precio;
        this.maximoAdultos = maximoAdultos;
        this.maximoNinos = maximoNinos;
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

    public int getMaximoAdultos() {
        return maximoAdultos;
    }

    public void setMaximoAdultos(int maximoAdultos) {
        this.maximoAdultos = maximoAdultos;
    }

    public int getMaximoNinos() {
        return maximoNinos;
    }

    public void setMaximoNinos(int maximoNinos) {
        this.maximoNinos = maximoNinos;
    }

}
