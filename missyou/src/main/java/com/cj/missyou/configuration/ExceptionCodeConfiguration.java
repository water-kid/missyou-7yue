package com.cj.missyou.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2023/7/28 10:05
 * @Author cc
 */
@PropertySource("classpath:config/exception-code.properties")
@ConfigurationProperties(prefix = "lin")
@Component
public class ExceptionCodeConfiguration {
    private Map<Integer,String> codes = new HashMap<>();


    public String getMessage(Integer code){
        return codes.get(code);
    }

    public Map<Integer, String> getCodes() {
        return codes;
    }

    public void setCodes(Map<Integer, String> codes) {
        this.codes = codes;
    }
}
