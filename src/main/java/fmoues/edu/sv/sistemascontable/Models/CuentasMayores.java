package fmoues.edu.sv.sistemascontable.Models;

import jakarta.persistence.*;

@Entity(name = "cuentasmayores")
@Table(name = "\"cuentasmayores\"", schema = "public")
public class CuentasMayores {

    @Id
    @Column(name = "id_cuentasMayores", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cuentasMayores;

    @Column(name = "codigo_cuentas_mayores", nullable = false)
    private String codigo_cuentas_mayores;

    @Column(name = "nombre_cuentas_mayores", nullable = false)
    private String nombre_cuentas_mayores;

    @Column(name = "descripcion_cuentas_mayores", nullable = false)
    private String descripcion_cuentas_mayores;

    @Column(name = "fk_rubro", nullable = false)
    private int fk_rubro;

    public int getId_cuentasMayores() {
        return id_cuentasMayores;
    }

    public void setId_cuentasMayores(int id_cuentasMayores) {
        this.id_cuentasMayores = id_cuentasMayores;
    }

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

    public int getFk_rubro() {
        return fk_rubro;
    }

    public void setFk_rubro(int fk_rubro) {
        this.fk_rubro = fk_rubro;
    }
}
