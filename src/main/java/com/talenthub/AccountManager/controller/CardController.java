package com.talenthub.AccountManager.controller;

import com.talenthub.AccountManager.model.Card;
import com.talenthub.AccountManager.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @CrossOrigin
    @PostMapping("/save")
    boolean save(@RequestBody Card card){
        return cardService.save(card);
    }

}
