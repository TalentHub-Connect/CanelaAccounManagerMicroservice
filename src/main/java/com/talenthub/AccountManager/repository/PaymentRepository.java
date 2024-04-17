package com.talenthub.AccountManager.repository;

import com.talenthub.AccountManager.model.BuyerInfo;
import com.talenthub.AccountManager.model.CardInfo;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository {
    public BuyerInfo saveBuyerInfo(BuyerInfo buyerInfo) {
        System.out.println(buyerInfo.toString());
        return buyerInfo;
    }

    public BuyerInfo saveCardInfo(BuyerInfo cardInfo) {
            System.out.println(cardInfo.toString());
        return cardInfo;
    }
}
