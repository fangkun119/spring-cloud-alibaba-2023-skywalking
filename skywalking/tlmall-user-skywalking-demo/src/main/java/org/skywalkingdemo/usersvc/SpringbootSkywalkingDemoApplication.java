package org.skywalkingdemo.usersvc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.skywalkingdemo.usersvc.dao")
public class SpringbootSkywalkingDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootSkywalkingDemoApplication.class, args);
    }
}
