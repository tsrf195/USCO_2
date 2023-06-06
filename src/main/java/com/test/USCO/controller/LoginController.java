package com.test.USCO.controller;


import com.test.USCO.entity.Persona;
import com.test.USCO.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/persona/")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
    @Autowired
    PersonaService personaService;
//    @PostMapping("login")
//    public ResponseEntity<?> login(@RequestBody String username, String password) {
//        System.out.println("estoy llegando a la funciona de login en el back :D");
//        boolean isValidUser = personaService.existsByUsername(username);
//
//        if (isValidUser) {
//            System.out.println("estás entrandooooooooo con un usuario vaaaalido");
//            return ResponseEntity.ok().build();
//        } else {
//            System.out.println("no estoy encontrando la persona con usuario: "+ username);
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//    }

}
