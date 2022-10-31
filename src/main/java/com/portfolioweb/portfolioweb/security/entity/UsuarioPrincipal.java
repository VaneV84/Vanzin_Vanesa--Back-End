package com.portfolioweb.portfolioweb.security.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioPrincipal implements UserDetails {

    //Atributos
    private String nombre;
    private String nombreUsuario;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    //Constructor
    public UsuarioPrincipal(String nombre, String nombreUsuario, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    //Método para crear usuario principal para login
    public static UsuarioPrincipal build(Usuario usuario) {
        List<GrantedAuthority> authorities = usuario.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getNombre(), usuario.getNombreUsuario(), usuario.getEmail(),
                usuario.getPassword(), authorities);
    }

    //Metodos declarados en UserDetails 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    //Método que verifica que la cuenta haya expirado
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //Método que verifica que la cuenta no este bloqueada
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //Método que verifica que la credencial no este expirada
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //Método que verifica que la cuenta esté habilitada
    @Override
    public boolean isEnabled() {
        return true;
    }
}
