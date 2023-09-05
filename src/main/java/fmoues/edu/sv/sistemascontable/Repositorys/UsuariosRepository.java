package fmoues.edu.sv.sistemascontable.Repositorys;

import fmoues.edu.sv.sistemascontable.Models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios,Integer> {

    @Query(value = "select * from usuarios where nombre_usuario = ?1 limit 1",nativeQuery = true)
    Usuarios findUserByUsername(String username);
}
