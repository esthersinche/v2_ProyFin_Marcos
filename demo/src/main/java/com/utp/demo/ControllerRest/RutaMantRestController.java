package com.utp.demo.ControllerRest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utp.demo.model.Ruta;
import com.utp.demo.service.RutaService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/rutaMant")
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
    public ResponseEntity<Ruta> BuscarxId(@PathVariable String id) {
        Ruta rutita1= rutaserv.buscarPorId(id);
        if (rutita1 != null) {
            return ResponseEntity.ok(rutita1);// ok= codigo 200(tudo bem + cuerpo)

        } else {
            return ResponseEntity.notFound().build();// notfound= 404(not tudo bem, sin cuerpo)
        }

    }
    // Reponse entity es una rpta http q tiene todo, cabecera, estado y cuerpo

    //crear
    @PostMapping("/save")
    public ResponseEntity<Ruta> guardar(@RequestBody Ruta route1) {
        Ruta createdruta= rutaserv.guardarRuta(route1);

        return ResponseEntity.ok(createdruta);
    }

    //actualizar
    @PutMapping("editar/{id}")
    public ResponseEntity<Ruta> actualizar(@PathVariable String rutaid, @RequestBody Ruta route2) {
        Ruta editedruta= rutaserv.buscarPorId(rutaid);

        if (editedruta != null) {
            rutaserv.guardarRuta(editedruta);
            return ResponseEntity.ok(editedruta);
            
        } else{
            return ResponseEntity.notFound().build();
        }

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
