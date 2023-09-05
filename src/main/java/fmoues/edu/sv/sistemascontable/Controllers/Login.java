package fmoues.edu.sv.sistemascontable.Controllers;

import fmoues.edu.sv.sistemascontable.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class Login {
   @Autowired
    private AuthService auth;

   @GetMapping("/")
    public boolean login(String username,String password){
       return auth.getUser(username) != null ? auth.getUser(username).isEstado_usuario():false;
   }

}
