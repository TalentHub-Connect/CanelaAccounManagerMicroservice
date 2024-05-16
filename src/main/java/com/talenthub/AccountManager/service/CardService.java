package com.talenthub.AccountManager.service;

import com.talenthub.AccountManager.model.Card;
import com.talenthub.AccountManager.repository.CardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Optional<Card> getCardById(int id) {
        return cardRepository.findById(id);
    }

    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }

    public void deleteCard(int id) {
        cardRepository.deleteById(id);
    }

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
