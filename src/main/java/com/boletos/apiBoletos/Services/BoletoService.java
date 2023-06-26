package com.boletos.apiBoletos.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boletos.apiBoletos.Models.Boletos;
import com.boletos.apiBoletos.Repository.BoletoRepository;

@Service
public class BoletoService {
    
    @Autowired
    private BoletoRepository boletosRepository;

    public List<Boletos> list(){
        return boletosRepository.findAll();
    }

    public List<Boletos> obtenerBoletosPorEvento(Long eventoId) {
        return boletosRepository.findByEvento_EventoId(eventoId);
    }
    
    public void  save(Boletos boletos){
        boletosRepository.save(boletos);
    }

    public Boletos  findById(Long id){
       return  boletosRepository.findById(id).get();
    }

    public void  delete(Long id){
        boletosRepository.deleteById(id);
    }
}
