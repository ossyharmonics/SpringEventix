package com.eventix.spring.proyectoeventix.controller;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eventix.spring.proyectoeventix.model.Evento;
import com.eventix.spring.proyectoeventix.services.EventoServices;
@RestController
@RequestMapping("/eventix/eventos")
public class EventoController {
    @Autowired
    private EventoServices es;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Evento> mostrarEventos(){
        return es.mostrarEventos();
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<?> buscarId(@PathVariable int id){
        Evento e = es.buscarId(id);
        if (es.buscarId(id) != null){
            return ResponseEntity.ok(e);
        }else{
            return ResponseEntity
                                .status(HttpStatus.NOT_FOUND)//Se define el código de error.
                                .body("Id de evento no encontrada.");//Se establece un mensaje para mostrar en el body.
        }
    }
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> buscarNombre(@PathVariable String nombre){
        Evento e = es.buscarNombre(nombre);
        if(es.buscarNombre(nombre) != null){
            return ResponseEntity.ok(e);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nombre de evento no encontrado.");
        }
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void crearEvento(@RequestBody Evento e){
        es.crearEvento(e);
    }
    @PutMapping("/{id}")
    public Evento actualizarEvento(@PathVariable int id, @RequestBody Evento e){
        return es.actualizarEvento(e);
    }
    @DeleteMapping("/{id}")//Este metodo devolverá un objeto del tipo response entity
    public ResponseEntity<Boolean> eliminarEvento(@PathVariable int id){
        if (es.eliminarEvento(id)){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
