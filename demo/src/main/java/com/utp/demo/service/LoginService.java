package com.utp.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utp.demo.model.Login;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public boolean login(String usuario, String pass) {
        Optional<Login> opt = loginRepository.findByUsuario(usuario);
        if (opt.isPresent()) {
            return opt.get().getPass().equals(pass);
        }
        return false;
    }
}
