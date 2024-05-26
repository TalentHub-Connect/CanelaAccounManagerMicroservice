package com.talenthub.AccountManager.model;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "coupon")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String expirationdate;
    private String status;  
    @Column(name = "companyid", nullable = false)
    private Long companyId;  
    private Double discountrate; 
 

 
    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   

    public String getStatus() {
        return status;
    }



    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Double getDiscountRate() {
        return discountrate;
    }

    public void setDiscountRate(Double discountrate) {
        this.discountrate = discountrate;
    }

    public String getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(String expirationdate) {
        this.expirationdate = expirationdate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getDiscountrate() {
        return discountrate;
    }

    public void setDiscountrate(Double discountrate) {
        this.discountrate = discountrate;
    }
}
