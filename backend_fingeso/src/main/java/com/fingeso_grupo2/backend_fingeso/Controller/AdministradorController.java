package com.fingeso_grupo2.backend_fingeso.Controller;

import com.fingeso_grupo2.backend_fingeso.Entity.Administrador;
import com.fingeso_grupo2.backend_fingeso.Service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdministradorController {
    @Autowired
    private AdministradorService administradorService;


    @GetMapping("/getAll")
    public ResponseEntity<List<Administrador>> getAdmins() {
        List<Administrador> admins = null;
        admins =administradorService.getAllAdmins();
        return new ResponseEntity<List<Administrador>>(admins,HttpStatus.OK);
    }


    /*
    @GetMapping("/getAll")
    public List<Administrador> getAdmins() {
        return administradorService.getAllAdmins();
    }
    */


    @GetMapping("/findByID/{id_admin}")
    public ResponseEntity<?> getAdministradorById(@PathVariable("id_admin") long id_admin) {
        Administrador admin = null;
        admin = administradorService.getAdminByID(id_admin);
        if (admin == null) {
            return new ResponseEntity<String>("No se encontró el administrador con ID: " + id_admin,HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Administrador>(admin,HttpStatus.OK);
        }
    }

    @GetMapping("/findByCorreo/{correo}")
    public ResponseEntity<?> getAdminByCorreo(@PathVariable("correo") String correo) {
        Administrador admin = administradorService.getAdminByCorreo(correo);
        if (admin == null) {
            return new ResponseEntity<>("No se encontró el administrador con correo: " + correo,HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Administrador>(admin,HttpStatus.OK);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registrarAdmin(@RequestBody Administrador administrador) {
        Administrador admin,adminAux = null;
        // REVISA SI YA EXISTE UN ADMIN CON EL MISMO CORREO
        adminAux = administradorService.getAdminByCorreo(administrador.getCorreo());
        if (adminAux != null) {
            return new ResponseEntity<String>("Ya existe una cuenta con el correo: " + administrador.getCorreo(),HttpStatus.NOT_FOUND);
        } else {
            admin = administradorService.addAdmin(administrador.getRut(),administrador.getNombre(),administrador.getContrasenia(),administrador.getCorreo());
            return new ResponseEntity<Administrador>(admin,HttpStatus.OK);
        }
    }





}
