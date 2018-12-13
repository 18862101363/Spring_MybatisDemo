package com.oracle.hibernate;

import com.oracle.mybatis.env.test.model.MyUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dong_zhengdong on 2018/12/13.
 */

@Component
@Transactional(value = "transactionManager")
public class BaseHibernateDao {

    @Autowired
    private SessionFactory sessionFactory;


    /**
     * @param id
     */
    public MyPerson findMyPersonById(String id) {
        Session session = sessionFactory.getCurrentSession();
        MyPerson person = (MyPerson) session.get(MyPerson.class, id);
        System.out.println("person :  " + person);
        return person;
    }

    /**
     * @param myPerson
     */
    public void saveMyPerson(MyPerson myPerson) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(myPerson);

    }


    /**
     * @param id
     */
    public void delMyPersonById(String id) {
        Session session = sessionFactory.getCurrentSession();
        MyPerson person = findMyPersonById(id);
        session.delete(person);

    }


    /**
     *
     * @param refId
     * @return
     */
    public List<MyUser> queryBySql(String refId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT p FROM MyPerson p WHERE  p.myComponent.myComponentRef.id = '" + refId + "'";
        return  session.createQuery(hql).list();
    }


}
