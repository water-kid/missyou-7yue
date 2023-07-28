package com.cj.missyou;

import com.cj.missyou.config.EnableFruitAutoConfiguration;
import com.cj.missyou.config.FruitConfigurationSelector;
import com.cj.missyou.config.MyConfig;
import com.cj.missyou.model.Watermelon;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @Date 2023/7/27 11:46
 * @Author cc
 */
//@ComponentScan
//    @Import(MyConfig.class)
//    @Import(FruitConfigurationSelector.class)
    @EnableFruitAutoConfiguration
public class FruitApplication {

    public static void main(String[] args) {
        // 默认启动web服务器，@ComponentScan会去扫web服务器
        ConfigurableApplicationContext context = new SpringApplicationBuilder(FruitApplication.class)
                .web(WebApplicationType.NONE)  // 关闭web服务器
                .run(args);
        Watermelon watermelon = (Watermelon) context.getBean("watermelon");
        System.out.println("watermelon = " + watermelon);
    }
}
