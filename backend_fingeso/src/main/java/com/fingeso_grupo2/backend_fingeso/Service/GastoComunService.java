package com.fingeso_grupo2.backend_fingeso.Service;

import com.fingeso_grupo2.backend_fingeso.Entity.Departamento;
import com.fingeso_grupo2.backend_fingeso.Entity.GastoComun;
import com.fingeso_grupo2.backend_fingeso.Entity.Subadministrador;
import com.fingeso_grupo2.backend_fingeso.Entity.Edificio;
import com.fingeso_grupo2.backend_fingeso.Repository.GastoComunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GastoComunService {

    private final GastoComunRepository gastoComunRepository;
    private final EdificioService edificioService;
    private final SubadministradorService subadministradorService;
    private final DepartamentoService departamentoService;
    private final DeudaService deudaService;

    @Autowired
    public GastoComunService(DeudaService deudaService,GastoComunRepository gastoComunRepository, EdificioService edificioService, SubadministradorService subadministradorService, DepartamentoService departamentoService){
        this.gastoComunRepository = gastoComunRepository;
        this.edificioService = edificioService;
        this.subadministradorService = subadministradorService;
        this.departamentoService = departamentoService;
        this.deudaService = deudaService;
    }

    // AÑADE UN GASTO COMUN
    public GastoComun addGastoComun(String descripcion, Integer monto, long id_edificio, long id_subadministrador) {
        Edificio edif = edificioService.getEdificioByID(id_edificio);
        Subadministrador sub = subadministradorService.getSubadministradorByID(id_subadministrador);
        if (edif == null) {
            throw new RuntimeException("No se pudo encontrar el edificio con id: " + id_edificio);
        } else if(sub == null){
            throw new RuntimeException("No se pudo encontrar al subadministrador con id: " + id_subadministrador);
        } else {
            GastoComun gastoComun = new GastoComun(descripcion, monto, edif, sub);
            return gastoComunRepository.save(gastoComun);
        }
    }

    // AÑADE UN GASTO COMUN POR UN ADMIN
    public GastoComun addGastoComunByAdmin(String descripcion, Integer monto, long id_edificio) {
        Edificio edif = edificioService.getEdificioByID(id_edificio);
        if (edif == null) {
            throw new RuntimeException("No se pudo encontrar el edificio con id: " + id_edificio);
        } else {
            GastoComun gastoComun = new GastoComun(descripcion, monto, edif, null);
            List<Departamento> depts = departamentoService.getAllDeptOfBuilding(id_edificio);
            Float totalM2 = edificioService.getM2FromBuilding(id_edificio);
            for (int i = 0;i < depts.size();i++) {
                Float deptM2 = departamentoService.getTotalM2(depts.get(i).getId_departamento());
                Float porcentaje = deptM2/totalM2;
                Integer monto2 = (int) (porcentaje*monto);
                deudaService.addDeuda(descripcion,monto2,depts.get(i).getId_departamento());
            }
            return gastoComunRepository.save(gastoComun);
        }
    }

    // OBTIENE UN GASTOCOMUN POR SU ID
    public GastoComun getGastoComunById(long id) {
        return gastoComunRepository.findById(id).orElse(null);
    }

    // OBTIENE TODOS LOS GASTOSCOMUNES
    public List<GastoComun> getAllGastosComunes() {
        return (List<GastoComun>) gastoComunRepository.findAll();
    }

    // VERIFICA SI EXISTE UN GASTOCOMUN SEGUN SU ID
    public boolean existsById(Long id) {
        return gastoComunRepository.existsById(id);
    }
}
