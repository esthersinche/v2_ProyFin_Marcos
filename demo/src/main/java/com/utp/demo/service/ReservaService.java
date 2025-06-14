package com.utp.demo.service;

import java.security.SecureRandom;
import java.util.List;

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

}
