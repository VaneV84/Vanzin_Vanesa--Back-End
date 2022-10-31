package com.portfolioweb.portfolioweb.controller;

import com.portfolioweb.portfolioweb.model.Experiencia;
import com.portfolioweb.portfolioweb.security.controller.Mensaje;
import com.portfolioweb.portfolioweb.service.ExperienciaService;
import com.portfolioweb.portfolioweb.dto.dtoExperiencia;
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
@RequestMapping("/explab")
@CrossOrigin(origins = "https://frontend-vmv.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {

    @Autowired
    ExperienciaService experienciaService;

    //Método para traer una lista
    @GetMapping("/list")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = experienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    
    //Método para buscar por ID
    @GetMapping("/find/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe la experiencia"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = experienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    

    //Método para crear una nueva experiencia
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexperiencia) {
        if (StringUtils.isBlank(dtoexperiencia.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (experienciaService.existsByNombre(dtoexperiencia.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = new Experiencia(dtoexperiencia.getNombre(), dtoexperiencia.getPuesto(),
                dtoexperiencia.getDescrip(), dtoexperiencia.getFechaComienzo(), 
                dtoexperiencia.getFechaFinal());
        
        experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }

    
    //Método para borrar experiencia
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id ingresado no existe"), HttpStatus.BAD_REQUEST);
        }
        
        experienciaService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    } 
    
    
    //Método para editar experiencia
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexperiencia) {
        //Valida la experiencia por ID
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id ingresado no existe"), HttpStatus.BAD_REQUEST);
        }
        //Valida la experiencia por NOMBRE 
        if (!experienciaService.existsByNombre(dtoexperiencia.getNombre())
                && experienciaService.getByNombre(dtoexperiencia.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        //El campo nombre no puede estar vacio
        if (StringUtils.isBlank(dtoexperiencia.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = experienciaService.getOne(id).get();
        experiencia.setNombre(dtoexperiencia.getNombre());
        experiencia.setPuesto(dtoexperiencia.getPuesto());
        experiencia.setDescrip(dtoexperiencia.getDescrip());
        experiencia.setFechaComienzo(dtoexperiencia.getFechaComienzo());
        experiencia.setFechaFinal(dtoexperiencia.getFechaFinal());
     
        experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
}