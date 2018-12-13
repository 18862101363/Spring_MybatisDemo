package com.oracle.mybatis.env.test;

import com.oracle.mybatis.env.test.model.MyUser;
import com.oracle.mybatis.env.test.service.MyUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Created by dong_zhengdong on 2018/12/11.
 */
@ContextConfiguration(locations = {"classpath:spring/applicationContext_mybatis.xml", "classpath:spring/applicationContext_hibernate.xml"})
public class MyUserServiceTest extends AbstractJUnit4SpringContextTests {


    @Autowired
    private MyUserService myUserService;

    @Test
    public void testFindMyUserbyId() {
        MyUser myUser = myUserService.findMyUserbyId(1);
        System.out.println(myUser);
    }


    @Test
    public void testDelMyUserById() {
        myUserService.delMyUserById(1);
    }


    @Test
    public void testInsertMyUser() {
        MyUser myUser = new MyUser(1, 20, "tom", 1, 2);
        myUserService.insertMyUser(myUser);

    }


}
