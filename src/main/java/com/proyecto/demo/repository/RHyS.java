
package com.proyecto.demo.repository;

import com.proyecto.demo.model.HyS;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RHyS extends JpaRepository<HyS, Integer>{
    
    public Optional<HyS> findByNombre(String nombre);
    
    public boolean existsByNombre(String nombre);
}
