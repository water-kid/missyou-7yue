package com.cj.missyou.api.v1;

import com.cj.missyou.exception.http.NotFoundException;
import com.cj.missyou.model.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Date 2023/7/23 18:18
 * @Author cc
 */
@RestController
//@Lazy
@RequestMapping("/v1/banner")
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
}
