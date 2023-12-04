package com.FingesoGrupo2.backendFingeso.Repository;


import com.FingesoGrupo2.backendFingeso.Entity.GastoComun;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastoComunRepository extends CrudRepository<GastoComun,Long> {
}
