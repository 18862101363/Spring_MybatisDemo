package com.oracle.mybatis.env.test.model;

/**
 *
 * CREATE TABLE MY_USER(
     ID INTEGER PRIMARY KEY,
     AGE INTEGER,
     NAME VARCHAR2(100),
     GENDER INTEGER,
     CARD_ID INTEGER
   );
 *
 * SELECT * FROM MY_USER;
    INSERT INTO MY_USER VALUES (1,20,'tom',1,2);
 *
 */
public class MyUser {

    private int id;
    private int age;
    private String name;
    private int gender;
    private int cardId;

    public MyUser(int id, int age, String name, int gender, int cardId) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.cardId = cardId;
    }

    public MyUser() {
    }

    public MyUser(int id, int age, String name, int gender) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.gender = gender;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return "MyCard{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", cardId=" + cardId +
                '}';
    }
}
