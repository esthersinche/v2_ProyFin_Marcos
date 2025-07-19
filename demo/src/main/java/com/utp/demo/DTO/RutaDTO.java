// src/main/java/com/utp/demo/DTO/RutaDTO.java
package com.utp.demo.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.utp.demo.model.Ruta;

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

    public static RutaDTO fromEntity(Ruta ruta) {
        System.out.println("ruta omfg: "+ ruta.getIdruta());
    RutaDTO dto = new RutaDTO();
    dto.setIdruta(ruta.getIdruta());
    dto.setNombreruta(ruta.getNombreruta());
    dto.setDescripcionruta(ruta.getDescripcionruta());
    dto.setDiasruta(ruta.getDiasruta());
    dto.setPrecioruta(ruta.getPrecioruta());
    dto.setSalida(ruta.getSalida());
    dto.setImagen(ruta.getImagen());

    // Opcional: si quieres obtener solo los modelos (nombres, no objetos completos)
    List<String> modelos = ruta.getRutaBarcos().stream()
        .map(rutaBarco -> rutaBarco.getBarco().getBarmodel().getModeloBarco())
        .distinct()
        .collect(Collectors.toList());

    dto.setModelos(modelos);

    return dto;
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
