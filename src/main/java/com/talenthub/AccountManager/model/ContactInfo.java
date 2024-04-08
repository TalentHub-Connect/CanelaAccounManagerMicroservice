package com.talenthub.AccountManager.model;


public class ContactInfo {
    private String email;
    private String name;
    private Integer cellphone;
    private String message;

    public ContactInfo() {
    }

    public ContactInfo(String email, String name, Integer cellphone, String message) {
        this.email = email;
        this.name = name;
        this.cellphone = cellphone;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", cellphone=" + cellphone +
                ", message='" + message + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCellphone() {
        return cellphone;
    }

    public void setCellphone(Integer cellphone) {
        this.cellphone = cellphone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
