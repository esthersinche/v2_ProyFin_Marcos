package com.utp.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "MODELOBARCO")
public class Barcos_modelo {

    @Id
    @Column(name = "modelo")
    private String modeloBarco; // Ej. SMODEL, MMODEL, LMODEL

    @OneToMany(mappedBy = "barmodel")
    private List<Barcos_modelo_tipocabina> tiposDeCabina = new ArrayList<>();

    public Barcos_modelo() {
    }

    public Barcos_modelo(String modeloBarco) {
        this.modeloBarco = modeloBarco;
    }

    public String getModeloBarco() {
        return modeloBarco;
    }

    public void setModeloBarco(String modeloBarco) {
        this.modeloBarco = modeloBarco;
    }

    public List<Barcos_modelo_tipocabina> getTiposDeCabina() {
        return tiposDeCabina;
    }

    public void setTiposDeCabina(List<Barcos_modelo_tipocabina> tiposDeCabina) {
        this.tiposDeCabina = tiposDeCabina;
    }

    // Capacidad total del modelo
    public int getCapacidad() {
        return tiposDeCabina.stream()
                .mapToInt(bmtc -> bmtc.getCant() * bmtc.getCabtype().getCantMaxPer())
                .sum();
    }

    // Total de cabinas del modelo
    public int getTotalcabinas() {
        return tiposDeCabina.stream()
                .mapToInt(Barcos_modelo_tipocabina::getCant)
                .sum();
    }
}
