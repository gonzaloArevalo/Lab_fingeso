package com.fingeso_grupo2.backend_fingeso.Entity;

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
    private Float departamento_m2;
    private Float estacionamiento_m2;
    private Float bodega_m2;

    @ManyToOne
    @JoinColumn(name = "id_edificio")
    private Edificio edificio;

    @ManyToOne
    @JoinColumn(name = "id_residente")
    private Residente residente;

    public Departamento(Float departamento_m2, Float estacionamiento_m2, Float bodega_m2, Edificio edificio, Residente residente){
        this.departamento_m2 = departamento_m2;
        this.estacionamiento_m2 = estacionamiento_m2;
        this.bodega_m2 = bodega_m2;
        this.edificio = edificio;
        this.residente = residente;
    }
}
