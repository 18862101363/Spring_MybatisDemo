package com.oracle.hibernate;

import com.oracle.hibernate.BaseHibernateDao;
import com.oracle.hibernate.MyComponent;
import com.oracle.hibernate.MyHouse;
import com.oracle.hibernate.MyPerson;
import com.oracle.mybatis.env.test.model.MyUser;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.List;

/**
 * Created by dong_zhengdong on 2018/12/11.
 */
@ContextConfiguration(locations = {"classpath:spring/applicationContext_mybatis.xml", "classpath:spring/applicationContext_hibernate.xml"})
public class BaseHibernateDaoTest extends AbstractJUnit4SpringContextTests {


    @Autowired
    private BaseHibernateDao hibernateDao;

    @Test
    public void testDelMyPersonById() {
        hibernateDao.delMyPersonById("8a9572fc67a6ad640167a6ad68ec0000");

    }


    @Test
    public void testSaveMyPerson() {
        MyComponentRef ref = new MyComponentRef("test");
        MyComponent myComponent = new MyComponent("tom", "tom123", ref);

        MyPerson person = new MyPerson(new MyHouse(), myComponent,"male");
        hibernateDao.saveMyPerson(person);
        hibernateDao.findMyPersonById(person.getId());
    }


    @Test
    public void testQueryBySql() {
        List<MyUser> myUsers = hibernateDao.queryBySql("402880e867a77b860167a77b8cbb0001");
        if (myUsers.size() > 0) {
            System.out.println(myUsers.get(0));
        }

    }



    @Test
    public void testUpdateMyUserNameById() {  //org.hibernate.StaleObjectStateException

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    hibernateDao.updateMyUserNameById("402880e867a7b91d0167a7b9383b0000", "lily");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    hibernateDao.updateMyUserNameById("402880e867a7b91d0167a7b9383b0000", "tony");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        thread1.start();
        thread2.start();

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
