package fmoues.edu.sv.sistemascontable.Repositorys;

import fmoues.edu.sv.sistemascontable.Models.CuentasMayores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentasMayoresRepository extends JpaRepository<CuentasMayores, Integer> {
}
