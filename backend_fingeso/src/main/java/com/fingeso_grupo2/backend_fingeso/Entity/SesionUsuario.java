package com.fingeso_grupo2.backend_fingeso.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sesion_usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SesionUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_sesion;

    @OneToOne
    @JoinColumn(name = "id_admin")
    private Administrador administrador;

    @OneToOne
    @JoinColumn(name = "id_subadmin")
    private Subadministrador subadministrador;

    @OneToOne
    @JoinColumn(name = "id_residente")
    private Residente residente;

    @OneToOne
    @JoinColumn(name = "id_personal")
    private Personal personal;

    public SesionUsuario(Administrador administrador,Subadministrador subadministrador,Residente residente,Personal personal) {
        this.administrador = administrador;
        this.subadministrador = subadministrador;
        this.residente = residente;
        this.personal = personal;
    }
}
