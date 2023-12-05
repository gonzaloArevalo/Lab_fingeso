package com.fingesoGrupo2.backendFINGESO.Repository;

import com.fingesoGrupo2.backendFINGESO.Entity.Subadministrador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SubadministradorRepository extends CrudRepository<Subadministrador,Long> {
}
