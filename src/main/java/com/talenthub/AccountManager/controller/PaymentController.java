package com.talenthub.AccountManager.controller;

import com.talenthub.AccountManager.model.BuyerInfo;
import com.talenthub.AccountManager.model.CardInfo;
import com.talenthub.AccountManager.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    //@CrossOrigin(origins = {"https://talenthubsoftware.vercel.app","http://localhost:8080", "http://localhost:4200", "https://canelaapigatewayback-production.up.railway.app"})
    @CrossOrigin
    @PostMapping("/buyer")
    public BuyerInfo getBuyerInfo(@RequestBody BuyerInfo buyerInfo) {
        return paymentService.getBuyerInfo(buyerInfo);
    }

    //@CrossOrigin(origins = {"https://talenthubsoftware.vercel.app","http://localhost:8080", "http://localhost:4200", "https://canelaapigatewayback-production.up.railway.app"})
    @CrossOrigin
    @PostMapping("/card")
    public BuyerInfo getCardInfo(@RequestBody BuyerInfo cardInfo) {
        return paymentService.getCardInfo(cardInfo);
    }
}
