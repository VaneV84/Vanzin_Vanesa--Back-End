package com.portfolioweb.portfolioweb.service;

import com.portfolioweb.portfolioweb.model.Persona;
import com.portfolioweb.portfolioweb.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonaService {
    
    //Inyección de dependencia para conectar el servicio al repositorio
    @Autowired
    PersonaRepository personaRepository;
    
     //Método Lista personas
    public List<Persona> list() {
        return personaRepository.findAll();
    }

    //Método de busqueda de persona por ID
    public Optional<Persona> getOne(int id) {
        return personaRepository.findById(id);
    }

    //Método de busqueda de persona por NOMBRE
    public Optional<Persona> getByNombre(String nombre) {
        return personaRepository.findByNombre(nombre);
    }

    //Método para guardar una persona
    public void save(Persona persona) {
        personaRepository.save(persona);
    }

    //Método para borrar una persona
    public void delete(int id) {
        personaRepository.deleteById(id);
    }

    //Método para ver si existe la persona por ID
    public boolean existsById(int id){
         return personaRepository.existsById(id);
    }
    
    //Método para ver si existe la persona por NOMBRE
        public boolean existsByNombre(String nombre){
         return personaRepository.existsByNombre(nombre);
    } 
}