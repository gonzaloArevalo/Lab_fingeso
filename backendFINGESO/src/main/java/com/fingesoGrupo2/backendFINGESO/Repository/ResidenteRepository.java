package com.FingesoGrupo2.backendFingeso.Repository;


import com.FingesoGrupo2.backendFingeso.Entity.Residente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidenteRepository extends CrudRepository<Residente,Long> {

}
