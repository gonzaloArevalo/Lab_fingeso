package com.fingeso_grupo2.backend_fingeso.Controller;

import com.fingeso_grupo2.backend_fingeso.Entity.Residente;
import com.fingeso_grupo2.backend_fingeso.Service.ResidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/residente")
public class ResidenteController {

    @Autowired
    private ResidenteService residenteService;

    @GetMapping("/login/{correo}/{contrasenia}")
    public ResponseEntity<?> loginResidente(@PathVariable("correo") String correo,
                                        @PathVariable("contrasenia") String contrasenia) {
        Residente residente = residenteService.getResidenteByCorreo(correo);
        if (residente != null) {
            if (residente.getContrasenia().equals(contrasenia)) {
                return new ResponseEntity<Residente>(residente,HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("Correo o contrasenia invalidos.",HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<String>("Correo o contrasenia invalidos.",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Residente>> getResidentes() {
        List<Residente> residentes;
        residentes = residenteService.getAllResidentes();
        return new ResponseEntity<List<Residente>>(residentes,HttpStatus.OK);
    }

    @GetMapping("/findByID/{id_residente}")
    public ResponseEntity<?> getResidenteById(@PathVariable("id_residente") long id_residente) {
        Residente residente = null;
        residente = residenteService.getResidenteByID(id_residente);
        if (residente == null) {
            return new ResponseEntity<String>("No se encontró al residente con ID: " + id_residente, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Residente>(residente, HttpStatus.OK);
        }
    }

    @GetMapping("/findByCorreo/{correo}")
    public ResponseEntity<?> getResidenteByCorreo(@PathVariable("correo") String correo) {
        Residente residente = residenteService.getResidenteByCorreo(correo);
        if (residente == null) {
            return new ResponseEntity<>("No se encontró al residente con correo: " + correo, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Residente>(residente, HttpStatus.OK);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registrarResidente(@RequestBody Residente residente) {
        Residente res, residenteAux = null;
        residenteAux = residenteService.getResidenteByCorreo(residente.getCorreo());
        if (residenteAux != null) {
            return new ResponseEntity<String>("Ya existe una cuenta con el correo: " + residente.getCorreo(), HttpStatus.NOT_FOUND);
        } else {
            res = residenteService.residenteAdd(residente.getRut(), residente.getNombre(), residente.getContrasenia(), residente.getCorreo());
            return new ResponseEntity<Residente>(res, HttpStatus.OK);
        }
    }
}
