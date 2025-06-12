package com.utp.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CABINA") // Asumiendo que la tabla es "CABINA" en tu base de datos
public class Cabina_Inst extends Cabina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // El ID de la cabina será autogenerado
    @Column(name = "cabina_id") // Mapeamos el campo "cabina_id" en la tabla CABINA
    private Long cabina_id;

    @ManyToOne
    @JoinColumn(name = "cabina_tipo", referencedColumnName = "cabinatipo") // Relación con CABINATIPO
    private Cabina_tipo cab_tipo;

    // Constructor para crear la instancia de Cabina_Inst
    public Cabina_Inst(int numadultos, int numninos, Cabina_tipo cab_tipo) {
        super(numadultos, numninos); // Llamamos al constructor de la clase padre Cabina
        this.cab_tipo = cab_tipo;
    }

    // Getters y setters
    public Long getCabina_id() {
        return cabina_id;
    }

    public void setCabina_id(Long cabina_id) {
        this.cabina_id = cabina_id;
    }

    public Cabina_tipo getCab_tipo() {
        return cab_tipo;
    }

    public void setCab_tipo(Cabina_tipo cab_tipo) {
        this.cab_tipo = cab_tipo;
    }

    // Métodos abstractos implementados de la clase Cabina

    @Override
    public int getCant_max_per() {
        return cab_tipo.getCant_max_per(); // Retorna la capacidad máxima de la cabina
    }

    @Override
    public String getNombre_cab() {
        return cab_tipo.getNombre_cab(); // Retorna el nombre de la cabina
    }

    @Override
    public double getPrec_cabina_per() {
        return cab_tipo.getPrec_cabina_per(); // Retorna el precio de la cabina
    }
}
