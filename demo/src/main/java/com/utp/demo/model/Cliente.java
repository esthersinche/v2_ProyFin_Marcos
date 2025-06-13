package com.utp.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @Column(name = "dni_cliente")
    private int dni_cliente;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "correo")
    private String correo;
    @Column(name = "celular")
    private int celular;
    @Column(name = "ciudad")
    private String ciudad;

    public Cliente() {
        // Obligatorio para Spring y formularios
    }

    public Cliente(String apellido, int celular, String ciudad, String correo, int dni_cliente, String nombre) {
        this.apellido = apellido;
        this.celular = celular;
        this.ciudad = ciudad;
        this.correo = correo;
        this.dni_cliente = dni_cliente;
        this.nombre = nombre;
    }

    public int getDni_cliente() {
        return dni_cliente;
    }

    public void setDni_cliente(int dni_cliente) {
        this.dni_cliente = dni_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

}
