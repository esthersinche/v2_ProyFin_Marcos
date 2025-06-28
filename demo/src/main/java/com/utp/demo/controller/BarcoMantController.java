package com.utp.demo.controller;


import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.utp.demo.model.Barcos;
import com.utp.demo.model.DTO.BarcoDTO;
import com.utp.demo.service.BarcoRepository;
import com.utp.demo.service.BarcoService;
import com.utp.demo.service.RutaService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/Mantenimiento/barcoMant")
public class BarcoMantController {
    private BarcoService barcoserv;
    private BarcoRepository barcorepo;
    private RutaService rutaserv;

    public BarcoMantController(BarcoService barcoserv, BarcoRepository barcorepo, RutaService rutaserv) {
        this.barcoserv = barcoserv;
        this.barcorepo = barcorepo;
        this.rutaserv = rutaserv;
    }

    @GetMapping
    public String mostrarlosbarcos(Model model) {
        model.addAttribute("barco", new BarcoDTO());
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
     * 
     * 
     * 
     * }else{
     * 
     * }
     * 
     * 
     * return "entity";
     * }
     */

    @GetMapping("/buscarbarco")
    public String BuscarbarcoxId(@RequestParam String idBarco, Model model) {

        BarcoDTO barcodto;

        if (idBarco == null || idBarco.isBlank()) {// si no hya nada o esta vacio
            model.addAttribute("errorMsg", "Ingrese un ID");
            barcodto = new BarcoDTO();// aaa

        } else {
            // se usa el dto mas q nada para futuras actus, posible agregar otros atributos
            Barcos barquito = barcoserv.buscarPorId(idBarco);

            if (barquito != null) {
                barcodto = barcoserv.convertiraDTO(barquito);

            } else {
                model.addAttribute("errorMsg", "No se encontro un barco con ID " + idBarco);
                barcodto = new BarcoDTO();
                barcodto.setIdBarco(idBarco);

            }

        }

        model.addAttribute("barco", barcodto);
        model.addAttribute("modelos", barcorepo.findDistinctModelos());
        model.addAttribute("rutasDisponibles", rutaserv.obtenerTodasLasRutas());

        return "Mantenimiento/barcoMant";
    }

    // editar
    @PostMapping("/editarbarco")
    public String EditarBarcoxId(@ModelAttribute("barco") BarcoDTO barquito, Model model) {

        if (barquito.getIdBarco().isBlank() && barquito.getNombreBarco().isBlank()
                && barquito.getCapitanBarco().isBlank()) {
            model.addAttribute("errorMsg", "No hay nada para editar");
            return "Mantenimiento/barcoMant";

        } // por si puso buscar y no le salio nada y usa el boton de editar

        Barcos barco = barcoserv.buscarPorId(barquito.getIdBarco());// se fija si el id esta en labase de datos

        if (barco == null) {// si se le ocurrio llenar todo y puso editar pero la id no esta en la bd
            model.addAttribute("errorMsg", "ID no existe, no hay nada para editar.");
            return "Mantenimiento/barcoMant";
        } else {
            barcoserv.convertiraBarcos(barquito, barco);
            barcoserv.guardarBarco(barco);
        }

        return "redirect:/Mantenimiento/barcoMant";
    }

    // Eliminar
    @PostMapping("/eliminarbarco")
    public String EliminarBarcoxId(@ModelAttribute("barco") BarcoDTO barquito2, Model model) {

        if (barquito2.getIdBarco().isBlank() && barquito2.getNombreBarco().isBlank()
                && barquito2.getCapitanBarco().isBlank()) {
            model.addAttribute("errorMsg", "No hay nada para eliminar.");
            return "Mantenimiento/barcoMant";
        }

        Barcos barco2 = barcoserv.buscarPorId(barquito2.getIdBarco());

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
    public String CrearBarco(@ModelAttribute("barco") BarcoDTO barquito3, Model model) {

        Barcos barcocrear= new Barcos();

        if (barquito3.getIdBarco().isBlank() || barquito3.getNombreBarco().isBlank()
                || barquito3.getCapitanBarco().isBlank()
                || barquito3.getModeloBarco().isBlank() || barquito3.getImgURLbarco().isBlank()
                || barquito3.getDescripcionBarco().isBlank()
                || barquito3.getIdsrutasbarco().isEmpty()) {

                    model.addAttribute("errorMsg", "Faltan datos para creación de Barco.");
                    return "Mantenimiento/barcoMant";

        }

            barcoserv.convertiraBarcos(barquito3, barcocrear);
            barcoserv.guardarBarco(barcocrear);
        
        return "redirect:/Mantenimiento/barcoMant";
    }

}
