package com.utp.demo.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "PAQUETE_BENEFICIO")
public class PaqueteBeneficio {

    @EmbeddedId
    private PaqueteBeneficioId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_paquete")
    @JoinColumn(name = "id_paquete")
    private Paquete paquete;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_beneficio")
    @JoinColumn(name = "id_beneficio")
    private Beneficio beneficio;

    public PaqueteBeneficio() {
    }

    public PaqueteBeneficio(Paquete paquete, Beneficio beneficio) {
        this.paquete = paquete;
        this.beneficio = beneficio;
        this.id = new PaqueteBeneficioId(paquete.getId_paquete(), beneficio.getId_bene());
    }

    public PaqueteBeneficioId getId() {
        return id;
    }

    public void setId(PaqueteBeneficioId id) {
        this.id = id;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public Beneficio getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(Beneficio beneficio) {
        this.beneficio = beneficio;
    }

    // Clave compuesta
    public static class PaqueteBeneficioId implements Serializable {
        private String id_beneficio;
        private String id_paquete;

        public PaqueteBeneficioId() {
        }

        public PaqueteBeneficioId(String id_paquete, String id_beneficio) {
            this.id_paquete = id_paquete;
            this.id_beneficio = id_beneficio;
        }

        public String getId_beneficio() {
            return id_beneficio;
        }

        public void setId_beneficio(String id_beneficio) {
            this.id_beneficio = id_beneficio;
        }

        public String getId_paquete() {
            return id_paquete;
        }

        public void setId_paquete(String id_paquete) {
            this.id_paquete = id_paquete;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof PaqueteBeneficioId))
                return false;
            PaqueteBeneficioId that = (PaqueteBeneficioId) o;
            return Objects.equals(id_paquete, that.id_paquete) &&
                    Objects.equals(id_beneficio, that.id_beneficio);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id_paquete, id_beneficio);
        }
    }
}