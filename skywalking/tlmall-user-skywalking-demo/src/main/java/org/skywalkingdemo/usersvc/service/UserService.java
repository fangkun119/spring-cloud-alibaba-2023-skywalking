package org.skywalkingdemo.usersvc.service;

import org.skywalkingdemo.usersvc.entity.User;
import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getById(Integer id);
}
