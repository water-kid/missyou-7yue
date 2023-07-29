package com.cj.missyou.dot;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @Date 2023/7/29 11:41
 * @Author cc
 */
@Getter
@Setter
public class SchoolDTO {
    @Length(min = 4,max = 10,message = "schoolDto name 长度不对")
//    @NotNull
    private String schoolName;
}
