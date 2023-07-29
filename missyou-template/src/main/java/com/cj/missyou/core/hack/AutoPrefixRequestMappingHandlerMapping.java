package com.cj.missyou.core.hack;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * @Date 2023/7/29 20:57
 * @Author cc
 */
@Component
public class AutoPrefixRequestMappingHandlerMapping  extends RequestMappingHandlerMapping {

    @Value("${missyou.api-package}")
    private String apiPackage;

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo oldRequestMappingInfo = super.getMappingForMethod(method, handlerType);

        if (oldRequestMappingInfo != null){
            // RequestMappingInfo 存在
            // 根据包名获取前缀
            String packageName = handlerType.getPackage().getName();
            String prefix = packageName.replace(apiPackage, "").replace(".", "/");
            RequestMappingInfo newRequestMappingInfo = RequestMappingInfo.paths(prefix).build().combine(oldRequestMappingInfo);
            return newRequestMappingInfo;
        }


        return oldRequestMappingInfo;





    }

}
