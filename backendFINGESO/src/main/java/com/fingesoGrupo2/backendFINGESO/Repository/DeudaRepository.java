package com.FingesoGrupo2.backendFingeso.Repository;


import com.FingesoGrupo2.backendFingeso.Entity.Deuda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeudaRepository extends CrudRepository<Deuda,Long> {
}
