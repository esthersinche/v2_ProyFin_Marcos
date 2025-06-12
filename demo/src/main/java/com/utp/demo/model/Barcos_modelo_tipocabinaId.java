package com.utp.demo.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Barcos_modelo_tipocabinaId implements Serializable {

    private String modelobarco;
    private String cab_tipo_id;

    public Barcos_modelo_tipocabinaId() {
    }

    public Barcos_modelo_tipocabinaId(String modelo_barco, String cab_tipo_id) {
        this.modelobarco = modelo_barco;
        this.cab_tipo_id = cab_tipo_id;
    }

    public String getModelobarco() {
        return modelobarco;
    }

    public void setModelo_barco(String modelo_barco) {
        this.modelobarco = modelo_barco;
    }

    public String getCab_tipo_id() {
        return cab_tipo_id;
    }

    public void setCab_tipo_id(String cab_tipo_id) {
        this.cab_tipo_id = cab_tipo_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelobarco, cab_tipo_id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Barcos_modelo_tipocabinaId))
            return false;
        Barcos_modelo_tipocabinaId that = (Barcos_modelo_tipocabinaId) o;
        return Objects.equals(modelobarco, that.modelobarco) &&
                Objects.equals(cab_tipo_id, that.cab_tipo_id);
    }
}
