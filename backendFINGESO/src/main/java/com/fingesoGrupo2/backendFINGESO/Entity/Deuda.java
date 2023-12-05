package com.fingesoGrupo2.backendFINGESO.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "deuda")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deuda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_deuda;
    private String descripcion_deuda;
    private Integer monto;

    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;
}