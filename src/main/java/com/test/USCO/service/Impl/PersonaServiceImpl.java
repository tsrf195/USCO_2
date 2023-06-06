package com.test.USCO.service.Impl;

import com.test.USCO.config.UserGrantedAuthority;
import com.test.USCO.entity.Persona;
import com.test.USCO.entity.Rol;
import com.test.USCO.repository.IPersonaRepository;
import com.test.USCO.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    IPersonaRepository personaRepository;

    @Override
    public Optional<Persona> getByUserName(String username){
        return personaRepository.findByUsername(username);
    }

    @Override
    public Boolean existsById(long id) {
        return personaRepository.existsById(id);
    }

    @Override
    public Boolean existsByUsername(String username){
        System.out.println("ESTE ES EL USUARIO QUE ESTÁ EN LA IMPLEMENTACION DE EXISTBYUSERNAME:"+username);
        return personaRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String username){
        return personaRepository.existsByEmail(username);
    }


    @Override
    public List<UserGrantedAuthority> listarRoles(long usuario){
        Collection<Rol> roles = personaRepository.findRolesById(usuario);
        List<UserGrantedAuthority> retornar = new ArrayList<>();
        roles.forEach(rol -> {
                        UserGrantedAuthority usuarioGranted = new UserGrantedAuthority("ROLE_"+ rol.getNombre());
            System.out.println("Rol:  "+usuarioGranted.getRole());
            retornar.add(usuarioGranted);
        });
        return retornar;
    }

    @Override
    public void save(Persona persona) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println("contraseña: " + persona.getPassword());
        persona.setPassword(passwordEncoder.encode(persona.getPassword()));
        System.out.println("usuario en save: " + persona.getUsername());
        personaRepository.save(persona);
    }
}
