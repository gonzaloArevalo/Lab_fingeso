package com.fingeso_grupo2.backend_fingeso.Controller;


import com.fingeso_grupo2.backend_fingeso.Entity.Personal;
import com.fingeso_grupo2.backend_fingeso.Service.EdificioService;
import com.fingeso_grupo2.backend_fingeso.Service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personal")
public class PersonalController {

    @Autowired
    PersonalService personalService;

    @Autowired
    EdificioService edificioService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Personal>> getPersonales() {
        List<Personal> personales = null;
        personales = personalService.getAllPersonales();
        return new ResponseEntity<List<Personal>>(personales, HttpStatus.OK);
    }

    @GetMapping("/findById/{id_personal}")
    public ResponseEntity<?> getPersonalById(@PathVariable("id_personal") long id_personal) {
        Personal personal = null;
        personal = personalService.getPersonalById(id_personal);
        if (personal == null) {
            return new ResponseEntity<String>("No se encontró el edificio con ID: " + id_personal, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Personal>(personal,HttpStatus.OK);
    }

    @GetMapping("/findByCorreo/{correo}")
    public ResponseEntity<?> getPersonalByCorreo(@PathVariable("correo") String correo) {
        Personal personal = personalService.getPersonalByCorreo(correo);
        if (personal == null) {
            return new ResponseEntity<>("No se encontró el administrador con correo: " + correo,HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Personal>(personal, HttpStatus.OK);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registrarEdificio(@RequestBody Personal personal) {
        Personal personal1 = null;
        Long idEdificio = personal.getEdificio().getId_edificio();
        if (!edificioService.existsById(idEdificio)) {
            return new ResponseEntity<String>("No se encontró el administrador con ID: " + idEdificio, HttpStatus.NOT_FOUND);
        }
        personal1 = personalService.personalAdd(personal.getRut(), personal.getNombre(), personal.getContrasenia(), personal.getCorreo(), personal.getSueldo(), personal.getEdificio().getId_edificio());
        return new ResponseEntity<Personal>(personal1,HttpStatus.OK);
    }
}
