package com.portfolio.jlpc.Security.entity;

//clase encargada de tener la seguridad, Se podria hacer en Usuario pero


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


//vamos a intentar que cada clase tenga su responsabilidad y no se emtan en las demas
//la clase va a implementar el tema de los privilegios de cada usuario
//mismos campos que usuario; menos el id}
//tambien va a tener en vez de roles(objeto de la calse rol), authoritis(objetos de la clase grantedAuthority; son cosas propias de la seguridad de Srpingboot)
//implementa de userdetails que tambien es del Security core
public class UsuarioPrincipal implements UserDetails{
    //no ide porque no es entidad
    private String nombre;
    private String nombreUsuario;
    private String email;
    private String password;
    //cambiamos la clase rol por las autoridades (autenticacion y autorizacion)
    private Collection <? extends GrantedAuthority> authorities;

    public UsuarioPrincipal(String nombre, String nombreUsuario, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }
    
    //metodo estatico, llamarBuild; va a asignar los privilegios a cada usuario
    //Si es amdin o usuario estandar; como parametro va a recibir un usuario que representa
    //a la entidad de la base de datos
    public static UsuarioPrincipal build(Usuario usuario){
        //primero obtener los roles; convertir los roles en autorithies
        List<GrantedAuthority> authorities = 
                usuario.getRoles().stream().map(rol -> 
                        new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getNombre(), usuario.getNombreUsuario(),
        usuario.getEmail(), usuario.getPassword(), authorities);
    }
    
    //implementa los metodos abstractos de UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.nombreUsuario;
    }
    
    //resto de booleanos a true
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
