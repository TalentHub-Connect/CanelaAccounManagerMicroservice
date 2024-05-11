package com.talenthub.AccountManager.repository;

import com.talenthub.AccountManager.model.Facturation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FacturationRepository extends JpaRepository<Facturation, Integer>, JpaSpecificationExecutor<Facturation> {

}