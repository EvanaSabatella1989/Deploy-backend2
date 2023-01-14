
package com.proyecto.demo.security.service;

import com.proyecto.demo.security.entity.Usuario;
import com.proyecto.demo.security.repository.IUsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {
     @Autowired
     IUsuarioRepository iusuarioRepository;
     
     public Optional<Usuario> getByNombreUsuario(String nombreUsuario ){
         return iusuarioRepository.findByNombreUsuario(nombreUsuario);
     }
     
     public boolean existsByNombreUsuario(String nombreUsuario){
         return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
     }
     
     public boolean existsByEmail(String email){
         return iusuarioRepository.existsByEmail(email);
     }
    //cambie save por saveAndFlush porque me daba error
     public void save(Usuario usuario){
         iusuarioRepository.saveAndFlush(usuario);
     }
}
