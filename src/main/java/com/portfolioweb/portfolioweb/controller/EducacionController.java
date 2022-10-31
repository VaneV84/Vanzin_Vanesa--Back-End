package com.portfolioweb.portfolioweb.controller;

import com.portfolioweb.portfolioweb.model.Educacion;
import com.portfolioweb.portfolioweb.security.controller.Mensaje;
import com.portfolioweb.portfolioweb.service.EducacionService;
import com.portfolioweb.portfolioweb.dto.dtoEducacion;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "https://frontend-vmv.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
    
    @Autowired
    EducacionService educacionService;

    //Método para traer una lista
    @GetMapping("/list")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = educacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    
    //Método para buscar por ID
    @GetMapping("/find/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!educacionService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe la educación"), HttpStatus.NOT_FOUND);
        Educacion educacion = educacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    

    //Método para crear una nueva educación
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion) {
        if (StringUtils.isBlank(dtoeducacion.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (educacionService.existsByNombre(dtoeducacion.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa educación ya existe"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(dtoeducacion.getNombre(), dtoeducacion.getDescrip(), 
            dtoeducacion.getFechaComienzo(), dtoeducacion.getFechaFinal());
        
        educacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Educación agregada"), HttpStatus.OK);
    }

    
    //Método para borrar educación
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!educacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id ingresado no existe"), HttpStatus.BAD_REQUEST);
        }
        
        educacionService.delete(id);
        return new ResponseEntity(new Mensaje("Educación eliminada"), HttpStatus.OK);
    } 
    
    
    //Método para editar educación
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion) {
        //Valida la educación por ID
        if (!educacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id ingresado no existe"), HttpStatus.BAD_REQUEST);
        }
        //Valida la educación por NOMBRE 
        if (!educacionService.existsByNombre(dtoeducacion.getNombre())
                && educacionService.getByNombre(dtoeducacion.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa educación ya existe"), HttpStatus.BAD_REQUEST);
        }
        //El campo nombre no puede estar vacio
        if (StringUtils.isBlank(dtoeducacion.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = educacionService.getOne(id).get();
        educacion.setNombre(dtoeducacion.getNombre());
        educacion.setDescrip(dtoeducacion.getDescrip());
        educacion.setFechaComienzo(dtoeducacion.getFechaComienzo());
        educacion.setFechaFinal(dtoeducacion.getFechaFinal());
     
        educacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    } 
}