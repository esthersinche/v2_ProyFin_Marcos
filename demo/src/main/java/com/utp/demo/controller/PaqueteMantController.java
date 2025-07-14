package com.utp.demo.controller;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utp.demo.model.Paquete;
import com.utp.demo.service.BeneficioService;
import com.utp.demo.service.PaqueteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("Mantenimiento/paqueteMant")
public class PaqueteMantController {

    private PaqueteService paqserv;
    private BeneficioService beneserv;
    
    public PaqueteMantController(PaqueteService paqserv, BeneficioService beneserv) {
        this.paqserv = paqserv;
        this.beneserv = beneserv;
    }

    //coso de api

    //listar
    


    /* 

    @GetMapping
    public String mostrarlospaquetes(Model model) {
        model.addAttribute("paquete", new PaqueteDTO());
        model.addAttribute("beneficiosDisponibles", beneserv.ObtenertodoslosBeneficios());
        return "Mantenimiento/paqueteMant";
    }

    //buscar
    @GetMapping("/buscarpaquete")
    public String BuscarpaquetexId(@RequestParam String idPaquete, Model model) {

        PaqueteDTO paqdto;

        if (idPaquete == null || idPaquete.isBlank()) {// si no hay nada en field o apunta a nulo como inicio
            model.addAttribute("errorMsg", "Ingrese un ID válido");
            paqdto = new PaqueteDTO();// aaa

        } else {
            // se usa el dto mas q nada para futuras actus, posible agregar otros atributos
            paqdto= new PaqueteDTO();//me salia error ;; x no inicializar
            Paquete paquetito= paqserv.buscarPorId(idPaquete);

            if (paquetito != null) {
                paqserv.convertiraDTO(paquetito, paqdto);

            } else {
                model.addAttribute("errorMsg", "No se encontro un barco con ID " + idPaquete);
                paqdto = new PaqueteDTO();
                paqdto.setIdPaquete(idPaquete);

            }

        }

        model.addAttribute("paquete", paqdto);
        model.addAttribute("beneficiosDisponibles", beneserv.ObtenertodoslosBeneficios());

        return "Mantenimiento/paqueteMant";
    }
    
    //editar
    @PostMapping("/editarpaquete")
    public String EditarPaquetexId(@ModelAttribute("paquete") PaqueteDTO paquetito, Model model) {

        if (paquetito.getIdPaquete().isBlank() && paquetito.getNomPaquete().isBlank()
                && paquetito.getDescPaquete().isBlank()) {//los 3 primeros
            model.addAttribute("errorMsg", "No hay nada para editar");
            return "Mantenimiento/paqueteMant";

        } // por si puso buscar y no le salio nada y usa el boton de editar
     
        Paquete paq= paqserv.buscarPorId(paquetito.getIdPaquete());// se fija si el id esta en labase de datos

        if (paq == null) {// si se le ocurrio llenar todo y puso editar pero la id no esta en la bd
            model.addAttribute("errorMsg", "ID no existe, no hay nada para editar.");
            return "Mantenimiento/paqueteMant";
        } else {
            paqserv.convertiraPaq(paquetito, paq);//convierte dto a paquete
            paqserv.guardarPaquete(paq);//guarda paquete
        }

        return "redirect:/Mantenimiento/paqueteMant";
        
    }

    //Eliminar
    @PostMapping("/eliminarpaquete")
    public String EliminarPaquetexId(@ModelAttribute("paquete") PaqueteDTO paquetito2, Model model) {

        if (paquetito2.getIdPaquete().isBlank() ) {
            model.addAttribute("errorMsg", "No hay nada para eliminar.");
            return "Mantenimiento/paqueteMant";
        }

        Paquete paq2= paqserv.buscarPorId(paquetito2.getIdPaquete());

        if (paq2 == null) {
            model.addAttribute("errorMsg", "ID no existe, no hay nada para eliminar.");
            return "Mantenimiento/paqueteMant";

        } else {
            Hibernate.initialize(paq2.getBeneficios());
            paqserv.eliminarPaquetexId(paquetito2.getIdPaquete());
        }
          
        return "redirect:/Mantenimiento/paqueteMant";
    }

    //guardar o crear
    @PostMapping("/guardarpaquete")
    public String GuardarPaquete(@ModelAttribute("paquete") PaqueteDTO paquetito3, Model model) {

        Paquete paqcreado= new Paquete();

        if (paquetito3.getIdPaquete().isBlank() || paquetito3.getNomPaquete().isBlank() || paquetito3.getDescPaquete().isBlank()
        || paquetito3.getPrecPaqueteUni() == null || paquetito3.getIdsbeneficios().isEmpty()) {

            model.addAttribute("errorMsg", "Faltan datos para creación de Paquete");
            model.addAttribute("beneficiosDisponibles", beneserv.ObtenertodoslosBeneficios());
            return "Mantenimiento/paqueteMant";
        }

        paqserv.convertiraPaq(paquetito3, paqcreado);
        paqserv.guardarPaquete(paqcreado);
        
        
        return "redirect:/Mantenimiento/paqueteMant";
    }
        */
    
    

    
}
