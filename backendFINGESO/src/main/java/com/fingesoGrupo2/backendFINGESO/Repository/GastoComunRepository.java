package com.fingesoGrupo2.backendFINGESO.Repository;


import com.fingesoGrupo2.backendFINGESO.Entity.GastoComun;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastoComunRepository extends CrudRepository<GastoComun,Long> {
}
