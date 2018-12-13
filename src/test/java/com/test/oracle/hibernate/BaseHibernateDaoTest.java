package com.test.oracle.hibernate;

import com.oracle.hibernate.BaseHibernateDao;
import com.oracle.hibernate.MyComponent;
import com.oracle.hibernate.MyPerson;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Created by dong_zhengdong on 2018/12/11.
 */
@ContextConfiguration(locations = {"classpath:spring/applicationContext_mybatis.xml", "classpath:spring/applicationContext_hibernate.xml"})
public class BaseHibernateDaoTest extends AbstractJUnit4SpringContextTests {


    @Autowired
    private BaseHibernateDao hibernateDao;

    @Test
    public void testFindMyUserbyId() {


    }


    @Test
    public void testSaveMyPerson() {
        MyPerson person = new MyPerson(new MyComponent("tom", "tom123"));
        hibernateDao.saveMyPerson(person);
        hibernateDao.findMyPersonById(person.getId());
    }


}
