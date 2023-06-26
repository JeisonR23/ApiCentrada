package com.boletos.apiBoletos.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boletos.apiBoletos.Models.Boletos;
import com.boletos.apiBoletos.Services.BoletoService;

@RestController
@RequestMapping("/boletos")
class BoletoController {

    @Autowired
    BoletoService boletoService;

    @GetMapping("/list/boletos")
    public List<Boletos> list() {
        return boletoService.list();
    }

    @GetMapping("/evento/{eventoId}")
    public List<Boletos> obtenerBoletosPorEvento(@PathVariable Long eventoId) {
        return boletoService.obtenerBoletosPorEvento(eventoId);
    }

    @GetMapping("/boleto/{id}")
    public ResponseEntity<Boletos> findById(@PathVariable Long id) {
        try {
            Boletos boleto = boletoService.findById(id);
            return new ResponseEntity<Boletos>(boleto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Boletos>(HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping("/boleto/save")
    public void save(@RequestBody Boletos boleto) {
        boletoService.save(boleto);
    }

    @PutMapping("/boleto/update/{id}")
    public ResponseEntity<Boletos> update(@RequestBody Boletos boleto, @PathVariable Long id) {
        try {
            Boletos boletoExistente = boletoService.findById(id);
            boletoService.save(boleto);
            return new ResponseEntity<Boletos>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Boletos>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/boleto/delete/{id}")
    public void delete(@PathVariable Long id) {
        boletoService.delete(id);
    }

}
