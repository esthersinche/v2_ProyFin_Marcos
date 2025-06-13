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

    public Reserva iniciarReserva() {
        Reserva r = new Reserva();
        // Generar ID único
        r.setId_reserva(UUID.randomUUID().toString());
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

    // Obtener todas las reservas
    public List<Reserva> obtenerTodasLasReservas() {
        return reservaRepository.findAll();
    }

    // Eliminar reserva
    public void eliminarReserva(String id) {
        reservaRepository.deleteById(id);
    }

    // Verificar existencia por ID
    public boolean existePorId(String id) {
        return reservaRepository.existsById(id);
    }
}
