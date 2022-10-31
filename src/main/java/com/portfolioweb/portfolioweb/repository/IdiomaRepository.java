package com.portfolioweb.portfolioweb.repository;

import com.portfolioweb.portfolioweb.model.Idioma;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdiomaRepository extends JpaRepository<Idioma, Integer> {
    
    public Optional<Idioma> findByNombre(String nombre);
    
    public boolean existsByNombre (String nombre);
}