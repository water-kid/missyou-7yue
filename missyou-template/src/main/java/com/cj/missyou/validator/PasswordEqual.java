package com.cj.missyou.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Date 2023/7/29 21:37
 * @Author cc
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = PasswordEqualValidator.class)
public @interface PasswordEqual {
    int min() default 3;
    int max() default 6;

    String message() default "两次密码不匹配";


    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
