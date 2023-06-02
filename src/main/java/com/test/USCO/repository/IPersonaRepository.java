package com.test.USCO.repository;

import com.test.USCO.entity.Persona;
import com.test.USCO.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long> {

    Optional<Persona> findByUsername(String username);

    Collection<Rol> findRolesById(@Param("id")Long personaId);

    public UserDetails findByEmail(String email);

    boolean existsByUserName(String username);
    boolean existsByEmail(String email);
}
