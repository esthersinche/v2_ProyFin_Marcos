package com.utp.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "RESERVA")
public class Reserva {

    @ManyToOne
    @JoinColumn(name = "dni_cliente", referencedColumnName = "dni_cliente") // Relación con Cliente
    private Cliente cliente; // Cliente que realiza la reserva

    @ManyToOne
    @JoinColumn(name = "id_ruta", referencedColumnName = "id_ruta") // Relación con Ruta
    private Ruta ruta; // Ruta seleccionada para la reserva

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paquete") // Relación con Paquete
    private List<Paquete> paquetes; // Paquetes seleccionados para la reserva

    @ManyToOne
    @JoinColumn(name = "id_cabina", referencedColumnName = "id_cabina") // Relación con Cabina
    private Cabina cabina; // Cabina reservada

    @Column(name = "cantidad_pasajeros")
    private int cantidadPasajeros; // Número de pasajeros

    @Column(name = "total")
    private double total; // Total de la reserva

    public Reserva() {
        // Constructor vacío para JPA
    }

    // Getters y setters
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
