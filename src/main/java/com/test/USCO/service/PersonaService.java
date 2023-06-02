package com.test.USCO.service;

import com.test.USCO.config.UserGrantedAuthority;
import com.test.USCO.entity.Persona;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface PersonaService  {
    List<UserGrantedAuthority> listarRoles(long usuario);

    void save(Persona persona);

    Optional<Persona> getByUserName(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String username);

}
