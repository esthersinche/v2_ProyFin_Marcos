package com.utp.demo.model;

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
    @MapsId("modelo_barco")
    @JoinColumn(name = "modelo")
    private Barcos_modelo bar_model;

    @ManyToOne
    @MapsId("cab_tipo_id")
    @JoinColumn(name = "cabinatipo")
    private Cabina_tipo cab_type;

    @Column(name = "cantidad")
    private int cant;

    public Barcos_modelo_tipocabina() {
    }

    public Barcos_modelo_tipocabina(Barcos_modelo bar_model, Cabina_tipo cab_type, int cant) {
        this.bar_model = bar_model;
        this.cab_type = cab_type;
        this.cant = cant;
        this.idparaelcoso = new Barcos_modelo_tipocabinaId(bar_model.getModelo_barco(), cab_type.getCabTipoId());
    }

    public Barcos_modelo_tipocabinaId getIdparaelcoso() {
        return idparaelcoso;
    }

    public void setIdparaelcoso(Barcos_modelo_tipocabinaId idparaelcoso) {
        this.idparaelcoso = idparaelcoso;
    }

    public Barcos_modelo getBar_model() {
        return bar_model;
    }

    public void setBar_model(Barcos_modelo bar_model) {
        this.bar_model = bar_model;
    }

    public Cabina_tipo getCab_type() {
        return cab_type;
    }

    public void setCab_type(Cabina_tipo cab_type) {
        this.cab_type = cab_type;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
}
