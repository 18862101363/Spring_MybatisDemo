package com.oracle.mybatis.env.test.service;


import com.oracle.mybatis.env.test.mapper.MyUserMapper;
import com.oracle.mybatis.env.test.model.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dong_zhengdong on 2018/12/11.
 */
@Service
@Transactional(value = "txManager_test")
public class MyUserService {

    @Autowired
    private MyUserMapper myUserMapper;


    public MyUser findMyUserbyId(int id) {
        return myUserMapper.findMyUserbyId(id);
    }


    public void delMyUserById(int id) {
        myUserMapper.delMyUserById(id);
    }


    public void insertMyUser(MyUser myUser) {
        myUserMapper.insertMyUser(myUser);
        MyUser u = findMyUserbyId(myUser.getId());
        System.out.println("u: " + u );
        int num = 10 / 0;
    }

}
