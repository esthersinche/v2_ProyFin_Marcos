package com.utp.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "RUTA_BARCO")
public class RutaBarco {

    @EmbeddedId
    private RutaBarcoId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idruta")
    @JoinColumn(name = "idruta")
    @JsonBackReference
    private Ruta ruta;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idbarco")
    @JoinColumn(name = "idbarco")
    private Barcos barco;

    @Column(name= "fechasalida")
    private Date fechasalida;

    public RutaBarco() {
    }

    

    public RutaBarco( Ruta ruta, Barcos barco, Date fechasalida) {
        this.ruta = ruta;
        this.barco = barco;
        this.fechasalida = fechasalida;
        this.id = new RutaBarcoId(ruta.getIdruta(), barco.getIDbarco());
    }

    public RutaBarcoId getId() {
        return id;
    }

    public void setId(RutaBarcoId id) {
        this.id = id;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Barcos getBarco() {
        return barco;
    }

    public void setBarco(Barcos barco) {
        this.barco = barco;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    // Clase embebida como ID compuesta
    public static class RutaBarcoId implements Serializable {

        private String idruta;
        private String idbarco;

        public RutaBarcoId() {
        }

        public RutaBarcoId(String idruta, String idbarco) {
            this.idruta = idruta;
            this.idbarco = idbarco;
        }

        public String getIdruta() {
            return idruta;
        }

        public void setIdruta(String idruta) {
            this.idruta = idruta;
        }

        public String getIdbarco() {
            return idbarco;
        }

        public void setIdbarco(String idbarco) {
            this.idbarco = idbarco;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof RutaBarcoId)) {
                return false;
            }
            RutaBarcoId that = (RutaBarcoId) o;
            return Objects.equals(idruta, that.idruta)
                    && Objects.equals(idbarco, that.idbarco);
        }

        @Override
        public int hashCode() {
            return Objects.hash(idruta, idbarco);
        }
    }



    
}
