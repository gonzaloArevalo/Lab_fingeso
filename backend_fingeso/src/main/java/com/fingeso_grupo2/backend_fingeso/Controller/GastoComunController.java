package com.fingeso_grupo2.backend_fingeso.Controller;

import com.fingeso_grupo2.backend_fingeso.Entity.GastoComun;
import com.fingeso_grupo2.backend_fingeso.Service.GastoComunService;
import com.fingeso_grupo2.backend_fingeso.Service.EdificioService;
import com.fingeso_grupo2.backend_fingeso.Service.SubadministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gastoComun")
public class GastoComunController {

    @Autowired
    private GastoComunService gastoComunService;
    @Autowired
    private EdificioService edificioService;
    @Autowired
    private SubadministradorService subadministradorService;

    public ResponseEntity<List<GastoComun>> getGastosComunes() {
        List<GastoComun> gastosComunes = null;
        gastosComunes = gastoComunService.getAllGastosComunes();
        return new ResponseEntity<List<GastoComun>>(gastosComunes, HttpStatus.OK);
    }

    @GetMapping("/findByID/{id_gastoComun}")
    public ResponseEntity<?> getGastoComunById(@PathVariable("id_gastoComun") long id_gastoComun) {
        GastoComun gastoComun = null;
        gastoComun = gastoComunService.getGastoComunById(id_gastoComun);
        if (gastoComun == null) {
            return new ResponseEntity<String>("No se encontró el gasto común con ID: " + id_gastoComun, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<GastoComun>(gastoComun, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registrarGastoComun(@RequestBody GastoComun gastoComun) {
        GastoComun gastoComun1 = null;
        Long idEdificio = gastoComun.getEdificio().getId_edificio();
        Long idSubadmin = gastoComun.getSubadministrador().getId_subadmin();
        if (!edificioService.existsById(idEdificio)) {
            return new ResponseEntity<String>("No se encontró el edificio con ID: " + idEdificio, HttpStatus.NOT_FOUND);
        } else if(!subadministradorService.existsById(idSubadmin)){
            return new ResponseEntity<String>("No se encontró al subadministrador con ID: " + idSubadmin, HttpStatus.NOT_FOUND);
        }
        gastoComun1 = gastoComunService.addGastoComun(gastoComun.getDescripcion(), gastoComun.getMonto(), gastoComun.getFecha(), gastoComun.getEdificio().getId_edificio(), gastoComun.getSubadministrador().getId_subadmin());
        return new ResponseEntity<GastoComun>(gastoComun1, HttpStatus.OK);
    }
}
