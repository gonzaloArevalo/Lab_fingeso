package com.fingeso_grupo2.backend_fingeso.Service;

import com.fingeso_grupo2.backend_fingeso.Entity.Edificio;
import com.fingeso_grupo2.backend_fingeso.Entity.Residente;
import com.fingeso_grupo2.backend_fingeso.Entity.Departamento;
import com.fingeso_grupo2.backend_fingeso.Repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;
    private final ResidenteService residenteService;
    private final EdificioService edificioService;

    @Autowired
    public DepartamentoService(DepartamentoRepository departamentoRepository, ResidenteService residenteService, EdificioService edificioService) {
        this.departamentoRepository = departamentoRepository;
        this.residenteService = residenteService;
        this.edificioService = edificioService;
    }

    public Departamento addDepartamento(Boolean estacionamiento, Boolean bodega, long id_edificio, long id_residente) {
        Edificio edif = edificioService.getEdificioByID(id_edificio);
        Residente res = residenteService.getResidenteByID(id_residente);
        if (edif == null) {
            throw new RuntimeException("No se pudo encontrar el edificio con id: " + id_edificio);
        } else if(res == null){
                throw new RuntimeException("No se pudo encontrar al residente con id: " + id_residente);
        } else {
            Departamento departamento = new Departamento(estacionamiento, bodega, edif, res);
            return departamentoRepository.save(departamento);
        }
    }

    public Departamento getDepartamentoByID(long id) {
        return departamentoRepository.findById(id).orElse(null);
    }

    public List<Departamento> getAllDepartamentos() {
        return (List<Departamento>) departamentoRepository.findAll();
    }

    public boolean existsById(Long id) {
        return departamentoRepository.existsById(id);
    }
}
