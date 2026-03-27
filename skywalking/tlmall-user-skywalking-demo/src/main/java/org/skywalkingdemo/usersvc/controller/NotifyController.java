package org.skywalkingdemo.usersvc.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notify")
public class NotifyController {
    @RequestMapping("/alarm")
    public String alarm(@RequestBody Object obj){
        sendMessage();
        return "notify successfully";
    }

    private void sendMessage(){
        // 在这里实现报警信息发送（邮件、短信、监控处理群、……）
        // ……
    }
}
