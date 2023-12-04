package com.FingesoGrupo2.backendFingeso.Repository;

import com.FingesoGrupo2.backendFingeso.Entity.Departamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends CrudRepository<Departamento,Long> {

}
