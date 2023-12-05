package com.fingesoGrupo2.backendFINGESO.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departamento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_departamento;
    private Boolean estacionamiento;
    private Boolean bodega;

    @ManyToOne
    @JoinColumn(name = "id_edificio")
    private Edificio edificio;

    @ManyToOne
    @JoinColumn(name = "id_residente")
    private Residente residente;
}
