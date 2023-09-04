package fmoues.edu.sv.sistemascontable.Models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name = "cuentas")
@Table(name = "\"cuentas\"", schema = "public")
@PrimaryKeyJoinColumn(name = "id_cuentas", foreignKey = @ForeignKey(name = "fk_cuentasMayores"))
@Inheritance(strategy = InheritanceType.JOINED)
public class Cuentas extends CuentasMayores implements Serializable {
    @Column(name = "codigo_cuentas", nullable = false)
    private String codigo_cuentas;

    @Column(name = "nombre_cuentas", nullable = false)
    private String nombre_cuentas;

    @Column(name = "descripcion_cuentas", nullable = false)
    private String descripcion;

    public String getCodigo_cuentas() {
        return codigo_cuentas;
    }

    public void setCodigo_cuentas(String codigo_cuentas) {
        this.codigo_cuentas = codigo_cuentas;
    }

    public String getNombre_cuentas() {
        return nombre_cuentas;
    }

    public void setNombre_cuentas(String nombre_cuentas) {
        this.nombre_cuentas = nombre_cuentas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
