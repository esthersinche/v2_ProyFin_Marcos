package com.utp.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Barcos_modelo extends Barcos{
    private String modelo_barco;//SMODEL, MMODEL, LMODEL
    private List<Ruta> listarutasxmodelo;//cada modelo tiene ciertas rutas q puede ir

    private List<Barcos_modelo_tipocabina> listacabxtipoxmodelo= new ArrayList<>();
    
    public Barcos_modelo(String iD_barco, String nombre_barco, String capitan_barco, String imagen_barco,
            String modelo_barco, List<Ruta> listarutasxmodelo, List<Barcos_modelo_tipocabina> listacabxtipoxmodelo) {
        super(iD_barco, nombre_barco, capitan_barco, imagen_barco);
        this.modelo_barco = modelo_barco;
        this.listarutasxmodelo = listarutasxmodelo;
        this.listacabxtipoxmodelo = listacabxtipoxmodelo;
    }

    @Override
    public String getModelo_barco() {
        return modelo_barco;
    }

    //capacidad
    public int getCapacidad(){
        int totalcapacidad= 0;
        for (Barcos_modelo_tipocabina bmtc : listacabxtipoxmodelo) {
            int cantcab= bmtc.getCant();
            int cant_max_per_cab= bmtc.getCab_type().getCant_max_per();
            totalcapacidad+= cantcab * cant_max_per_cab;
            
        }
        return totalcapacidad;

        
    }

 //polimorfismo god

    //total de cabinas
    public int getTotalcabinas(){
        int totalcabinas= 0;
        for (Barcos_modelo_tipocabina bmtc : listacabxtipoxmodelo) {
            totalcabinas+= bmtc.getCant();         
        }

        return totalcabinas;
    }

    //polimorfismo god

    
    
}
