package com.utp.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

//mas dirigida a lo q es reserva

@MappedSuperclass
public abstract class Cabina {

    @Column(name = "numadultos")
    private int numadultos;

    public Cabina() {
    }

    public Cabina(int numadultos) {
        this.numadultos = numadultos;
    }

    public int getNumadultos() {
        return numadultos;
    }

    public void setNumadultos(int numadultos) {
        this.numadultos = numadultos;
    }

    // Métodos abstractos
    public abstract String getCabtipoid();

    public abstract String getNombrecab();

    public abstract int getCantmaxper();

    public abstract double getPreccabinaper();

    // Total de personas (por ahora solo adultos, puedes extenderlo si consideras
    // niños después)
    public int getNumtotalper() {
        return this.numadultos;
    }

    // Validación de capacidad de la cabina
    public boolean capacidadvalida() {
        return getNumtotalper() <= getCantmaxper();
    }
}
