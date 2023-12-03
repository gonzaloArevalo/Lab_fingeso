package com.fingesoGrupo2.backendFINGESO;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_usuario;
    private String nombre;
    private String contrasenia;
    private String correo;
    private String id_rol;
    private long sueldo;


    public Usuario(long id_usuario, String nombre, String contrasenia, String correo, String id_rol, long sueldo) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.id_rol = id_rol;
        this.sueldo = sueldo;
    }

}
