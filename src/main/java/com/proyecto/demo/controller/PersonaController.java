
package com.proyecto.demo.controller;

import com.proyecto.demo.dto.DtoPersona;
import com.proyecto.demo.model.Persona;
import com.proyecto.demo.security.controller.Mensaje;
import com.proyecto.demo.service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
//@CrossOrigin(origins = {"https://portfolio-argentina-prog-90acd.web.app","http://localhost:4200"})
@CrossOrigin(origins = "https://portfolio-argentina-prog-90acd.web.app")
public class PersonaController {

    @Autowired
    ImpPersonaService personaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
//    @PostMapping("/create")
//    public ResponseEntity<?> create(@RequestBody DtoPersona dtopersona){
//        if(StringUtils.isBlank(dtopersona.getNombre()))
//            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
//        if(personaService.existsByNombre(dtopersona.getNombre()))
//            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
//        
//        Persona persona = new Persona(dtopersona.getNombre(),dtopersona.getApellido(), dtopersona.getDescripcion(), dtopersona.getImg());
//        personaService.save(persona);
//        
//        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
//    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtopersona){
        //Validamos si existe el ID
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        //Compara nombre de experiencias
        if(personaService.existsByNombre(dtopersona.getNombre()) && personaService.getByNombre(dtopersona.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtopersona.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona persona = personaService.getOne(id).get();
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setProfesion(dtopersona.getProfesion());
        persona.setDescripcion((dtopersona.getDescripcion()));
        persona.setImg(dtopersona.getImg());
        persona.setUbicacion(dtopersona.getUbicacion());
        
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
             
    }
    
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> delete(@PathVariable("id") int id) {
//        if (!personaService.existsById(id)) {
//            return new ResponseEntity(new Mensaje("el ID no existe"), HttpStatus.NOT_FOUND);
//        }
//        personaService.delete(id);
//        return new ResponseEntity(new Mensaje("persona eliminada"), HttpStatus.OK);
//    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
}
