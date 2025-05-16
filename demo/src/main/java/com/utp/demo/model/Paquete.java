package com.utp.demo.model;

import com.utp.demo.model.Barcos.Modelobarco;
import com.utp.demo.model.Cabina.Cabina_tipo;

public class Paquete {

    private String nombre_paq;
    private Cabina_tipo cabinatipo_paq;
    private String descripcion_paq;
    private Ruta ruta_paq;
    private Modelobarco modelobarco_paq;
    //private double precio_paq;//por una persona, se multiplicara al comprar

    public Paquete(String nombre_paq, Cabina_tipo cabinatipo_paq, String descripcion_paq, Ruta ruta_paq,
            Modelobarco modelobarco_paq) {
        this.nombre_paq = nombre_paq;
        this.cabinatipo_paq = cabinatipo_paq;
        this.descripcion_paq = descripcion_paq;
        this.ruta_paq = ruta_paq;
        this.modelobarco_paq = modelobarco_paq;
    }

    public String getNombre_paq() {
        return nombre_paq;
    }

    public void setNombre_paq(String nombre_paq) {
        this.nombre_paq = nombre_paq;
    }

    public Cabina_tipo getCabinatipo_paq() {
        return cabinatipo_paq;
    }

    public void setCabinatipo_paq(Cabina_tipo cabinatipo_paq) {
        this.cabinatipo_paq = cabinatipo_paq;
    }

    public String getDescripcion_paq() {
        return descripcion_paq;
    }

    public void setDescripcion_paq(String descripcion_paq) {
        this.descripcion_paq = descripcion_paq;
    }

    public Ruta getRuta_paq() {
        return ruta_paq;
    }

    public void setRuta_paq(Ruta ruta_paq) {
        this.ruta_paq = ruta_paq;
    }

    public Modelobarco getModelobarco_paq() {
        return modelobarco_paq;
    }

    public void setModelobarco_paq(Modelobarco modelobarco_paq) {
        this.modelobarco_paq = modelobarco_paq;
    }

    public double getPrec_paq_uni() {
        return this.cabinatipo_paq.getPrec_cabina_per() + 300 + ruta_paq.getPrecio_ruta();
    }//300 es precio descripcion paquetes, lo hare dsps no hay tiempo
    //en otra clase multiplicarlo por la cant de personas

}
