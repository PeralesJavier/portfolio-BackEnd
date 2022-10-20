package com.portfolio.jlpc.Security.repository;

import com.portfolio.jlpc.Security.entity.Rol;
import com.portfolio.jlpc.Security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional <Rol> findByRolNombre(RolNombre rolNombre);
}
