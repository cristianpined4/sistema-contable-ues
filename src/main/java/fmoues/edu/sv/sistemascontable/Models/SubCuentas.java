package fmoues.edu.sv.sistemascontable.Models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name = "subcuentas")
@Table(name = "\"subcuentas\"", schema = "public")
@PrimaryKeyJoinColumn(name = "id_subcuentas", foreignKey = @ForeignKey(name = "fk_cuentas"))
public class SubCuentas extends Cuentas implements Serializable {
    @Column(name = "codigo_subcuentas", nullable = false)
    private String codigo_subcuentas;

    @Column(name = "nombre_subcuentas", nullable = false)
    private String nombre_subcuentas;

    @Column(name = "descripcion_subcuentas", nullable = false)
    private String descripcion_subcuentas;

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
}
