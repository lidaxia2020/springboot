package com.lidaxia.springbootsecurity.vo;

import com.lidaxia.springbootsecurity.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 9:31（
 */
@Data
public class SysAuthorityVo extends PageCondition implements Serializable {
    private String authorityId;//权限id

    private String authorityName;//权限名称，ROLE_开头，全大写

    private String authorityRemark;//权限描述

}