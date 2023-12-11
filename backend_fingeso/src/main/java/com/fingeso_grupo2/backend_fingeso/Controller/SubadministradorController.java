package com.fingeso_grupo2.backend_fingeso.Controller;

import com.fingeso_grupo2.backend_fingeso.Entity.Residente;
import com.fingeso_grupo2.backend_fingeso.Entity.Subadministrador;
import com.fingeso_grupo2.backend_fingeso.Service.EdificioService;
import com.fingeso_grupo2.backend_fingeso.Service.SubadministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subadmin")
public class SubadministradorController {

    @Autowired
    private SubadministradorService subadministradorService;
    @Autowired
    private EdificioService edificioService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Subadministrador>> getSubadministradores() {
        List<Subadministrador> subadministradores = null;
        subadministradores = subadministradorService.getAllSubadministradores();
        return new ResponseEntity<List<Subadministrador>>(subadministradores, HttpStatus.OK);
    }

    @GetMapping("/findByID/{id_subadministrador}")
    public ResponseEntity<?> getSubadministradorById(@PathVariable("id_subadministrador") long id_subadministrador) {
        Subadministrador subadministrador = null;
        subadministrador = subadministradorService.getSubadministradorByID(id_subadministrador);
        if (subadministrador == null) {
            return new ResponseEntity<String>("No se encontró al subadministrador con ID: " + id_subadministrador, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Subadministrador>(subadministrador, HttpStatus.OK);
    }

    @GetMapping("/login/{correo}/{contrasenia}")
    public ResponseEntity<?> loginSubadmin(@PathVariable("correo") String correo,
                                            @PathVariable("contrasenia") String contrasenia) {
        Subadministrador subadmin = subadministradorService.getSubadministradorByCorreo(correo);
        if (subadmin != null) {
            if (subadmin.getContrasenia().equals(contrasenia)) {
                return new ResponseEntity<Subadministrador>(subadmin,HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("Correo o contrasenia invalidos.",HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<String>("Correo o contrasenia invalidos.",HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registrarSubadministrador(@RequestBody Subadministrador subadministrador) {
        Subadministrador subadministrador1 = null;
        Long idEdificio = subadministrador.getEdificio().getId_edificio();
        if (!edificioService.existsById(idEdificio)) {
            return new ResponseEntity<String>("No se encontró el edificio con ID: " + idEdificio, HttpStatus.NOT_FOUND);
        }
        subadministrador1 = subadministradorService.addSubadministrador(subadministrador.getRut(), subadministrador.getNombre(), subadministrador.getContrasenia(), subadministrador.getCorreo(), subadministrador.getEdificio().getId_edificio());
        return new ResponseEntity<Subadministrador>(subadministrador1, HttpStatus.OK);
    }
}
