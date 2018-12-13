package com.oracle.hibernate;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by dong_zhengdong on 2018/12/13.
 */
@Entity
@Table(name = "MY_PERSON")
public class MyPerson {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Embedded
//    @AttributeOverrides( {
//            @AttributeOverride(name="name", column = @Column(name="name") ),
//            @AttributeOverride(name="password", column = @Column(name="password") )
//    } )
    private MyComponent myComponent;

    public MyComponent getMyComponent() {
        return myComponent;
    }

    public void setMyComponent(MyComponent myComponent) {
        this.myComponent = myComponent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MyPerson(MyComponent myComponent) {
        this.myComponent = myComponent;
    }



    public MyPerson() {
    }

    @Override
    public String toString() {
        return "MyPerson{" +
                "id='" + id + '\'' +
                ", myComponent=" + myComponent +
                '}';
    }
}
