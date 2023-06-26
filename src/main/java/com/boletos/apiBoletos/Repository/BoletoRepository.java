package com.boletos.apiBoletos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boletos.apiBoletos.Models.Boletos;

public interface BoletoRepository extends JpaRepository <Boletos, Long> {

    List<Boletos> findByEvento_EventoId(Long eventoId);
    
}

