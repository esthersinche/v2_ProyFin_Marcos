package com.utp.demo.DTO.Fragmentos;

import com.utp.demo.model.Cliente;
import com.utp.demo.model.Reserva;

public class ClienteReservaDTO {
    
    private int dniCliente;
    private String nombre;
    private String apellido;
    private String correo;
    private int celular;
    private String ciudad;

    //mas la cantidad de pasajeros q pide el html
    private int cantidadpasajeros;

    public ClienteReservaDTO() {
    }

    public static ClienteReservaDTO convertiraDTOcli(Cliente cli){
        ClienteReservaDTO clidto= new ClienteReservaDTO();

        clidto.setDniCliente(cli.getDniCliente());
        clidto.setNombre(cli.getNombre());
        clidto.setApellido(cli.getApellido());
        clidto.setCorreo(cli.getCorreo());
        clidto.setCelular(cli.getCelular());
        clidto.setCiudad(cli.getCiudad());

        return clidto;
        
    }


    public int getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(int dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCantidadpasajeros() {
        return cantidadpasajeros;
    }

    public void setCantidadpasajeros(int cantidadpasajeros) {
        this.cantidadpasajeros = cantidadpasajeros;
    }

    

    

    
}
