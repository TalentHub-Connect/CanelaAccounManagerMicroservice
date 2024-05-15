package com.talenthub.AccountManager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "service")
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 45)
    @Column(name = "description", length = 45)
    private String description;

    @Column(name = "rol_id")
    private Long rolId;

    @Size(max = 50)
    @ColumnDefault("ACTIVO")
    @Column(name = "status", length = 50)
    private String status;

}