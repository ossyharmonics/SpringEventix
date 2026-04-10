package com.eventix.spring.proyectoeventix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventix.spring.proyectoeventix.model.Evento;
import com.eventix.spring.proyectoeventix.services.EventoServices;
@RestController
@RequestMapping("/eventix/eventos")
public class EventoController {
    @Autowired
    private EventoServices es;

    @GetMapping
    public List<Evento> mostrarEventos(){
        return es.mostrarEventos();
    }
    @GetMapping("/eventos/id/{id}")
    public Evento buscarId(@PathVariable int id){
        return es.buscarId(id);
    }
    @GetMapping("/eventos/nombre/{nombre}")
    public Evento buscarNombre(@PathVariable String nombre){
        return es.buscarNombre(nombre);
    }
    @PostMapping
    public Evento crearEvento(@RequestBody Evento e){
        return es.crearEvento(e);
    }
    @PutMapping("/{id}")
    public Evento actualizarEvento(@PathVariable int id, @RequestBody Evento e){
        return es.actualizarEvento(e);
    }
    @DeleteMapping("/{id}")
    public void eliminarEvento(@PathVariable int id){
        es.eliminarEvento(id);
        System.out.println("Evento eliminado");
    }
}
