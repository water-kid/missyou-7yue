package com.cj.missyou.config;

import com.cj.missyou.model.Apple;
import com.cj.missyou.model.Fruit;
import com.cj.missyou.model.Mysql;
import com.cj.missyou.model.Pear;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Date 2023/7/27 10:41
 * @Author cc
 */
@Component
@ConditionalOnProperty(prefix = "app",name = "fruit",matchIfMissing = true)
public class FruitConfig {

    @Bean
    public Mysql mysql(){
        return new Mysql();
    }


    @Bean
    @ConditionalOnProperty(value = "fruit.name",havingValue = "apple")
    public Fruit apple(){
        return new Apple();
    }

    @Bean
    @ConditionalOnBean(name = "mysql")
    @ConditionalOnMissingBean(name="mysql")
    public Fruit pear(){
        return new Pear();
    }




}
