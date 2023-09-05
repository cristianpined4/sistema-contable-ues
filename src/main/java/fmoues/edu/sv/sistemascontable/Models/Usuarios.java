package fmoues.edu.sv.sistemascontable.Models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity(name = "usuarios")
@Table(name = "\"usuarios\"", schema = "public")
public class Usuarios {

    @Id
    @Column(name = "id_usuario", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;
    @Column(name = "nombre_usuario", nullable = false)
    private String nombre_usuario;

    @Column(name = "apellido_usuario", nullable = false)
    private String apellido_usuario;

    @Column(name = "usuario_usuario", nullable = false, unique = true)
    private String usuario_usuario;

    @Column(name = "contrasena_usuario", nullable = false)
    private String contrasena_usuario;

    @Column(name = "correo_usuario", nullable = false, unique = true)
    private String correo_usuario;

    @Column(name = "fecha_registro_usuario", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date fecha_registro;

    @Column(name = "estado_usuario", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean estado_usuario;

    @Column(name = "fk_rol", nullable = false)
    private int fk_rol;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public String getUsuario_usuario() {
        return usuario_usuario;
    }

    public void setUsuario_usuario(String usuario_usuario) {
        this.usuario_usuario = usuario_usuario;
    }

    public String getContrasena_usuario() {
        return contrasena_usuario;
    }

    public void setContrasena_usuario(String contrasena_usuario) {
        this.contrasena_usuario = contrasena_usuario;
    }

    public String getCorreo_usuario() {
        return correo_usuario;
    }

    public void setCorreo_usuario(String correo_usuario) {
        this.correo_usuario = correo_usuario;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public boolean isEstado_usuario() {
        return estado_usuario;
    }

    public void setEstado_usuario(boolean estado_usuario) {
        this.estado_usuario = estado_usuario;
    }

    public int getFk_rol() {
        return fk_rol;
    }

    public void setFk_rol(int fk_rol) {
        this.fk_rol = fk_rol;
    }
}
