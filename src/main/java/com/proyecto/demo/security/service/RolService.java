
package com.proyecto.demo.security.service;

import com.proyecto.demo.security.entity.Rol;
import com.proyecto.demo.security.enums.RolNombre;
import com.proyecto.demo.security.repository.IRolRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolService {
    @Autowired
    IRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
    //cambie save por saveAndFlush porque me daba error
    public void save(Rol rol){
        irolRepository.saveAndFlush(rol);
    }
}

