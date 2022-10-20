package com.portfolio.jlpc.Security.service;

import com.portfolio.jlpc.Security.entity.Usuario;
import com.portfolio.jlpc.Security.repository.UsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//Para mantener la coherencia en la BDT
@Transactional
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;
    
    public Optional <Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepository.existByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(String email){
        return usuarioRepository.existByEmail(email);
    }
    
    //para guardar
    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
