package fmoues.edu.sv.sistemascontable.Repositorys;

import fmoues.edu.sv.sistemascontable.Models.Partidas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidasRepositorys extends JpaRepository<Partidas, Integer> {
    @Query(value = "select * from partidas where id_partida = ?1 limit 1", nativeQuery = true)
    Partidas findOneById(Integer id);
}
