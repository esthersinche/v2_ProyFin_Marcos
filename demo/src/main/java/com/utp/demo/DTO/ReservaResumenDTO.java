package com.utp.demo.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.utp.demo.model.Reserva;

public class ReservaResumenDTO {

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaReserva;

    // Datos del cliente
    private String clienteNombre; // reserva.cliente.nombre + " " + reserva.cliente.apellido
    private int clienteDni; // reserva.cliente.dniCli
    private String clienteCorreo; // reserva.cliente.correo
    private int cantidadPasajeros; // reserva.cantidadPasajeros

    // Detalles de Ruta
    @JsonFormat(pattern = "dd/MM/yyyy")
    private String nombreRuta; //reserva.ruta.nombreruta
    private String puertoSalida; // reserva.ruta.salida (si es String)
    private String puertoDestino; // reserva.ruta.nombreruta o destino según tu modelo
    private String rutaDuracion; // reserva.ruta.diasruta
    private double subtotalRuta; // reserva.ruta.precioruta

    // Paquete escogido
    private String paqueteNombre; // reserva.paquete.nomPaquete
    private String paqueteDescripcion; // reserva.paquete.descPaquete
    private double subtotalPaquete; // reserva.paquete.precPaqueteUni

    // Cabina escogida
    private String cabinaTipo; // reserva.cabina.cabTipo.nombreCab
    private double cabinaPrecioPorPersona; // reserva.cabina.cabTipo.precCabinaPer

    // Total a pagar
    private double total; // reserva.total
    private double precioUnitario;

    public ReservaResumenDTO() {
    }

    public static ReservaResumenDTO convertiraDTO(Reserva r) {
        ReservaResumenDTO dto = new ReservaResumenDTO();

        dto.fechaReserva = r.getFechaReserva();
        dto.clienteNombre = r.getCliente().getNombre() + " " + r.getCliente().getApellido();
        dto.clienteDni = r.getCliente().getDniCliente();
        dto.clienteCorreo = r.getCliente().getCorreo();
        dto.cantidadPasajeros = r.getCantidadPasajeros();

        if (r.getRuta() != null) {
            dto.nombreRuta = r.getRuta().getNombreruta();
            dto.puertoSalida = r.getRuta().getSalida();
            dto.puertoDestino = r.getRuta().getNombreruta();
            dto.rutaDuracion = r.getRuta().getDiasruta();
            dto.subtotalRuta = r.getRuta().getPrecioruta();
        }
        if (r.getPaquete() != null) {
            dto.paqueteNombre = r.getPaquete().getNomPaquete();
            dto.paqueteDescripcion = r.getPaquete().getDescPaquete();
            dto.subtotalPaquete = r.getPaquete().getPrecPaqueteUni();
        }
        if (r.getCabina() != null && r.getCabina().getCabTipo() != null) {
            dto.cabinaTipo = r.getCabina().getCabTipo().getNombreCab();
            dto.cabinaPrecioPorPersona = r.getCabina().getCabTipo().getPrecCabinaPer();
        }
        if (r.getCabina() != null && r.getPaquete() != null && r.getRuta() != null) {
            double precioUnit = r.getCabina().getCabTipo().getPrecCabinaPer()
                    + r.getPaquete().getPrecPaqueteUni()
                    + r.getRuta().getPrecioruta();
            dto.setPrecioUnitario(precioUnit);
        }

        dto.total = r.getTotal();
        return dto;

    }

    // ——— Getters y setters ———
    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate f) {
        this.fechaReserva = f;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String n) {
        this.clienteNombre = n;
    }

    public int getClienteDni() {
        return clienteDni;
    }

    public void setClienteDni(int d) {
        this.clienteDni = d;
    }

    public String getClienteCorreo() {
        return clienteCorreo;
    }

    public void setClienteCorreo(String c) {
        this.clienteCorreo = c;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int c) {
        this.cantidadPasajeros = c;
    }

    public String getPuertoSalida() {
        return puertoSalida;
    }

    public void setPuertoSalida(String p) {
        this.puertoSalida = p;
    }

    public String getPuertoDestino() {
        return puertoDestino;
    }

    public void setPuertoDestino(String p) {
        this.puertoDestino = p;
    }

    public String getRutaDuracion() {
        return rutaDuracion;
    }

    public void setRutaDuracion(String r) {
        this.rutaDuracion = r;
    }

    public double getSubtotalRuta() {
        return subtotalRuta;
    }

    public void setSubtotalRuta(double s) {
        this.subtotalRuta = s;
    }

    public String getPaqueteNombre() {
        return paqueteNombre;
    }

    public void setPaqueteNombre(String p) {
        this.paqueteNombre = p;
    }

    public String getPaqueteDescripcion() {
        return paqueteDescripcion;
    }

    public void setPaqueteDescripcion(String d) {
        this.paqueteDescripcion = d;
    }

    public double getSubtotalPaquete() {
        return subtotalPaquete;
    }

    public void setSubtotalPaquete(double s) {
        this.subtotalPaquete = s;
    }

    public String getCabinaTipo() {
        return cabinaTipo;
    }

    public void setCabinaTipo(String t) {
        this.cabinaTipo = t;
    }

    public double getCabinaPrecioPorPersona() {
        return cabinaPrecioPorPersona;
    }

    public void setCabinaPrecioPorPersona(double p) {
        this.cabinaPrecioPorPersona = p;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double t) {
        this.total = t;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

}
