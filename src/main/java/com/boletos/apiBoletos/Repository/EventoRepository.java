package com.boletos.apiBoletos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boletos.apiBoletos.Models.Evento;

public interface EventoRepository extends JpaRepository <Evento, Long> {
    
}

