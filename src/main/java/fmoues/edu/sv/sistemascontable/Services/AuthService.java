package fmoues.edu.sv.sistemascontable.Services;

import fmoues.edu.sv.sistemascontable.Models.Usuarios;
import fmoues.edu.sv.sistemascontable.Repositorys.UsuariosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Objects;

@Service
public class AuthService {
    @Autowired
    private UsuariosRepository users;

    private String hashWith256(String textToHash) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] byteOfTextToHash = textToHash.getBytes(StandardCharsets.UTF_8);
        byte[] hashedByetArray = digest.digest(byteOfTextToHash);
        String encoded = Base64.getEncoder().encodeToString(hashedByetArray);
        return encoded;
    }

    public Usuarios getAuth(String username, String password) throws NoSuchAlgorithmException {
        Usuarios user = users.findUserByUsername(username);
        if (Objects.equals(username, "admin") && user == null) {
            Usuarios nuevoAdmin = new Usuarios();
            nuevoAdmin.setFk_rol(1);
            nuevoAdmin.setContrasena_usuario(hashWith256("admin"));
            nuevoAdmin.setNombre_usuario("Admin");
            nuevoAdmin.setApellido_usuario("Admin");
            nuevoAdmin.setUsuario_usuario(username);
            nuevoAdmin.setCorreo_usuario("admin@admin.com");
            users.save(nuevoAdmin);
            user = nuevoAdmin;
        }
        Usuarios res = null;
        if (user != null && Objects.equals(user.getContrasena_usuario(), hashWith256(password))) {
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
