package com.fingeso_grupo2.backend_fingeso.Controller;


import com.fingeso_grupo2.backend_fingeso.Entity.Deuda;
import com.fingeso_grupo2.backend_fingeso.Service.DeudaService;
import com.fingeso_grupo2.backend_fingeso.Service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deuda")
public class DeudaController {

    @Autowired
    private DeudaService deudaService;
    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Deuda>> getDeudas() {
        List<Deuda> deudas = null;
        deudas = deudaService.getAllDeudas();
        return new ResponseEntity<List<Deuda>>(deudas, HttpStatus.OK);
    }

    @GetMapping("/findByID/{id_deuda}")
    public ResponseEntity<?> getDeudaById(@PathVariable("id_deuda") long id_deuda) {
        Deuda deuda = null;
        deuda = deudaService.getDeudaById(id_deuda);
        if (deuda == null) {
            return new ResponseEntity<String>("No se encontró la deuda con ID: " + id_deuda, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Deuda>(deuda, HttpStatus.OK);
    }

    @GetMapping("/deudasPorResidente/{id_residente}")
    public ResponseEntity<List<Deuda>> getDeudasPorIdResidente(@PathVariable("id_residente") long id_residente) {
        List<Deuda> deudas = deudaService.getAllDeudasOfDept(id_residente);
        return new ResponseEntity<List<Deuda>>(deudas,HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registrarDeuda(@RequestBody Deuda deuda) {
        Deuda deuda1 = null;
        Long idDep = deuda.getDepartamento().getId_departamento();
        if (!departamentoService.existsById(idDep)) {
            return new ResponseEntity<String>("No se encontró el administrador con ID: " + idDep, HttpStatus.NOT_FOUND);
        }
        deuda1 = deudaService.addDeuda(deuda.getDescripcion_deuda(), deuda.getMonto(), deuda.getDepartamento().getId_departamento());
        return new ResponseEntity<Deuda>(deuda1,HttpStatus.OK);
    }
}
