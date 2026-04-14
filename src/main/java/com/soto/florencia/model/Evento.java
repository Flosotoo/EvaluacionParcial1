package com.soto.florencia.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evento {
    @NotNull(message = "El id no puede estar vacio")
    private int id;

    @NotBlank(message = "El nombre del evento no puede ir vacio")
    private String nombre;

    @NotNull(message = "El dia de la fecha no puede estar vacio")
    @Min(value = 1, message = "Debe ser mayor o igual a 1")
    @Max(value = 31, message = "Debe ser igual o menos a 31")
    private int dia;

    @NotBlank(message = "No puee ir vacio")
    private String ubicacion;

    @NotNull(message = "La cantidad de participantes no puede ir en blanco")
    @Min(value = 1, message = "Debe tener uno o mas participantes")
    private int cant_part;


}
