package com.utp.demo.ControllerRest;

import java.net.URI;
import java.time.LocalDate;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.utp.demo.DTO.Fragmentos.BarcoReservaDTO;
import com.utp.demo.DTO.Fragmentos.ClienteReservaDTO;
import com.utp.demo.DTO.Fragmentos.PaqueteyCabinaReservaDTO;
import com.utp.demo.DTO.Fragmentos.RutaReservaDTO;
import com.utp.demo.DTO.ReservaResumenDTO;
import com.utp.demo.model.Barcos;
import com.utp.demo.model.Cabina_Inst;
import com.utp.demo.model.Cliente;
import com.utp.demo.model.Paquete;
import com.utp.demo.model.Reserva;
import com.utp.demo.model.Ruta;
import com.utp.demo.service.BarcoService;
import com.utp.demo.service.CabinaService;
import com.utp.demo.service.ClienteService;
import com.utp.demo.service.PaqueteService;
import com.utp.demo.service.ReservaService;
import com.utp.demo.service.RutaService;

@RestController
@RequestMapping("/api/reservacontrol")
public class ReservaRestController {

    private final ReservaService reservaserv;
    private final RutaService rutaserv;
    private final BarcoService barcoserv;
    private final PaqueteService paqserv;
    private final CabinaService cabinaserv;
    private final ClienteService cliserv;

    public ReservaRestController(ReservaService reservaserv, RutaService rutaserv, BarcoService barcoserv,
            PaqueteService paqserv, CabinaService cabinaserv, ClienteService cliserv) {
        this.reservaserv = reservaserv;
        this.rutaserv = rutaserv;
        this.barcoserv = barcoserv;
        this.paqserv = paqserv;
        this.cabinaserv = cabinaserv;
        this.cliserv = cliserv;
    }

    // api
    // 1: Cliente
    // guardar cliente empezando a crear la reserva
    @PostMapping
    public ResponseEntity<ReservaResumenDTO> guardarclientevar(@RequestBody ClienteReservaDTO clidto) {

        // se crea al cliente para guardarlo en la variable cliente de reserva entidad
        Cliente cli = new Cliente(clidto.getDniCliente(), clidto.getNombre(), clidto.getApellido(),
                clidto.getCorreo(), clidto.getCelular(), clidto.getCiudad());

        cliserv.guardarCliente(cli);

        // se envia a reserva todo lo q se de en el hmtl
        Reserva reservita = reservaserv.iniciarReserva();
        reservita.setCliente(cli);
        reservita.setCantidadPasajeros(clidto.getCantidadpasajeros());
        reservita.setFechaReserva(LocalDate.now());

        Reserva resbeacon = reservaserv.guardar(reservita);

        // convertir
        ReservaResumenDTO resres = ReservaResumenDTO.convertiraDTO(resbeacon);

        // para que el patch tenga el id reserva con q seguir
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(resbeacon.getIdReserva())
                .toUri();

        return ResponseEntity.created(location).body(resres);
        // created = 201 con header y body causa
    }

    // 2: rutas y barcos ;;;;;;;;;;;;;;;;;;;;;; ueueueueueueue patch para continuar
    // actualizando reserva poquito a poquito
    // sans undertale goat
    @PatchMapping("/{id}/ruta")
    public ResponseEntity<ReservaResumenDTO> guardarparcialruta(@PathVariable String id,
            @RequestBody RutaReservaDTO routedto) {

        // buscar id reserva}
        Reserva continuereserva = reservaserv.buscar(id);
        if (continuereserva == null) {
            return ResponseEntity.notFound().build();
        }
        // luego buscar la id de ruta
        Ruta idroutefound = rutaserv.buscarPorId(routedto.getIdRuta());
        if (idroutefound == null) {
            return ResponseEntity.notFound().build();
        }

        // guardar las weas
        continuereserva.setRuta(idroutefound);
        continuereserva = reservaserv.guardar(continuereserva);
        ReservaResumenDTO resres2 = ReservaResumenDTO.convertiraDTO(continuereserva);
        return ResponseEntity.ok(resres2);
    }

    // actualizando parte de reserva con barcos
    @PatchMapping("/{id}/barcos")
    public ResponseEntity<ReservaResumenDTO> guardarparcialbarcos(@PathVariable String id,
            @RequestBody BarcoReservaDTO boatdto) {

        // buscar reserva primero
        Reserva continuereserva2 = reservaserv.buscar(id);
        if (continuereserva2 == null) {
            return ResponseEntity.notFound().build();
        }
        // ahora si id de barco
        Barcos idboatfound = barcoserv.buscarPorId(boatdto.getIdBarco());
        if (idboatfound == null) {
            return ResponseEntity.notFound().build();
        }

        // guardar todo manito todo
        continuereserva2.setBarco(idboatfound);
        continuereserva2 = reservaserv.guardar(continuereserva2);
        ReservaResumenDTO resres3 = ReservaResumenDTO.convertiraDTO(continuereserva2);
        return ResponseEntity.ok(resres3);
    }

