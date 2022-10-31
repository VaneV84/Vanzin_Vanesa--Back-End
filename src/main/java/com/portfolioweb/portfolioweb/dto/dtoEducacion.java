package com.portfolioweb.portfolioweb.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoEducacion {
    
    //Atributos
    @NotBlank
    private String nombre;
    @NotBlank
    private String descrip;
    @NotBlank
    private int fechaComienzo;
    private int fechaFinal;

    //Constructores
    public dtoEducacion() {
    }

    public dtoEducacion(String nombre, String descrip, int fechaComienzo, int fechaFinal) {
        this.nombre = nombre;
        this.descrip = descrip;
        this.fechaComienzo = fechaComienzo;
        this.fechaFinal = fechaFinal;
    }
}