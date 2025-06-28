package com.utp.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.utp.demo.model.Ruta;
import com.utp.demo.model.DTO.RutaDTO;
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
        model.addAttribute("ruta", new RutaDTO());
        model.addAttribute("puertos", rutaserv.obtenerTodasLasSalidas());
        return "Mantenimiento/rutaMant";
    }

    //buscar
    @GetMapping("/buscarruta")
    public String BuscarRutaxId(@RequestParam String idRuta, Model model) {

        RutaDTO rutadto;

        if (idRuta == null || idRuta.isBlank()) {// si no hay nada en field o apunta a nulo como inicio
            model.addAttribute("errorMsg", "Ingrese un ID válido");
            rutadto = new RutaDTO();// aaa

        } else {
            // se usa el dto mas q nada para futuras actus, posible agregar otros atributos
            rutadto= new RutaDTO();//me salia error ;; x no inicializar
            Ruta rutita= rutaserv.buscarPorId(idRuta);

            if (rutita != null) {
                rutaserv.convertiraDTO(rutita, rutadto);

            } else {
                model.addAttribute("errorMsg", "No se encontro una Ruta con ID " + idRuta);
                rutadto = new RutaDTO();
                rutadto.setIdRuta(idRuta);

            }

        }

        model.addAttribute("ruta", rutadto);
        model.addAttribute("puertos", rutaserv.obtenerTodasLasSalidas());

        return "Mantenimiento/rutaMant";
    }
    
    //editar
    @PostMapping("/editarruta")
    public String EditarRutaxId(@ModelAttribute("ruta") RutaDTO rutita, Model model) {

        if (rutita.getIdRuta().isBlank() || rutita.getNombreRuta().isBlank()
                || rutita.getDescripcionRuta().isBlank()) {//los 3 primeros
            model.addAttribute("errorMsg", "No hay nada para editar");
            return "Mantenimiento/rutaMant";

        } // por si puso buscar y no le salio nada y usa el boton de editar
     
        Ruta ruta= rutaserv.buscarPorId(rutita.getIdRuta());// se fija si el id esta en labase de datos

        if (ruta == null) {// si se le ocurrio llenar todo y puso editar pero la id no esta en la bd
            model.addAttribute("puertos", rutaserv.obtenerTodasLasSalidas());
            model.addAttribute("errorMsg", "ID no existe, no hay nada para editar.");
            return "Mantenimiento/rutaMant";
        } else {
            rutaserv.convertiraRuta(rutita, ruta);
            rutaserv.guardarRuta(ruta);
        }

        return "redirect:/Mantenimiento/rutaMant";
    }
    
    //eliminar
    @PostMapping("/eliminarruta")
    public String EliminarRutaxId(@ModelAttribute("ruta") RutaDTO rutita2, Model model) {

        if (rutita2.getIdRuta().isBlank() ) {
            model.addAttribute("errorMsg", "No hay nada para eliminar.");
            model.addAttribute("puertos", rutaserv.obtenerTodasLasSalidas());
            return "Mantenimiento/rutaMant";
        }

        Ruta ruta2= rutaserv.buscarPorId(rutita2.getIdRuta());

        if (ruta2 == null) {
            model.addAttribute("errorMsg", "ID no existe, no hay nada para eliminar.");
            model.addAttribute("puertos", rutaserv.obtenerTodasLasSalidas());
            return "Mantenimiento/rutaMant";

        } else {

            rutaserv.eliminarRuta(rutita2.getIdRuta());
        }
          
        return "redirect:/Mantenimiento/rutaMant";
    }
    
    //guardar
    @PostMapping("/guardarruta")
    public String GuardarRuta(@ModelAttribute("ruta") RutaDTO rutita3, Model model) {

         Ruta rutacreada= new Ruta();

        if (rutita3.getIdRuta().isBlank() || rutita3.getNombreRuta().isBlank() || rutita3.getDiasRuta().isBlank() || 
        rutita3.getPrecioRuta() == null || rutita3.getSalidaRuta().isBlank() || rutita3.getDescripcionRuta().isBlank()
        || rutita3.getUrlRuta().isBlank()) {

            model.addAttribute("errorMsg", "Faltan datos para creación de Ruta");
            model.addAttribute("puertos", rutaserv.obtenerTodasLasSalidas());
            return "Mantenimiento/rutaMant";
        }

        rutaserv.convertiraRuta(rutita3, rutacreada);
        rutaserv.guardarRuta(rutacreada);
      
        return "redirect:/Mantenimiento/rutaMant";
    }
    
    
    
}
