package com.cj.missyou.core;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Date 2023/7/29 21:24
 * @Author cc
 */
@Component
@PropertySource("classpath:config/exception-code.properties")
@ConfigurationProperties(prefix = "lin")
public class LoadExceptionCodeProperties {

    private Map<Integer,String> codes;

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
