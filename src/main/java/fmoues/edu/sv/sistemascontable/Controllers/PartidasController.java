package fmoues.edu.sv.sistemascontable.Controllers;

import com.google.gson.Gson;
import fmoues.edu.sv.sistemascontable.Models.Partidas;
import fmoues.edu.sv.sistemascontable.Services.PartidasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/partidas")
public class PartidasController {
    @Autowired
    private PartidasService pa;

    @Autowired
    private Gson gson;

    @GetMapping("/")
    public Object getAll() {
        return Map.of("success", true, "data", gson.toJson(pa.getAll()));
    }

    @PostMapping("/new")
    public Object newPartida(@RequestBody String ob) {
        Partidas nueva = gson.fromJson(ob, Partidas.class);
        nueva = pa.nuevaPartida(nueva);
        return Map.of("success", nueva != null, "data", gson.toJson(nueva));
    }

    @DeleteMapping("/delete")
    public Object removePartida(@RequestBody String id) {
        boolean res = pa.removerOne(Integer.parseInt(id));
        return Map.of("success", res, "data", id);
    }
}
