package com.fingesoGrupo2.backendFINGESO.Repository;


import com.fingesoGrupo2.backendFINGESO.Entity.Deuda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeudaRepository extends CrudRepository<Deuda,Long> {
}
