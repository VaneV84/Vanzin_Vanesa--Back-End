package com.portfolioweb.portfolioweb.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoHyS {
    
    //Atributos
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;
    
    //Constructores
    public dtoHyS() {
    }

    public dtoHyS(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }
}