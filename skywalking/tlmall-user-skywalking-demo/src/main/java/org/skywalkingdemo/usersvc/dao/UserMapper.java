package org.skywalkingdemo.usersvc.dao;

import org.skywalkingdemo.usersvc.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    @Select("select * from user")
    List<User> list();

    @Select("select * from user where id=#{id}")
    User getById(Integer id);
}