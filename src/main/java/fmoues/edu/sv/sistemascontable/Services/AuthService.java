package fmoues.edu.sv.sistemascontable.Services;

import fmoues.edu.sv.sistemascontable.Models.Usuarios;
import fmoues.edu.sv.sistemascontable.Repositorys.UsuariosRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private UsuariosRepository users;

    public Usuarios getAuth(String username, String password){
        Usuarios user = users.findUserByUsername(username);
        Usuarios res = null;
        if(user.getContrasena_usuario() == password) res = user;
        return res;
    }
}
