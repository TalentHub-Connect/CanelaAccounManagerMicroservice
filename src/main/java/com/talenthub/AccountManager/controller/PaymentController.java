package com.talenthub.AccountManager.controller;

import com.talenthub.AccountManager.model.BuyerInfo;
import com.talenthub.AccountManager.model.CardInfo;
import com.talenthub.AccountManager.model.ContactInfo;
import com.talenthub.AccountManager.service.ContactService;
import com.talenthub.AccountManager.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
    @PostMapping("/buyer")
    public BuyerInfo getBuyerInfo(@RequestBody BuyerInfo buyerInfo) {
        return paymentService.getBuyerInfo(buyerInfo);
    }

    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
    @PostMapping("/card")
    public BuyerInfo getCardInfo(@RequestBody BuyerInfo cardInfo) {
        return paymentService.getCardInfo(cardInfo);
    }
}
