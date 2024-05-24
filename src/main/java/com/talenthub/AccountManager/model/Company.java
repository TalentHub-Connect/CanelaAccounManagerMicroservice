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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "namecompany")
    private String nameCompany;

    @Column(name = "nit")
    private int nit;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phonecompany")
    private int phoneCompany;

    @Column(name = "namelegalrepresentative")
    private String nameLegalRepresentative;

    @Column(name = "idlegalrepresentative")
    private Integer idLegalRepresentative;

    @Column(name = "linkdate")
    private String linkDate;

    @Column(name = "subscriptionenddate")
    private String subscriptionEndDate;

    @Column(name = "numworkers")
    private int numWorkers;

    @Column(name = "status")
    private String status;

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    @Column(name = "plan_id")
    private Long planId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneCompany() {
        return phoneCompany;
    }

    public void setPhoneCompany(int phoneCompany) {
        this.phoneCompany = phoneCompany;
    }

    public String getNameLegalRepresentative() {
        return nameLegalRepresentative;
    }

    public void setNameLegalRepresentative(String nameLegalRepresentative) {
        this.nameLegalRepresentative = nameLegalRepresentative;
    }

    public int getIdLegalRepresentative() {
        return idLegalRepresentative;
    }

    public void setIdLegalRepresentative(int idLegalRepresentative) {
        this.idLegalRepresentative = idLegalRepresentative;
    }

    public String getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(String linkDate) {
        this.linkDate = linkDate;
    }

    public String getSubscriptionEndDate() {
        return subscriptionEndDate;
    }

    public void setSubscriptionEndDate(String subscriptionEndDate) {
        this.subscriptionEndDate = subscriptionEndDate;
    }

    public int getNumWorkers() {
        return numWorkers;
    }

    public void setNumWorkers(int numWorkers) {
        this.numWorkers = numWorkers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
