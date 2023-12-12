package com.fingeso_grupo2.backend_fingeso.Service;

import com.fingeso_grupo2.backend_fingeso.Entity.Residente;
import com.fingeso_grupo2.backend_fingeso.Repository.ResidenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidenteService {

    @Autowired
    private ResidenteRepository residenteRepository;

    public Residente residenteAdd(Integer rut, String nombre, String contrasenia, String correo){
        Residente residente = new Residente(rut,nombre,contrasenia,correo);
        return residenteRepository.save(residente);
    }

    // OBTIENE UN USUARIO RESIDENTE POR SU ID
    public Residente getResidenteByID(long id){
        return residenteRepository.findById(id).orElse(null);
    }

    // OBTIENE A TODOS LOS USUARIOS RESIDENTE
    public List<Residente> getAllResidentes(){
        return (List<Residente>) residenteRepository.findAll();
    }

    // OBTIENE UN USUARIO RESIDENTE POR SU CORREO
    public Residente getResidenteByCorreo(String correo) {
        return residenteRepository.findByCorreo(correo).orElse(null);
    }

    // VERIFICA SI EXISTE UN USUARIO RESIDENTE SEGUN SU CORREO
    public boolean existsById(Long id) {
        return residenteRepository.existsById(id);
    }
}
