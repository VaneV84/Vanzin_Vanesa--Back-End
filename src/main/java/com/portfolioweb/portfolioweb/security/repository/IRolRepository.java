package com.portfolioweb.portfolioweb.security.repository;

import com.portfolioweb.portfolioweb.security.entity.Rol;
import com.portfolioweb.portfolioweb.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);   
}