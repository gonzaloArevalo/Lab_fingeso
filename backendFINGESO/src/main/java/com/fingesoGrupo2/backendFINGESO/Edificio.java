package com.fingesoGrupo2.backendFINGESO;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "edificio")
@Data
@NoArgsConstructor
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_edificio;
    private long id_subadmin;
    private long id_admin;

    public Edificio(long id_edificio, long id_subadmin, long id_admin) {
        this.id_edificio = id_edificio;
        this.id_subadmin = id_subadmin;
        this.id_admin = id_admin;
    }

}
