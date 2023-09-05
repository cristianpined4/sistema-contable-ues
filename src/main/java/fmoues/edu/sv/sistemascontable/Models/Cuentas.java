package fmoues.edu.sv.sistemascontable.Models;

import jakarta.persistence.*;

@Entity(name = "cuentas")
@Table(name = "\"cuentas\"", schema = "public")
public class Cuentas {

    @Id
    @Column(name = "id_cuentas", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cuentas;
    @Column(name = "codigo_cuentas", nullable = false)
    private String codigo_cuentas;

    @Column(name = "nombre_cuentas", nullable = false)
    private String nombre_cuentas;

    @Column(name = "descripcion_cuentas", nullable = false)
    private String descripcion_cuentas;

    @Column(name = "fk_cuentasMayores", nullable = false)
    private int fk_cuentasMayores;

    public int getId_cuentas() {
        return id_cuentas;
    }

    public void setId_cuentas(int id_cuentas) {
        this.id_cuentas = id_cuentas;
    }

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

    public String getDescripcion_cuentas() {
        return descripcion_cuentas;
    }

    public void setDescripcion_cuentas(String descripcion_cuentas) {
        this.descripcion_cuentas = descripcion_cuentas;
    }

    public int getFk_cuentasMayores() {
        return fk_cuentasMayores;
    }

    public void setFk_cuentasMayores(int fk_cuentasMayores) {
        this.fk_cuentasMayores = fk_cuentasMayores;
    }
}
