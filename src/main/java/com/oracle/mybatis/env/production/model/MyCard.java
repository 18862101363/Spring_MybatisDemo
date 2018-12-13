package com.oracle.mybatis.env.production.model;

/**
 *
 * CREATE TABLE MY_CARD(
     ID INTEGER PRIMARY KEY,
     CARD_NUMBER VARCHAR2(100)
    );

     INSERT INTO MY_CARD VALUES (1,'XXXXX1');
     SELECT * FROM MY_CARD;
 *
 */
public class MyCard {

    private int id;
    private String cardNumber;

    public MyCard() {
    }

    public MyCard(int id, String cardNumber) {
        this.id = id;
        this.cardNumber = cardNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "MyCard{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
