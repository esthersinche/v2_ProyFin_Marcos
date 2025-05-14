package com.utp.demo.servicio;

import com.utp.demo.modelo.Cabina;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabinaService {

    public List<Cabina> obtenerTodoCabinas() {
        return List.of(
                new Cabina("Camarote Exterior", 1200, 4, 2),
                new Cabina("Camarote Interior", 1000, 4, 2),
                new Cabina("Habitación Exterior Con Balcón", 1500, 2, 1),
                new Cabina("Habitación Interior", 1100, 2, 1),
                new Cabina("Suite", 2000, 2, 2));
    }

    public Cabina buscarPorNombreCabina(String nombre_cab) {
        return obtenerTodoCabinas().stream()
                .filter(c -> c.getNombre_cab().equalsIgnoreCase(nombre_cab))
                .findFirst()
                .orElse(null);
    }
}
