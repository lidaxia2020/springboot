package com.lidaxia.springbootsecurity.repository;

import com.lidaxia.springbootsecurity.common.CommonRepository;
import com.lidaxia.springbootsecurity.pojo.SysUserMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 11:33（
 */
@Repository
public interface SysUserMenuRepository extends CommonRepository<SysUserMenu, String> {
    List<SysUserMenu> findByUserId(String userId);
}
