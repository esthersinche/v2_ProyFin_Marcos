package com.utp.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

//solo la clase para q extienda a la implementacion los metdos y los datos
//esto es Reserva Cabina mas q nada debido al numadultos y numninos, osea la cabina reservada por el
//cliente
@MappedSuperclass
public abstract class Cabina {
    @Column(name= "numadultos")
    private int numadultos;
    
    public Cabina(int numadultos) {
        this.numadultos = numadultos;       
    }
    
    public int getNumadultos() {
        return numadultos;
    }

    public void setNumadultos(int numadultos) {
        this.numadultos = numadultos;
    }

    //metodos abstractos
    public abstract String getCab_tipo_id();
    public abstract String getNombre_cab();
    public abstract int getCant_max_per();
    public abstract double getPrec_cabina_per();

    public int getNumtotalper(){
        return this.numadultos;
    }//devuelve numeor total de personas , es mas como para reserva y eso


    public boolean capacidadvalida() {
        int totalper = getNumtotalper();
        return totalper <= getCant_max_per();

        //return totalper <= cabinatipo.getCant_max_per();
        //retorna true(si totalper es menor o igual) o false(mayor)
        //el enum agarra el tipo de enum de acuerdo a la cabina del paquete escogido
        //v2: polimorfismo
    }

}