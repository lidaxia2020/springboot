package com.lidaxia.springbootvalidation.vo;

import lombok.Data;

import javax.validation.constraints.*;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/11 15:42（
 */
@Data
public class UserVoByAdd {

    @Pattern(regexp = "\\d+$",message = "主键只能是数字")
    @NotEmpty(message = "主键不能为空")
    private String id;

    @NotEmpty(message = "名字不能为空")
    private String name;

    @DecimalMin(value = "18",message = "年龄不能小于18岁")
    @DecimalMax(value = "25",message = "年龄不能大于25岁")
    @NotNull(message = "年龄不能为空")
    private Integer age;

    @NotEmpty(message = "地址不能为空")
    private String addr;

    @Email(message = "邮件格式不正确")
    @NotEmpty(message = "邮件不能为空")
    private String email;
}
