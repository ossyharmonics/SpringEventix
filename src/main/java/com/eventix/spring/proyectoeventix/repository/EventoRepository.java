package com.eventix.spring.proyectoeventix.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.eventix.spring.proyectoeventix.model.Evento;

@Repository
public class EventoRepository {
    private List<Evento> agendaEventos = new ArrayList<>();

    public List<Evento> mostrarEventos() {
        return agendaEventos;
    }
    public Evento buscarId(int id){
        for (Evento e : agendaEventos){
            if (e.getId() == id){
                return e;
            }
        }
        return null;
    }
    public Evento buscarNombre(String nombre){
        for (Evento e : agendaEventos){
            if (e.getNombre().equals(nombre)){
                return e;
            }
        }
        return null;
    }
    public Evento crearEvento(Evento e){
        agendaEventos.add(e);
        return e;
    }
    public Evento actualizarEvento(Evento e){
        int id = 0;
        int p = 0;
        for (int i = 0; i < agendaEventos.size(); i++){
            if (agendaEventos.get(i).getId() == id){
                id = agendaEventos.get(i).getId();
                p = i;
            }
        }
        Evento e1 = new Evento();
        e1.setId(id);
        e1.setNombre(e.getNombre());
        e1.setTipoEvento(e.getTipoEvento());
        e1.setFechaEvento(e.getFechaEvento());
        e1.setUbicacion(e.getUbicacion());
        agendaEventos.set(p, e1);
        return e1;
    }
    public void eliminarEvento(int id){
        Evento e = buscarId(id);
        if (e != null){
            agendaEventos.remove(e);
        }
    }
    public EventoRepository(){
        agendaEventos.add(new Evento(1, "Concierto de Rock", "Música", "2023-10-15", "Estadio Nacional", "5000"));
        agendaEventos.add(new Evento(2, "Feria de Tecnología", "Tecnología", "2023-11-20", "Centro de Convenciones", "2000"));
        agendaEventos.add(new Evento(3, "Festival de Cine", "Cine", "2023-12-05", "Cineplex", "1000"));
    }


}
