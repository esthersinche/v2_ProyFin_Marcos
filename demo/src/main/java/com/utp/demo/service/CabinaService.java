package com.utp.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utp.demo.model.Cabina;
import com.utp.demo.model.Cabina.Cabina_tipo;

@Service
public class CabinaService {

    public List<Cabina> obtenerTodoCabinas() {
        return List.of(
                new Cabina(Cabina_tipo.inf, 0, 0),
                new Cabina(Cabina_tipo.ext, 0, 0),
                new Cabina(Cabina_tipo.cbal, 0, 0),
                new Cabina(Cabina_tipo.suit, 0, 0),
                new Cabina(Cabina_tipo.fam, 0, 0)
        );//los numeros se quedan en int ya que se llenara en lo que es compra, debido a q
        //el enum ya tiene un num de personas maximo
    }

    //adicion, listado, consultas, eliminacion, busquedas

    //adicion no
    //listado(arriba)

    //consultas
    public Cabina buscarPorNombreCabina(String nombre_cab) {
        return obtenerTodoCabinas().stream()
                .filter(c -> c.getCabinatipo().getNombre_cabina().equalsIgnoreCase(nombre_cab))
                .findFirst().orElse(null);
    }

    public Cabina buscarPorcantmaxperCabina(int cantmax) {
        return obtenerTodoCabinas().stream()
                .filter(c -> c.getCabinatipo().getCant_max_per() == cantmax)
                .findFirst().orElse(null);
    }

    //eliminacion




}
