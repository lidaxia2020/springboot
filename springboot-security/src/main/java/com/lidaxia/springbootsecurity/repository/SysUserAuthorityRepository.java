package com.lidaxia.springbootsecurity.repository;

import com.lidaxia.springbootsecurity.common.CommonRepository;
import com.lidaxia.springbootsecurity.pojo.SysUserAuthority;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 11:28（
 */
@Repository
public interface SysUserAuthorityRepository extends CommonRepository<SysUserAuthority, String> {
    List<SysUserAuthority> findByUserId(String userId);
}