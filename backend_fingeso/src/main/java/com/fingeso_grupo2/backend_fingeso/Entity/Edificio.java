package com.fingeso_grupo2.backend_fingeso.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "edificio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_edificio;
    private Integer departamentosTotales;
    private Integer departamentosOcupados;

    @ManyToOne
    @JoinColumn(name = "id_admin")
    private Administrador administrador;
}
