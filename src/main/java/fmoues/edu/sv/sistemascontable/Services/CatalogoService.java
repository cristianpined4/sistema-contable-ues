package fmoues.edu.sv.sistemascontable.Services;

import fmoues.edu.sv.sistemascontable.Models.Cuentas;
import fmoues.edu.sv.sistemascontable.Models.CuentasMayores;
import fmoues.edu.sv.sistemascontable.Models.Rubros;
import fmoues.edu.sv.sistemascontable.Models.SubCuentas;
import fmoues.edu.sv.sistemascontable.Repositorys.CuentasMayoresRepository;
import fmoues.edu.sv.sistemascontable.Repositorys.CuentasRepository;
import fmoues.edu.sv.sistemascontable.Repositorys.RubrosRepository;
import fmoues.edu.sv.sistemascontable.Repositorys.SubcuentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogoService {
    @Autowired
    private SubcuentasRepository subcuentasRepository;
    @Autowired
    private CuentasRepository cuentasRepository;
    @Autowired
    private CuentasMayoresRepository cuentasMayoresRepository;
    @Autowired
    private RubrosRepository rubrosRepository;

    public SubCuentas save(SubCuentas objeto) {
        return subcuentasRepository.save(objeto);
    }

    public List<SubCuentas> getCatalogo() {
        return subcuentasRepository.findAll();
    }

    public Cuentas getCuentaById(Integer id) {
        return cuentasRepository.getById(id);
    }

    public CuentasMayores getCuentaMayorById(Integer id) {
        return cuentasMayoresRepository.getById(id);
    }

    public Rubros getRubroById(Integer id) {
        return rubrosRepository.getById(id);
    }

    public ArrayList<String> getListadoDeCuentaById(Integer id) {
        ArrayList<String> listado = new ArrayList<String>();
        SubCuentas subCuenta = subcuentasRepository.getById(id);
        Cuentas cuenta = getCuentaById(subCuenta.getFk_cuentas());
        CuentasMayores cuentaMayor = getCuentaMayorById(cuenta.getFk_cuentasMayores());
        Rubros rubro = getRubroById(cuentaMayor.getFk_rubro());

        listado.add(rubro.getNombre_rubro());
        listado.add(cuentaMayor.getNombre_cuentas_mayores());
        listado.add(cuenta.getNombre_cuentas());
        listado.add(subCuenta.getNombre_subcuentas());
        return listado;
    }
}
