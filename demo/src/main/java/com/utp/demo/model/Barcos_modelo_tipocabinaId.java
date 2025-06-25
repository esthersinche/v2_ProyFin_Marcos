package com.utp.demo.model;

import java.io.Serializable;
import java.util.Objects;

public class Barcos_modelo_tipocabinaId implements Serializable {

    private String modelobarco;
    private String cabtipoid;

    public Barcos_modelo_tipocabinaId() {
    }

    public Barcos_modelo_tipocabinaId(String modelobarco, String cabtipoid) {
        this.modelobarco = modelobarco;
        this.cabtipoid = cabtipoid;
    }

    public String getModelobarco() {
        return modelobarco;
    }

    public void setModelobarco(String modelobarco) {
        this.modelobarco = modelobarco;
    }

    public String getCabtipoid() {
        return cabtipoid;
    }

    public void setCabtipoid(String cabtipoid) {
        this.cabtipoid = cabtipoid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Barcos_modelo_tipocabinaId)) {
            return false;
        }
        Barcos_modelo_tipocabinaId that = (Barcos_modelo_tipocabinaId) o;
        return Objects.equals(modelobarco, that.modelobarco)
                && Objects.equals(cabtipoid, that.cabtipoid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelobarco, cabtipoid);
    }
}
