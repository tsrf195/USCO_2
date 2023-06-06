package com.test.USCO.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
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

   @GetMapping("/login")
    String login() {
       return "login";
   }

}
