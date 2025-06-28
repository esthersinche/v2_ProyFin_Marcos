package com.utp.demo.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.demo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);
}
