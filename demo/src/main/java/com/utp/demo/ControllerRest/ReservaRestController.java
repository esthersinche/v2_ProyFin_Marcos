package com.utp.demo.ControllerRest;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.utp.demo.DTO.ReservaResumenDTO;
import com.utp.demo.DTO.Fragmentos.ClienteReservaDTO;
import com.utp.demo.DTO.Fragmentos.RutaReservaDTO;
import com.utp.demo.model.Cliente;
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

//api

    //1: Cliente
    //guardar cliente empezando a crear la reserva

    @PostMapping("/savecliente")
    public ResponseEntity<ReservaResumenDTO> guardarclientevar(@RequestBody ClienteReservaDTO clidto) {
        
        //se crea al cliente para guardarlo en la variable cliente de reserva entidad
        Cliente cli= new Cliente(clidto.getDniCliente(), clidto.getNombre(), clidto.getApellido(),
        clidto.getCorreo(), clidto.getCelular(), clidto.getCiudad());

        cliserv.guardarCliente(cli);

        //se envia a reserva todo lo q se de en el hmtl
        Reserva reservita= new Reserva();
        reservita.setCliente(cli);
        reservita.setCantidadPasajeros(clidto.getCantidadpasajeros());
        reservita.setFechaReserva(LocalDate.now());

        reservaserv.guardar(reservita);

        //convertir
        ReservaResumenDTO resres= ReservaResumenDTO.convertiraDTO(reservita);

        return ResponseEntity.ok(resres);
    }

    //2: rutas y barcos ;;;;;;;;;;;;;;;;;;;;;; ueueueueueueue patch para continuar 
    //actualizando reserva poquito a poquito
    //sans undertale goat
    @PatchMapping("/{id}/ruta")
    public ResponseEntity<ReservaResumenDTO> guardarparcialruta(@PathVariable String idruta , @RequestBody RutaReservaDTO routedto){


        //buscar id
        Ruta idroutefound= rutaserv.buscarPorId(idruta);
        if (idroutefound != null) {

            reservita
        }

        
    }

    

    


    
}
