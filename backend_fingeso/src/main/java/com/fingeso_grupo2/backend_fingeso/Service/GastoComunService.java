package com.fingeso_grupo2.backend_fingeso.Service;

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

    @Autowired
    public GastoComunService(GastoComunRepository gastoComunRepository, EdificioService edificioService, SubadministradorService subadministradorService){
        this.gastoComunRepository = gastoComunRepository;
        this.edificioService = edificioService;
        this.subadministradorService = subadministradorService;
    }

    public GastoComun addGastoComun(String descripcion, Integer monto, Date fecha, long id_edificio, long id_subadministrador) {
        Edificio edif = edificioService.getEdificioByID(id_edificio);
        Subadministrador sub = subadministradorService.getSubadministradorByID(id_subadministrador);
        if (edif == null) {
            throw new RuntimeException("No se pudo encontrar el edificio con id: " + id_edificio);
        } else if(sub == null){
            throw new RuntimeException("No se pudo encontrar al subadministrador con id: " + id_subadministrador);
        } else {
            GastoComun gastoComun = new GastoComun(descripcion, monto, fecha, edif, sub);
            return gastoComunRepository.save(gastoComun);
        }
    }

    public GastoComun getGastoComunById(long id) {
        return gastoComunRepository.findById(id).orElse(null);
    }

    public List<GastoComun> getAllGastosComunes() {
        return (List<GastoComun>) gastoComunRepository.findAll();
    }

    public boolean existsById(Long id) {
        return gastoComunRepository.existsById(id);
    }
}
