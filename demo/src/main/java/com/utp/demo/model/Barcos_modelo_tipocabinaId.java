package com.utp.demo.model;

import java.io.Serializable;
//para evitar posibles duplicas en lo q es tipos/Barcos_modelo_tipocabina
import java.util.Objects;


public class Barcos_modelo_tipocabinaId implements Serializable{
    private String modelo_barco;
    private String cab_tipo_id;


    public Barcos_modelo_tipocabinaId() {
    }

    public Barcos_modelo_tipocabinaId(String modelo_barco, String cab_tipo_id) {
        this.modelo_barco = modelo_barco;
        this.cab_tipo_id = cab_tipo_id;
    }

    public String getModelo_barco() {
        return modelo_barco;
    }

    public void setModelo_barco(String modelo_barco) {
        this.modelo_barco = modelo_barco;
    }

    public String getCab_tipo_id() {
        return cab_tipo_id;
    }

    public void setCab_tipo_id(String cab_tipo_id) {
        this.cab_tipo_id = cab_tipo_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelo_barco, cab_tipo_id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Barcos_modelo_tipocabinaId)) return false;
        Barcos_modelo_tipocabinaId that = (Barcos_modelo_tipocabinaId) o;
        return Objects.equals(modelo_barco, that.modelo_barco) &&
               Objects.equals(cab_tipo_id, that.cab_tipo_id);
    }

    
  
    

    

    

    

    



    





    
}
