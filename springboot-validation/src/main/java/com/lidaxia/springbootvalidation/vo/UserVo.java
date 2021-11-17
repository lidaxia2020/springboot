package com.lidaxia.springbootvalidation.vo;

import com.lidaxia.springbootvalidation.validation.PasswordEqual;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/12 9:35（
 */
@Data
@PasswordEqual
public class UserVo {

    @NotEmpty
    private String password1;

    @NotEmpty
    private String password2;
}
