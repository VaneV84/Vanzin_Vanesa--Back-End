package com.portfolioweb.portfolioweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Experiencia {
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private String puesto;
    private String descrip;
    private int fechaComienzo;
    private int fechaFinal;
    
    //Constructores
    public Experiencia() {
    }

    public Experiencia(String nombre, String puesto, String descrip, int fechaComienzo, int fechaFinal) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.descrip = descrip;
        this.fechaComienzo = fechaComienzo;
        this.fechaFinal = fechaFinal;
    }
}