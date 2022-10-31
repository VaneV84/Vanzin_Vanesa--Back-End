package com.portfolioweb.portfolioweb.security.repository;

import com.portfolioweb.portfolioweb.security.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    
    //Verifica que el usuario exita por nombre de usuario e email
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
}