package com.AdmEdificio.AdminEdificio.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="usuario")
@Data
@NoArgsConstructor

public class Usuario {

    @Id
    private Long id;


}
