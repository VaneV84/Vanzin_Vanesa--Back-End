package com.portfolioweb.portfolioweb.service;

import com.portfolioweb.portfolioweb.model.Educacion;
import com.portfolioweb.portfolioweb.repository.EducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService {
    
    @Autowired
    EducacionRepository educacionRepository;

    //Método Lista educación
    public List<Educacion> list() {
        return educacionRepository.findAll();
    }

    //Método de busqueda de educación por ID
    public Optional<Educacion> getOne(int id) {
        return educacionRepository.findById(id);
    }

    //Método de busqueda de educación por NOMBRE
    public Optional<Educacion> getByNombre(String nombre) {
        return educacionRepository.findByNombre(nombre);
    }

    //Método para guardar una educación
    public void save(Educacion educacion) {
        educacionRepository.save(educacion);
    }

    //Método para borrar una educación
    public void delete(int id) {
        educacionRepository.deleteById(id);
    }

    //Método para ver si existe la educación por ID
    public boolean existsById(int id){
         return educacionRepository.existsById(id);
    }
    
    //Método para ver si existe la educación por NOMBRE
        public boolean existsByNombre(String nombre){
         return educacionRepository.existsByNombre(nombre);
    }
}