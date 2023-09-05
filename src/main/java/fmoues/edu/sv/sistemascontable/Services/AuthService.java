package fmoues.edu.sv.sistemascontable.Services;

import fmoues.edu.sv.sistemascontable.Models.Usuarios;
import fmoues.edu.sv.sistemascontable.Repositorys.UsuariosRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private UsuariosRepository users;

    public Usuarios getUser(String username){
        return users.findUserByUsername(username);
    }
}
