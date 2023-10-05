package fmoues.edu.sv.sistemascontable.Controllers;

import com.google.gson.Gson;
import fmoues.edu.sv.sistemascontable.Repositorys.PartidasRepositorys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/libro-mayor")
public class LibroMayorController {
    @Autowired
    PartidasRepositorys repo;
    @Autowired
    Gson json;

    @GetMapping("/search/{inicio}/{fin}")
    public Object getLibroMayor(@PathVariable String inicio, @PathVariable String fin) {
        List<Object> el = repo.getDataLibroMayor(inicio, fin);
        return Map.of("success", true, "data", json.toJson(el));
    }
}
