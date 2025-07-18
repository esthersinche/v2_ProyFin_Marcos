package com.utp.demo.ControllerRest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utp.demo.DTO.BarcoDTO;
import com.utp.demo.DTO.RutaDTO;
import com.utp.demo.model.Barcos;
import com.utp.demo.model.Barcos_modelo;
import com.utp.demo.model.Ruta;
import com.utp.demo.service.BarcoRepository;
import com.utp.demo.service.BarcoService;
import com.utp.demo.service.RutaRepository;
import com.utp.demo.service.RutaService;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/barcoMant")
public class BarcoMantRestController {

    private BarcoService barcoserv;
    private BarcoRepository barcorepo;
    private RutaService rutaserv;

    public BarcoMantRestController(BarcoService barcoserv, BarcoRepository barcorepo, RutaService rutaserv) {
        this.barcoserv = barcoserv;
        this.barcorepo = barcorepo;
        this.rutaserv = rutaserv;
    }

    // cambios para api
    // listar para barcos y para q react los cargue
    @GetMapping("/listarbarcos")
    public List<Barcos> listar() {
        return barcoserv.obtenerBarcos();
    }

    // listar para modelos
    @GetMapping("/listarmodelos")
    public List<BarcoDTO> listarmodelos() {
        return barcoserv.obtenerBarcos()
                .stream().map(BarcoDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // listar para rutas

    @GetMapping("/listarrutas")
    public List<RutaDTO> listarrutas() {
        return rutaserv.listarRutasDTO(null, null);
    }

    // obtener x id
    @GetMapping("/buscar/{id}")
    public ResponseEntity<BarcoDTO> BuscarxId(@PathVariable String id) {
        Barcos entidad = barcoserv.buscarPorId(id);
        if (entidad == null) {
            return ResponseEntity.notFound().build();
        }
        BarcoDTO dto = BarcoDTO.fromEntity(entidad);
        return ResponseEntity.ok(dto);
        /*
         * Barcos barquito1 = barcoserv.buscarPorId(id);
         * if (barquito1 != null) {
         * return ResponseEntity.ok(barquito1);// ok= codigo 200(tudo bem + cuerpo)
         * 
         * } else {
         * return ResponseEntity.notFound().build();// notfound= 404(not tudo bem, sin
         * cuerpo)
         * }
         */
    }
    // Reponse entity es una rpta http q tiene todo, cabecera, estado y cuerpo

    // crear barcos
    @PostMapping("/save")
    public ResponseEntity<Barcos> guardar(@RequestBody Barcos barquito1) {
        Barcos createdbarquito = barcoserv.guardarBarco(barquito1);

        return ResponseEntity.ok(createdbarquito);
    }

    // actualizar barcos
    @PutMapping("/editar/{id}")
    public ResponseEntity<Barcos> actualizarxId(@PathVariable String id, @RequestBody Barcos barquito2) {
        Barcos editedbarquito = barcoserv.buscarPorId(id);

        if (editedbarquito != null) {
            barcoserv.guardarBarco(editedbarquito);
            return ResponseEntity.ok(editedbarquito);
        } else {
            return ResponseEntity.notFound().build();
        }
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
