package com.test.USCO.controller;

import com.test.USCO.config.UserGrantedAuthority;
import com.test.USCO.entity.Persona;
import com.test.USCO.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/persona/")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("listarRoles")
    @Secured("Role_admin")
    public ResponseEntity<List<UserGrantedAuthority>> listarRoles(){
        Persona persona = (Persona) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        return new ResponseEntity<>(personaService.listarRoles(persona.getId()), HttpStatus.OK);
    }
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody String username, String password) {

        System.out.println("estoy llegando a la funciona de login en el back :D");
        boolean isValidUser = personaService.existsByUsername(username);
        System.out.println("estado del boolean: "+ isValidUser );
        if (isValidUser) {
            System.out.println("estás entrandooooooooo con un usuario vaaaalido");
            return ResponseEntity.ok().build();
        } else {
            System.out.println("no estoy encontrando la persona con usuario: "+ username);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    //mover todos los if al servicio (mejor y más avanzado, la capa de controller no se debería de encargar de esto)
    @PostMapping("crear")
    public ResponseEntity<?> crear(@RequestBody Persona persona){
        System.out.println("estoy llegando al back para crear");
        if (persona.getName() == null){
            return new ResponseEntity<>("El nombre es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (persona.getEmail() == null){
            return new ResponseEntity<>("El email es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (persona.getDob() == null){
            return new ResponseEntity<>("La fecha de nacimiento es obligatorio", HttpStatus.BAD_REQUEST);
        }
        System.out.println("estoy en el controller"+ persona.getPassword());
        System.out.println("estoy en el controller"+ persona.getUsername());
        Persona persona_nueva = new Persona(persona.getName(), persona.getPassword(), persona.getEmail(), persona.getDob(), persona.getUsername());
        System.out.println("estoy en el controller con persona nueva: "+ persona_nueva.getPassword());
        System.out.println("estoy en el controller con persona nueva: "+ persona_nueva.getUsername());
        personaService.save(persona_nueva);
        return new ResponseEntity<>("Usuario Creado", HttpStatus.OK);
    }



    @PutMapping("actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable("id") long id ,@RequestBody Persona persona){
        if (personaService.existsById(persona.getId()))
            return new ResponseEntity<>("Usuario no existe.", HttpStatus.NOT_FOUND);
        if (personaService.existsByEmail(persona.getEmail())){
            System.out.println("correo siendo usado por otro usuario");
            return new ResponseEntity<>("Correo ya esta siendo usado.", HttpStatus.BAD_REQUEST);
        }
        if (!personaService.existsByUsername(persona.getUsername()))
            return new ResponseEntity<>("Username ya esta siendo usado", HttpStatus.BAD_REQUEST);

        if (persona.getName() == null){
            return new ResponseEntity<>("El nombre es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (persona.getEmail() == null){
            return new ResponseEntity<>("El email es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (persona.getDob() == null){
            return new ResponseEntity<>("La fecha de nacimiento es obligatorio", HttpStatus.BAD_REQUEST);
        }
        personaService.save(persona);
        return new ResponseEntity<>("Persona Actualizada.", HttpStatus.OK);
    }


}
