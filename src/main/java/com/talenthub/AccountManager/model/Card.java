package com.talenthub.AccountManager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "card")
public class Card implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "cardnumber", nullable = false)
    private String cardnumber;

    @Column(name = "cardholder")
    private String cardholder;

    @Column(name = "cardmonth")
    private String cardmonth;

    @Column(name = "cardyear")
    private String cardyear;

    @Column(name = "cardcvc")
    private String cardcvc;

    @Column(name = "autorenewal")
    private Integer autorenewal;

    @Column(name = "holderemail", nullable = false)
    private String holderemail;


}
