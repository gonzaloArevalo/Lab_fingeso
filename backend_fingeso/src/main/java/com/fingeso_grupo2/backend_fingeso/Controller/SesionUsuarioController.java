package com.fingeso_grupo2.backend_fingeso.Controller;

import com.fingeso_grupo2.backend_fingeso.Entity.SesionUsuario;
import com.fingeso_grupo2.backend_fingeso.Service.SesionUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sesion")
public class SesionUsuarioController {
    @Autowired
    private SesionUsuarioService sesionUsuarioService;

    @PostMapping("/login/{correo}/{contrasenia}")
    public ResponseEntity<?> login(@PathVariable String correo,@PathVariable String contrasenia) {
        SesionUsuario sesionUsuario = sesionUsuarioService.addSesion(correo,contrasenia);
        if (sesionUsuario != null) {
            return new ResponseEntity<SesionUsuario>(sesionUsuario,HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Correo inválido o contrasenia inválida.",HttpStatus.NOT_FOUND);
        }
    }
}