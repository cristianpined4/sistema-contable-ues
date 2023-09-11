package fmoues.edu.sv.sistemascontable.Models;

import jakarta.persistence.*;

@Entity(name = "detalle_partidas")
@Table(name = "\"detalle_partidas\"", schema = "public")
public class DetallePartidas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_partida", length = 10)
    private int id_detalle_partida;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "monto", length = 10, precision = 2, nullable = false)
    private double monto;

    @Column(name = "tipo", length = 10, nullable = false)
    private String tipo;

    @Column(name = "fk_partida", nullable = false)
    private int fk_partida;

    @Column(name = "fk_subcuentas", nullable = false)
    private int fk_subcuentas;

    @Column(name = "fecha", nullable = false)
    private String fecha;

    public int getId_detalle_partida() {
        return id_detalle_partida;
    }

    public void setId_detalle_partida(int id_detalle_partida) {
        this.id_detalle_partida = id_detalle_partida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getFk_partida() {
        return fk_partida;
    }

    public void setFk_partida(int fk_partida) {
        this.fk_partida = fk_partida;
    }

    public int getFk_subcuentas() {
        return fk_subcuentas;
    }

    public void setFk_subcuentas(int fk_subcuentas) {
        this.fk_subcuentas = fk_subcuentas;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
