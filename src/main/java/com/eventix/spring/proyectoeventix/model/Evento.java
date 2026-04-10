package com.eventix.spring.proyectoeventix.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Evento {
    int id;
    String nombre;
    String tipoEvento;
    String fechaEvento;
    String ubicacion;
    String capacidad;
}
