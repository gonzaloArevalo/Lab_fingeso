package com.fingeso_grupo2.backend_fingeso.Repository;


import com.fingeso_grupo2.backend_fingeso.Entity.Deuda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeudaRepository extends CrudRepository<Deuda,Long> {
}
