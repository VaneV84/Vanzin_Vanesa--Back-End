package com.portfolioweb.portfolioweb.security.service;

import com.portfolioweb.portfolioweb.security.entity.Rol;
import com.portfolioweb.portfolioweb.security.enums.RolNombre;
import com.portfolioweb.portfolioweb.security.repository.IRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {

    @Autowired
    IRolRepository irolRepository;

    //Método para buscar por rol
    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return irolRepository.findByRolNombre(rolNombre);
    }

    //Método para guardar cambios
    public void save(Rol rol) {
        irolRepository.save(rol);
    }
}
