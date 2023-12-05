package com.fingesoGrupo2.backendFINGESO.Repository;

import com.fingesoGrupo2.backendFINGESO.Entity.Administrador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends CrudRepository<Administrador,Long> {

}