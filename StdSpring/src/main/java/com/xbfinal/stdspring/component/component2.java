package com.xbfinal.stdspring.component;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @Title: component2
 * @Author 笑霸fianl
 * @Package com.xbfinal.stdspring.component
 * @Date 2023/5/20 9:56
 * @描述:  功能1  事件发布
 */

@Component
@Slf4j
public class component2 {

    @Autowired
    private ConfigurableApplicationContext context;


    /**
     * 发布事件
     */
    public void  sentListener(){
        log.info("准备发布事件");
        context.publishEvent(new Object());
        log.info("事件发布完毕");
    }
}
