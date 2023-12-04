package com.FingesoGrupo2.backendFingeso.Repository;


import com.FingesoGrupo2.backendFingeso.Entity.Edificio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificioRepository extends CrudRepository<Edificio,Long> {
}
