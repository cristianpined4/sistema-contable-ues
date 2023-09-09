package fmoues.edu.sv.sistemascontable.Services;

import fmoues.edu.sv.sistemascontable.Models.Partidas;
import fmoues.edu.sv.sistemascontable.Repositorys.PartidasRepositorys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidasService {
    @Autowired
    private PartidasRepositorys repo;

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
}
