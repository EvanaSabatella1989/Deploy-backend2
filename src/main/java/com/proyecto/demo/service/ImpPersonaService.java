
package com.proyecto.demo.service;

import com.proyecto.demo.model.Persona;
import com.proyecto.demo.repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpPersonaService{
    
    @Autowired
    IPersonaRepository ipersoRepo;

   public List<Persona> list(){
        return ipersoRepo.findAll();
    }
    
    public Optional<Persona> getOne(int id){
        return ipersoRepo.findById(id);
    }
    
    public Optional<Persona> getByNombre(String nombre){
        return ipersoRepo.findByNombre(nombre);
    }
    
    public void save(Persona persona){
        ipersoRepo.save(persona);
    }
    
    public void delete(int id){
        ipersoRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return ipersoRepo.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return ipersoRepo.existsByNombre(nombre);
    }
}
