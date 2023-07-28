package com.cj.missyou.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Date 2023/7/27 16:29
 * @Author cc
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(FruitConfigurationSelector.class)
public @interface EnableFruitAutoConfiguration {

}
