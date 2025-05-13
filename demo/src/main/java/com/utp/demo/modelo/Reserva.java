package com.utp.demo.modelo;

import java.util.List;

public class Reserva {
    private Cliente cliente;
    private Ruta ruta;
    private List<Paquete> paquetes;
    private Cabina cabina;

    public Reserva(Cliente cliente, Ruta ruta, List<Paquete> paquetes, Cabina cabina) {
        this.cliente = cliente;
        this.ruta = ruta;
        this.paquetes = paquetes;
        this.cabina = cabina;
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

}
