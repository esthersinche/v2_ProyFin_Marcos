package com.utp.demo.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.utp.demo.model.Paquete;

@Service
public class PaqueteService {

    private final PaqueteRepository paqueteRepository;
    private BeneficioService beneserv;

    public PaqueteService(PaqueteRepository paqueteRepository, BeneficioService beneserv) {
        this.paqueteRepository = paqueteRepository;
        this.beneserv = beneserv;
    }

    // Obtener todos los paquetes
    public List<Paquete> obtenerTodosLosPaquetes() {
        return paqueteRepository.findAll();
    }

    // <-- Nuevo -->
    public Paquete buscarPorId(String id) {
        return paqueteRepository.findById(id).orElse(null);
    }

    public Paquete guardarPaquete(Paquete paq){
        return paqueteRepository.save(paq);

    }

    public void eliminarPaquetexId(String id){
        paqueteRepository.deleteById(id);

    }

    /* 
    // Buscar paquete por nombre y ruta
    public Paquete buscarPorNombreYRuta(String nombrePaquete, String nombreRuta) {
        return paqueteRepository
                .findByNombrePaqAndRutaNombreIgnoreCase(nombrePaquete, nombreRuta)
                .orElse(null);
    }

    // Buscar paquetes por múltiples rutas
    public List<Paquete> buscarPorRutas(List<String> nombresRutas) {
        return paqueteRepository.findByRutaNombreInIgnoreCase(nombresRutas);
    }

    // Buscar paquetes por modelos de barco
    public List<Paquete> buscarPorModelos(List<String> modelos) {
        return paqueteRepository.findByModeloBarcoInIgnoreCase(modelos);

    }
         // Buscar paquetes por nombre de ruta
    public List<Paquete> obtenerPaquetesPorRuta(String nombreRuta) {
        return paqueteRepository.findByRutaNombreIgnoreCase(nombreRuta);
    }

    

    // Buscar paquetes por capacidades máximas
    public List<Paquete> buscarPorCapacidadMaxima(List<Integer> capacidades) {
        return paqueteRepository.findByCabinaCantMaxPerIn(capacidades);
    }


    public List<Barcos> obtenerPorRuta(String rutaId) {
        return barcoRepository.findAllByRutaId(rutaId);
    }

    //renómbralo si quieres a buscarPorId  qcy
    public Barcos buscarPorIdBarco(String id) {
        return barcoRepository.findById(id).orElse(null);
    }

    // Devuelve un paquete por su ID o null si no existe 
    public Paquete buscarPorId(String id) {
        return paqueteRepository.findById(id).orElse(null);
    }

     */
    // Buscar paquetes por lista de nombres
    public List<Paquete> buscarPorNombrePaquetes(List<String> nombresPaquetes) {
        return paqueteRepository.findByNombrePaqInIgnoreCase(nombresPaquetes);
    }

    //convertir de dto a paquete
    /* 
     * public Paquete convertiraPaq(PaqueteDTO paqdto, Paquete paq){
        paq.setIdPaquete(paqdto.getIdPaquete());
        paq.setNomPaquete(paqdto.getNomPaquete());
        paq.setDescPaquete(paqdto.getDescPaquete());
        paq.setPrecPaqueteUni(paqdto.getPrecPaqueteUni());

        List<PaqueteBeneficio> idspaqbene= new ArrayList<>();//lista
        for (String idspqbn : paqdto.getIdsbeneficios()) {//each para buscar el id
            Beneficio bene= beneserv.BuscarBeneficioxID(idspqbn);//se guarda en obj beneficio
            if (bene != null) {
                PaqueteBeneficio omfg= new PaqueteBeneficio();//nuevo paqbene

                //id compuesto pa q funcione
                PaqueteBeneficioId idhelp= new PaqueteBeneficioId(paq.getIdPaquete(), bene.getIdBene());
                //setear id a paqbene creado
                omfg.setId(idhelp);

                //enlazar
                omfg.setPaquete(paq);
                omfg.setBeneficio(bene);

                //añadir a lista
                idspaqbene.add(omfg);
                
            }            
        }
        paq.setBeneficios(idspaqbene);

        return paq;
    }

    //convertir de paquete a dto
    public PaqueteDTO convertiraDTO(Paquete paqs, PaqueteDTO paqdtoo){
        paqdtoo.setIdPaquete(paqs.getIdPaquete());
        paqdtoo.setNomPaquete(paqs.getNomPaquete());
        paqdtoo.setDescPaquete(paqs.getDescPaquete());
        paqdtoo.setPrecPaqueteUni(paqs.getPrecPaqueteUni());

        List<String> idsbenes= paqs.getBeneficios().stream().map(pb -> pb.getBeneficio().getIdBene()).collect(Collectors.toList());
        paqdtoo.setIdsbeneficios(idsbenes);

        return paqdtoo;

    }
    */

    


}
