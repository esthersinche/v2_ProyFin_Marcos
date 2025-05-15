package com.utp.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.utp.demo.model.Cabina;
import com.utp.demo.model.Paquete;
//import com.utp.demo.model.Ruta;

@Service
public class PaqueteService {
    //public Ruta ruta;
    private RutaService rutaserv;//en rutaservicio estan todas las rutas

    public PaqueteService(RutaService rutaserv) {
        this.rutaserv = rutaserv;
    }//no necesita autowired debido a cambios en spring esto lo reconoce automotico 

    

    public List<Paquete> obtenerTodoPaquetes() {
        return List.of(
            /* 
                new Paquete("Todo Incluido", "Todos los beneficios del crucero", 1200),
                new Paquete("Sin Paquetes", "Solo el crucero base", 0),
                new Paquete("Paquete de Bebidas", "Incluye bebidas ilimitadas", 300),
                new Paquete("Paquete de Internet", "Wi-Fi ilimitado en todo el barco", 250),
                new Paquete("Paquete de Restaurantes", "Acceso a restaurantes gourmet", 350),
                new Paquete("Paquete de Entretenimiento para Niños", "Actividades para menores", 200),
                new Paquete("Paquete de Entretenimiento para Adultos", "Shows y actividades nocturnas", 400),
                new Paquete("Paquete de Piscinas", "Acceso a piscinas premium", 150)*/
                new Paquete("Todo incluido", Cabina.Cabina_tipo.fam, "Todos los beneficios del crucero", rutaserv.obtenerTodoRutas().get(0) ),//primera ruta del array de rutas de ruta servicio
                new Paquete("Sin Paquetes", Cabina.Cabina_tipo.inf, "Solo el crucero base", rutaserv.obtenerTodoRutas().get(1)),
                new Paquete("Paquete de Bebidas", Cabina.Cabina_tipo.ext, "Incluye bebidas ilimitadas", rutaserv.obtenerTodoRutas().get(2)),
                new Paquete("Paquete de Internet", Cabina.Cabina_tipo.cbal, "Wi-Fi ilimitado en todo el barco", rutaserv.obtenerTodoRutas().get(3) ),
                new Paquete("Paquete de Restaurantes", Cabina.Cabina_tipo.suit, "Acceso a restaurantes gourmet", rutaserv.obtenerTodoRutas().get(2)),
                new Paquete("Paquete de Entretenimiento para Niños", Cabina.Cabina_tipo.fam, "Actividades para menores", rutaserv.obtenerTodoRutas().get(1)),
                new Paquete("Paquete de Entretenimiento para Adultos", Cabina.Cabina_tipo.suit, "Shows y actividades nocturnas", rutaserv.obtenerTodoRutas().get(0)),
                new Paquete("Paquete de Piscinas", Cabina.Cabina_tipo.cbal, "Acceso a piscinas premium", rutaserv.obtenerTodoRutas().get(3))
            );
    }

    //adicion, listado, consultas, eliminacion, busquedas

    //adicion tal vez
    //listado(arriba)

    //consultas
    public List<Paquete> buscarPorNombrePaquetes(List<String> nombres_paquetes) {
        return obtenerTodoPaquetes().stream()
                .filter(p -> nombres_paquetes.contains(p.getNombre_paq()))
                .collect(Collectors.toList());
    }

    //falta agregar tengo q pensar










}
