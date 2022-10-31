package com.portfolioweb.portfolioweb.repository;

import com.portfolioweb.portfolioweb.model.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProyectosRepository extends JpaRepository<Proyectos, Integer> {
    
    public Optional<Proyectos> findByNombre(String nombre);
    
    public boolean existsByNombre(String nombre);
}