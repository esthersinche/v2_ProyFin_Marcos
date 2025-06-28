package com.utp.demo.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
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
    @MapsId("idpaquete")
    @JoinColumn(name = "idpaquete")
    private Paquete paquete;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idbeneficio")
    @JoinColumn(name = "idbeneficio")
    private Beneficio beneficio;

    public PaqueteBeneficio() {
    }

    public PaqueteBeneficio(Paquete paquete, Beneficio beneficio) {
        this.paquete = paquete;
        this.beneficio = beneficio;
        this.id = new PaqueteBeneficioId(paquete.getIdPaquete(), beneficio.getIdBene());
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
    @Embeddable
    public static class PaqueteBeneficioId implements Serializable {

        private String idbeneficio;
        private String idpaquete;

        public PaqueteBeneficioId() {
        }

        public PaqueteBeneficioId(String idpaquete, String idbeneficio) {
            this.idpaquete = idpaquete;
            this.idbeneficio = idbeneficio;
        }

        public String getId_beneficio() {
            return idbeneficio;
        }

        public void setIdbeneficio(String idbeneficio) {
            this.idbeneficio = idbeneficio;
        }

        public String getIdpaquete() {
            return idpaquete;
        }

        public void setIdpaquete(String idpaquete) {
            this.idpaquete = idpaquete;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof PaqueteBeneficioId)) {
                return false;
            }
            PaqueteBeneficioId that = (PaqueteBeneficioId) o;
            return Objects.equals(idpaquete, that.idpaquete)
                    && Objects.equals(idbeneficio, that.idbeneficio);
        }

        @Override
        public int hashCode() {
            return Objects.hash(idpaquete, idbeneficio);
        }
    }
}
