package com.cj.missyou.core.hack;

import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * @Date 2023/7/28 11:34
 * @Author cc
 */
@Component
public class AutoPrefixUrlMapping extends RequestMappingHandlerMapping {

    @Value("${missyou.api-package}")
    private String apiPackage;

    /**
     *
     * @param method 请求要处理的方法
     * @param handlerType 控制器类，指要处理该请求的处理器类
     */
    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo requestMappingInfo = super.getMappingForMethod(method, handlerType);

        if (requestMappingInfo != null){
            String prefix = this.getPrefix(handlerType);
            RequestMappingInfo newRequestMappingInfo = RequestMappingInfo.paths(prefix).build().combine(requestMappingInfo);
            return newRequestMappingInfo;
        }

        return requestMappingInfo;
    }

    private String getPrefix(Class<?> handlerType) {
        String path = handlerType.getPackage().getName();
        String dotpath = path.replace(apiPackage,"");
        return dotpath.replace(".","/");
    }

}
