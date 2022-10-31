package com.portfolioweb.portfolioweb.controller;

import com.portfolioweb.portfolioweb.model.HyS;
import com.portfolioweb.portfolioweb.security.controller.Mensaje;
import com.portfolioweb.portfolioweb.service.HySService;
import com.portfolioweb.portfolioweb.dto.dtoHyS;
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
@RequestMapping("/hys")
@CrossOrigin(origins = "https://frontend-vmv.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class HySController {
    
    @Autowired
    HySService hysService;

    //Método para traer una lista
    @GetMapping("/list")
    public ResponseEntity<List<HyS>> list() {
        List<HyS> list = hysService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    
    //Método para buscar por ID
    @GetMapping("/find/{id}")
    public ResponseEntity<HyS> getById(@PathVariable("id") int id){
        if(!hysService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe la skill"), HttpStatus.NOT_FOUND);
        HyS hys = hysService.getOne(id).get();
        return new ResponseEntity(hys, HttpStatus.OK);
    }
    

    //Método para crear una nueva skill
    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody dtoHyS dtohys) {
        if (StringUtils.isBlank(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (hysService.existsByNombre(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        HyS hys = new HyS(dtohys.getNombre(), dtohys.getPorcentaje());
        
        hysService.save(hys);
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    
    //Método para borrar skill
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!hysService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id ingresado no existe"), HttpStatus.BAD_REQUEST);
        }
        
        hysService.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
    } 
    
    
    //Método para editar skill
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHyS dtohys) {
        //Valida la skill por ID
        if (!hysService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id ingresado no existe"), HttpStatus.BAD_REQUEST);
        }
        //Valida la skill por NOMBRE 
        if (!hysService.existsByNombre(dtohys.getNombre())
                && hysService.getByNombre(dtohys.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //El campo nombre no puede estar vacio
        if (StringUtils.isBlank(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);
        }

        HyS hys = hysService.getOne(id).get();
        hys.setNombre(dtohys.getNombre());
        hys.setPorcentaje(dtohys.getPorcentaje());
     
        hysService.save(hys);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
    }  
}