package fmoues.edu.sv.sistemascontable.Repositorys;

import fmoues.edu.sv.sistemascontable.Models.DetallePartidas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePartidasRepository extends JpaRepository<DetallePartidas, Integer> {

    @Query(value = "select *  from detalle_partidas where fk_partida = ?1", nativeQuery = true)
    List<DetallePartidas> getAllBySubcuenta(Integer id);
}
