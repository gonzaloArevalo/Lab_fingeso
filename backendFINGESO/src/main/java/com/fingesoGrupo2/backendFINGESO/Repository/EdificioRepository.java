package com.fingesoGrupo2.backendFINGESO.Repository;


import com.fingesoGrupo2.backendFINGESO.Entity.Edificio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificioRepository extends CrudRepository<Edificio,Long> {
}
