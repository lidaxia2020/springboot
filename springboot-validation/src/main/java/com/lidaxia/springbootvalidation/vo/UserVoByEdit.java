package com.lidaxia.springbootvalidation.vo;

import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/11 15:42（
 */
@Data
public class UserVoByEdit {

    @NotEmpty(message = "主键不能为空")
    private String id;

    private String name;

    @DecimalMin(value = "18",message = "年龄不能小于18岁")
    @DecimalMax(value = "25",message = "年龄不能大于25岁")
    private Integer age;

    private String addr;

    @Email(message = "邮件格式不正确")
    private String email;
}