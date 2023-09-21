package fmoues.edu.sv.sistemascontable.Services;

import fmoues.edu.sv.sistemascontable.Models.Usuarios;
import fmoues.edu.sv.sistemascontable.Repositorys.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService {
    @Autowired
    private UsuariosRepository users;

    public Usuarios getAuth(String username, String password) {
        Usuarios user = users.findUserByUsername(username);
        if (Objects.equals(username, "admin") && user == null) {
            Usuarios nuevoAdmin = new Usuarios();
            nuevoAdmin.setFk_rol(1);
            nuevoAdmin.setContrasena_usuario("admin");
            nuevoAdmin.setNombre_usuario("Admin");
            nuevoAdmin.setApellido_usuario("Admin");
            nuevoAdmin.setUsuario_usuario(username);
            nuevoAdmin.setCorreo_usuario("admin@admin.com");
            users.save(nuevoAdmin);
            user = nuevoAdmin;
        }
        Usuarios res = null;
        if (user != null && Objects.equals(user.getContrasena_usuario(), password)) {
            res = user;
            res.setContrasena_usuario("");
        }
        return res;
    }

    public boolean registro(Usuarios user) {
        boolean res;
        try {
            users.save(user);
            res = true;
        } catch (Error e) {
            res = false;
        }
        return res;
    }
}
