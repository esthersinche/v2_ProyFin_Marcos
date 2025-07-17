package com.utp.demo.controller;

import java.time.LocalDate;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

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

import jakarta.validation.Valid;

@Controller

@SessionAttributes("reserva")

public class ReservaController {

    private final ReservaService reservaService;
    private final RutaService rutaService;
    private final BarcoService barcoService;
    private final PaqueteService paqueteService;
    private final CabinaService cabinaService;

    public ReservaController(
            ReservaService reservaService,
            RutaService rutaService,
            BarcoService barcoService,
            PaqueteService paqueteService,
            CabinaService cabinaService) {
        this.reservaService = reservaService;
        this.rutaService = rutaService;
        this.barcoService = barcoService;
        this.paqueteService = paqueteService;
        this.cabinaService = cabinaService;
    }

// Paso 1: Cliente
    @GetMapping("/comprar")
    public String mostrarFormularioCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "comprar";
    }

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/guardarCliente")
    public String guardarCliente(
            @Valid @ModelAttribute Cliente cliente,
            BindingResult result,
            @RequestParam int cantidadPasajeros,
            @ModelAttribute("reserva") Reserva reserva,
            Model model) {
        if (result.hasErrors()) {
            return "comprar";
        }
        clienteService.guardarCliente(cliente);

        reserva.setCliente(cliente);
        reserva.setCantidadPasajeros(cantidadPasajeros);
        reserva.setFechaReserva(LocalDate.now());
        return "redirect:/elegirruta";
    }

    @ModelAttribute("reserva")
    public Reserva reservaSession() {
        return reservaService.iniciarReserva();
    }

// Paso 2: Ruta + barco
    @GetMapping("/elegirruta")
    public String mostrarRutas(
            @RequestParam(required = false) String selectedRuta,
            @ModelAttribute("reserva") Reserva reserva,
            Model model) {

        // Siempre cargo las rutas
        model.addAttribute("rutas", rutaService.obtenerTodasLasRutas());

        if (selectedRuta != null) {
            // Si viene ?selectedRuta=XYZ, cargo los barcos y marco la ruta seleccionada
            model.addAttribute("selectedRuta", selectedRuta);
            model.addAttribute("barcos", barcoService.obtenerPorRuta(selectedRuta));
        } else {
            // Primera vez que entras, lista de barcos vacía
            model.addAttribute("barcos", Collections.<Barcos>emptyList());
        }

        return "elegirruta";
    }

    @PostMapping("/guardarRuta")
    public String guardarRuta(
            @RequestParam String idruta,
            @ModelAttribute("reserva") Reserva reserva) {

        Ruta ruta = rutaService.buscarPorId(idruta);
        reserva.setRuta(ruta);

        // redirige enviando el parámetro selectedRuta
        return "redirect:/elegirruta?selectedRuta=" + idruta;
    }

    @PostMapping("/guardarBarco")
    public String guardarBarco(
            @RequestParam String idbarco,
            @ModelAttribute("reserva") Reserva reserva) {
        Barcos barco = barcoService.buscarPorIdBarco(idbarco);
        reserva.setBarco(barco);
        return "redirect:/elegirpaquete";
    }

// Paso 3: Paquete + Cabina + Cálculo Precio Unitario
    @GetMapping("/elegirpaquete")
    public String paqueteForm(Model model, @ModelAttribute("reserva") Reserva reserva) {
        model.addAttribute("paquetes", paqueteService.obtenerTodosLosPaquetes());
        model.addAttribute("cabinas", cabinaService.obtenerPorBarco(reserva.getBarco().getIDbarco()));
        return "elegirpaquete";
    }

    @PostMapping("/guardarPaquete")
    public String guardarPaquete(
            @RequestParam String idpaquete,
            @RequestParam String idcabina,
            @ModelAttribute("reserva") Reserva reserva,
            Model model) {
        Paquete pq = paqueteService.buscarPorId(idpaquete);
        Cabina_Inst cb = cabinaService.buscarPorIdCabina(idcabina);
        reserva.setPaquete(pq);
        reserva.setCabina(cb);
        double unitario = pq.getPrecPaqueteUni()
                + reserva.getRuta().getPrecioruta()
                + cb.getCabTipo().getPrecCabinaPer();
        model.addAttribute("precioUnitario", unitario);
        // recargar misma vista con precio disponible y confirmación
        model.addAttribute("paquetes", paqueteService.obtenerTodosLosPaquetes());
        model.addAttribute("cabinas", cabinaService.obtenerPorBarco(reserva.getBarco().getIDbarco()));
        return "elegirpaquete";
    }

    @PostMapping("/confirmarReserva")
    public String confirmarReserva(
            @ModelAttribute("reserva") Reserva reserva,
            @RequestParam double precioUnitario,
            SessionStatus status) {
        reserva.setTotal(precioUnitario * reserva.getCantidadPasajeros());
        // Guarda y recupera la entidad con su id generado
        Reserva reservaGuardada = reservaService.guardar(reserva);
        status.setComplete();   // elimina "reserva" de la sesión
        return "redirect:/resumen?id=" + reservaGuardada.getIdReserva();
    }

// Paso 4: Resumen
    @GetMapping("/resumen")
    public String mostrarResumen(
            @RequestParam("id") String idReserva,
            Model model) {

        // Recupera la reserva completa (con cliente, ruta, paquete, etc.)
        Reserva reserva = reservaService.buscar(idReserva);
        ReservaResumenDTO resres= ReservaResumenDTO.convertiraDTO(reserva);
        

        model.addAttribute("resumen", resres);
        return "resumen";
    }

}
