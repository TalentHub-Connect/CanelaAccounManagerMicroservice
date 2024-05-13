package com.talenthub.AccountManager.repository;

import com.talenthub.AccountManager.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CardRepository extends JpaRepository<Card, String>, JpaSpecificationExecutor<Card> {

}