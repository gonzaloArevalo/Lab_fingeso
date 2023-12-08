package com.fingeso_grupo2.backend_fingeso.Controller;

import com.fingeso_grupo2.backend_fingeso.Entity.Edificio;
import com.fingeso_grupo2.backend_fingeso.Service.AdministradorService;
import com.fingeso_grupo2.backend_fingeso.Service.EdificioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/edificio")
public class EdificioController {
    @Autowired
    private EdificioService edificioService;
    @Autowired
    private AdministradorService administradorService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Edificio>> getEdificios() {
        List<Edificio> edificios = null;
        edificios = edificioService.getAllEdificios();
        return new ResponseEntity<List<Edificio>>(edificios, HttpStatus.OK);
    }

    @GetMapping("/findByID/{id_edificio}")
    public ResponseEntity<?> getEdificioById(@PathVariable("id_edificio") long id_edificio) {
        Edificio edificio = null;
        edificio = edificioService.getEdificioByID(id_edificio);
        if (edificio == null) {
            return new ResponseEntity<String>("No se encontró el edificio con ID: " + id_edificio, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Edificio>(edificio,HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registrarEdificio(@RequestBody Edificio edificio) {
        Edificio edificio1 = null;
        Long idAdmin = edificio.getAdministrador().getId_admin();
        if (!administradorService.existsById(idAdmin)) {
            return new ResponseEntity<String>("No se encontró el administrador con ID: " + idAdmin, HttpStatus.NOT_FOUND);
        }
        edificio1 = edificioService.addEdificio(edificio.getDepartamentosTotales(),edificio.getDepartamentosOcupados(),edificio.getAdministrador().getId_admin());
        return new ResponseEntity<Edificio>(edificio1,HttpStatus.OK);
    }
}
