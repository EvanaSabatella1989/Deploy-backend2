
package com.proyecto.demo.security.repository;

import com.proyecto.demo.security.entity.Rol;
import com.proyecto.demo.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre (RolNombre rolNombre);
    
}
