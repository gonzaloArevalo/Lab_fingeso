package com.fingeso_grupo2.backend_fingeso.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "gasto_comun")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GastoComun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_gasto_comun;
    private String descripcion;
    private Integer monto;
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id_edificio")
    private Edificio edificio;

    @ManyToOne
    @JoinColumn(name = "id_subadmin")
    private Subadministrador subadministrador;

    public GastoComun(String descripcion, Integer monto, Edificio edificio, Subadministrador subadministrador){
        this.descripcion = descripcion;
        this.monto = monto;
        this.fecha = new Date();
        this.edificio = edificio;
        this.subadministrador = subadministrador;
    }
}
