package com.boletos.apiBoletos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boletos.apiBoletos.Models.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
    
}

