package com.fingeso_grupo2.backend_fingeso.Service;

import com.fingeso_grupo2.backend_fingeso.Entity.Administrador;
import com.fingeso_grupo2.backend_fingeso.Entity.Subadministrador;
import com.fingeso_grupo2.backend_fingeso.Entity.Edificio;
import com.fingeso_grupo2.backend_fingeso.Repository.SubadministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubadministradorService {

    private SubadministradorRepository subadministradorRepository;
    private EdificioService edificioService;

    @Autowired
    public SubadministradorService(SubadministradorRepository subadministradorRepository, EdificioService edificioService){
        this.subadministradorRepository = subadministradorRepository;
        this.edificioService = edificioService;
    }

    public Subadministrador addSubadministrador(Integer rut, String nombre, String contrasenia, String correo, long id_edificio) {
        Edificio edificio = edificioService.getEdificioByID(id_edificio);
        if (edificio == null) {
            throw new RuntimeException("No se pudo encontrar el edificio con id: " + id_edificio);
        } else {
            Subadministrador subadministrador = new Subadministrador(rut, nombre, contrasenia, correo, edificio);
            return subadministradorRepository.save(subadministrador);
        }
    }

    public Subadministrador getSubadministradorByID(long id) {
        return subadministradorRepository.findById(id).orElse(null);
    }

    public Subadministrador getSubadministradorByCorreo(String correo) {
        return subadministradorRepository.findByCorreo(correo).orElse(null);
    }

    public List<Subadministrador> getAllSubadministradores() {
        return (List<Subadministrador>) subadministradorRepository.findAll();
    }

    public boolean existsById(Long id) {
        return subadministradorRepository.existsById(id);
    }
}
