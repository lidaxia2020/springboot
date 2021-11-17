package com.lidaxia.springbootswagger2.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/16 14:26（
 */
@Data
@ApiModel(description = "User实体Vo")
public class UserVo {
    @ApiModelProperty("用户id")
    private Integer id;

    @ApiModelProperty("用户名称")
    private String userName;
}