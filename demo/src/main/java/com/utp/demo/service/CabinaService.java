package com.utp.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.utp.demo.model.Cabina;
import com.utp.demo.model.Cabina_tipo;
import com.utp.demo.repository.CabinaRepository; // Asegúrate de tener un repositorio para acceder a las cabinas

@Service
public class CabinaService {

    @Autowired
    private CabinaRepository cabinaRepository; // Usando el repositorio para acceder a las cabinas desde la base de
                                               // datos

    // Obtener todas las cabinas desde la base de datos
    public List<Cabina> obtenerTodasCabinas() {
        return cabinaRepository.findAll(); // Reemplazamos los datos hardcodeados con la consulta a la base de datos
    }

    // Consultas
    public Cabina buscarPorNombreCabina(String nombre_cab) {
        return obtenerTodasCabinas().stream()
                .filter(c -> c.getCabinatipo().getNombre_cab().equalsIgnoreCase(nombre_cab))
                .findFirst()
                .orElse(null); // Si no se encuentra, se devuelve null
    }

    public Cabina buscarPorCantMaxPerCabina(int cantMax) {
        return obtenerTodasCabinas().stream()
                .filter(c -> c.getCabinatipo().getCant_max_per() == cantMax)
                .findFirst()
                .orElse(null); // Si no se encuentra, se devuelve null
    }

    public Cabina buscarPorTipoCabina(Cabina_tipo tipo) {
        return obtenerTodasCabinas().stream()
                .filter(c -> c.getCabinatipo().equals(tipo)) // Compara el tipo de cabina
                .findFirst()
                .orElse(null); // Si no se encuentra, se devuelve null
    }

    // Eliminación de una cabina (si es necesario)
    public void eliminarCabina(Cabina cabina) {
        cabinaRepository.delete(cabina);
    }
}
