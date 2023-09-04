package fmoues.edu.sv.sistemascontable.Models;

import jakarta.persistence.*;

@Entity(name = "roles")
@Table(name = "\"roles\"", schema = "public")
@Inheritance(strategy = InheritanceType.JOINED)
public class Roles {
    @Id
    @Column(name = "id_rol", length = 10)
    private String id_rol;

    @Column(name = "nombre_rol", nullable = false)
    private String nombre_rol;

    @Column(name = "descripcion_rol", nullable = false)
    private String descripcion_rol;

    public String getId_rol() {
        return id_rol;
    }

    public void setId_rol(String id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public String getDescripcion_rol() {
        return descripcion_rol;
    }

    public void setDescripcion_rol(String descripcion_rol) {
        this.descripcion_rol = descripcion_rol;
    }
}
