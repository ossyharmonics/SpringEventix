package com.eventix.spring.proyectoeventix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventix.spring.proyectoeventix.model.Evento;
import com.eventix.spring.proyectoeventix.repository.EventoRepository;

@Service
public class EventoServices {
    @Autowired
    private EventoRepository er;
    
    public List<Evento> mostrarEventos(){
        return er.mostrarEventos();
    }
    public Evento buscarId(int id){
        return er.buscarId(id);
    }
    public Evento buscarNombre(String nombre){
        return er.buscarNombre(nombre);
    }
    public Evento crearEvento(Evento e){
        return er.crearEvento(e);
    }
    public Evento actualizarEvento(Evento e){
        return er.actualizarEvento(e);
    }
    public boolean eliminarEvento(int id){
        return er.eliminarEvento(id);
    }
    
}
