package com.utp.demo.controller;

import org.hibernate.Hibernate;
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


    

    @GetMapping
    public String mostrarlospaquetes(Model model) {
        model.addAttribute("paquete", new Paquete());
        model.addAttribute("beneficiosDisponibles", beneserv.ObtenertodoslosBeneficios());
        return "Mantenimiento/paqueteMant";
    }

    //buscar
    @GetMapping("/buscarpaquete")
    public String BuscarpaquetexId(@RequestParam String idPaquete, Model model) {

        //PaqueteDTO paqdto;
        Paquete paquetito= new Paquete();

        if (idPaquete == null || idPaquete.isBlank()) {// si no hay nada en field o apunta a nulo como inicio
            model.addAttribute("errorMsg", "Ingrese un ID válido");
            //paqdto = new PaqueteDTO();// aaa

        } else {
            // se usa el dto mas q nada para futuras actus, posible agregar otros atributos
            //paqdto= new PaqueteDTO();//me salia error ;; x no inicializar
            Paquete foundpaq= paqserv.buscarPorId(idPaquete);
            //paquetito= paqserv.buscarPorId(idPaquete);

            if (foundpaq != null) {
                //paqserv.convertiraDTO(paquetito, paqdto);
                paquetito= foundpaq;
                model.addAttribute("paquete", paquetito);
                

            } else {
                model.addAttribute("errorMsg", "No se encontró un barco con ID " + idPaquete);
                //paqdto = new PaqueteDTO();
                //paqdto.setIdPaquete(idPaquete);
                paquetito.setIdPaquete(idPaquete);
            }
        }     

        model.addAttribute("paquete", paquetito);
        model.addAttribute("beneficiosDisponibles", beneserv.ObtenertodoslosBeneficios());
        return "Mantenimiento/paqueteMant";
    }
    
    //editar
    @PostMapping("/editarpaquete")
    public String EditarPaquetexId(@ModelAttribute("paquete") Paquete paquetito2, Model model) {

        if (paquetito2.getIdPaquete().isBlank() && paquetito2.getNomPaquete().isBlank()
                && paquetito2.getDescPaquete().isBlank()) {//los 3 primeros
            model.addAttribute("errorMsg", "No hay nada para editar");
            return "Mantenimiento/paqueteMant";

        } // por si puso buscar y no le salio nada y usa el boton de editar
     
        Paquete paq= paqserv.buscarPorId(paquetito2.getIdPaquete());// se fija si el id esta en labase de datos

        if (paq == null) {// si se le ocurrio llenar todo y puso editar pero la id no esta en la bd
            model.addAttribute("errorMsg", "ID no existe, no hay nada para editar.");
            return "Mantenimiento/paqueteMant";
        } else {
            //paqserv.convertiraPaq(paquetito, paq);//convierte dto a paquete
            paqserv.guardarPaquete(paq);//guarda paquete
        }

        return "redirect:/Mantenimiento/paqueteMant";
        
    }

    //Eliminar
    @PostMapping("/eliminarpaquete")
    public String EliminarPaquetexId(@ModelAttribute("paquete") Paquete paquetito3, Model model) {

        if (paquetito3.getIdPaquete().isBlank() ) {
            model.addAttribute("errorMsg", "No hay nada para eliminar.");
            return "Mantenimiento/paqueteMant";
        }

        Paquete paq3= paqserv.buscarPorId(paquetito3.getIdPaquete());

        if (paq3 == null) {
            model.addAttribute("errorMsg", "ID no existe, no hay nada para eliminar.");
            return "Mantenimiento/paqueteMant";

        } else {
            Hibernate.initialize(paq3.getBeneficios());
            paqserv.eliminarPaquetexId(paquetito3.getIdPaquete());
        }
          
        return "redirect:/Mantenimiento/paqueteMant";
    }

    //guardar o crear
    @PostMapping("/guardarpaquete")
    public String GuardarPaquete(@ModelAttribute("paquete") Paquete paquetito4, Model model) {

        Paquete paqcreado= new Paquete();

        if (paquetito4.getIdPaquete().isBlank() || paquetito4.getNomPaquete().isBlank() || paquetito4.getDescPaquete().isBlank()
        || paquetito4.getPrecPaqueteUni() <= 0 || paquetito4.getBeneficios().isEmpty()) {

            model.addAttribute("errorMsg", "Faltan datos para creación de Paquete");
            model.addAttribute("beneficiosDisponibles", beneserv.ObtenertodoslosBeneficios());
            return "Mantenimiento/paqueteMant";
        }

        //paqserv.convertiraPaq(paquetito4, paqcreado);
        paqserv.guardarPaquete(paqcreado);         
        return "redirect:/Mantenimiento/paqueteMant";
    }
        
    
    

    
}
