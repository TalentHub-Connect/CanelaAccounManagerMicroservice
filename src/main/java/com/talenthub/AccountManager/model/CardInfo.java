package com.talenthub.AccountManager.model;

public class CardInfo {

    private Boolean autoRenewal;
    private String cardCvc;
    private String cardMonth;
    private String cardNumber;
    private String cardYear;
    private String cardholder;

    public CardInfo() {
    }

    public CardInfo(Boolean autoRenewal, String cardCvc, String cardMonth, String cardNumber, String cardYear, String cardholder) {
        this.autoRenewal = autoRenewal;
        this.cardCvc = cardCvc;
        this.cardMonth = cardMonth;
        this.cardNumber = cardNumber;
        this.cardYear = cardYear;
        this.cardholder = cardholder;
    }

    public Boolean getAutoRenewal() {
        return autoRenewal;
    }

    public void setAutoRenewal(Boolean autoRenewal) {
        this.autoRenewal = autoRenewal;
    }

    public String getCardCvc() {
        return cardCvc;
    }

    public void setCardCvc(String cardCvc) {
        this.cardCvc = cardCvc;
    }

    public String getCardMonth() {
        return cardMonth;
    }

    public void setCardMonth(String cardMonth) {
        this.cardMonth = cardMonth;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardYear() {
        return cardYear;
    }

    public void setCardYear(String cardYear) {
        this.cardYear = cardYear;
    }

    public String getCardholder() {
        return cardholder;
    }

    public void setCardholder(String cardholder) {
        this.cardholder = cardholder;
    }

    @Override
    public String toString() {
        return "CardInfo{" +
                "autoRenewal=" + autoRenewal +
                ", cardCvc='" + cardCvc + '\'' +
                ", cardMonth='" + cardMonth + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardYear='" + cardYear + '\'' +
                ", cardHolder='" + cardholder + '\'' +
                '}';
    }
}
