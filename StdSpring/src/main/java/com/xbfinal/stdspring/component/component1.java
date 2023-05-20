package com.xbfinal.stdspring.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;



/**
 * @Title: Coponent1
 * @Author 笑霸fianl
 * @Package com.xbfinal.stdspring.component
 * @Date 2023/5/20 9:54
 * @描述:  功能1  事件监听
 */

@Component
@Slf4j
public class component1 {


    /**
     * 事件监听
     */
    @EventListener
    public void myListener(Object o){
        log.info("\n 当前事件 -->{}",o);
        log.info("事件接收完毕");
    }
}
