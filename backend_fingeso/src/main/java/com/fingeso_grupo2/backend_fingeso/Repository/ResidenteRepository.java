package com.fingeso_grupo2.backend_fingeso.Repository;


import com.fingeso_grupo2.backend_fingeso.Entity.Residente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidenteRepository extends CrudRepository<Residente,Long> {

}
