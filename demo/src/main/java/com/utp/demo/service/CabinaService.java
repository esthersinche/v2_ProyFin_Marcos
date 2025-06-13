package com.utp.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utp.demo.model.Cabina_Inst;
import com.utp.demo.model.Cabina_tipo;

@Service
public class CabinaService {

    private final CabinaRepository cabrepo;

    public CabinaService(CabinaRepository cabrepo) {
        this.cabrepo = cabrepo;
    }

    // Obtener todas las cabinas
    public List<Cabina_Inst> obtenerTodasLasCabinas() {
        return cabrepo.findAll();
    }

    // Buscar por ID
    public Cabina_Inst buscarPorIdCabina(Long id) {
        return cabrepo.findById(id).orElse(null);
    }

    // Buscar por nombre de cabina
    public Cabina_Inst buscarPorNombreCabina(String nombreCabina) {
        return cabrepo.findAll().stream()
                .filter(c -> c.getNombre_cab().equalsIgnoreCase(nombreCabina))
                .findFirst()
                .orElse(null);
    }

    // Buscar por cantidad máxima de personas
    public Cabina_Inst buscarPorCapacidadMaxima(int capacidad) {
        return cabrepo.findAll().stream()
                .filter(c -> c.getCant_max_per() == capacidad)
                .findFirst()
                .orElse(null);
    }

    // Buscar por tipo de cabina (ID)
    public List<Cabina_Inst> buscarPorTipoCabina(String tipoId) {
        return cabrepo.findByCab_tipo_Cab_tipo_id(tipoId);
    }

    // DE RESERVA
    public Cabina_Inst buscarPorTipoCabina(Cabina_tipo tipoCabina) {
        return cabrepo.findFirstByCab_tipo(tipoCabina);
    }
}
