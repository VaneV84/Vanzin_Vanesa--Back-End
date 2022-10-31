package com.portfolioweb.portfolioweb.repository;

import com.portfolioweb.portfolioweb.model.HyS;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HySRepository extends JpaRepository<HyS, Integer> {
    
    public Optional<HyS> findByNombre(String nombre);
    
    public boolean existsByNombre (String nombre);
}