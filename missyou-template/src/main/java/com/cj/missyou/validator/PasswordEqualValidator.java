package com.cj.missyou.validator;

import com.cj.missyou.model.Banner;
import com.cj.missyou.model.Person;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Date 2023/7/29 21:35
 * @Author cc
 */
public class PasswordEqualValidator implements ConstraintValidator<PasswordEqual, Person> {

    private Integer min;
    private Integer max;

    @Override
    public void initialize(PasswordEqual constraintAnnotation) {
        this.max = constraintAnnotation.max();
        this.min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(Person person, ConstraintValidatorContext context) {


        String password01 = person.getPassword01();
        String password02 = person.getPassword02();
        if (password01.length() < min){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("长度不能小于3").addConstraintViolation();
            return  false;
        }

        return password01.equals(password02);
    }
}
