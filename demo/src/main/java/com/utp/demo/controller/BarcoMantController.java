package com.utp.demo.controller;



import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.utp.demo.model.Barcos;
import com.utp.demo.service.BarcoRepository;
import com.utp.demo.service.BarcoService;
import com.utp.demo.service.RutaService;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/Mantenimiento/barcoMant")
public class BarcoMantController {

    private final BarcoController barcoController;
    private BarcoService barcoserv;
    private BarcoRepository barcorepo;
    private RutaService rutaserv;

    public BarcoMantController(BarcoService barcoserv, BarcoRepository barcorepo, RutaService rutaserv, BarcoController barcoController) {
        this.barcoserv = barcoserv;
        this.barcorepo = barcorepo;
        this.rutaserv = rutaserv;
        this.barcoController = barcoController;
    }

    


    @GetMapping
    public String mostrarlosbarcos(Model model) {
        model.addAttribute("barco", new Barcos());
        model.addAttribute("modelos", barcorepo.findDistinctModelos());
        model.addAttribute("rutasDisponibles", rutaserv.obtenerTodasLasRutas());
        return "Mantenimiento/barcoMant";
    }

    // si el id existe agrega los atributos de este en los fields, para actualizar o
    // eliminar
    // si el id no existe se queda en blanco, entonces es para crear

    /*
     * @PostMapping("/buscarbarco")
     * public String buscarbarcoporid(@RequestParam(required = false) String
     * idBarco) {
     * if (idBarco != null) {
     * 
     * barcoserv.buscarPorId(idBarco);
     
      
      
      }else{
      
     }
      
      
      return "entity";
     }*/
     

    @GetMapping("/buscarbarco")
    public String BuscarbarcoxId(@RequestParam String idBarco, Model model) {

        //BarcoDTO barcodto;
        Barcos barquito= new Barcos();

        if (idBarco == null || idBarco.isBlank()) {// si no hya nada o esta vacio
            model.addAttribute("errorMsg", "Ingrese un ID");
            //barcodto = new BarcoDTO();// aaa
            //barquito= new Barcos();


        } else {
            // se usa el dto mas q nada para futuras actus, posible agregar otros atributos
            //Barcos barquito = barcoserv.buscarPorId(idBarco);
            Barcos foundboat= barcoserv.buscarPorId(idBarco);
            //barquito= barcoserv.buscarPorId(idBarco);

            if (foundboat != null) {
                //barcodto = barcoserv.convertiraDTO(barquito);
                barquito= foundboat;
                model.addAttribute("barco", barquito);

            } else {
                model.addAttribute("errorMsg", "No se encontro un barco con ID " + idBarco);
                //barcodto = new BarcoDTO();
                //barcodto.setIdBarco(idBarco);
                barquito.setIDbarco(idBarco);

            }

        }

        model.addAttribute("barco", barquito);
        model.addAttribute("modelos", barcorepo.findDistinctModelos());
        model.addAttribute("rutasDisponibles", rutaserv.obtenerTodasLasRutas());

        return "Mantenimiento/barcoMant";
    }//ya

    // editar
    @PostMapping("/editarbarco")
    public String EditarBarcoxId(@ModelAttribute("barco") Barcos barquito2, Model model) {

        if (barquito2.getIDbarco().isBlank() && barquito2.getNombrebarco().isBlank()
                && barquito2.getCapitanbarco().isBlank()) {
            model.addAttribute("errorMsg", "No hay nada para editar");
            return "Mantenimiento/barcoMant";

        } // por si puso buscar y no le salio nada y usa el boton de editar

        Barcos barco = barcoserv.buscarPorId(barquito2.getIDbarco());
        // se fija si el id esta en labase de datos y lo guarda en un obj

        if (barco == null) {// si se le ocurrio llenar todo y puso editar pero la id no esta en la bd
            model.addAttribute("errorMsg", "ID no existe, no hay nada para editar.");
            return "Mantenimiento/barcoMant";
        } else {
            //barcoserv.convertiraBarcos(barquito, barco);
            barcoserv.guardarBarco(barquito2);
        }

        return "redirect:/Mantenimiento/barcoMant";
    }

    // Eliminar
    @PostMapping("/eliminarbarco")
    public String EliminarBarcoxId(@ModelAttribute("barco") Barcos barquito3, Model model) {

        if (barquito3.getIDbarco().isBlank() && barquito3.getNombrebarco().isBlank()
                && barquito3.getCapitanbarco().isBlank()) {
            model.addAttribute("errorMsg", "No hay nada para eliminar.");
            return "Mantenimiento/barcoMant";
        }

        Barcos barco2 = barcoserv.buscarPorId(barquito3.getIDbarco());

        if (barco2 == null) {
            model.addAttribute("errorMsg", "ID no existe, no hay nada para eliminar.");
            return "Mantenimiento/barcoMant";

        } else {
            Hibernate.initialize(barco2.getRutas());
            barcoserv.eliminarBarco(barco2.getIDbarco());
        }

        return "redirect:/Mantenimiento/barcoMant";
    }

    // crear
    @PostMapping("/crearbarco")
    public String CrearBarco(@ModelAttribute("barco") Barcos barquito4, Model model) {

        //Barcos barcocrear= new Barcos();

        if (barquito4.getIDbarco().isBlank() || barquito4.getNombrebarco().isBlank()
                || barquito4.getCapitanbarco().isBlank()
                || barquito4.getBarmodel().getModeloBarco().isEmpty() || barquito4.getImagenbarco().isBlank()
                || barquito4.getDescripcionbarco().isBlank()
                || barquito4.getRutas().isEmpty()) {

                    model.addAttribute("errorMsg", "Faltan datos para creación de Barco.");
                    return "Mantenimiento/barcoMant";

        }

            //barcoserv.convertiraBarcos(barquito3, barcocrear);
            barcoserv.guardarBarco(barquito4);
        
        return "redirect:/Mantenimiento/barcoMant";
    }
    

}
