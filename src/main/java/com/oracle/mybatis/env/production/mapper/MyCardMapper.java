package com.oracle.mybatis.env.production.mapper;

import com.oracle.mybatis.env.production.model.MyCard;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dong_zhengdong on 2018/12/11.
 */
@Mapper
@Transactional(value = "txManager_production")
public interface MyCardMapper {


    @Results(id = "baseMap", value = {
            @Result(id=true, column = "ID", property = "id"),
            @Result(column = "CARD_NUMBER", property = "cardNumber"),
     })
    @Select(value="SELECT * FROM MY_CARD WHERE ID  = #{id}")
    public MyCard findMyCardbyId(int id);



    @Delete("DELETE FROM MY_CARD WHERE ID  = #{id}")
    public void delMyCardById(int id);


    @Insert("INSERT INTO MY_CARD VALUES (#{id}, #{cardNumber})")
    public void insertMyCard(MyCard myCard);
}
