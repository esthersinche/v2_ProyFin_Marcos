package com.utp.demo.service;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utp.demo.DTO.ReservaResumenDTO;
import com.utp.demo.model.Reserva;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    // Obtiene todas las reservas
    public List<Reserva> obtenerTodasLasReservas() {
        return reservaRepository.findAll();
    }

    // Elimina la reserva
    public void eliminarReserva(String id) {
        reservaRepository.deleteById(id);
    }

    // Verifica si existe por ID
    public boolean existePorId(String id) {
        return reservaRepository.existsById(id);
    }

    public Reserva iniciarReserva() {
        Reserva r = new Reserva();
        String id;
        // Genera hasta que encuentres un ID que NO exista en BD
        do {
            id = generarIdAleatorio(20);
        } while (reservaRepository.existsById(id));
        r.setIdReserva(id);
        return r;
    }
    private final SecureRandom rnd = new SecureRandom();
    private static final String ALFABETO = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    //metodo q necesitaba
    private String generarIdAleatorio(int longitud) {
        StringBuilder sb = new StringBuilder(longitud);
        for (int i = 0; i < longitud; i++) {
            sb.append(ALFABETO.charAt(rnd.nextInt(ALFABETO.length())));
        }
        return sb.toString();
    }

    // Guardar o actualizar una reserva
    public Reserva guardar(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    // Buscar reserva por ID
    public Reserva buscar(String id) {
        return reservaRepository.findById(id).orElse(null);
    }


    //de coso a dto
    public ReservaResumenDTO convertiraDTO(Reserva reservita, ReservaResumenDTO resdto) {

    /* 
     * //de coso a dto
    public ReservaResumenDTO convertiraDTO(Reserva reservita){
        ReservaResumenDTO resdto= new ReservaResumenDTO();

        resdto.setFechaReserva(reservita.getFechaReserva());
        //cliente
        resdto.setClienteNombre(reservita.getCliente().getNombre());
        resdto.setClienteDni(reservita.getCliente().getDniCliente());
        resdto.setClienteCorreo(reservita.getCliente().getCorreo());
        resdto.setCantidadPasajeros(reservita.getCantidadPasajeros());

        //detalles ruta
        resdto.setPuertoSalida(reservita.getRuta().getSalida());
        resdto.setPuertoDestino(reservita.getRuta().getNombreruta());
        resdto.setRutaDuracion(reservita.getRuta().getDiasruta());
        resdto.setSubtotalRuta(reservita.getRuta().getPrecioruta());

        //paquete
        resdto.setPaqueteNombre(reservita.getPaquete().getNomPaquete());
        resdto.setPaqueteDescripcion(reservita.getPaquete().getDescPaquete());
        resdto.setSubtotalPaquete(reservita.getPaquete().getPrecPaqueteUni());

        //cabina
        resdto.setCabinaTipo(reservita.getCabina().getCabTipo().getNombreCab());
        resdto.setCabinaPrecioPorPersona(reservita.getCabina().getCabTipo().getPrecCabinaPer());

        //total
        resdto.setTotal(reservita.getTotal());

        return resdto;

    }
    */
    
    //de dto a coso
    /*  public Reserva convertiraReserva(Reserva reservita1, ReservaResumenDTO resresdto){

        
    }
     */

}
