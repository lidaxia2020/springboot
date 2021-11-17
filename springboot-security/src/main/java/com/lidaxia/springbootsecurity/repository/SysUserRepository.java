package com.lidaxia.springbootsecurity.repository;

import com.lidaxia.springbootsecurity.common.CommonRepository;
import com.lidaxia.springbootsecurity.pojo.SysUser;
import org.springframework.stereotype.Repository;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 11:22（
 */
@Repository
public interface SysUserRepository extends CommonRepository<SysUser, String> {
    SysUser findByLoginName(String username);
}