package com.boletos.apiBoletos.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boletos.apiBoletos.Models.Usuario;
import com.boletos.apiBoletos.Services.UsuarioService;

@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RestController
 class UsuarioController {
       
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/list/usuario")
    public List<Usuario> list(){
        return usuarioService.list();
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
       try {
         Usuario usuario = usuarioService.findById(id);
           return  new ResponseEntity<Usuario>( usuario, HttpStatus.OK);
       }catch (Exception e){
           return  new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);

       }
    }
    @PostMapping("/save")
    public void  save(@RequestBody Usuario usuario){
        usuarioService.save(usuario);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Usuario> update (@RequestBody Usuario usuario, @PathVariable Long id){
        try {
            Usuario usuarioExistente = usuarioService.findById(id);
            usuarioService.save(usuario);
            return  new ResponseEntity<Usuario>(HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public void  delete(@PathVariable Long id){
        usuarioService.delete(id);
    }

}
