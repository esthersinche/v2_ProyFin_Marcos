package com.utp.demo.model.DTO;

import java.util.List;

public class BarcoDTO {
    private String idBarco;
    private String nombreBarco;
    private String capitanBarco;
    private String modeloBarco;
    private String imgURLbarco; 
    private String descripcionBarco;
    public List<String> idsrutasbarco;
    
    public BarcoDTO() {
    }

    public String getIdBarco() {
        return idBarco;
    }

    public void setIdBarco(String idBarco) {
        this.idBarco = idBarco;
    }

    public String getNombreBarco() {
        return nombreBarco;
    }

    public void setNombreBarco(String nombreBarco) {
        this.nombreBarco = nombreBarco;
    }

    public String getCapitanBarco() {
        return capitanBarco;
    }

    public void setCapitanBarco(String capitanBarco) {
        this.capitanBarco = capitanBarco;
    }

    public String getModeloBarco() {
        return modeloBarco;
    }

    public void setModeloBarco(String modeloBarco) {
        this.modeloBarco = modeloBarco;
    }

    public List<String> getIdsrutasbarco() {
        return idsrutasbarco;
    }

    public void setIdsrutasbarco(List<String> idsrutasbarco) {
        this.idsrutasbarco = idsrutasbarco;
    }

    public String getImgURLbarco() {
        return imgURLbarco;
    }

    public void setImgURLbarco(String imgURLbarco) {
        this.imgURLbarco = imgURLbarco;
    }

    public String getDescripcionBarco() {
        return descripcionBarco;
    }

    public void setDescripcionBarco(String descripcionBarco) {
        this.descripcionBarco = descripcionBarco;
    }

    

    

}
