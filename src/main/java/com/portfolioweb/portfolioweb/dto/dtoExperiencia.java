package com.portfolioweb.portfolioweb.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoExperiencia {
   
    //Atributos
    @NotBlank
    private String nombre;
    @NotBlank
    private String puesto;
    @NotBlank
    private String descrip;
    @NotBlank
    private int fechaComienzo;
    private int fechaFinal;
    
    
    //Constructores
    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombre, String puesto, String descrip, int fechaComienzo, int fechaFinal) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.descrip = descrip;
        this.fechaComienzo = fechaComienzo;
        this.fechaFinal = fechaFinal;
    }
}