package com.utp.demo.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utp.demo.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {

    Optional<Login> findByUsuario(String usuario);
}