    // 3: paquete
    @PatchMapping("/{id}/paqueteycabina")
    public ResponseEntity<ReservaResumenDTO> guardarparcialpaqsycabin(@PathVariable String id,
            @RequestBody PaqueteyCabinaReservaDTO packdto) {

        // buscarreserva the usual
        Reserva continuereserva3 = reservaserv.buscar(id);
        if (continuereserva3 == null) {
            return ResponseEntity.notFound().build();
        }

        // id de paquete y de cabina
        Paquete idpaqfound = paqserv.buscarPorId(packdto.getIdPaquete());
        Cabina_Inst idcabinfound = cabinaserv.buscarPorIdCabina(packdto.getIdCabina());
        if (idpaqfound == null || idcabinfound == null) {
            return ResponseEntity.notFound().build();
        }

        // guardartodo sisisisisisisisisisisisisisisisisi
        // heavy is the crown goddddddd
        // THIS IS WHAT U ASKED FOR HEAVY IS THE CROWN
        continuereserva3.setPaquete(idpaqfound);
        continuereserva3.setCabina(idcabinfound);
        continuereserva3 = reservaserv.guardar(continuereserva3);
        ReservaResumenDTO resres4 = ReservaResumenDTO.convertiraDTO(continuereserva3);
        return ResponseEntity.ok(resres4);

    }

    // 4: finalizado
    @PatchMapping("/{id}/pago")
    public ResponseEntity<ReservaResumenDTO> confirmarypagofinal(@PathVariable String id) {

        // tut ututu ututu tutututu utututut utututu utututu utututu ututututtututuut
        // last one omfg free at last
        Reserva continuefinalreserva = reservaserv.buscar(id);
        if (continuefinalreserva == null) {
            return ResponseEntity.notFound().build();
        }

        // porsia
        if (continuefinalreserva.getRuta() == null || continuefinalreserva.getBarco() == null
                || continuefinalreserva.getPaquete() == null || continuefinalreserva.getCabina() == null) {
            return ResponseEntity.notFound().build();

        }

        // pagospagospagospagos
        double pagofinomguni = continuefinalreserva.getPaquete().getPrecPaqueteUni()
                + continuefinalreserva.getCabina().getCabTipo().getPrecCabinaPer()
                + continuefinalreserva.getRuta().getPrecioruta();

        // set total y guardor todo, mi precioso nono el señor frodo no te alejara demi
        continuefinalreserva.setTotal(pagofinomguni * continuefinalreserva.getCantidadPasajeros());
        continuefinalreserva = reservaserv.guardar(continuefinalreserva);

        // convertir y mandar como json p
        ReservaResumenDTO resres5 = ReservaResumenDTO.convertiraDTO(continuefinalreserva);

        return ResponseEntity.ok(resres5);
    }

    // final omfg 5: resumen completo
    @GetMapping("/{id}")
    public ResponseEntity<ReservaResumenDTO> resumenyipee(@PathVariable String id) {

        // buscar id por ultima vez esta vez fr
        Reserva finalfinalreservafr = reservaserv.buscar(id);
        if (finalfinalreservafr == null) {
            return ResponseEntity.notFound().build();
        }
        // osea existe
        // si esta incompleto
        if (finalfinalreservafr.getCliente() == null || finalfinalreservafr.getRuta() == null
                || finalfinalreservafr.getBarco() == null
                || finalfinalreservafr.getPaquete() == null || finalfinalreservafr.getCabina() == null) {
            return ResponseEntity.badRequest().build();
            // 400= bad request
        } else {
            // siexiste / y no esta incompleto
            ReservaResumenDTO finalresresalfin = ReservaResumenDTO.convertiraDTO(finalfinalreservafr);
            return ResponseEntity.ok(finalresresalfin);// 200
        }
    }

    //simulacion de pago causas 
    @PostMapping("/pagos/simulacion")
    public ResponseEntity<String> simularPago(@RequestBody Map<String, Object> payload) {
        String metodo = (String) payload.get("metodo");
        String reservaId = (String) payload.get("reservaId");

        if (metodo == null || reservaId == null) {
            return ResponseEntity.badRequest().body("Faltan datos");
        }

        // Simulación de lógica según método
        if (metodo.equals("tarjeta")) {
            // Lógica ficticia: validación de tarjeta (si se desea)
            System.out.println("Simulando pago con tarjeta para reserva " + reservaId);
        } else if (metodo.equals("yape")) {
            System.out.println("Simulando pago con Yape para reserva " + reservaId);
        } else {
            return ResponseEntity.badRequest().body("Método no válido");
        }

        return ResponseEntity.ok("Pago simulado exitoso");
    }
}
