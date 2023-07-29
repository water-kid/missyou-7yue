package com.cj.missyou.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Date 2023/7/29 17:08
 * @Author cc
 */
@Data
public class User {
    @NotNull
    private String name;

    @Email
    private String email;

    @Min(18)
    private int age;

}
