package fmoues.edu.sv.sistemascontable.Models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name = "cuentasmayores")
@Table(name = "\"cuentasmayores\"", schema = "public")
@PrimaryKeyJoinColumn(name = "id_cuentasMayores", foreignKey = @ForeignKey(name = "fk_rubro"))
@Inheritance(strategy = InheritanceType.JOINED)
public class CuentasMayores extends Rubros implements Serializable {
    @Column(name = "codigo_cuentas_mayores", nullable = false)
    private String codigo_cuentas_mayores;

    @Column(name = "nombre_cuentas_mayores", nullable = false)
    private String nombre_cuentas_mayores;

    @Column(name = "descripcion_cuentas_mayores", nullable = false)
    private String descripcion_cuentas_mayores;

    public String getCodigo_cuentas_mayores() {
        return codigo_cuentas_mayores;
    }

    public void setCodigo_cuentas_mayores(String codigo_cuentas_mayores) {
        this.codigo_cuentas_mayores = codigo_cuentas_mayores;
    }

    public String getNombre_cuentas_mayores() {
        return nombre_cuentas_mayores;
    }

    public void setNombre_cuentas_mayores(String nombre_cuentas_mayores) {
        this.nombre_cuentas_mayores = nombre_cuentas_mayores;
    }

    public String getDescripcion_cuentas_mayores() {
        return descripcion_cuentas_mayores;
    }

    public void setDescripcion_cuentas_mayores(String descripcion_cuentas_mayores) {
        this.descripcion_cuentas_mayores = descripcion_cuentas_mayores;
    }
}
