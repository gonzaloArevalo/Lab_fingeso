package com.fingeso_grupo2.backend_fingeso.Service;

import com.fingeso_grupo2.backend_fingeso.Entity.Personal;
import com.fingeso_grupo2.backend_fingeso.Entity.Edificio;
import com.fingeso_grupo2.backend_fingeso.Repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalService {

    private final PersonalRepository personalRepository;
    private final EdificioService edificioService;

    @Autowired
    public PersonalService(PersonalRepository personalRepository, EdificioService edificioService){
        this.personalRepository = personalRepository;
        this.edificioService = edificioService;
    }

    public Personal personalAdd(Integer rut, String nombre, String contrasenia, String correo, Integer sueldo, long id_edificio){
        Edificio edificio = edificioService.getEdificioByID(id_edificio);
        if (edificio == null) {
            throw new RuntimeException("No se pudo encontrar al administrador con id: " + id_edificio);
        } else {
            Personal personal = new Personal(rut, nombre, contrasenia, correo, sueldo, edificio);
            return personalRepository.save(personal);
        }
    }

    public Personal getPersonalById(long id){
        return personalRepository.findById(id).orElse(null);
    }

    public Personal getPersonalByCorreo(String correo){
        return personalRepository.findByCorreo(correo).orElse(null);
    }

    public List<Personal> getAllPersonales() {
        return (List<Personal>) personalRepository.findAll();
    }
}
