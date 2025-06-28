package com.utp.demo.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "RESERVA")
public class Reserva {

    @Id
    @Column(name = "idreserva", length = 20, nullable = false)
    private String idReserva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idruta")
    private Ruta ruta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idpaquete")
    private Paquete paquete;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_abina")
    private Cabina_Inst cabina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idbarco")
    private Barcos barco;

    @Column(name = "cantidadpasajeros")
    private int cantidadPasajeros;

    @Column(name = "fechareserva")
    private LocalDate fechaReserva;

    @Column(name = "total")
    private double total;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "dni_cliente", referencedColumnName = "dni_cliente")
    private Cliente cliente;

    public Reserva() {
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String id_reserva) {
        this.idReserva = id_reserva;
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

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public Cabina_Inst getCabina() {
        return cabina;
    }

    public void setCabina(Cabina_Inst cabina) {
        this.cabina = cabina;
    }

    public Barcos getBarco() {
        return barco;
    }

    public void setBarco(Barcos barco) {
        this.barco = barco;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
