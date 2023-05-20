package com.xbfinal.stdspring;

import com.xbfinal.stdspring.component.component1;
import com.xbfinal.stdspring.component.component2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StdSpringApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(StdSpringApplication.class, args);


        run.getBean(component2.class).sentListener();

    }

}
