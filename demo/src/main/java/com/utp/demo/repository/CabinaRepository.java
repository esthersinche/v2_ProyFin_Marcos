package com.utp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.utp.demo.model.Cabina;
import com.utp.demo.model.Cabina_tipo;

public class CabinaRepository extends JpaRepository<Cabina, Long> {

    // Eliminar cabina
    public void delete(Cabina cabina);

    public List<Cabina> findAll();

    public Cabina_tipo getCabinatipo() {
        return this.cab_tipo_id; // Suponiendo que 'cab_tipo' es un campo en tu clase Cabina
    }
}
