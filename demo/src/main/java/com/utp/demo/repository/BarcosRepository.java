package com.utp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utp.demo.model.Barcos;

public class BarcosRepository extends JpaRepository<Barcos, String> {

}
