package com.cj.missyou.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Date 2023/7/24 16:15
 * @Author cc
 */
//@Component
//@Lazy
@Data
@ToString
public class Banner {

    private String  ip;


    public Banner() {
        System.out.println("banner");
    }
}
