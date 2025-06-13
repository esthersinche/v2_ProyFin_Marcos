package com.utp.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.utp.demo.model.Cabina_Inst;
import com.utp.demo.model.Cliente;
import com.utp.demo.model.Paquete;
import com.utp.demo.model.Reserva;
import com.utp.demo.model.Ruta;
import com.utp.demo.service.CabinaService;
import com.utp.demo.service.PaqueteService;
import com.utp.demo.service.RutaService;

@Controller
@SessionAttributes("reserva")
public class ReservaController {

    private final RutaService rutaService;
    private final PaqueteService paqueteService;
    private final CabinaService cabinaService;

    public ReservaController(RutaService rutaService, PaqueteService paqueteService, CabinaService cabinaService) {
        this.rutaService = rutaService;
        this.paqueteService = paqueteService;
        this.cabinaService = cabinaService;
    }

    @ModelAttribute("reserva")
    public Reserva crearReserva() {
        return new Reserva();
    }

    // Paso 1: Cliente
    @GetMapping("/comprar")
    public String mostrarFormularioCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "comprar";
    }

    @PostMapping("/guardarCliente")
    public String guardarCliente(@ModelAttribute Cliente cliente, @ModelAttribute("reserva") Reserva reserva) {
        reserva.setCliente(cliente);
        return "redirect:/elegirruta";
    }

    // Paso 2: Ruta
    @GetMapping("/elegirruta")
    public String mostrarRutas(Model model) {
        model.addAttribute("rutas", rutaService.obtenerTodasLasRutas());
        return "elegirruta";
    }

    @PostMapping("/guardarRuta")
    public String guardarRuta(@RequestParam String nombre_ruta, @ModelAttribute("reserva") Reserva reserva) {
        Ruta ruta = rutaService.buscarPorNombreRuta(nombre_ruta);
        reserva.setRuta(ruta);
        return "redirect:/elegirpaquete";
    }

    // Paso 3: Paquete y Cabina
    @GetMapping("/elegirpaquete")
    public String mostrarPaquetesPorRuta(Model model, @ModelAttribute("reserva") Reserva reserva) {
        Ruta rutaSeleccionada = reserva.getRuta();

        if (rutaSeleccionada == null) {
            System.out.println("Ruta no encontrada en la reserva.");
            return "redirect:/elegirruta";
        }

        List<Paquete> paquetes = paqueteService.obtenerPaquetesPorRuta(rutaSeleccionada.getNombre_ruta());

        if (paquetes.isEmpty()) {
            System.out.println("No hay paquetes disponibles para esta ruta.");
        }

        model.addAttribute("paquetes", paquetes);
        return "elegirpaquete";
    }

    @PostMapping("/guardarPaquete")
    public String guardarPaqueteCabina(
            @RequestParam String nombrePaquete,
            @ModelAttribute("reserva") Reserva reserva) {

        String nombreRuta = reserva.getRuta().getNombre_ruta();
        Paquete paquete = paqueteService.buscarPorNombreYRuta(nombrePaquete, nombreRuta);

        if (paquete == null) {
            System.out.println("Paquete no encontrado para la ruta.");
            return "redirect:/elegirpaquete";
        }

        Cabina_Inst cabina = cabinaService.buscarPorTipoCabina(paquete.getCabinatipoPaq());
        reserva.setCabina(cabina);

        reserva.setPaquete(paquete);

        int cantidad = reserva.getCantidadPasajeros();
        double precioUnitario = paquete.getPrec_paquete_uni();
        double total = cantidad * precioUnitario;

        reserva.setTotal(total);

        return "redirect:/resumen";
    }

    // Paso 4: Resumen
    @GetMapping("/resumen")
    public String mostrarResumen(@ModelAttribute("reserva") Reserva reserva, Model model) {
        model.addAttribute("reserva", reserva);
        return "resumen";
    }
}
