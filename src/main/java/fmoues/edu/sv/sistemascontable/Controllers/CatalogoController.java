package fmoues.edu.sv.sistemascontable.Controllers;

import com.google.gson.Gson;
import fmoues.edu.sv.sistemascontable.Services.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/catalogo")
public class CatalogoController {

    @Autowired
    private CatalogoService misServicios;
    @Autowired
    private Gson gson;

    public CatalogoController() {
        this.misServicios = new CatalogoService();
    }

    @GetMapping("/subcuentas")
    public String getSubCuentas() {
        return gson.toJson(this.misServicios.getCatalogo());
    }

    @GetMapping("/cuentas/{id}")
    public ArrayList<String> getListadoCuentas(@PathVariable Integer id) {
        return this.misServicios.getListadoDeCuentaById(id);
    }
}
