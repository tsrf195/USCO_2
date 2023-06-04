package com.test.USCO.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @Autowired
    PersonaService personaService;
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody String username, String password) {

        boolean isValidUser = personaService.existsByUsername(username);

        if (isValidUser) {
            // Return success response
            return ResponseEntity.ok().build();
        } else {
            // Return error response
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

   @GetMapping("/login")
    String login() {
       return "login";
   }

}
