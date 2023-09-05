package fmoues.edu.sv.sistemascontable.Services;

import fmoues.edu.sv.sistemascontable.Models.Usuarios;
import fmoues.edu.sv.sistemascontable.Repositorys.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UsuariosRepository users;

    public Usuarios getAuth(String username, String password){
        Usuarios user = users.findUserByUsername(username);
        Usuarios res = null;
        if(user.getContrasena_usuario() == password) res = user;
        return res;
    }

    public boolean registro (Usuarios user){
        boolean res;
        try {
            users.save(user);
            res = true;
        }catch (Error e){
            res = false;
        }
        return res;
    }
}
