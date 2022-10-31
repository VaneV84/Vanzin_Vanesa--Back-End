package com.portfolioweb.portfolioweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Proyectos {
    
    //Atributos
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud establecida")
    private String nombre;
    
    @NotNull
    private int fecha;
    
    @NotNull
    private String descrip;
    
    private String img;
    
    //Constructores
    public Proyectos() {
    }

    public Proyectos(String nombre, int fecha, String descrip, String img) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.descrip = descrip;
        this.img = img;
    }
}