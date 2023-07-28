package com.cj.missyou.config;

import com.cj.missyou.model.Fruit;
import com.cj.missyou.model.Watermelon;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Date 2023/7/27 11:51
 * @Author cc
 */
@Configuration
public class MyConfig {

    @Bean
    public Watermelon watermelon(){
        return new Watermelon();
    }
}
