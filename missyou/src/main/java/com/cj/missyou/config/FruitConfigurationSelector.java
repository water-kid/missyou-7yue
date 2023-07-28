package com.cj.missyou.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Date 2023/7/27 11:57
 * @Author cc
 */
public class FruitConfigurationSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{MyConfig.class.getName()};
    }

}
