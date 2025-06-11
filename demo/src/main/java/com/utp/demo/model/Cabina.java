package com.utp.demo.model;
//solo la clase para q extienda a la implementacion los metdos y los datos
//esto es Reserva Cabina mas q nada debido al numadultos y numninos, osea la cabina reservada por el
//cliente

public abstract class Cabina {

    private int numadultos;
    private int numninos;
 

    public Cabina(int numadultos, int numninos) {
        this.numadultos = numadultos;
        this.numninos = numninos;
    }

    
    public int getNumadultos() {
        return numadultos;
    }


    public void setNumadultos(int numadultos) {
        this.numadultos = numadultos;
    }


    public int getNumninos() {
        return numninos;
    }


    public void setNumninos(int numninos) {
        this.numninos = numninos;
    }


    //metodos abstractos
    public abstract String getNombre_cab();
    public abstract int getCant_max_per();
    public abstract double getPrec_cabina_per();

    public int getNumtotalper(){
        return this.numadultos + this.numninos;
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
