package com.boletos.apiBoletos.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boletos.apiBoletos.Models.Usuario;
import com.boletos.apiBoletos.Repository.UsuarioRepository;


@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> list(){
        return usuarioRepository.findAll();
    }

    public void  save(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public Usuario  findById(Long id){
       return usuarioRepository.findById(id).get();
    }

    public void  delete(Long id){
        usuarioRepository.deleteById(id);
    }
}
