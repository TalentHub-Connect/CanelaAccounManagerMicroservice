package com.talenthub.AccountManager.model;

public class BuyerInfo {

    private String nombre;
    private String apellido;
    private String email;

    private CardInfo tarjeta;

    public BuyerInfo() {
    }

    public BuyerInfo(String nombre, String apellido, String email, CardInfo tarjeta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tarjeta = tarjeta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CardInfo getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(CardInfo tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public String toString() {
        return "BuyerInfo{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", tarjeta=" + tarjeta.toString() +
                '}';
    }
}
