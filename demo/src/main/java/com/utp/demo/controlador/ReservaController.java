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

    // Paso 1: Cliente
    @GetMapping("/comprar")
    public String mostrarFormularioCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("reserva", new Reserva()); // <-- Añade esto
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
        model.addAttribute("rutas", rutaService.obtenerTodoRutas());
        return "elegirruta";
    }

    @PostMapping("/guardarRuta")
    public String guardarRuta(@RequestParam String nombre_ruta, @ModelAttribute("reserva") Reserva reserva) {
        Ruta ruta = rutaService.buscarPorNombreRuta(nombre_ruta);
        reserva.setRuta(ruta);
        return "redirect:/elegirpaquete";
    }

    // Paso 3: Paquetes y Cabina
    @GetMapping("/elegirpaquete")
    public String mostrarPaquetesYCabinas(Model model) {
        model.addAttribute("paquetes", paqueteService.obtenerTodoPaquetes());
        model.addAttribute("cabinas", cabinaService.obtenerTodoCabinas());
        return "elegirpaquete";
    }

    @PostMapping("/guardarPaquete")
    public String guardarPaqueteCabina(
            @RequestParam List<String> paquetesSeleccionados,
            @RequestParam String nombre_cab,
            @RequestParam int cantidadAdultos,
            @RequestParam int cantidadNinos,
            @ModelAttribute("reserva") Reserva reserva) {

        // Obtener objetos reales
        List<Paquete> paquetes = paqueteService.buscarPorNombrePaquetes(paquetesSeleccionados);
        Cabina cabina = cabinaService.buscarPorNombreCabina(nombre_cab);

        // Guardar datos en reserva
        reserva.setCabina(cabina);
        reserva.setPaquetes(paquetes);
        reserva.setCantidadAdultos(cantidadAdultos);
        reserva.setCantidadNinos(cantidadNinos);

        // Calcular total
        double total = 0;
        double precioRuta = reserva.getRuta().getPrecio_ruta();
        double precioCabina = cabina.getPrecio();

        // 1. Ruta
        total += cantidadAdultos * precioRuta;
        total += cantidadNinos * (precioRuta * 0.65);

        // 2. Paquetes
        for (Paquete paquete : paquetes) {
            boolean esParaNinos = paquete.getNombre_paq().toLowerCase().contains("niños");
            if (esParaNinos) {
                total += cantidadNinos * paquete.getPrecio_paq();
            } else {
                total += cantidadAdultos * paquete.getPrecio_paq();
                total += cantidadNinos * (paquete.getPrecio_paq() * 0.65);
            }
        }

        // 3. Cabina
        total += precioCabina;

        int maxAdultos = cabina.getMaximoAdultos();
        int maxNinos = cabina.getMaximoNinos();

        int adicionalesAdultos = Math.max(0, cantidadAdultos - maxAdultos);
        int adicionalesNinos = Math.max(0, cantidadNinos - maxNinos);

        double adicionalAdulto = precioCabina / maxAdultos;
        double adicionalNino = precioCabina / maxNinos;

        total += (adicionalesAdultos * adicionalAdulto);
        total += (adicionalesNinos * adicionalNino);

        reserva.setTotal(total);

        return "redirect:/resumen";
    }

    // Paso 4: Resumen final
    @GetMapping("/resumen")
    public String mostrarResumen(@ModelAttribute("reserva") Reserva reserva, Model model) {
        model.addAttribute("reserva", reserva);
        return "resumen";
    }
}
