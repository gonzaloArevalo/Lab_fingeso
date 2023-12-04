package com.FingesoGrupo2.backendFingeso.Repository;

import com.FingesoGrupo2.backendFingeso.Entity.Subadministrador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SubadministradorRepository extends CrudRepository<Subadministrador,Long> {
}
