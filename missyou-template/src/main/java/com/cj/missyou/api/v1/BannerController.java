package com.cj.missyou.api.v1;

import com.cj.missyou.exception.ForbiddenException;
import com.cj.missyou.model.Banner;
import com.cj.missyou.model.Person;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

/**
 * @Date 2023/7/29 20:40
 * @Author cc
 */
@RestController
@RequestMapping("/banner")
@Validated
public class BannerController {

    @RequestMapping("/test/{id}")
    public void test(@PathVariable @Range(min = 1,max = 10,message = "not greater than 10") Integer id,
                     String name, @RequestBody @Validated Person person){

    }

    @GetMapping("/test")
    public String test01() throws ForbiddenException {
        throw new ForbiddenException(10002);
    }

}
