package com.utp.demo.ControllerRest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.utp.demo.model.Barcos;
import com.utp.demo.service.BarcoService;

@RestController
public class BarcoMantRestController {

    private BarcoService barcoserv;

    public BarcoMantRestController(BarcoService barcoserv) {
        this.barcoserv = barcoserv;
    }

    // cambios para api
    // listar
    @GetMapping("/listar")
    public List<Barcos> listar() {
        return barcoserv.obtenerBarcos();
    }

    // obtener x id
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Barcos> BuscarxId(@PathVariable String id, Model model) {
        Barcos barquito1 = barcoserv.buscarPorId(id);
        if (barquito1 != null) {
            model.addAttribute("barco", barquito1);// añade datos a inputs(?)
            return ResponseEntity.ok(barquito1);// ok= codigo 200(tudo bem + cuerpo)

        } else {
            model.addAttribute("errorMsg", "Ingrese un ID válido");
            return ResponseEntity.notFound().build();// notfound= 404(not tudo bem, sin cuerpo)
        }

    }
    // Reponse entity es una rpta http q tiene todo, cabecera, estado y cuerpo

    // crear/actualizar barcos
    @PostMapping("/save")
    public ResponseEntity<Barcos> guardar(@RequestBody Barcos barco) {
        Barcos barquito2 = barcoserv.guardarBarco(barco);

        return ResponseEntity.ok(barquito2);
    }

    // eliminarqwewqe
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminarxId(@PathVariable String id) {
        // parametro en la url
        Barcos barquito3 = barcoserv.buscarPorId(id);
        if (barquito3 != null) {
            barcoserv.eliminarBarco(id);
            return ResponseEntity.ok().build();// ok= codigo 200 w/o obj es tudo bem sin cuerpo
        } else {

            return ResponseEntity.notFound().build();
            // build finaliza coso, solo se envia la cabecera y codigo sin cuerpo
        }

    }

}
