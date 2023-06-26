package com.boletos.apiBoletos.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boletos.apiBoletos.Models.Evento;
import com.boletos.apiBoletos.Repository.EventoRepository;

@Service
public class EventoService {
    
    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> list(){
        return eventoRepository.findAll();
    }

    public void  save(Evento evento){
        eventoRepository.save(evento);
    }

    public Evento  findById(Long id){
       return eventoRepository.findById(id).get();
    }

    public void  delete(Long id){
        eventoRepository.deleteById(id);
    }
}
