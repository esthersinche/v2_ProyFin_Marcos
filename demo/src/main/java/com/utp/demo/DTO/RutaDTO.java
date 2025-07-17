// src/main/java/com/utp/demo/DTO/RutaDTO.java
package com.utp.demo.DTO;

import java.util.List;

public class RutaDTO {

    private String idruta;
    private String nombreruta;
    private String descripcionruta;
    private String diasruta;
    private double precioruta;
    private String salida;
    private String imagen;
    private List<String> modelos;

    // Constructors, getters y setters
    public RutaDTO() {
    }

    public String getIdruta() {
        return idruta;
    }

    public void setIdruta(String idruta) {
        this.idruta = idruta;
    }

    public String getNombreruta() {
        return nombreruta;
    }

    public void setNombreruta(String nombreruta) {
        this.nombreruta = nombreruta;
    }

    public String getDescripcionruta() {
        return descripcionruta;
    }

    public void setDescripcionruta(String descripcionruta) {
        this.descripcionruta = descripcionruta;
    }

    public String getDiasruta() {
        return diasruta;
    }

    public void setDiasruta(String diasruta) {
        this.diasruta = diasruta;
    }

    public double getPrecioruta() {
        return precioruta;
    }

    public void setPrecioruta(double precioruta) {
        this.precioruta = precioruta;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<String> getModelos() {
        return modelos;
    }

    public void setModelos(List<String> modelos) {
        this.modelos = modelos;
    }
}
