package com.oracle.hibernate;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by dong_zhengdong on 2018/12/13.
 */
@Entity
@Table(name = "MY_HOUSE")
public class MyHouse {


    @Id
    @GenericGenerator(name = "idGenerator",strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "HOUSE_ID")  // 测试主键名为非ID，从也可以关联，即根据@Id注解决定哪个是主的ID的
    private String houseId;

    public MyHouse() {
    }



    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    @Override
    public String toString() {
        return "MyHouse{" +
                "houseId='" + houseId + '\'' +
                '}';
    }
}
