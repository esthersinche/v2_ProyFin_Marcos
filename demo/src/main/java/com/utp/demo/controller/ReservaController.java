package com.utp.demo.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.utp.demo.model.Barcos;
import com.utp.demo.model.Cabina_Inst;
import com.utp.demo.model.Cliente;
import com.utp.demo.model.Paquete;
import com.utp.demo.model.Reserva;
import com.utp.demo.model.Ruta;
import com.utp.demo.service.BarcoService;
import com.utp.demo.service.CabinaService;
import com.utp.demo.service.PaqueteService;
import com.utp.demo.service.ReservaService;
import com.utp.demo.service.RutaService;

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

    @ModelAttribute("reserva")
    public Reserva reservaSession() {
        return reservaService.iniciarReserva();
    }

// Paso 1: Cliente
    @GetMapping("/comprar")
    public String mostrarFormularioCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "comprar";
    }

    @PostMapping("/guardarCliente")
    public String guardarCliente(
            @ModelAttribute Cliente cliente,
            @RequestParam int cantidadPasajeros,
            @ModelAttribute("reserva") Reserva reserva
    ) {

        reserva.setCliente(cliente);
        reserva.setCantidadPasajeros(cantidadPasajeros);
        reserva.setFechaReserva(LocalDate.now());
        return "redirect:/elegirruta";

    }

// Paso 2: Ruta + barco
    @GetMapping("/elegirruta")
    public String mostrarRutas(Model model) {
        model.addAttribute("rutas", rutaService.obtenerTodasLasRutas());
        model.addAttribute("barcos", barcoService.obtenerPorRuta(null));
        return "elegirruta";
    }

    @PostMapping("/guardarRuta")
    public String guardarRuta(
            @RequestParam String idruta,
            @ModelAttribute("reserva") Reserva reserva,
            Model model) {
        Ruta ruta = rutaService.buscarPorId(idruta);
        reserva.setRuta(ruta);
        model.addAttribute("rutas", rutaService.obtenerTodasLasRutas());
        model.addAttribute("selectedRuta", idruta);
        model.addAttribute("barcos", barcoService.obtenerPorRuta(idruta));
        return "elegirruta";
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
        Cabina_Inst cb = cabinaService.buscarPorIdCabina(Long.parseLong(idcabina));
        reserva.setPaquete(pq);
        reserva.setCabina(cb);
        double unitario = pq.getPrecPaqueteUni()
                + reserva.getRuta().getPrecioruta()
                + cb.getCab_tipo().getPrecCabinaPer();
        model.addAttribute("precioUnitario", unitario);
        // recargar misma vista con precio disponible y confirmación
        model.addAttribute("paquetes", paqueteService.obtenerTodosLosPaquetes());
        model.addAttribute("cabinas", cabinaService.obtenerPorBarco(reserva.getBarco().getIDbarco()));
        return "elegirpaquete";
    }

    @PostMapping("/confirmarReserva")
    public String confirmarReserva(
            @ModelAttribute("reserva") Reserva reserva,
            @RequestParam double precioUnitario) {
        int qty = reserva.getCantidadPasajeros();
        reserva.setTotal(precioUnitario * qty);
        reservaService.guardar(reserva);
        return "redirect:/resumen";
    }

// Paso 4: Resumen
    @GetMapping("/resumen")
    public String mostrarResumen(@ModelAttribute("reserva") Reserva reserva, Model model
    ) {
        model.addAttribute("reserva", reserva);
        return "resumen";
    }

}
