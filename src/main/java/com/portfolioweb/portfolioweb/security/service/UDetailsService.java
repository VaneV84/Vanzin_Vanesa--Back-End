package com.portfolioweb.portfolioweb.security.service;

import com.portfolioweb.portfolioweb.security.entity.Usuario;
import com.portfolioweb.portfolioweb.security.entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UDetailsService implements UserDetailsService { 
  
    @Autowired
    UsuarioService usuarioService;

    //Método para cargar usuario por nombre de usuario
    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipal.build(usuario);
    }
}
