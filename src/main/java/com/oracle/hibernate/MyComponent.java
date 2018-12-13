package com.oracle.hibernate;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

/**
 * Created by dong_zhengdong on 2018/12/13.
 */
@Embeddable
public class MyComponent {


    @Column(name = "NAME")
    private String name;
    @Column(name = "PASSWORD")
    private String password;

    @OneToOne(fetch = FetchType.EAGER)
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "REF_ID")
    private MyComponentRef myComponentRef;





    public MyComponent(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public MyComponent(String name, String password, MyComponentRef myComponentRef) {
        this.name = name;
        this.password = password;
        this.myComponentRef = myComponentRef;
    }

    public MyComponent() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyComponentRef getMyComponentRef() {
        return myComponentRef;
    }

    public void setMyComponentRef(MyComponentRef myComponentRef) {
        this.myComponentRef = myComponentRef;
    }

    @Override
    public String toString() {
        return "MyComponent{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", myComponentRef=" + myComponentRef +
                '}';
    }
}
