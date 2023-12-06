package com.fingeso_grupo2.backend_fingeso.Service;

import com.fingeso_grupo2.backend_fingeso.Entity.Administrador;
import com.fingeso_grupo2.backend_fingeso.Repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService {
    @Autowired
    private AdministradorRepository administradorRepository;

    // REGISTRAR NUEVO ADMINISTRADOR
    public Administrador addAdmin(Integer rut,String nombre,String contrasenia,String correo) {
        Administrador admin = new Administrador(rut,nombre,contrasenia,correo);
        return administradorRepository.save(admin);
    }

    // OBTENER ADMINISTRADOR POR ID
    public Administrador getAdminByID(long id) {
        return administradorRepository.findById(id).orElse(null);
    }

    // OBTENER A TODOS LOS ADMINISTRADORES
    public List<Administrador> getAllAdmins() {
        return (List<Administrador>) administradorRepository.findAll();
    }
}
