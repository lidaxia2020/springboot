package com.scaffolding.learn.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/23 23:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Table(name = "user_role")
public class UserAndRole implements Serializable {

//    @Column(name = "role_id")
    private Long roleId;

//    @Column(name = "user_id")
    private Long userId;


}