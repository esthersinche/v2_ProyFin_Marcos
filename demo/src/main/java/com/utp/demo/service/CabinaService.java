package com.utp.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utp.demo.model.Barcos;
import com.utp.demo.model.Cabina_Inst;
import com.utp.demo.model.Cabina_tipo;

@Service
public class CabinaService {

    private final CabinaRepository cabrepo;
    private final BarcoService barcoserv;

    public CabinaService(CabinaRepository cabrepo, BarcoService barcoserv) {
        this.cabrepo = cabrepo;
        this.barcoserv = barcoserv;
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
        return cabrepo.findByCabTipoId(tipoId);
    }

    // DE RESERVA
    public Cabina_Inst buscarPorTipoCabina(Cabina_tipo tipoCabina) {
        return cabrepo.findFirstByCabTipo(tipoCabina);
    }

    /**
     * Devuelve las instancias de cabina disponibles para un barco dado,
     * inspeccionando su modelo y los tipos de cabina asociados.
     */
    public List<Cabina_Inst> obtenerPorBarco(String idBarco) {
        Barcos barco = barcoserv.buscarPorIdBarco(idBarco);
        if (barco == null || barco.getBarmodel() == null) {
            return List.of();
        }
        // Extraer los IDs de cabina que el modelo soporta
        List<String> tipoIds = barco.getBarmodel().getTiposDeCabina().stream()
            .map(bmtc -> bmtc.getCab_type().getCab_tipo_id())
            .toList();

        return cabrepo.findByCabTipoIdIn(tipoIds);
    }
}
