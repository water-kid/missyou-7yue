package com.cj.missyou.conditional;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Arrays;

/**
 * @Date 2023/7/27 9:54
 * @Author cc
 */
public class FruitConditional implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        BeanDefinitionRegistry registry = context.getRegistry();
        String propertyName = context.getEnvironment().getProperty("fruit.name");
            if (propertyName.equalsIgnoreCase("apple")){
                return true;
            }

        return false;
    }
}
