package com.cj.missyou.validators;

import com.cj.missyou.dot.PersonDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Date 2023/7/29 15:35
 * @Author cc
 */

/**
 * 泛型：
 *      <自定义注解的类型,自定义注解修饰的目标的类型>
 *
 *
 *     如果注解在类上，，修饰的是类
 *     如果注解在字段上，，修饰的是字段 ，，就是字段的类型
 */
public class PasswordValidator implements ConstraintValidator<PasswordEquals, PersonDTO> {

    private int min;
    private int max;

    /**
     * 校验通过 返回true，不通过返回false
     */
    @Override
    public boolean isValid(PersonDTO personDTO, ConstraintValidatorContext context) {
       // 没有考虑密码为空
        String password01 = personDTO.getPassword01();
        String password02 = personDTO.getPassword02();

        return password01.equals(password02);
    }

    /**
     * 获取注解传入的值
     */
    @Override
    public void initialize(PasswordEquals constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
