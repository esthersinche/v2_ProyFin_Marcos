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
    private final String modelo_barco;//SMODEL, MMODEL, LMODEL

    /*private List<Ruta> listarutasxmodelo;//cada modelo tiene ciertas rutas q puede ir*/
    @OneToMany(mappedBy= "bar_model")
    private List<Barcos_modelo_tipocabina> listacabxtipoxmodelo = new ArrayList<>();
 

    public Barcos_modelo(String modelo_barco) {
        this.modelo_barco = modelo_barco;
    }

    public String getModelo_barco() {
        return modelo_barco;
    }

    public List<Barcos_modelo_tipocabina> getListacabxtipoxmodelo() {
        return listacabxtipoxmodelo;
    }

    public void setListacabxtipoxmodelo(List<Barcos_modelo_tipocabina> listacabxtipoxmodelo) {
        this.listacabxtipoxmodelo = listacabxtipoxmodelo;
    }

    //capacidad
    public int getCapacidad() {
        int totalcapacidad = 0;
        for (Barcos_modelo_tipocabina bmtc : listacabxtipoxmodelo) {
            int cantcab = bmtc.getCant();
            int cant_max_per_cab = bmtc.getCab_type().getCant_max_per();
            totalcapacidad += cantcab * cant_max_per_cab;

        }
        return totalcapacidad;

    }

    //polimorfismo god
    //total de cabinas
    public int getTotalcabinas() {
        int totalcabinas = 0;
        for (Barcos_modelo_tipocabina bmtc : listacabxtipoxmodelo) {
            totalcabinas += bmtc.getCant();
        }

        return totalcabinas;
    }

    //polimorfismo god
}