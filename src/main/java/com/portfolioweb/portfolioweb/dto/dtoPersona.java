package com.portfolioweb.portfolioweb.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoPersona {
    
    //Atributos
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String apellido;
    
    @NotBlank
    private String puesto;
    
    @NotBlank
    private String intro;
    
    private String img;
    
    //Constructores
    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String puesto, String intro, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
        this.intro = intro;
        this.img = img;
    }
}