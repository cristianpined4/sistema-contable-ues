package fmoues.edu.sv.sistemascontable.Repositorys;

import fmoues.edu.sv.sistemascontable.Models.Partidas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidasRepositorys extends JpaRepository<Partidas, Integer> {
    @Query(value = "select * from partidas where id_partida = ?1 limit 1", nativeQuery = true)
    Partidas findOneById(Integer id);

    @Query(value = "SELECT cuentas.nombre_cuentas as nombre_cuenta, tipo,  monto, cuentas.codigo_cuentas as codigo, rubros.nombre_rubro as rubro\n" +
            "FROM detalle_partidas \n" +
            "INNER JOIN subcuentas ON subcuentas.id_subcuentas = detalle_partidas.fk_subcuentas \n" +
            "INNER JOIN cuentas ON cuentas.id_cuentas = subcuentas.fk_cuentas \n" +
            "INNER JOIN cuentasMayores ON cuentasMayores.id_cuentasMayores = cuentas.fk_cuentasMayores \n" +
            "INNER JOIN rubros ON rubros.id_rubro = cuentasMayores.fk_rubro \n" +
            "INNER JOIN partidas ON partidas.id_partida = detalle_partidas.fk_partida\n" +
            "WHERE date(partidas.fecha_partida) BETWEEN date(?1) AND date(?2) \n" +
            "ORDER BY nombre_cuenta", nativeQuery = true)
    List<Object> getDataLibroMayor(String inicio, String fin);
}
