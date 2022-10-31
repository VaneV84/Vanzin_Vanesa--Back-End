package com.portfolioweb.portfolioweb.security.controller;

public class Mensaje {
    
    //Atributo
    private String mensaje;
    
    
    //Constructores
    public Mensaje() {
    }

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    //Getter y Setter
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
