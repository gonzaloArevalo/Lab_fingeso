package com.fingeso_grupo2.backend_fingeso.Service;

import com.fingeso_grupo2.backend_fingeso.Entity.Administrador;
import com.fingeso_grupo2.backend_fingeso.Entity.Edificio;
import com.fingeso_grupo2.backend_fingeso.Repository.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService {

    private final EdificioRepository edificioRepository;
    private final AdministradorService administradorService;

    @Autowired
    public EdificioService(EdificioRepository edificioRepository,AdministradorService administradorService) {
        this.edificioRepository = edificioRepository;
        this.administradorService = administradorService;
    }

    // ANIADIR OTRO EDIFICIO A LA BASE DE DATOS
    public Edificio addEdificio(Integer departamentosTotales,Integer departamentosOcupados,long id_admin) {
        Administrador admin = administradorService.getAdminByID(id_admin);
        if (admin == null) {
            throw new RuntimeException("No se pudo encontrar al administrador con id: " + id_admin);
        } else {
            Edificio edificio = new Edificio(departamentosTotales,departamentosOcupados,admin);
            return edificioRepository.save(edificio);
        }
    }

    // OBTENER EDIFICIO POR ID
    public Edificio getEdificioByID(long id) {
        return edificioRepository.findById(id).orElse(null);
    }

    // OBTENER A TODOS LOS EDIFICIOS
    public List<Edificio> getAllEdificios() {
        return (List<Edificio>) edificioRepository.findAll();
    }
}
