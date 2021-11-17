package com.lidaxia.springbootsecurity.vo;

import com.lidaxia.springbootsecurity.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 9:29（
 */
@Data
public class SysUserMenuVo extends PageCondition implements Serializable {
    private String userMenuId;//用户菜单表id

    private String userId;//用户id

    private String menuId;//菜单id

    private SysUserVo sysUser;//用户

    private SysMenuVo sysMenu;//菜单
}