package com.utp.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

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
    @MapsId("id_ruta")
    @JoinColumn(name = "id_ruta")
    private Ruta ruta;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_barco")
    @JoinColumn(name = "id_barco")
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

        private String id_ruta;
        private String id_barco;

        public RutaBarcoId() {
        }

        public RutaBarcoId(String id_ruta, String id_barco) {
            this.id_ruta = id_ruta;
            this.id_barco = id_barco;
        }

        public String getId_ruta() {
            return id_ruta;
        }

        public void setId_ruta(String id_ruta) {
            this.id_ruta = id_ruta;
        }

        public String getId_barco() {
            return id_barco;
        }

        public void setId_barco(String id_barco) {
            this.id_barco = id_barco;
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
            return Objects.equals(id_ruta, that.id_ruta)
                    && Objects.equals(id_barco, that.id_barco);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id_ruta, id_barco);
        }
    }



    
}
