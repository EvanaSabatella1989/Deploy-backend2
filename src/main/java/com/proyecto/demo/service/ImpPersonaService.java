
package com.proyecto.demo.service;

import com.proyecto.demo.interfaces.IPersonaService;
import com.proyecto.demo.model.Persona;
import com.proyecto.demo.repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService{
    
    @Autowired
    IPersonaRepository ipersoRepo;

    @Override
    public List<Persona> getPersona() {
        return ipersoRepo.findAll();
    }

    @Override
    public void savePersona(Persona pers) {
        ipersoRepo.save(pers);
    }

    @Override
    public void deletePersona(Long id) {
        ipersoRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        return ipersoRepo.findById(id).orElse(null);
    }
    
}
