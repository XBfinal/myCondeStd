package com.example.config;

import com.example.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Title: SpringConfig
 * @Author 笑霸fianl
 * @Package com.example.config
 * @Date 2023/9/13 16:30
 * @描述:
 */
@Configuration
public class SpringConfig {

    @Bean
    public User user(){
        User user = new User();
        user.setAge(18);
        user.setName("钟骏骐");
        return user;
    }
}
