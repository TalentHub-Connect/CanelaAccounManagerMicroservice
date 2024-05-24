package com.talenthub.AccountManager.repository;

import com.talenthub.AccountManager.model.Card;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

    Card findByHolderEmail(String email);
}
