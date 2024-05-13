package com.talenthub.AccountManager.service;

import com.talenthub.AccountManager.model.Card;
import com.talenthub.AccountManager.repository.CardRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;


    public boolean save(Card card) {
        try {
            System.out.println(card.toString());
            cardRepository.save(card);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
