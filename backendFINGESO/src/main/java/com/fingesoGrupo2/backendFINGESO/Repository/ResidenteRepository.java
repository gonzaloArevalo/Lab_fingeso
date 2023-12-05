package com.fingesoGrupo2.backendFINGESO.Repository;


import com.fingesoGrupo2.backendFINGESO.Entity.Residente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidenteRepository extends CrudRepository<Residente,Long> {

}
