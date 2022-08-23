package com.portfolio.jlpc.Interface;

import com.portfolio.jlpc.entity.Persona;
import java.util.List;


public interface IPersonaService {
    //Descripcion de los metodos a utilizar
    public List<Persona> getPersona();
    
    public void savePersona(Persona persona);
    
    public void deletePersona(Long id);
    
    public Persona findPersona(Long id);
}
