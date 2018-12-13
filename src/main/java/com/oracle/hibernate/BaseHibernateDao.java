package com.oracle.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dong_zhengdong on 2018/12/13.
 */

@Component
@Transactional(value = "transactionManager")
public class BaseHibernateDao {

    @Autowired
    private SessionFactory sessionFactory;


    /**
     *
     * @param id
     */
    public void findMyPersonById(String id) {
        Session session = sessionFactory.getCurrentSession();
        MyPerson person = (MyPerson) session.get(MyPerson.class, id);
        System.out.println("person :  " + person);
    }

    /**
     *
     * @param myPerson
     */
    public void saveMyPerson(MyPerson myPerson) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(myPerson);

    }



}
