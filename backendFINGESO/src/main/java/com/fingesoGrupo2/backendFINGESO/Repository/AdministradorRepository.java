package com.FingesoGrupo2.backendFingeso.Repository;

import com.FingesoGrupo2.backendFingeso.Entity.Administrador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends CrudRepository<Administrador,Long> {

}