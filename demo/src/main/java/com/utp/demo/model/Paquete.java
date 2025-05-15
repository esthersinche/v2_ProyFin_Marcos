package com.utp.demo.model;

public class Paquete {

    private String nombre_paq;
    private Cabina cabina_paq;
    private String descripcion_paq;
    private double precio_paq;//por una persona, se multiplicara al comprar
    

    public Paquete(String nombre_paq, Cabina cabina_paq, String descripcion_paq, double precio_paq) {
        this.nombre_paq = nombre_paq;
        this.cabina_paq = cabina_paq;
        this.descripcion_paq = descripcion_paq;
        this.precio_paq = precio_paq;
    }

    public String getNombre_paq() {
        return nombre_paq;
    }

    public void setNombre_paq(String nombre_paq) {
        this.nombre_paq = nombre_paq;
    }

    public Cabina getCabina_paq() {
        return cabina_paq;
    }

    public void setCabina_paq(Cabina cabina_paq) {
        this.cabina_paq = cabina_paq;
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
