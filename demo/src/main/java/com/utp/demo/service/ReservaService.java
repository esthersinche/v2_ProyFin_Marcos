package com.utp.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    //metodo q necesitaba
    public Reserva iniciarReserva() {
        Reserva r = new Reserva();
        // Generar ID único
        r.setIdReserva(UUID.randomUUID().toString());
        return r;
    }

    // Guardar o actualizar una reserva
    public Reserva guardar(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    // Buscar reserva por ID
    public Reserva buscar(String id) {
        return reservaRepository.findById(id).orElse(null);
    }

}
