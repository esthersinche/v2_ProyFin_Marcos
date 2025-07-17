package com.utp.demo.DTO;


public class BarcoDTO {

    private String idBarco;
    private String nombreBarco;
    private String modeloBarco;
    private String capitanBarco;
    private int totalCabinas;
    private int capacidadTotal;

    private String descripcionBarco;
    private String imgURLbarco;

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

    public int getTotalCabinas() {
        return totalCabinas;
    }

    public void setTotalCabinas(int totalCabinas) {
        this.totalCabinas = totalCabinas;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public void setCapacidadTotal(int capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }

}
