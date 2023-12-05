package com.fingesoGrupo2.backendFINGESO.Repository;

import com.fingesoGrupo2.backendFINGESO.Entity.Departamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends CrudRepository<Departamento,Long> {

}
