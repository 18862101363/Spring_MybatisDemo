package com.oracle.hibernate;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by dong_zhengdong on 2018/12/13.
 */
@Entity
@Table(name = "MY_COMPONENT_REF")
public class MyComponentRef {

    @Id
    @GenericGenerator(name = "refIdGenerator",strategy = "uuid")
    @GeneratedValue(generator = "refIdGenerator")
    @Column(name = "ID")
    private String id;

    @Column(name = "NOTES")
    private String notes;


    public MyComponentRef(String notes) {
        this.notes = notes;
    }

    public MyComponentRef() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    @Override
    public String toString() {
        return "MyComponentRef{" +
                "id='" + id + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
