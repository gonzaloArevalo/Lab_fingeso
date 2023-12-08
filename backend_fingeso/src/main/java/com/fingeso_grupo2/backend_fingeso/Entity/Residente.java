package com.fingeso_grupo2.backend_fingeso.Entity;

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

    public Residente(Integer rut, String nombre, String contrasenia, String correo){
        this.rut = rut;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.correo = correo;
    }
}
