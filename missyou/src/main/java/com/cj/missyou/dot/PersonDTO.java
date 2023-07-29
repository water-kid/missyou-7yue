package com.cj.missyou.dot;

import com.cj.missyou.validators.PasswordEquals;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Date 2023/7/29 9:19
 * @Author cc
 */
//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@PasswordEquals
public class PersonDTO {
//    @NonNull
    @Length(min = 2,max = 10,message = "xxxxxx")
    private String name;
    private String age;

    @Valid
    private SchoolDTO schoolDTO;

    // 密码长度
    private String password01;
    private String password02;


}
