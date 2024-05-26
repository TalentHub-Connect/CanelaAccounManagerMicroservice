package com.talenthub.AccountManager.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "facturation")
public class Facturation {
    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "facturationdate")
    @Temporal(TemporalType.DATE)
    private String facturationDate;

    @Column(name = "price")
    private Double price;


    @Column(name = "status")
    private String status;

    @Column(name = "companyid", nullable = false)
    private Long companyId;

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacturationDate() {
        return facturationDate;
    }

    public void setFacturationDate(String facturationDate) {
        this.facturationDate = facturationDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

   
    
    
}