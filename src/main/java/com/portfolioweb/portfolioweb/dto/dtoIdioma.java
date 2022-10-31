package com.portfolioweb.portfolioweb.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoIdioma {
    
    //Atributos
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;
    
    //Constructores
    public dtoIdioma() {
    }

    public dtoIdioma(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }
}