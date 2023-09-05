package fmoues.edu.sv.sistemascontable.Models;

import jakarta.persistence.*;

@Entity(name = "rubros")
@Table(name = "\"rubros\"", schema = "public")
public class Rubros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rubro", length = 10)
    private int id_rubro;

    @Column(name = "codigo_rubro", nullable = false)
    private String codigo_rubro;

    @Column(name = "nombre_rubro", nullable = false)
    private String nombre_rubro;

    @Column(name = "descripcion_rubro", nullable = false)
    private String descripcion_rubro;

    public int getId_rubro() {
        return id_rubro;
    }

    public void setId_rubro(int id_rubro) {
        this.id_rubro = id_rubro;
    }

    public String getCodigo_rubro() {
        return codigo_rubro;
    }

    public void setCodigo_rubro(String codigo_rubro) {
        this.codigo_rubro = codigo_rubro;
    }

    public String getNombre_rubro() {
        return nombre_rubro;
    }

    public void setNombre_rubro(String nombre_rubro) {
        this.nombre_rubro = nombre_rubro;
    }

    public String getDescripcion_rubro() {
        return descripcion_rubro;
    }

    public void setDescripcion_rubro(String descripcion_rubro) {
        this.descripcion_rubro = descripcion_rubro;
    }
}
