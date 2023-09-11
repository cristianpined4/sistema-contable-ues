package fmoues.edu.sv.sistemascontable.Services;

import fmoues.edu.sv.sistemascontable.Models.DetallePartidas;
import fmoues.edu.sv.sistemascontable.Models.Partidas;
import fmoues.edu.sv.sistemascontable.Repositorys.DetallePartidasRepository;
import fmoues.edu.sv.sistemascontable.Repositorys.PartidasRepositorys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidasService {
    @Autowired
    private PartidasRepositorys repo;

    @Autowired
    private DetallePartidasRepository repoDetalle;

    public Partidas nuevaPartida(Partidas ob) {
        return repo.save(ob);
    }

    public List<Partidas> getAll() {
        return repo.findAll();
    }

    public Boolean removerOne(int id) {
        repo.deleteById(id);
        return !repo.existsById(id);
    }

    public Partidas getPartida(Integer id) {
        return repo.findOneById(id);
    }

    public DetallePartidas nuevoDetalle(DetallePartidas ob) {
        return repoDetalle.save(ob);
    }

    public List<DetallePartidas> getAllDetalle(Integer id) {
        return repoDetalle.getAllBySubcuenta(id);
    }
}
