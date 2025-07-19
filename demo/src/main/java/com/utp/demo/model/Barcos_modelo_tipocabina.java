package com.utp.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipos")
public class Barcos_modelo_tipocabina {

    @EmbeddedId
    private Barcos_modelo_tipocabinaId idparaelcoso;

    @ManyToOne
    @MapsId("modelobarco")
    @JoinColumn(name = "modelo")
    @JsonBackReference
    private Barcos_modelo barmodel; //bar_model

    @ManyToOne
    @MapsId("cabtipoid")
    @JoinColumn(name = "cabinatipo")
    private Cabina_tipo cabtype; //cab_type

    @Column(name = "cantidad")
    private int cant;

    public Barcos_modelo_tipocabina() {
    }

    public Barcos_modelo_tipocabina(Barcos_modelo barmodel, Cabina_tipo cabtype, int cant) {
        this.barmodel = barmodel;
        this.cabtype = cabtype;
        this.cant = cant;
        this.idparaelcoso = new Barcos_modelo_tipocabinaId(barmodel.getModeloBarco(), cabtype.getCabTipoId());
    }

    public Barcos_modelo_tipocabinaId getIdparaelcoso() {
        return idparaelcoso;
    }

    public void setIdparaelcoso(Barcos_modelo_tipocabinaId idparaelcoso) {
        this.idparaelcoso = idparaelcoso;
    }

    public Barcos_modelo getBarmodel() {
        return barmodel;
    }

    public void setBarmodel(Barcos_modelo barmodel) {
        this.barmodel = barmodel;
    }

    public Cabina_tipo getCabtype() {
        return cabtype;
    }

    public void setCabtype(Cabina_tipo cabtype) {
        this.cabtype = cabtype;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
}
