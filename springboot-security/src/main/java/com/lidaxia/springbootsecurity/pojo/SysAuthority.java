package com.lidaxia.springbootsecurity.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 9:36（
 */
@Entity
@Table(name = "sys_authority")
@Data
public class SysAuthority implements Serializable {
    @Id
    private String authorityId;//权限id

    private String authorityName;//权限名称，ROLE_开头，全大写

    private String authorityRemark;//权限描述

}