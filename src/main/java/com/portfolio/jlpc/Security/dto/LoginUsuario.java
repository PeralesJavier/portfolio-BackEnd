package com.portfolio.jlpc.Security.dto;

import javax.validation.constraints.NotBlank;


public class LoginUsuario {
    //No pueden estar en blanco
    @NotBlank
    private String nombreUsuario;
    
    @NotBlank
    private String password;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
