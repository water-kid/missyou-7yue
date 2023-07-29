package com.cj.missyou.model;

import com.cj.missyou.validator.PasswordEqual;
import lombok.Getter;
import lombok.Setter;

/**
 * @Date 2023/7/29 21:38
 * @Author cc
 */
@Getter
@Setter
@PasswordEqual(min = 3)
public class Person {
    private String name;
    private String password01;
    private String password02;
}
