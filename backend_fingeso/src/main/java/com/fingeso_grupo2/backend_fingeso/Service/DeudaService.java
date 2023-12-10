package com.fingeso_grupo2.backend_fingeso.Service;

import com.fingeso_grupo2.backend_fingeso.Entity.Administrador;
import com.fingeso_grupo2.backend_fingeso.Entity.Deuda;
import com.fingeso_grupo2.backend_fingeso.Entity.Departamento;
import com.fingeso_grupo2.backend_fingeso.Entity.Edificio;
import com.fingeso_grupo2.backend_fingeso.Repository.DeudaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeudaService {

    private DeudaRepository deudaRepository;
    private DepartamentoService departamentoService;

    @Autowired
    public DeudaService(DeudaRepository deudaRepository, DepartamentoService departamentoService){
        this.deudaRepository = deudaRepository;
        this.departamentoService = departamentoService;
    }

    public Deuda addDeuda(String descripcion_deuda, Integer monto, long id_departamento) {
        Departamento dep = departamentoService.getDepartamentoByID(id_departamento);
        if (dep == null) {
            throw new RuntimeException("No se pudo encontrar el departamento con id: " + id_departamento);
        } else {
            Deuda deuda = new Deuda(descripcion_deuda, monto, dep);
            return deudaRepository.save(deuda);
        }
    }

    public Deuda getDeudaById(long id) {
        return deudaRepository.findById(id).orElse(null);
    }

    public List<Deuda> getAllDeudas() {
        return (List<Deuda>) deudaRepository.findAll();
    }

    public boolean existsById(Long id) {
        return deudaRepository.existsById(id);
    }
}
