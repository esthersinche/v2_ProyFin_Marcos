package com.utp.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utp.demo.model.Reserva;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    // Guardar o actualizar una reserva
    public Reserva guardarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    // Buscar reserva por ID
    public Reserva buscarPorId(String id) {
        Optional<Reserva> optionalReserva = reservaRepository.findById(id);
        return optionalReserva.orElse(null);
    }

    // Obtener todas las reservas (por si quieres una lista general)
    public List<Reserva> obtenerTodasLasReservas() {
        return reservaRepository.findAll();
    }

    // Eliminar reserva
    public void eliminarReserva(String id) {
        reservaRepository.deleteById(id);
    }

    // Verificar si existe una reserva por ID (útil antes de guardar)
    public boolean existePorId(String id) {
        return reservaRepository.existsById(id);
    }
}
