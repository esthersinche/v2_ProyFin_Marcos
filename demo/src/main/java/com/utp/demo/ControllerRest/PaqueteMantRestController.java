package com.utp.demo.ControllerRest;

import org.springframework.web.bind.annotation.RestController;

import com.utp.demo.model.Paquete;
import com.utp.demo.service.PaqueteService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/paqueteMant")
public class PaqueteMantRestController {

    private PaqueteService paqserv;

    public PaqueteMantRestController(PaqueteService paqserv) {
        this.paqserv = paqserv;
    }

    //api

    //listar
    @GetMapping("/listar")
    public List<Paquete> listar() {
        return paqserv.obtenerTodosLosPaquetes();
    }

    //buscar
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Paquete> BuscarxId(@PathVariable String id) {
        Paquete paquetito1= paqserv.buscarPorId(id);
        if (paquetito1 != null) {
            return ResponseEntity.ok(paquetito1);// ok= codigo 200(tudo bem + cuerpo)

        } else {
            return ResponseEntity.notFound().build();// notfound= 404(not tudo bem, sin cuerpo)
        }

    }
    // Reponse entity es una rpta http q tiene todo, cabecera, estado y cuerpo

    //crear 
    @PostMapping("/save")
    public ResponseEntity<Paquete> guardar(@RequestBody Paquete paq1) {
        Paquete createdpaq= paqserv.guardarPaquete(paq1);

        return ResponseEntity.ok(createdpaq);
    }

    //actualizar 
    @PutMapping("editar/{id}")
    public ResponseEntity<Paquete> actualizar(@PathVariable String paqid, @RequestBody Paquete paq2) {
        Paquete editedpaq= paqserv.buscarPorId(paqid);

        if (editedpaq != null) {
            paqserv.guardarPaquete(editedpaq);
            return ResponseEntity.ok(editedpaq);         
        } else{
            return ResponseEntity.notFound().build();
        }

    }

    //eliminar
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminarxId(@PathVariable String id) {
        // parametro en la url
        Paquete paquetito3= paqserv.buscarPorId(id);
        if (paquetito3 != null) {
            paqserv.eliminarPaquetexId(id);
            return ResponseEntity.ok().build();// ok= codigo 200 w/o obj es tudo bem sin cuerpo
        } else {
            return ResponseEntity.notFound().build();
            // build finaliza coso, solo se envia la cabecera y codigo sin cuerpo
        }

    }
    
}
