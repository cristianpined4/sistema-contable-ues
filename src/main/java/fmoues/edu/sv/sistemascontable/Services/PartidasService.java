package fmoues.edu.sv.sistemascontable.Services;

import fmoues.edu.sv.sistemascontable.Models.DetallePartidas;
import fmoues.edu.sv.sistemascontable.Models.Partidas;
import fmoues.edu.sv.sistemascontable.Repositorys.DetallePartidasRepository;
import fmoues.edu.sv.sistemascontable.Repositorys.PartidasRepositorys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
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
        boolean res = false;
        try{
            repo.deleteById(id);
            repoDetalle.removerAllDetalle(id);
            res = true;
        }catch (Exception error){
            res = false;
        }
        return !repo.existsById(id) && !res;
    }

    public Partidas getPartida(Integer id) {
        return repo.findOneById(id);
    }

    public DetallePartidas nuevoDetalle(DetallePartidas ob) {
        return repoDetalle.save(ob);
    }

    public DetallePartidas updateDetalle(DetallePartidas ob, Integer id){
        DetallePartidas edit = repoDetalle.getReferenceById(id);
        edit.setFecha(ob.getFecha());
        edit.setFk_subcuentas(ob.getFk_subcuentas());
        edit.setDescripcion(ob.getDescripcion());
        edit.setTipo(ob.getTipo());
        edit.setMonto(ob.getMonto());
        return  repoDetalle.save(edit);
    }

    public Boolean removerDetalleOne(Integer id) {
        repoDetalle.deleteById(id);
        return !repoDetalle.existsById(id);
    }

    public Boolean removerDetalleAll(Integer ids) {
        boolean res = false;
        try{
            repoDetalle.removerAllDetalle(ids);
        }catch (Throwable error){
            res = true;
        }
        return res;
    }

    public List<DetallePartidas> getAllDetalle(Integer id) {
        return repoDetalle.getAllBySubcuenta(id);
    }
}
