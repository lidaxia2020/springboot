package com.lidaxia.springbootsecurity.vo;

import com.lidaxia.springbootsecurity.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 11:29（
 */
@Data
public class SysUserAuthorityVo extends PageCondition implements Serializable {
    private String userAuthorityId;//用户权限表id

    private String userId;//用户id

    private String authorityId;//权限id

    private SysUserVo sysUser;//用户

    private SysAuthorityVo sysAuthority;//权限
}
