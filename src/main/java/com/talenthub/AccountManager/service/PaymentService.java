package com.talenthub.AccountManager.service;

import com.talenthub.AccountManager.model.BuyerInfo;
import com.talenthub.AccountManager.model.CardInfo;
import com.talenthub.AccountManager.model.ContactInfo;
import com.talenthub.AccountManager.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;
    public BuyerInfo getBuyerInfo(BuyerInfo buyerInfo) {
        //Revisar si está
        return paymentRepository.saveBuyerInfo(buyerInfo);
    }

    public BuyerInfo getCardInfo(BuyerInfo cardInfo) {
        //Revisar si está
        return paymentRepository.saveCardInfo(cardInfo);
    }
}
