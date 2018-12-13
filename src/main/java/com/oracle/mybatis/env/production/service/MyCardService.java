package com.oracle.mybatis.env.production.service;

import com.oracle.mybatis.env.production.mapper.MyCardMapper;
import com.oracle.mybatis.env.production.model.MyCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dong_zhengdong on 2018/12/11.
 */
@Service
@Transactional(value = "txManager_production")
public class MyCardService {

    @Autowired
    private MyCardMapper myCardMapper;


    public MyCard findMyCardbyId(int id) {
        return myCardMapper.findMyCardbyId(id);
    }


    public void delMyCardById(int id) {
        myCardMapper.delMyCardById(id);
    }


    public void insertMyCard(MyCard myCard) {
        myCardMapper.insertMyCard(myCard);
        MyCard u = findMyCardbyId(myCard.getId());
        System.out.println("u: " + u );
        int num = 10 / 0;
    }

}
