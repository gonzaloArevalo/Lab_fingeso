package com.fingesoGrupo2.backendFINGESO;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "deuda")
@Data
@NoArgsConstructor
public class Deuda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)

    private long id_deuda;
    private String descripcion_deuda;
    private long id_departamento;

    public Deuda(long id_deuda, String descripcion_deuda, long id_departamento) {
        this.id_deuda = id_deuda;
        this.descripcion_deuda = descripcion_deuda;
        this.id_departamento = id_departamento;
    }
}
