package com.portfolio.jlpc.Security.repository;

import com.portfolio.jlpc.Security.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Integer>{
    //3 metodos: 1 obtener un usuario a partir de nombre de usuario
    Optional <Usuario> findByNombreUsuario(String nombreUsuario);
    //Probamos con boleanos para ver si existe
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
}
