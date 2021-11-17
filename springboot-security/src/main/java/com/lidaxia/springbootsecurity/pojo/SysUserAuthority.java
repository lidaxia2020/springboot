package com.lidaxia.springbootsecurity.pojo;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 11:28（
 */
@Entity
@Table(name = "sys_user_authority")
@Data
public class SysUserAuthority implements Serializable {
    @Id
    private String userAuthorityId;//用户权限表id

    private String userId;//用户id

    private String authorityId;//权限id

    @OneToOne
    @JoinColumn(name = "userId",referencedColumnName = "userId", insertable = false, updatable = false)
    @NotFound(action= NotFoundAction.IGNORE)
    private SysUser sysUser;//用户

    @OneToOne
    @JoinColumn(name = "authorityId",referencedColumnName = "authorityId", insertable = false, updatable = false)
    @NotFound(action= NotFoundAction.IGNORE)
    private SysAuthority sysAuthority;//权限

}