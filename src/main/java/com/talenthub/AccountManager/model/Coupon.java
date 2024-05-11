package com.talenthub.AccountManager.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Entity
@Table(name = "coupon")
@Accessors(chain = true)
public class Coupon implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "expirationdate")
    private String expirationdate;

    @Column(name = "status")
    private String status;

    @Column(name = "discountrate")
    private Double discountrate;

    @Column(name = "companyid", nullable = false)
    private Integer companyid;

}
