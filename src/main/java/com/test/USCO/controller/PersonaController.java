package com.test.USCO.controller;

import com.test.USCO.config.UserGrantedAuthority;
import com.test.USCO.entity.Persona;
import com.test.USCO.entity.Persona_Roles;
import com.test.USCO.entity.Rol;
import com.test.USCO.service.Impl.PersonaServiceImpl;
import com.test.USCO.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/persona/")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("listarRoles")
    @Secured("Role_admin")
    public ResponseEntity<List<UserGrantedAuthority>> listarRoles(){
        Persona persona = (Persona) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        return new ResponseEntity<>(personaService.listarRoles(persona.getId()), HttpStatus.OK);
    }

    @PostMapping("crear")
    public ResponseEntity<?> crear(@RequestBody Persona persona){
        if (persona.getName() == null){
            return new ResponseEntity<>("El nombre es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (persona.getEmail() == null){
            return new ResponseEntity<>("El email es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (persona.getDob() == null){
            return new ResponseEntity<>("La fecha de nacimiento es obligatorio", HttpStatus.BAD_REQUEST);
        }
        Persona persona_nueva = new Persona(persona.getName(), persona.getPassword(), persona.getEmail(), persona.getDob());
        personaService.save(persona_nueva);
        return new ResponseEntity<>("Usuario Creado", HttpStatus.OK);
    }


}
