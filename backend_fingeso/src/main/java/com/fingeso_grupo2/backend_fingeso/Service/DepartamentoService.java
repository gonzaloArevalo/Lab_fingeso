package com.fingeso_grupo2.backend_fingeso.Service;

import com.fingeso_grupo2.backend_fingeso.Entity.Edificio;
import com.fingeso_grupo2.backend_fingeso.Entity.Residente;
import com.fingeso_grupo2.backend_fingeso.Entity.Departamento;
import com.fingeso_grupo2.backend_fingeso.Repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    // AÑADE UN DEPARTAMENTO
    public Departamento addDepartamento(Float departamento_m2, Float estacionamiento_m2, Float bodega_m2, long id_edificio, long id_residente) {
        Edificio edif = edificioService.getEdificioByID(id_edificio);
        Residente res = residenteService.getResidenteByID(id_residente);
        if (edif == null) {
            throw new RuntimeException("No se pudo encontrar el edificio con id: " + id_edificio);
        } else if(res == null){
                throw new RuntimeException("No se pudo encontrar al residente con id: " + id_residente);
        } else {
            Departamento departamento = new Departamento(departamento_m2, estacionamiento_m2,bodega_m2, edif, res);
            return departamentoRepository.save(departamento);
        }
    }

    // OBTIENE UN DEPARTAMENTO SEGUN SU ID
    public Departamento getDepartamentoByID(long id) {
        return departamentoRepository.findById(id).orElse(null);
    }

    // OBTIENE TODOS LOS DEPARTAMENTOS
    public List<Departamento> getAllDepartamentos() {
        return (List<Departamento>) departamentoRepository.findAll();
    }

    // VERIFICA SI UN DEPARTAMENTO EXISTE SEGUN SU ID
    public boolean existsById(Long id) {
        return departamentoRepository.existsById(id);
    }

    // OBTIENE TODOS LOS DEPARTAMENTOS DE UN EDIFICIO SEGUN UN ID
    public List<Departamento> getAllDeptOfBuilding(long id_edificio) {
        Edificio edif = edificioService.getEdificioByID(id_edificio);
        if (edif != null) {
            List<Departamento> depts = getAllDepartamentos();
            List<Departamento> salida = new ArrayList<>();
            for (int i = 0;i < depts.size();i++) {
                if (depts.get(i).getEdificio().getId_edificio() == id_edificio) {
                    salida.add(depts.get(i));
                }
            }
            if (!salida.isEmpty()) {
                return salida;
            } else {
                return null;
            }
        } else {
            throw new RuntimeException("No se pudo encontrar al edificio con id: " + id_edificio);
        }
    }

    // OBTIENE EL TOTAL DE M2 OCUPADOS POR EL DEPARTAMENTO
    public Float getTotalM2(long id) {
        Departamento dept = getDepartamentoByID(id);
        Float totalM2 = dept.getDepartamento_m2() + dept.getEstacionamiento_m2() + dept.getBodega_m2();
        return totalM2;
    }
}
