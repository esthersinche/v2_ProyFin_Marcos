package com.utp.demo.model;

import java.util.List;

public class Reserva {

    private Cliente cliente;
    private Ruta ruta;
    private List<Paquete> paquetes;
    private Cabina cabina;

    // Cantidades de pasajeros
    private int cantidadPasajeros;

    // Total calculado de la reserva
    private double total;

    public Reserva() {
        // Constructor vacío Spring necesita poder crear el objeto sin argumentos.
        // para instanciarlo automaticamente
    }

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

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
