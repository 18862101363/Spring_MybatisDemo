package com.oracle.hibernate;

import com.sun.tools.corba.se.idl.StringGen;
import org.hibernate.annotations.Cascade;
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
    @Column(name = "ID")
    private String id;     //  ID 定义在 component 中，而不在当前table类中定义，会报错，说当前table类没有identifier , 但如果是继承关系，ID定义在基类中，好像是可以的


    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    // CascadeType.PERSIST无法级联保存解决（https://blog.csdn.net/u012382571/article/details/50977185）：
    @JoinColumn(name = "MY_HOUSE_ID")
    private MyHouse myHouse;


    @Embedded
//    @AttributeOverrides( {
//            @AttributeOverride(name="name", column = @Column(name="name") ),
//            @AttributeOverride(name="password", column = @Column(name="password") )
//    } )
    private MyComponent myComponent;



    @Version
    private int version;  // org.hibernate.StaleObjectStateException   .
                    //   version 不可以再component中定义


    @Column(name = "GENDER")
    private String gender;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MyComponent getMyComponent() {
        return myComponent;
    }

    public void setMyComponent(MyComponent myComponent) {
        this.myComponent = myComponent;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public MyHouse getMyHouse() {
        return myHouse;
    }

    public void setMyHouse(MyHouse myHouse) {
        this.myHouse = myHouse;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public MyPerson(MyHouse myHouse, MyComponent myComponent, String gender) {
        this.myHouse = myHouse;
        this.myComponent = myComponent;
        this.gender = gender;
    }


    public MyPerson() {
    }

    public MyPerson(MyHouse myHouse, MyComponent myComponent, int version, String gender) {
        this.myHouse = myHouse;
        this.myComponent = myComponent;
        this.version = version;
        this.gender = gender;
    }
}
