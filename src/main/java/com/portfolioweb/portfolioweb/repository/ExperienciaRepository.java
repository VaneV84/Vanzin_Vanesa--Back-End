package com.portfolioweb.portfolioweb.repository;

import com.portfolioweb.portfolioweb.model.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Integer> {
    
    public Optional<Experiencia> findByNombre(String nombre);
    
    public boolean existsByNombre (String nombre);
}