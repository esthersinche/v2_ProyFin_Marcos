package com.utp.demo.ControllerRest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.utp.demo.model.Ruta;
import com.utp.demo.service.RutaService;

public class RutaMantRestController {
    
    private RutaService rutaserv;

    public RutaMantRestController(RutaService rutaserv) {
        this.rutaserv = rutaserv;
    }

    //api

    //listar
    @GetMapping("/listar")
    public List<Ruta> listar() {
        return rutaserv.obtenerTodasLasRutas();
    }

    //buscar
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Ruta> BuscarxId(@PathVariable String id, Model model) {
        Ruta rutita1= rutaserv.buscarPorId(id);
        if (rutita1 != null) {
            model.addAttribute("ruta", rutita1);// añade datos a inputs(?)
            return ResponseEntity.ok(rutita1);// ok= codigo 200(tudo bem + cuerpo)

        } else {
            model.addAttribute("errorMsg", "Ingrese un ID válido");
            return ResponseEntity.notFound().build();// notfound= 404(not tudo bem, sin cuerpo)
        }

    }
    // Reponse entity es una rpta http q tiene todo, cabecera, estado y cuerpo

    //crear o editar
    @PostMapping("/save")
    public ResponseEntity<Ruta> guardar(@RequestBody Ruta route) {
        Ruta rutita2= rutaserv.guardarRuta(route);

        return ResponseEntity.ok(rutita2);
    }

    //eliminar
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminarxId(@PathVariable String id) {
        // parametro en la url
        Ruta rutita3= rutaserv.buscarPorId(id);
        if (rutita3 != null) {
            rutaserv.eliminarRuta(id);
            return ResponseEntity.ok().build();// ok= codigo 200 w/o obj es tudo bem sin cuerpo
        } else {
            return ResponseEntity.notFound().build();
            // build finaliza coso, solo se envia la cabecera y codigo sin cuerpo
        }

    }
}
