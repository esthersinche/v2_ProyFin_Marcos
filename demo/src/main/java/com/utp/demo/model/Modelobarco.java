package com.utp.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MODELOBARCO")
public class Modelobarco extends Barcos {

    @Id
    @Column(name = "modelo")
    private String modelo_barco; // SMODEL, MMODEL, LMODEL

    @OneToMany(mappedBy = "modelo", fetch = FetchType.LAZY) // Relación con los barcos que usan este modelo
    private List<Barcos> barcos = new ArrayList<>(); // Relación con los barcos que usan este modelo

    @OneToMany(mappedBy = "modelo_barco", fetch = FetchType.LAZY) // Relación con la tabla RUTA_BARCO
    private List<Ruta> listarutasxmodelo = new ArrayList<>(); // Rutas asociadas a este modelo de barco

    @OneToMany(mappedBy = "modelo", fetch = FetchType.LAZY) // Relación con las cabinas de este modelo
    private List<Barcos_modelo_tipocabina> listacabxtipoxmodelo = new ArrayList<>(); // Tipos de cabina asociados a este
                                                                                     // modelo

    @Column(name = "recreacion")
    private String recreacion; // Actividades recreativas a bordo del barco

    @Column(name = "imagen")
    private String imagen_barco; // URL de la imagen del barco

    // Constructor
    public Modelobarco(String id_barco, String nombre_barco, String capitan_barco, String imagen_barco,
            String modelo_barco, List<Ruta> listarutasxmodelo, List<Barcos_modelo_tipocabina> listacabxtipoxmodelo,
            String recreacion) {
        super(id_barco, nombre_barco, capitan_barco, imagen_barco); // Llamada al constructor de la clase padre
        this.modelo_barco = modelo_barco;
        this.listarutasxmodelo = listarutasxmodelo;
        this.listacabxtipoxmodelo = listacabxtipoxmodelo;
        this.recreacion = recreacion;
    }

    @Override
    public String getModelo_barco() {
        return modelo_barco;
    }

    // Capacidad del barco según las cabinas
    public int getCapacidad() {
        int totalcapacidad = 0;
        for (Barcos_modelo_tipocabina bmtc : listacabxtipoxmodelo) {
            int cantcab = bmtc.getCant();
            int cant_max_per_cab = bmtc.getCab_type().getCant_max_per();
            totalcapacidad += cantcab * cant_max_per_cab;
        }
        return totalcapacidad;
    }

    // Total de cabinas asociadas al modelo de barco
    public int getTotalcabinas() {
        int totalcabinas = 0;
        for (Barcos_modelo_tipocabina bmtc : listacabxtipoxmodelo) {
            totalcabinas += bmtc.getCant();
        }
        return totalcabinas;
    }

    // Getters y setters
    public String getModelo_barco() {
        return modelo_barco;
    }

    public void setModelo_barco(String modelo_barco) {
        this.modelo_barco = modelo_barco;
    }

    public List<Ruta> getListarutasxmodelo() {
        return listarutasxmodelo;
    }

    public void setListarutasxmodelo(List<Ruta> listarutasxmodelo) {
        this.listarutasxmodelo = listarutasxmodelo;
    }

    public List<Barcos_modelo_tipocabina> getListacabxtipoxmodelo() {
        return listacabxtipoxmodelo;
    }

    public void setListacabxtipoxmodelo(List<Barcos_modelo_tipocabina> listacabxtipoxmodelo) {
        this.listacabxtipoxmodelo = listacabxtipoxmodelo;
    }

    public String getRecreacion() {
        return recreacion;
    }

    public void setRecreacion(String recreacion) {
        this.recreacion = recreacion;
    }

    public String getImagen_barco() {
        return imagen_barco;
    }

    public void setImagen_barco(String imagen_barco) {
        this.imagen_barco = imagen_barco;
    }
}
