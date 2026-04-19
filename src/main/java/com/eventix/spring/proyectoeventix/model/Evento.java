package com.eventix.spring.proyectoeventix.model;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "El id no puede ser nulo")
    int id;

    @NotBlank
    String nombre;

    String tipoEvento;

    @NotNull
    String fechaEvento;

    @NotNull
    String ubicacion;
    @Min(0)
    int capacidad;
}
