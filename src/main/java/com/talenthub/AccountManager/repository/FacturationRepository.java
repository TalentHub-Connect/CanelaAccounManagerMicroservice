package com.talenthub.AccountManager.repository;

import com.talenthub.AccountManager.model.Facturation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FacturationRepository extends JpaRepository<Facturation, Long>, JpaSpecificationExecutor<Facturation> {
    List<Facturation> findByCompanyId(Long companyId);

}