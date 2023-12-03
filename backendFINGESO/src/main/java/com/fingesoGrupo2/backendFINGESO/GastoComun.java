package com.fingesoGrupo2.backendFINGESO;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "gastocomun")
@Data
@NoArgsConstructor
public class GastoComun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_gasto_comun;
    private String descripcion;
    private Integer monto;
    private Date fecha;
    private long id_edificio;
    private long id_departamento;
    private long id_subadministrador;

    public GastoComun(long id_gasto_comun, String descripcion, Integer monto, Date fecha, long id_edificio, long id_departamento, long id_subadministrador) {
        this.id_gasto_comun = id_gasto_comun;
        this.descripcion = descripcion;
        this.monto = monto;
        this.fecha = fecha;
        this.id_edificio = id_edificio;
        this.id_departamento = id_departamento;
        this.id_subadministrador = id_subadministrador;
    }
}
