package com.lidaxia.springbootsecurity.pojo;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 11:35（
 */
@Entity
@Table(name = "sys_user_menu")
@Data
public class SysUserMenu implements Serializable {
    @Id
    private String userMenuId;//用户菜单表id

    private String userId;//用户id

    private String menuId;//菜单id

    @OneToOne
    @JoinColumn(name = "userId",referencedColumnName = "userId", insertable = false, updatable = false)
    @NotFound(action= NotFoundAction.IGNORE)
    private SysUser sysUser;//用户

    @OneToOne
    @JoinColumn(name = "menuId",referencedColumnName = "menuId", insertable = false, updatable = false)
    @NotFound(action= NotFoundAction.IGNORE)
    private SysMenu sysMenu;//菜单
}