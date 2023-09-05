package fmoues.edu.sv.sistemascontable.Controllers;

import fmoues.edu.sv.sistemascontable.Services.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/catalogo")
public class CatalogoController {

    @Autowired
    private CatalogoService misServicios;

    public CatalogoController() {
        this.misServicios = new CatalogoService();
    }

    @GetMapping("/cuentas/{id}")
    public ArrayList<String> getListadoCuentas(@PathVariable Integer id) {
        return this.misServicios.getListadoDeCuentaById(id);
    }
}
