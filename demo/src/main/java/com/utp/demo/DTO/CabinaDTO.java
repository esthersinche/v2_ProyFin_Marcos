package com.utp.demo.DTO;

import com.utp.demo.model.Cabina_Inst;

public class CabinaDTO {

    private String idCabina;
    private String nombreCab;
    private String cabTipoId;
    private int capacidadMax;
    private double precioPorPersona;

    public CabinaDTO(String idCabina, String nombreCab, String cabTipoId, int capacidadMax, double precioPorPersona) {
        this.idCabina = idCabina;
        this.nombreCab = nombreCab;
        this.cabTipoId = cabTipoId;
        this.capacidadMax = capacidadMax;
        this.precioPorPersona = precioPorPersona;
    }

    public static CabinaDTO fromEntity(Cabina_Inst c) {
        return new CabinaDTO(
                c.getCabinaId(),
                c.getCabTipo().getNombreCab(),
                c.getCabTipo().getCabTipoId(),
                c.getCabTipo().getCantMaxPer(),
                c.getCabTipo().getPrecCabinaPer()
        );
    }

    // Getters
    public String getIdCabina() {
        return idCabina;
    }

    public String getNombreCab() {
        return nombreCab;
    }

    public String getCabTipoId() {
        return cabTipoId;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public double getPrecioPorPersona() {
        return precioPorPersona;
    }

    public void setIdCabina(String idCabina) {
        this.idCabina = idCabina;
    }

    public void setNombreCab(String nombreCab) {
        this.nombreCab = nombreCab;
    }

    public void setCabTipoId(String cabTipoId) {
        this.cabTipoId = cabTipoId;
    }

    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    public void setPrecioPorPersona(double precioPorPersona) {
        this.precioPorPersona = precioPorPersona;
    }

}
