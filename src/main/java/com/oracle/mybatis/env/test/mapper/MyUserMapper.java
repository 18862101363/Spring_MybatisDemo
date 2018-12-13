package com.oracle.mybatis.env.test.mapper;

import com.oracle.mybatis.env.test.model.MyUser;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dong_zhengdong on 2018/12/12.
 */
@Mapper
@Transactional(value = "txManager_test")
public interface MyUserMapper {


    @Results(id = "baseMap", value = {
            @Result(id=true, column = "ID", property = "id"),
            @Result(column = "AGE", property = "age"),
            @Result(column = "NAME", property = "name"),
            @Result(column = "GENDER", property = "gender"),
            @Result(column = "CARD_ID", property = "cardId"),
    })
    @Select(value="SELECT  * FROM MY_USER WHERE ID  = #{id}")
    public MyUser findMyUserbyId(int id);



    @Delete("DELETE FROM MY_USER WHERE ID  = #{id}")
    public void delMyUserById(int id);


    @Insert("INSERT INTO MY_USER VALUES (#{id}, #{age}, #{name}, #{gender}, #{cardId})")
    public void insertMyUser(MyUser myUser);
}
