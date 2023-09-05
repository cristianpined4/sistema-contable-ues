package fmoues.edu.sv.sistemascontable.Models;

import jakarta.persistence.*;

@Entity(name = "subcuentas")
@Table(name = "\"subcuentas\"", schema = "public")
public class SubCuentas {

    @Id
    @Column(name = "id_subcuentas", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_subcuentas;
    @Column(name = "codigo_subcuentas", nullable = false)
    private String codigo_subcuentas;

    @Column(name = "nombre_subcuentas", nullable = false)
    private String nombre_subcuentas;

    @Column(name = "descripcion_subcuentas", nullable = false)
    private String descripcion_subcuentas;

    @Column(name = "fk_cuentas", nullable = false)
    private int fk_cuentas;

    public int getId_subcuentas() {
        return id_subcuentas;
    }

    public void setId_subcuentas(int id_subcuentas) {
        this.id_subcuentas = id_subcuentas;
    }

    public String getCodigo_subcuentas() {
        return codigo_subcuentas;
    }

    public void setCodigo_subcuentas(String codigo_subcuentas) {
        this.codigo_subcuentas = codigo_subcuentas;
    }

    public String getNombre_subcuentas() {
        return nombre_subcuentas;
    }

    public void setNombre_subcuentas(String nombre_subcuentas) {
        this.nombre_subcuentas = nombre_subcuentas;
    }

    public String getDescripcion_subcuentas() {
        return descripcion_subcuentas;
    }

    public void setDescripcion_subcuentas(String descripcion_subcuentas) {
        this.descripcion_subcuentas = descripcion_subcuentas;
    }

    public int getFk_cuentas() {
        return fk_cuentas;
    }

    public void setFk_cuentas(int fk_cuentas) {
        this.fk_cuentas = fk_cuentas;
    }
}
