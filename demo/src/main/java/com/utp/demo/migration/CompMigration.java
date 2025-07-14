package com.utp.demo.migration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.utp.demo.service.UsuarioRepository;

@Component
//para migrar las cuentas ya que tenemos el coso de bcrypt mas nuestra bd no esta encriptada o
//paso por una encriptacion ya que no se creo desde aqui y ponerlo en sqlserver es instalar
//algo .net y es mas dificil so
public class CompMigration implements CommandLineRunner{
    //el command es una interfaz de spring q corre el override de run dsps de iniciar la app
    //se usa normalmente para inicializar datos de usuario o db's
    
    private UsuarioRepository usurepo;
    private PasswordEncoder passenco;

    public CompMigration(UsuarioRepository usurepo, PasswordEncoder passenco) {
        this.usurepo = usurepo;
        this.passenco = passenco;
    }

    @Override
    public void run(String... args){
        //encuentra todos los usuarios(3), stream/recorre, los filtra en base a las contras q 
        //no empiezen con $2, devuelve un stream/secuencia/coleccion(?), luego entra a un 
        //foreach q codifica las contras y luego les hace set, finalmente guarda y se hac un 
        //log para verificar q funciona esto
        usurepo.findAll().stream()
        .filter(u -> !u.getPassword().startsWith("$2"))
        .forEach(u -> {u.setPassword(passenco.encode(u.getPassword()));
            usurepo.save(u);
            System.out.println("Se migro: " + u.getUsername());
        });
    }
    
    
}
