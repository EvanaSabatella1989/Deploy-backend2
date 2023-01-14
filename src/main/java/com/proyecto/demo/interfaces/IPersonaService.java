
package com.proyecto.demo.interfaces;


import com.proyecto.demo.model.Persona;
import java.util.List;


public interface IPersonaService {
    //traer una lista de personas
    public List<Persona> getPersona();
    //guardar un objeto de tipo Persona
    public void savePersona(Persona pers);
    //Eliminar un objeto pero lo buscamos por Id
    public void deletePersona(Long id);
    //Buscar una persona por Id
    public Persona findPersona(Long id);
    
}