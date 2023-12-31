package com.cj.missyou;

import com.cj.missyou.dot.PersonDTO;
import com.cj.missyou.dot.SchoolDTO;
import com.cj.missyou.model.Banner;
import com.cj.missyou.model.Fruit;
import com.cj.missyou.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@SpringBootTest
class MissyouApplicationTests {

//    @Test
//    void contextLoads() {
//    }
//
//    @Autowired
//    Environment environment;
//
////    @Autowired
////    AnnotationConfigApplicationContext annotationConfigApplicationContext;
//    @Test
//    public void test01(){
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(Config.class);
//        context.refresh();
//        ConfigurableEnvironment environment1 = context.getEnvironment();
//        MutablePropertySources propertySources = environment1.getPropertySources();
//        System.out.println("propertySources = " + propertySources);
////        environment.containsProperty()
////        ConfigurableEnvironment environment1 = annotationConfigApplicationContext.getEnvironment();
////        System.out.println("environment1 = " + environment1);
//        System.out.println("environment = " + environment);
//
////        environment.getSyste
//    }
//
//
//    @Autowired
//    Banner banner;
//
//
//    @Test
//    public void test02(){
//        System.out.println(banner);
//    }
//
//    @Autowired
//    Fruit fruit;
//
//    @Test
//    public void test03(){
//        System.out.println("fruit = " + fruit);
//    }

    @Test
    public void test04(){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        User user = new User();
        user.setName(null);
        user.setEmail("invalid_email");
        user.setAge(16);
        Set<ConstraintViolation<User>> validate = validator.validate(user);
        validate.forEach(System.out::println);
    }
}
