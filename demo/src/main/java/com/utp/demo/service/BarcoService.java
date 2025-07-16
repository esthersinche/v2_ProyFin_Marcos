package com.utp.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utp.demo.model.Barcos;


@Service
public class BarcoService {

    @Autowired
    private BarcoRepository barcoRepository;

    /* 
     * @Autowired
    private BarcosmodeloService barcmodeserv;

    @Autowired
    private RutaService rutaserv;
    */
    

    // Listado completo
    public List<Barcos> obtenerBarcos() {
        return barcoRepository.findAll();
    }

    // Buscar por ID de barco
    public Barcos buscarPorIdBarco(String id) {
        return barcoRepository.findById(id).orElse(null);
    }

    // Buscar por nombre del barco
    public Barcos buscarPorNombreBarco(String nombre) {
        return barcoRepository.findByNombreBarcoIgnoreCase(nombre);
    }

    // Buscar por capitán
    public Barcos buscarPorCapitan(String nombre) {
        return barcoRepository.findByCapitanBarcoIgnoreCase(nombre);
    }

    // Buscar por modelo (nombre del modelo)
    public Barcos buscarPorNombreModelo(String modeloNombre) {
        return barcoRepository.findByModeloNombreIgnoreCase(modeloNombre);
    }

    // Guardar nuevo barco
    public Barcos guardarBarco(Barcos barco) {
        return barcoRepository.save(barco);
    }

    // Eliminar barco por ID
    public void eliminarBarco(String id) {
        barcoRepository.deleteById(id);
    }

    /**
     * Devuelve solo los barcos que cubren la ruta indicada
     */
    public List<Barcos> obtenerPorRuta(String rutaId) {
        return barcoRepository.findAllByRutaId(rutaId);
    }

    /**
     * Ya existente, renómbralo si quieres a buscarPorId
     */
    public Barcos buscarPorId(String id) {
        return barcoRepository.findById(id).orElse(null);
    }
    /* 

    public BarcoDTO convertiraDTO (Barcos barco){
        BarcoDTO barcodtoo= new BarcoDTO();
        barcodtoo.setIdBarco(barco.getIDbarco());
        barcodtoo.setNombreBarco(barco.getNombrebarco());
        barcodtoo.setCapitanBarco(barco.getCapitanbarco());
        barcodtoo.setModeloBarco(barco.getBarmodel().getModeloBarco());
        barcodtoo.setImgURLbarco(barco.getImagenbarco());
        barcodtoo.setDescripcionBarco(barco.getDescripcionbarco());
        List<String> idsrutas= barco.getRutas().stream().map(rb -> rb.getRuta().getIdruta()).collect(Collectors.toList());
        barcodtoo.setIdsrutasbarco(idsrutas);

        return barcodtoo;

    }

    public Barcos convertiraBarcos (BarcoDTO barcodto, Barcos barquito){
        barquito.setIDbarco(barcodto.getIdBarco());
        barquito.setNombrebarco(barcodto.getNombreBarco());
        barquito.setCapitanbarco(barcodto.getCapitanBarco());

        Barcos_modelo modelo= barcmodeserv.buscarxId(barcodto.getModeloBarco());
        barquito.setBarmodel(modelo);

        barquito.setImagenbarco(barcodto.getImgURLbarco());
        barquito.setDescripcionbarco(barcodto.getDescripcionBarco());

        Set<RutaBarco> idsrutasbarco= new HashSet<>();
        for (String idruta : barcodto.getIdsrutasbarco()) {//falta desc
            Ruta pls= rutaserv.buscarPorId(idruta);
            if (pls != null) {
                RutaBarco ayuda= new RutaBarco();

                //id embebido
                RutaBarcoId idayuda= new RutaBarcoId(pls.getIdruta(), barquito.getIDbarco());
                ayuda.setId(idayuda);

                //enlazar
                ayuda.setRuta(pls);
                ayuda.setBarco(barquito);
                //fechasalida falta

                idsrutasbarco.add(ayuda);
            }                     
        }
        barquito.setRutas(idsrutasbarco);

        return barquito;
    }
        */
}
