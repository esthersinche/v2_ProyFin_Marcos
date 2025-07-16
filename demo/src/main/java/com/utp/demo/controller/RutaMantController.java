package com.utp.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.utp.demo.model.Ruta;
import com.utp.demo.service.RutaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller

@RequestMapping("/Mantenimiento/rutaMant")
public class RutaMantController {
    private RutaService rutaserv;

    public RutaMantController(RutaService rutaserv) {
        this.rutaserv = rutaserv;
    }

    @GetMapping
    public String mostrarlasrutas(Model model) {
        model.addAttribute("ruta", new Ruta());
        model.addAttribute("puertos", rutaserv.obtenerTodasLasSalidas());
        return "Mantenimiento/rutaMant";
    }

    //buscar
    @GetMapping("/buscarruta")
    public String BuscarRutaxId(@RequestParam String idRuta, Model model) {

        Ruta rutita= new Ruta();

        if (idRuta == null || idRuta.isBlank()) {// si no hay nada en field o apunta a nulo como inicio
            model.addAttribute("errorMsg", "Ingrese un ID válido");
           // rutadto = new RutaDTO();// aaa

        } else {
            // se usa el dto mas q nada para futuras actus, posible agregar otros atributos
            Ruta foundruta= rutaserv.buscarPorId(idRuta);

            if (foundruta != null) {
                rutita= foundruta;
                model.addAttribute("ruta", rutita);
                

            } else {
                model.addAttribute("errorMsg", "No se encontro una Ruta con ID " + idRuta);
                rutita.setIdruta(idRuta);

            }

        }

        model.addAttribute("ruta", rutita);
        model.addAttribute("puertos", rutaserv.obtenerTodasLasSalidas());

        return "Mantenimiento/rutaMant";
    }
    
    //editar
    @PostMapping("/editarruta")
    public String EditarRutaxId(@ModelAttribute("ruta") Ruta rutita1, Model model) {

        if (rutita1.getIdruta().isBlank() || rutita1.getNombreruta().isBlank()
                || rutita1.getDescripcionruta().isBlank()) {//los 3 primeros
            model.addAttribute("errorMsg", "No hay nada para editar");
            return "Mantenimiento/rutaMant";

        } // por si puso buscar y no le salio nada y usa el boton de editar
     
        Ruta ruta= rutaserv.buscarPorId(rutita1.getIdruta());// se fija si el id esta en labase de datos

        if (ruta == null) {// si se le ocurrio llenar todo y puso editar pero la id no esta en la bd
            model.addAttribute("puertos", rutaserv.obtenerTodasLasSalidas());
            model.addAttribute("errorMsg", "ID no existe, no hay nada para editar.");
            return "Mantenimiento/rutaMant";
        } else {
            rutaserv.guardarRuta(ruta);
        }

        return "redirect:/Mantenimiento/rutaMant";
    }
    
    //eliminar
    @PostMapping("/eliminarruta")
    public String EliminarRutaxId(@ModelAttribute("ruta") Ruta rutita3, Model model) {

        if (rutita3.getIdruta().isBlank() ) {
            model.addAttribute("errorMsg", "No hay nada para eliminar.");
            model.addAttribute("puertos", rutaserv.obtenerTodasLasSalidas());
            return "Mantenimiento/rutaMant";
        }

        Ruta ruta2= rutaserv.buscarPorId(rutita3.getIdruta());

        if (ruta2 == null) {
            model.addAttribute("errorMsg", "ID no existe, no hay nada para eliminar.");
            model.addAttribute("puertos", rutaserv.obtenerTodasLasSalidas());
            return "Mantenimiento/rutaMant";

        } else {

            rutaserv.eliminarRuta(rutita3.getIdruta());
        }
          
        return "redirect:/Mantenimiento/rutaMant";
    }
    
    //guardar
    @PostMapping("/guardarruta")
    public String GuardarRuta(@ModelAttribute("ruta") Ruta rutita4, Model model) {

         Ruta rutacreada= new Ruta();

        if (rutita4.getIdruta().isBlank() || rutita4.getNombreruta().isBlank() || rutita4.getDiasruta().isBlank() || 
        rutita4.getPrecioruta() == 0 || rutita4.getSalida().isBlank() || rutita4.getDescripcionruta().isBlank()
        || rutita4.getImagen().isBlank()) {

            model.addAttribute("errorMsg", "Faltan datos para creación de Ruta");
            model.addAttribute("puertos", rutaserv.obtenerTodasLasSalidas());
            return "Mantenimiento/rutaMant";
        }

        rutaserv.guardarRuta(rutacreada);    
        return "redirect:/Mantenimiento/rutaMant";
    }
    
    
    
}
