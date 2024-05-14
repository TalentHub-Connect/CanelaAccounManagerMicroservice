package com.talenthub.AccountManager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "cardnumber", nullable = false, length = 19)
    private String cardNumber;
    
    @Column(name = "cardholder", length = 50)
    private String cardHolder;
    
    @Column(name = "cardmonth", length = 2)
    private String cardMonth;
    
    @Column(name = "cardyear", length = 2)
    private String cardYear;
    
    @Column(name = "cardcvc", length = 3)
    private String cardCvc;
    
    @Column(name = "autorenewal")
    private int autoRenewal;
    
    @Column(name = "holderemail", length = 45)
    private String holderEmail;


}