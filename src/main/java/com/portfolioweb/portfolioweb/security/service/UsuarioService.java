package com.portfolioweb.portfolioweb.security.service;

import com.portfolioweb.portfolioweb.security.entity.Usuario;
import com.portfolioweb.portfolioweb.security.repository.IUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    IUsuarioRepository iusuarioRepository;

    //Método para buscar usuario
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    //Método para verificar si el usuario existe por nombre de usuario
    public boolean existsByNombreUsuario(String nombreUsuario) {
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    //Método para verificar si el usuario existe por email
    public boolean existsByEmail(String email) {
        return iusuarioRepository.existsByEmail(email);
    }
    
    //M{etodo para guarsar un usuario
    public void save(Usuario usuario) {
        iusuarioRepository.save(usuario);
    }
}
