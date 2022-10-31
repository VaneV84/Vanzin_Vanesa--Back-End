package com.portfolioweb.portfolioweb.service;

import com.portfolioweb.portfolioweb.model.Experiencia;
import com.portfolioweb.portfolioweb.repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {

    @Autowired
    ExperienciaRepository experienciaRepository;

    //Método Lista experiencias
    public List<Experiencia> list() {
        return experienciaRepository.findAll();
    }

    //Método de busqueda de experiencia por ID
    public Optional<Experiencia> getOne(int id) {
        return experienciaRepository.findById(id);
    }

    //Método de busqueda de experiencia por NOMBRE
    public Optional<Experiencia> getByNombre(String nombre) {
        return experienciaRepository.findByNombre(nombre);
    }

    //Método para guardar una experiencia
    public void save(Experiencia experiencia) {
        experienciaRepository.save(experiencia);
    }

    //Método para borrar una experiencia
    public void delete(int id) {
        experienciaRepository.deleteById(id);
    }

    //Método para ver si existe la experiencia por ID
    public boolean existsById(int id){
         return experienciaRepository.existsById(id);
    }
    
    //Método para ver si existe la experiencia por NOMBRE
        public boolean existsByNombre(String nombre){
         return experienciaRepository.existsByNombre(nombre);
    }
}