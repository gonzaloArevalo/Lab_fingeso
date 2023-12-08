package com.fingeso_grupo2.backend_fingeso.Service;

import com.fingeso_grupo2.backend_fingeso.Entity.Administrador;
import com.fingeso_grupo2.backend_fingeso.Entity.SesionUsuario;
import com.fingeso_grupo2.backend_fingeso.Repository.SesionUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SesionUsuarioService {
    private final SesionUsuarioRepository sesionUsuarioRepository;
    private final AdministradorService administradorService;

    @Autowired
    public SesionUsuarioService(SesionUsuarioRepository sesionUsuarioRepository, AdministradorService administradorService) {
        this.sesionUsuarioRepository = sesionUsuarioRepository;
        this.administradorService = administradorService;
    }

    //private final ResidenteService residenteService;
    //private final PersonalService personalService;
    //private final SubadministradorService subadministradorService;


    // REGISTRAR NUEVA SESION
    public SesionUsuario addSesion(String correo,String contrasenia) {
        Administrador admin = administradorService.getAdminByCorreo(correo);
        if (admin != null) {
            if (contrasenia.equals(admin.getContrasenia())) {
                SesionUsuario su = new SesionUsuario(admin,null,null,null);
                return sesionUsuarioRepository.save(su);
            }
        }
        /*
        Subdministrador subadmin = subadministradorService.getSubadminByCorreo(correo);
        if (subadmin != null) {
            SesionUsuario su = new SesionUsuario(null,subadmin,null,null);
            return sesionUsuarioRepository.save(su);
        }
        Residente residente = residenteService.getResidenteByCorreo(correo);
        if (residente != null) {
            SesionUsuario su = new SesionUsuario(null,null,residente,null);
            return sesionUsuarioRepository.save(su);
        }
        Personal personal = personalService.getPersonalByCorreo(correo);
        if (personal != null) {
            SesionUsuario su = new SesionUsuario(null,null,null,personal);
            return sesionUsuarioRepository.save(su);
        }
        */
        return null;
    }

    // OBTENER TODAS LAS SESIONES
    public List<SesionUsuario> getAllSesiones() {
        return (List<SesionUsuario>) sesionUsuarioRepository.findAll();
    }
}
