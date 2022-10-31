package com.portfolioweb.portfolioweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class Persona {
    //Atributos de Clase Persona
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String nombre;
    
    @NotNull
    private String apellido;
    
    @NotNull
    private String puesto;
    
    @NotNull
    private String intro;
    
    private String img;
    
    //Constructores
    public Persona() {
    }

    public Persona(String nombre, String apellido, String puesto, String intro, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
        this.intro = intro;
        this.img = img;
    }
}