package com.scaffolding.learn.dto;

import com.scaffolding.learn.entity.MenuRight;
import com.scaffolding.learn.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/23 23:15
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LoginUserDto implements Serializable {
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String actualName;

    /**
     * 性别: 0-男，1-女
     */
    private Integer sex;

    /**
     * email
     */
    private String email;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 职称
     */
    private String postName;

    /**
     * 状态: 0-禁用，1-启用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 角色列表
     */
    private List<Role> roles;

    /**
     * 权限菜单
     */
    private List<MenuRight> menus;


    public static LoginUserDto user2LoginUserDto(UserDto userDto) {
        return LoginUserDto.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .actualName(userDto.getActualName())
                .sex(userDto.getSex())
                .phone(userDto.getPhone())
                .email(userDto.getEmail())
                .address(userDto.getAddress())
                .postName(userDto.getPostName())
                .status(userDto.getStatus())
                .createTime(userDto.getCreateTime())
                .modifyTime(userDto.getModifyTime())
                .roles(userDto.getRoles())
                .menus(userDto.getMenus())
                .build();
    }

}
