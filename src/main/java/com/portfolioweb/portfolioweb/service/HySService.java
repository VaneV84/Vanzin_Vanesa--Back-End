package com.portfolioweb.portfolioweb.service;

import com.portfolioweb.portfolioweb.model.HyS;
import com.portfolioweb.portfolioweb.repository.HySRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HySService {
    
    @Autowired
    HySRepository hysRepository;

    //Método Lista skills
    public List<HyS> list() {
        return hysRepository.findAll();
    }

    //Método de busqueda de skill por ID
    public Optional<HyS> getOne(int id) {
        return hysRepository.findById(id);
    }

    //Método de busqueda de skill por NOMBRE
    public Optional<HyS> getByNombre(String nombre) {
        return hysRepository.findByNombre(nombre);
    }

    //Método para guardar una skill
    public void save(HyS skill) {
        hysRepository.save(skill);
    }

    //Método para borrar una skill
    public void delete(int id) {
        hysRepository.deleteById(id);
    }

    //Método para ver si existe la skill por ID
    public boolean existsById(int id){
         return hysRepository.existsById(id);
    }
    
    //Método para ver si existe la skill por NOMBRE
        public boolean existsByNombre(String nombre){
         return hysRepository.existsByNombre(nombre);
    }
}