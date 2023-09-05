package fmoues.edu.sv.sistemascontable.Repositorys;

import fmoues.edu.sv.sistemascontable.Models.Rubros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubrosRepository extends JpaRepository<Rubros, Integer> {
}
