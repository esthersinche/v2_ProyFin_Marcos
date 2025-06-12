package com.utp.demo.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipos") // Relacionado con la tabla "tipos" de la base de datos
public class Barcos_modelo_tipocabina {

    @EmbeddedId
    private Barcos_modelo_tipocabinaId idparaelcoso; // Identificador compuesto

    @ManyToOne
    @JoinColumn(name = "modelo", insertable = false, updatable = false) // Relaciona con Modelobarco
    private Modelobarco bar_model;

    @ManyToOne
    @JoinColumn(name = "cabinatipo", insertable = false, updatable = false) // Relaciona con Cabina_tipo
    private Cabina_tipo cab_type;

    private int cant; // Cantidad de cabinas de este tipo para este modelo

    // Constructor vacío
    public Barcos_modelo_tipocabina() {
    }

    // Constructor con parámetros
    public Barcos_modelo_tipocabina(Modelobarco bar_model, Cabina_tipo cab_type, int cant) {
        this.bar_model = bar_model;
        this.cab_type = cab_type;
        this.cant = cant;
        this.idparaelcoso = new Barcos_modelo_tipocabinaId(bar_model.getModelo_barco(), cab_type.getCab_tipo_id());
    }

    // Getters y Setters
    public Barcos_modelo_tipocabinaId getIdparaelcoso() {
        return idparaelcoso;
    }

    public void setIdparaelcoso(Barcos_modelo_tipocabinaId idparaelcoso) {
        this.idparaelcoso = idparaelcoso;
    }

    public Modelobarco getBar_model() {
        return bar_model;
    }

    public void setBar_model(Modelobarco bar_model) {
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
