package com.fingeso_grupo2.backend_fingeso.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "subadministrador")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subadministrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_subadmin;
    private Integer rut;
    private String nombre;
    private String contrasenia;
    private String correo;

    @ManyToOne
    @JoinColumn(name = "id_edificio")
    private Edificio edificio;

    public Subadministrador(Integer rut, String nombre, String contrasenia, String correo, Edificio edificio){
        this.rut = rut;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.edificio = edificio;
    }
}