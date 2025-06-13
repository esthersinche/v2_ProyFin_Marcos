package com.utp.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

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
    public abstract String getCab_tipo_id();

    public abstract String getNombre_cab();

    public abstract int getCant_max_per();

    public abstract double getPrec_cabina_per();

    // Total de personas (por ahora solo adultos, puedes extenderlo si consideras
    // niños después)
    public int getNumtotalper() {
        return this.numadultos;
    }

    // Validación de capacidad de la cabina
    public boolean capacidadvalida() {
        return getNumtotalper() <= getCant_max_per();
    }
}
