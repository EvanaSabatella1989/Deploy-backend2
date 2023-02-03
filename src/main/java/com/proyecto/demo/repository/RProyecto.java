
package com.proyecto.demo.repository;

import com.proyecto.demo.model.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyecto extends JpaRepository<Proyecto, Integer>{
    
    public Optional<Proyecto> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
