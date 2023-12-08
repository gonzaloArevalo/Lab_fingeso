package com.fingeso_grupo2.backend_fingeso.Controller;

import com.fingeso_grupo2.backend_fingeso.Entity.Departamento;
import com.fingeso_grupo2.backend_fingeso.Service.DepartamentoService;
import com.fingeso_grupo2.backend_fingeso.Service.EdificioService;
import com.fingeso_grupo2.backend_fingeso.Service.ResidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;
    @Autowired
    private EdificioService edificioService;
    @Autowired
    private ResidenteService residenteService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Departamento>> getDepartamentos() {
        List<Departamento> departamentos = null;
        departamentos = departamentoService.getAllDepartamentos();
        return new ResponseEntity<List<Departamento>>(departamentos, HttpStatus.OK);
    }

    @GetMapping("/findByID/{id_departamento}")
    public ResponseEntity<?> getDepartamentoById(@PathVariable("id_departamento") long id_departamento) {
        Departamento departamento = null;
        departamento = departamentoService.getDepartamentoByID(id_departamento);
        if (departamento == null) {
            return new ResponseEntity<String>("No se encontró el departamento con ID: " + id_departamento, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Departamento>(departamento, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registrarDepartamento(@RequestBody Departamento departamento) {
        Departamento departamento1 = null;
        Long idEdificio = departamento.getEdificio().getId_edificio();
        Long idResidente = departamento.getResidente().getId_residente();
        if (!edificioService.existsById(idEdificio)) {
            return new ResponseEntity<String>("No se encontró el edificio con ID: " + idEdificio, HttpStatus.NOT_FOUND);
        } else if(!residenteService.existsById(idResidente)){
            return new ResponseEntity<String>("No se encontró al residente con ID: " + idResidente, HttpStatus.NOT_FOUND);
        }
        departamento1 = departamentoService.addDepartamento(departamento.getEstacionamiento(), departamento.getBodega(), departamento.getEdificio().getId_edificio(), departamento.getResidente().getId_residente());
        return new ResponseEntity<Departamento>(departamento1, HttpStatus.OK);
    }
}
