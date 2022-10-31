package com.portfolioweb.portfolioweb.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoProyectos {
    
    //Atributos
    @NotBlank  
    private String nombre;
    @NotBlank
    private int fecha;
    @NotBlank
    private String descrip;
    
    private String img;
    
    
    //Constructores
    public dtoProyectos() {
    }

    public dtoProyectos(String nombre, int fecha, String descrip, String img) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.descrip = descrip;
        this.img = img;
    }
}
