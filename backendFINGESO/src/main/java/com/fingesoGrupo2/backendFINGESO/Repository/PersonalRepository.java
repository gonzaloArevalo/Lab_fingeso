package com.fingesoGrupo2.backendFINGESO.Repository;

import com.fingesoGrupo2.backendFINGESO.Entity.Personal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepository extends CrudRepository<Personal,Long> {
}
