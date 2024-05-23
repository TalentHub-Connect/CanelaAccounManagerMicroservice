package com.talenthub.AccountManager.controller;

import com.talenthub.AccountManager.model.Card;
import com.talenthub.AccountManager.service.CardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @CrossOrigin
    @PostMapping("/save")
    boolean save(@RequestBody Card card){
        return cardService.save(card);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable int id) {
        Optional<Card> card = cardService.getCardById(id);
        return card.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Card createCard(@RequestBody Card card) {
        return cardService.saveCard(card);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> updateCard(@PathVariable int id, @RequestBody Card cardDetails) {
        Optional<Card> optionalCard = cardService.getCardById(id);
        if (optionalCard.isPresent()) {
            Card card = optionalCard.get();
            card.setCardNumber(cardDetails.getCardNumber());
            card.setCardHolder(cardDetails.getCardHolder());
            card.setCardMonth(cardDetails.getCardMonth());
            card.setCardYear(cardDetails.getCardYear());
            card.setCardCvc(cardDetails.getCardCvc());
            card.setAutoRenewal(cardDetails.getAutoRenewal());
            card.setHolderEmail(cardDetails.getHolderEmail());
            Card updatedCard = cardService.saveCard(card);
            return ResponseEntity.ok(updatedCard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable int id) {
        if (cardService.getCardById(id).isPresent()) {
            cardService.deleteCard(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/email/{email}")
    public Card getCardByEmail(@PathVariable String email) {
        return cardService.getCardByEmail(email);
    }
}
