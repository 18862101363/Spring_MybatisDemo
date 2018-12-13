package com.oracle.mybatis.env.production;

import com.oracle.mybatis.env.production.service.MyCardService;
import com.oracle.mybatis.env.production.model.MyCard;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Created by dong_zhengdong on 2018/12/11.
 */
@ContextConfiguration(locations = {"classpath:spring/applicationContext_mybatis.xml", "classpath:spring/applicationContext_hibernate.xml"})
public class MyCardServiceTest extends AbstractJUnit4SpringContextTests {


    @Autowired
    private MyCardService myCardService;

    @Test
    public void testFindMyCardbyId() {
        MyCard myCard = myCardService.findMyCardbyId(1);
        System.out.println(myCard);
    }


    @Test
    public void testDelMyCardById() {
        myCardService.delMyCardById(1);
    }


    @Test
    public void testInsertMyCard() {
        MyCard myCard = new MyCard(1, "XXXXX1");
        myCardService.insertMyCard(myCard);

    }


}
