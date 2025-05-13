package com.utp.demo.controlador;

import com.utp.demo.modelo.*;
import com.utp.demo.servicio.RutaService;
import com.utp.demo.servicio.PaqueteService;
import com.utp.demo.servicio.CabinaService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // Paso 1: Formulario del cliente
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

    // Paso 2: Elegir ruta
    @GetMapping("/elegirruta")
    public String mostrarRutas(Model model) {
        model.addAttribute("rutas", rutaService.obtenerTodas());
        return "elegirruta";
    }

    @PostMapping("/guardarRuta")
    public String guardarRuta(@RequestParam String nombre_ruta, @ModelAttribute("reserva") Reserva reserva) {
        Ruta ruta = rutaService.buscarPorNombre(nombre_ruta);
        reserva.setRuta(ruta);
        return "redirect:/elegirpaquete";
    }

    // Paso 3: Elegir paquetes y cabina
    @GetMapping("/elegirpaquete")
    public String mostrarPaquetesYCabinas(Model model) {
        model.addAttribute("paquetes", paqueteService.obtenerTodos());
        model.addAttribute("cabinas", cabinaService.obtenerTodas());
        return "elegirpaquete";
    }

    @PostMapping("/guardarPaquete")
    public String guardarPaqueteCabina(
            @RequestParam List<String> paquetesSeleccionados,
            @RequestParam String nombre_cab,
            @RequestParam int cantidad_personas,
            @RequestParam int cantidad_niños,
            @ModelAttribute("reserva") Reserva reserva) {

        List<Paquete> paquetes = paqueteService.buscarPorNombres(paquetesSeleccionados);
        Cabina cabina = cabinaService.buscarPorNombre(nombre_cab);
        cabina.setCantidad_personas(cantidad_personas);
        cabina.setCantidad_niños(cantidad_niños);

        reserva.setPaquetes(paquetes);
        reserva.setCabina(cabina);

        return "redirect:/resumen";
    }

    // Paso 4: Mostrar resumen
    @GetMapping("/resumen")
    public String mostrarResumen(@ModelAttribute("reserva") Reserva reserva, Model model) {
        model.addAttribute("reserva", reserva);
        return "resumen";
    }
}
