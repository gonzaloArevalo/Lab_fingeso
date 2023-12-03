package com.fingesoGrupo2.backendFINGESO;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departamento")
@Data
@NoArgsConstructor
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_departamento;
    private Boolean estacionamiento;
    private Boolean bodega;
    private long id_edificio;
    private long id_usuario;

    public Departamento(long id_departamento, Boolean estacionamiento, Boolean bodega, long id_edificio, long id_usuario) {
        this.id_departamento = id_departamento;
        this.estacionamiento = estacionamiento;
        this.bodega = bodega;
        this.id_edificio = id_edificio;
        this.id_usuario = id_usuario;
    }

}
