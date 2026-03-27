package org.skywalkingdemo.usersvc.controller;

import org.skywalkingdemo.usersvc.entity.User;
import org.skywalkingdemo.usersvc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        // 模拟请求异常
        if (id == 4) {
            throw new IllegalArgumentException("参数异常");
        }
        // 模拟慢调用
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 获取用户信息
        return userService.getById(id);
    }

    @RequestMapping("")
    public List<User> getUsers() {
        // TraceContext可以绑定key-value
        TraceContext.putCorrelation("name", "fox");
        Optional<String> op = TraceContext.getCorrelation("name");
        log.info("name = {} ", op.get());

        // 获取跟踪的traceId
        String traceId = TraceContext.traceId();
        log.info("traceId = {} ", traceId);

        // 返回用户列表
        return userService.getUsers();
    }
}
