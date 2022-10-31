package com.portfolioweb.portfolioweb.controller;

import com.portfolioweb.portfolioweb.dto.dtoProyectos;
import com.portfolioweb.portfolioweb.model.Proyectos;
import com.portfolioweb.portfolioweb.security.controller.Mensaje;
import com.portfolioweb.portfolioweb.service.ProyectosService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins = "https://frontend-vmv.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class ProyectosController {
    
    @Autowired
    ProyectosService proyectosService;

    //Método para traer una lista
    @GetMapping("/list")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = proyectosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    //Método para buscar por ID
    @GetMapping("/find/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!proyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el proyecto"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = proyectosService.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    

    //Método para crear un nuevo proyecto
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproyectos) {
        if (StringUtils.isBlank(dtoproyectos.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (proyectosService.existsByNombre(dtoproyectos.getNombre())) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyectos = new Proyectos(dtoproyectos.getNombre(), dtoproyectos.getFecha(),
                dtoproyectos.getDescrip(), dtoproyectos.getImg());
        
        proyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }

    
    //Método para borrar un proyecto
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!proyectosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id ingresado no existe"), HttpStatus.BAD_REQUEST);
        }
        
        proyectosService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    } 
    
    
    //Método para editar un proyecto
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproyectos) {
        //Valida el proyecto por ID
        if (!proyectosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id ingresado no existe"), HttpStatus.BAD_REQUEST);
        }
        //Valida el proyecto por NOMBRE 
        if (!proyectosService.existsByNombre(dtoproyectos.getNombre())
                && proyectosService.getByNombre(dtoproyectos.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        //El campo nombre no puede estar vacio
        if (StringUtils.isBlank(dtoproyectos.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyectos = proyectosService.getOne(id).get();
        proyectos.setNombre(dtoproyectos.getNombre());
        proyectos.setFecha(dtoproyectos.getFecha());
        proyectos.setDescrip(dtoproyectos.getDescrip());
        proyectos.setImg(dtoproyectos.getImg());
     
        proyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto actualizada"), HttpStatus.OK);
    }
}