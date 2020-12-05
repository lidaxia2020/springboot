package com.security.learn3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/23 23:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleAndMenu implements Serializable {
    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 菜单id
     */
    private Long menuId;


}