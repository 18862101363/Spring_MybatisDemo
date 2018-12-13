package com.oracle.hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by dong_zhengdong on 2018/12/13.
 */
@Embeddable
public class MyComponent {


    @Column(name = "NAME")
    private String name;
    @Column(name = "PASSWORD")
    private String password;


    public MyComponent(String name, String password) {
        this.name = name;
        this.password = password;
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

    @Override
    public String toString() {
        return "MyComponent{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
