package com.cj.missyou.api.v1;

import com.cj.missyou.dot.PersonDTO;
import com.cj.missyou.exception.http.NotFoundException;
import com.cj.missyou.model.Banner;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Max;
import java.io.IOException;
import java.util.Map;

/**
 * @Date 2023/7/23 18:18
 * @Author cc
 */
@RestController
//@Lazy
@RequestMapping("/banner")
@Validated
public class BannerController {


//    @Autowired
    Banner banner;


    @Autowired
    public void setBanner(Banner banner) {
        this.banner = banner;
    }

//        public BannerController(Banner banner) {
//        this.banner = banner;
//    }

    //    @GetMapping("/test")
    @RequestMapping(value = "/test",method = {RequestMethod.GET})
    @ResponseBody
    public String test(HttpServletResponse response) throws IOException {
//        response.getWriter().write("中文");
//        System.out.println("ba = " + banner);
//        return "中文111";

        throw new NotFoundException(10002);
    }

    @PostMapping("/test01")
    public void test01(@RequestBody Map<String,Object> map){
        System.out.println("map = " + map);
    }

    @PostMapping("/test/{id}")
    public PersonDTO test02(@PathVariable @Range(min = 1,max = 10,message = "not greater than 10") Integer id,
                            @RequestParam @Length(min = 4) String name,
                            @Validated @RequestBody PersonDTO personDTO){
        PersonDTO personDTO1 = PersonDTO.builder().name("cc").age("12").build();
        System.out.println("map = " + personDTO);
        PersonDTO personDTO2 = new PersonDTO();
//        personDTO2.setName("cc");
//        personDTO2.setAge("11");

        return personDTO;
    }

    public void getByName(){}



}
