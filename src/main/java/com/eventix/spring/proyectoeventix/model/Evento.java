package com.eventix.spring.proyectoeventix.model;

import org.jspecify.annotations.NonNull;

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
    @NonNull
    int id;

    @NonBlank
    String nombre;

    String tipoEvento;

    @NonNull
    String fechaEvento;

    @NonNull
    String ubicacion;

    String capacidad;
}
