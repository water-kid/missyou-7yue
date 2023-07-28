package com.cj.missyou;

import com.cj.missyou.conditional.FruitConditional;
import com.cj.missyou.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Date 2023/7/24 18:48
 * @Author cc
 */
@Configuration
public class Config {
    @Value("${mysql.ip}")
    private String ip;

    public void setIp(String ip) {
        this.ip = ip;
    }

//    @Bean
//    public Mysql mysql(){
//        return new Mysql();
//    }

    @Bean
    public Banner banner(){
        Banner banner = new Banner();
        banner.setIp(ip);
        return banner;
    }

//    @Bean
//    @ConditionalOnProperty(value = "fruit.name",havingValue = "apple",matchIfMissing = false)
//    public Fruit apple(){
//        return new Apple();
//    }
//
//    @Bean
//    @ConditionalOnProperty(value = "fruit.name",havingValue = "pear")
//    public Fruit pear(){
//        return new Pear();
//    }
}
