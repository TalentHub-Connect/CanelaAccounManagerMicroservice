package com.talenthub.AccountManager.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

@Accessors(chain = true)
@Data
@Entity
@Table(name = "company")
public class Company implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "namecompany")
    private String namecompany;

    @Column(name = "nit")
    private Integer nit;

    @Column(name = "namelegalrepresentative")
    private String namelegalrepresentative;

    @Column(name = "idlegalrepresentative")
    private Integer idlegalrepresentative;

    @Column(name = "email")
    private String email;

    @Column(name = "phonecompany")
    private Integer phonecompany;

    @Column(name = "numworkers")
    private Integer numworkers;

    @Column(name = "address")
    private String address;

    @Column(name = "linkdate")
    private String linkdate;

    @Column(name = "subscriptionenddate")
    private String subscriptionenddate;

    @Column(name = "status")
    private String status;

}
