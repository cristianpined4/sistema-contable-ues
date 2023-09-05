package fmoues.edu.sv.sistemascontable.Controllers;

import fmoues.edu.sv.sistemascontable.Models.Usuarios;
import fmoues.edu.sv.sistemascontable.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class Login {
   @Autowired
    private AuthService auth;



   @PostMapping("/")
    public boolean login(@RequestBody String username, @RequestBody String password){
       return auth.getAuth(username,password) != null ? auth.getAuth(username,password).isEstado_usuario():false;
   }

   @PostMapping("/resgister")
    public boolean register(@RequestBody Usuarios user){
       return auth.registro(user);
   }

}
