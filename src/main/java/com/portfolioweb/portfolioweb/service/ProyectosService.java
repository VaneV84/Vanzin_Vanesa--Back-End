package com.portfolioweb.portfolioweb.service;

import com.portfolioweb.portfolioweb.model.Proyectos;
import com.portfolioweb.portfolioweb.repository.ProyectosRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectosService {
    
    @Autowired
    ProyectosRepository proyectosRepository;

    //Método Lista proyectos
    public List<Proyectos> list() {
        return proyectosRepository.findAll();
    }

    //Método de busqueda de proyecto por ID
    public Optional<Proyectos> getOne(int id) {
        return proyectosRepository.findById(id);
    }

    //Método de busqueda de proyecto por NOMBRE
    public Optional<Proyectos> getByNombre(String nombre) {
        return proyectosRepository.findByNombre(nombre);
    }

    //Método para guardar un proyecto
    public void save(Proyectos proyectos) {
        proyectosRepository.save(proyectos);
    }

    //Método para borrar un proyecto
    public void delete(int id) {
        proyectosRepository.deleteById(id);
    }

    //Método para ver si existe el proyecto por ID
    public boolean existsById(int id){
         return proyectosRepository.existsById(id);
    }
    
    //Método para ver si existe el proyecto por NOMBRE
    public boolean existsByNombre(String nombre){
         return proyectosRepository.existsByNombre(nombre);
    }
}
