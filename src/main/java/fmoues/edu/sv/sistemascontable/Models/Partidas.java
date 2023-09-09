package fmoues.edu.sv.sistemascontable.Models;

import jakarta.persistence.*;

@Entity(name = "partidas")
@Table(name = "\"partidas\"", schema = "public")
public class Partidas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_partida", length = 10)
    private int id_partida;

    @Column(name = "descripcion_partida", nullable = false)
    private String descripcion_partida;

    @Column(name = "fecha_partida", nullable = false)
    private String fecha_partida;

    public int getId_partida() {
        return id_partida;
    }

    public void setId_partida(int id_partida) {
        this.id_partida = id_partida;
    }

    public String getDescripcion_partida() {
        return descripcion_partida;
    }

    public void setDescripcion_partida(String descripcion_partida) {
        this.descripcion_partida = descripcion_partida;
    }

    public String getFecha_partida() {
        return fecha_partida;
    }

    public void setFecha_partida(String fecha_partida) {
        this.fecha_partida = fecha_partida;
    }
}
