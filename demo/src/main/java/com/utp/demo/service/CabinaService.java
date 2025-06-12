package com.utp.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.utp.demo.model.Cabina;

@Service
public class CabinaService {
    private final CabinaRepository cabrepo;

    public CabinaService(CabinaRepository cabrepo) {
        this.cabrepo = cabrepo;
    }

    public List<Cabina> obtenerTodoCabinas() {
        return cabrepo.findAll();
        /*return List.of(
                new Cabina(Cabina_tipo.inf, 0, 0),
                new Cabina(Cabina_tipo.ext, 0, 0),
                new Cabina(Cabina_tipo.cbal, 0, 0),
                new Cabina(Cabina_tipo.suit, 0, 0),
                new Cabina(Cabina_tipo.fam, 0, 0));// los numeros se quedan en int ya que se llenara en lo que es
                                                   // compra, debido a q
                                                   // el enum ya tiene un num de personas maximo */
        
    }

    // adicion, listado, consultas, eliminacion, busquedas
    // adicion no
    // listado(arriba)
    // consultas
    public Cabina buscarPorIdCabina(Long id_cab){
        return cabrepo.findById(id_cab).orElse(null);
    }

    public Cabina buscarPorNombreCabina(String nombre_cab) {
        return obtenerTodoCabinas().stream()
                .filter(c -> c.getNombre_cab().equalsIgnoreCase(nombre_cab))
                .findFirst().orElse(null);
    }

    public Cabina buscarPorcantmaxperCabina(int cantmax) {
        return obtenerTodoCabinas().stream()
                .filter(c -> c.getCant_max_per() == cantmax)
                .findFirst().orElse(null);
    }

    public Cabina buscarPorTipoCabina(String cabinaTipoId) {
        return obtenerTodoCabinas().stream()
                .filter(c -> c.getCab_tipo_id().equals(cabinaTipoId))
                .findFirst()
                .orElse(null);
    }

    // eliminacion
}