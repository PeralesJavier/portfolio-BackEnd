package com.portfolio.jlpc.Security.service;

import com.portfolio.jlpc.Security.entity.Rol;
import com.portfolio.jlpc.Security.enums.RolNombre;
import com.portfolio.jlpc.Security.repository.RolRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolService {
    
    @Autowired
    RolRepository rolRepository;
    //encontrar uno por rolNombre
    
    public Optional <Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }
}
