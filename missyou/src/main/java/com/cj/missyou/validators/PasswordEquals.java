package com.cj.missyou.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Date 2023/7/29 15:28
 * @Author cc
 */
@Documented // 注解里面的注释加入到文档
 @Retention(RetentionPolicy.RUNTIME)
 @Target({ElementType.TYPE})
@Constraint(validatedBy = PasswordValidator.class)  // 指定多个校验类
public @interface PasswordEquals {
 int min() default 3;
 int max() default 6;
 String message() default "password not equal";

 /**
  *  如果要自定义校验  有两个模板方法，必须加上，，规范必须要有这两个东西
  */
 Class<?>[] groups() default {};
 Class<? extends Payload>[] payload() default {};
}
