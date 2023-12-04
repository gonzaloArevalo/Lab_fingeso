package com.FingesoGrupo2.backendFingeso.Repository;

import com.FingesoGrupo2.backendFingeso.Entity.Personal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepository extends CrudRepository<Personal,Long> {
}
