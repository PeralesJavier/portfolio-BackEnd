package com.portfolio.jlpc.Security.service;

import com.portfolio.jlpc.Security.entity.Usuario;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.jlpc.Security.repository.UsuarioRepository;

@Service
//Para mantener la coherencia en la BDT; persistencia; rolback
@Transactional
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;
    
    public Optional <Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }
    
    //para guardar un usuario nuevo
    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
