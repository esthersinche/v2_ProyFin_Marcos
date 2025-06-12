package com.utp.demo.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name= "RESERVA")
public class Reserva {
    @Id
    @Column(name = "id_reserva")
    private String id_reserva;
    @Column(name = "dni_cliente")
    private Cliente cliente;
    @Column(name = "id_ruta")    
    private Ruta ruta;
    @Column(name = "id_paquete")   
    private Paquete paquetes;
    @Column(name = "id_cabina")   
    private Cabina cabina;
    @Column(name = "id_barco")   
    private Barcos barco;

    @Column(name = "cantidad_pasajeros")   
    private int cantidadPasajeros;

    @Column(name = "fecha_reserva")   
    private Date fecha_reserva;

    @Column(name = "total")   
    private double total;

    public Reserva() {
        // Constructor vacío Spring necesita poder crear el objeto sin argumentos.
        // para instanciarlo automaticamente
    }


    public Reserva(Barcos barco, Cabina cabina, int cantidadPasajeros, Cliente cliente, Date fecha_reserva, String id_reserva, Paquete paquetes, Ruta ruta, double total) {
        this.barco = barco;
        this.cabina = cabina;
        this.cantidadPasajeros = cantidadPasajeros;
        this.cliente = cliente;
        this.fecha_reserva = fecha_reserva;
        this.id_reserva = id_reserva;
        this.paquetes = paquetes;
        this.ruta = ruta;
        this.total = total;
    }
    public String getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(String id_reserva) {
        this.id_reserva = id_reserva;
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

    public Paquete getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(Paquete paquetes) {
        this.paquetes = paquetes;
    }

    public Cabina getCabina() {
        return cabina;
    }

    public void setCabina(Cabina cabina) {
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

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    

}
