package com.FingesoGrupo2.backendFingeso.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "personal")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_personal;
    private Integer rut;
    private String nombre;
    private String contrasenia;
    private String correo;
    private Integer sueldo;

    @ManyToOne
    @JoinColumn(name = "id_edificio")
    private Edificio edificio;

}
