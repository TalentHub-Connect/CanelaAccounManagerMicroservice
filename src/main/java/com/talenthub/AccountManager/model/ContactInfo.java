package com.talenthub.AccountManager.model;


public class ContactInfo {
    private String formName;
    private String cellphone;

    private String email;
    private String message;

    public ContactInfo() {
    }

    public ContactInfo(String formName, String cellphone, String email, String message) {
        this.email = email;
        this.formName = formName;
        this.cellphone = cellphone;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFormName() {
        return formName;
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "email='" + email + '\'' +
                ", name='" + formName + '\'' +
                ", cellphone=" + cellphone +
                ", message='" + message + '\'' +
                '}';
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
