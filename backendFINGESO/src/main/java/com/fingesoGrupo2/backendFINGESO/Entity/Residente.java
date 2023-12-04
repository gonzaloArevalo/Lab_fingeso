package com.FingesoGrupo2.backendFingeso.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "residente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Residente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_residente;
    private Integer rut;
    private String nombre;
    private String contrasenia;
    private String correo;
}
