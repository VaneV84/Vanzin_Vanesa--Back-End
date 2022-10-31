package com.portfolioweb.portfolioweb.controller;

import com.portfolioweb.portfolioweb.model.Idioma;
import com.portfolioweb.portfolioweb.security.controller.Mensaje;
import com.portfolioweb.portfolioweb.service.IdiomaService;
import com.portfolioweb.portfolioweb.dto.dtoIdioma;
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
@RequestMapping("/idioma")
@CrossOrigin(origins = "https://frontend-vmv.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class IdiomaController {
    
    @Autowired
    IdiomaService idiomaService;

    //Método para traer una lista
    @GetMapping("/list")
    public ResponseEntity<List<Idioma>> list() {
        List<Idioma> list = idiomaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    //Método para buscar por ID
    @GetMapping("/find/{id}")
    public ResponseEntity<Idioma> getById(@PathVariable("id") int id){
        if(!idiomaService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el idioma"), HttpStatus.NOT_FOUND);
        Idioma idioma = idiomaService.getOne(id).get();
        return new ResponseEntity(idioma, HttpStatus.OK);
    }
    

    //Método para crear un nuevo idioma
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoIdioma dtoidioma) {
        if (StringUtils.isBlank(dtoidioma.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (idiomaService.existsByNombre(dtoidioma.getNombre())) {
            return new ResponseEntity(new Mensaje("El idioma ya existe"), HttpStatus.BAD_REQUEST);
        }

        Idioma idioma = new Idioma(dtoidioma.getNombre(), dtoidioma.getPorcentaje());
        
        idiomaService.save(idioma);
        return new ResponseEntity(new Mensaje("Idioma agregado"), HttpStatus.OK);
    }

    
    //Método para borrar idioma
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!idiomaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id ingresado no existe"), HttpStatus.BAD_REQUEST);
        }
        
        idiomaService.delete(id);
        return new ResponseEntity(new Mensaje("Idioma eliminado"), HttpStatus.OK);
    } 
    
    
    //Método para editar idioma
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoIdioma dtoidioma) {
        //Valida la skill por ID
        if (!idiomaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id ingresado no existe"), HttpStatus.BAD_REQUEST);
        }
        //Valida el idioma por NOMBRE 
        if (!idiomaService.existsByNombre(dtoidioma.getNombre())
                && idiomaService.getByNombre(dtoidioma.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El idioma ya existe"), HttpStatus.BAD_REQUEST);
        }
        //El campo nombre no puede estar vacio
        if (StringUtils.isBlank(dtoidioma.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);
        }

        Idioma idioma = idiomaService.getOne(id).get();
        idioma.setNombre(dtoidioma.getNombre());
        idioma.setPorcentaje(dtoidioma.getPorcentaje());
     
        idiomaService.save(idioma);
        return new ResponseEntity(new Mensaje("Idioma actualizado"), HttpStatus.OK);
    }  
}