package fmoues.edu.sv.sistemascontable.Controllers;

import com.google.gson.Gson;
import fmoues.edu.sv.sistemascontable.Models.Usuarios;
import fmoues.edu.sv.sistemascontable.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/login")
public class LoginController {
    @Autowired
    private AuthService auth;
    @Autowired
    private Gson gson;


    @PostMapping("/auth")
    public Object login(@RequestBody String user) {
        boolean res = false;
        Usuarios ob = gson.fromJson(user, Usuarios.class);
        ob = auth.getAuth(ob.getUsuario_usuario(), ob.getContrasena_usuario());
        return Map.of("success", ob != null, "user", gson.toJson(ob));
    }

    @PostMapping("/register")
    public boolean register(@RequestBody Usuarios user) {
        return auth.registro(user);
    }

}
