package com.utp.demo.modelo;

import java.util.List;

public class Reserva {

    private Cliente cliente;
    private Ruta ruta;
    private List<Paquete> paquetes;
    private Cabina cabina;

    // Cantidades de pasajeros
    private int cantidadAdultos;
    private int cantidadNinos;

    // Total calculado de la reserva
    private double total;

    public Reserva() {
        // Constructor vacío Spring necesita poder crear el objeto sin argumentos.
        // para instanciarlo automaticamente
    }

    // Getters y Setters

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

    public Cabina getCabina() {
        return cabina;
    }

    public void setCabina(Cabina cabina) {
        this.cabina = cabina;
    }

    public int getCantidadAdultos() {
        return cantidadAdultos;
    }

    public void setCantidadAdultos(int cantidadAdultos) {
        this.cantidadAdultos = cantidadAdultos;
    }

    public int getCantidadNinos() {
        return cantidadNinos;
    }

    public void setCantidadNinos(int cantidadNinos) {
        this.cantidadNinos = cantidadNinos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
