package com.example.springstu;


import com.example.config.SpringConfig;
import com.example.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example")
public class HelloApplication  {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(SpringConfig.class);

        User user = (User)annotationConfigApplicationContext.getBean("user");
        System.out.println(user.toString());
    }

}