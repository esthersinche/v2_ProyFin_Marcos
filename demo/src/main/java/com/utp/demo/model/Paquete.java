package com.utp.demo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "Paquete")
public class Paquete {
    @Id
    @Column(name= "Id_paquete")
    private String Id_paquete;
    @Column(name= "nom_paquete")
    private String nom_paquete;
    @Column(name= "desc_paquete")
    private String desc_paquete;
    @ManyToMany
    @JoinTable(name= "Paq_Beneficios",joinColumns= @JoinColumn(name= "Id_paquete"),
    inverseJoinColumns= @JoinColumn(name= "id_bene")
    )
    private List<Beneficio> listabeneficiosxpaq;
    @Column(name= "prec_paquete_uni")
    private double prec_paquete_uni;
    
    public Paquete() {
    }

    public Paquete(String id_paquete, String nom_paquete, String desc_paquete, double prec_paquete_uni) {
        Id_paquete = id_paquete;
        this.nom_paquete = nom_paquete;
        this.desc_paquete = desc_paquete;
        this.prec_paquete_uni = prec_paquete_uni;
    }

    public String getId_paquete() {
        return Id_paquete;
    }

    public void setId_paquete(String id_paquete) {
        Id_paquete = id_paquete;
    }

    public String getNom_paquete() {
        return nom_paquete;
    }

    public void setNom_paquete(String nom_paquete) {
        this.nom_paquete = nom_paquete;
    }

    public String getDesc_paquete() {
        return desc_paquete;
    }

    public void setDesc_paquete(String desc_paquete) {
        this.desc_paquete = desc_paquete;
    }

    public List<Beneficio> getListabeneficiosxpaq() {
        return listabeneficiosxpaq;
    }

    public void setListabeneficiosxpaq(List<Beneficio> listabeneficiosxpaq) {
        this.listabeneficiosxpaq = listabeneficiosxpaq;
    }

    public double getPrec_paquete_uni() {
        return prec_paquete_uni;
    }

    public void setPrec_paquete_uni(double prec_paquete_uni) {
        this.prec_paquete_uni = prec_paquete_uni;
    }

    public void addbene(Beneficio benef){
        listabeneficiosxpaq.add(benef);

    }

    

    


    /* 
    private String nombre_paq;
    private Cabina_tipo cabinatipo_paq;
    private String descripcion_paq;
    private Ruta ruta_paq;
    private Modelobarco modelobarco_paq;
    */

    
    //private double precio_paq;//por una persona, se multiplicara al comprar

    
    /* 

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
    */

}