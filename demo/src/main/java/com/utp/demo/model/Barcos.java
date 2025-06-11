package com.utp.demo.model;


//@Entity
//Table(name= "Barcos")
public abstract class Barcos {

    //@Id
    private String ID_barco;
    private String nombre_barco;
    private String capitan_barco;
    //el nombre del modelo estara en las hijas
    //la capacidad es un metodo
    //ruta sera lista inicializada en cada modelo de barco
    private String imagen_barco;

    public Barcos(String iD_barco, String nombre_barco, String capitan_barco, String imagen_barco) {
        ID_barco = iD_barco;
        this.nombre_barco = nombre_barco;
        this.capitan_barco = capitan_barco;
        this.imagen_barco = imagen_barco;
    }

    public String getID_barco() {
        return ID_barco;
    }

    public void setID_barco(String iD_barco) {
        ID_barco = iD_barco;
    }

    public String getNombre_barco() {
        return nombre_barco;
    }

    public void setNombre_barco(String nombre_barco) {
        this.nombre_barco = nombre_barco;
    }

    public String getCapitan_barco() {
        return capitan_barco;
    }

    public void setCapitan_barco(String capitan_barco) {
        this.capitan_barco = capitan_barco;
    }

    public String getImagen_barco() {
        return imagen_barco;
    }

    public void setImagen_barco(String imagen_barco) {
        this.imagen_barco = imagen_barco;
    }

    //metodos abstractos para modelos de barco (3)
    public abstract String getModelo_barco();
    

    

    

    


    



}
