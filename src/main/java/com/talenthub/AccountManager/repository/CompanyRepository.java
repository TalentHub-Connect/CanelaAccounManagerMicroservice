package com.talenthub.AccountManager.repository;

import com.talenthub.AccountManager.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>, JpaSpecificationExecutor<Company> {
    @Query("SELECT c.id FROM Company c WHERE c.email = ?1")
    Integer getCompanyIdByEmail(String email);
}