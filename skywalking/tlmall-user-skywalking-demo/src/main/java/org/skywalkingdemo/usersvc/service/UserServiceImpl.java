package org.skywalkingdemo.usersvc.service;

import org.skywalkingdemo.usersvc.dao.UserMapper;
import org.skywalkingdemo.usersvc.entity.User;
import org.apache.skywalking.apm.toolkit.trace.Tag;
import org.apache.skywalking.apm.toolkit.trace.Tags;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Trace
    @Tag(key = "users", value = "returnedObj")
    @Override
    public List<User> getUsers(){
        return userMapper.list();
    }

    @Trace
    @Tags({
        @Tag(key = "param", value = "arg[0]"),
        @Tag(key = "user", value = "returnedObj")
    })
    @Override
    public User getById(Integer id){
        return userMapper.getById(id);
    }
}
