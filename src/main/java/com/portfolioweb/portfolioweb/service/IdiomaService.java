package com.portfolioweb.portfolioweb.service;

import com.portfolioweb.portfolioweb.model.Idioma;
import com.portfolioweb.portfolioweb.repository.IdiomaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class IdiomaService {
    @Autowired
    IdiomaRepository idiomaRepository;

    //Método Lista idiomas
    public List<Idioma> list() {
        return idiomaRepository.findAll();
    }

    //Método de busqueda de idioma por ID
    public Optional<Idioma> getOne(int id) {
        return idiomaRepository.findById(id);
    }

    //Método de busqueda de idioma por NOMBRE
    public Optional<Idioma> getByNombre(String nombre) {
        return idiomaRepository.findByNombre(nombre);
    }

    //Método para guardar un idioma
    public void save(Idioma idioma) {
        idiomaRepository.save(idioma);
    }

    //Método para borrar un idioma
    public void delete(int id) {
        idiomaRepository.deleteById(id);
    }

    //Método para ver si existe el idioma por ID
    public boolean existsById(int id){
         return idiomaRepository.existsById(id);
    }
    
    //Método para ver si existe el idioma por NOMBRE
        public boolean existsByNombre(String nombre){
         return idiomaRepository.existsByNombre(nombre);
    }
}