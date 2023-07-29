package com.cj.missyou.config;

import com.cj.missyou.core.hack.AutoPrefixRequestMappingHandlerMapping;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @Date 2023/7/29 20:41
 * @Author cc
 */
@Configuration
public class RequestAutoPrefixConfiguration implements WebMvcRegistrations {
    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return  new AutoPrefixRequestMappingHandlerMapping();
    }
}
