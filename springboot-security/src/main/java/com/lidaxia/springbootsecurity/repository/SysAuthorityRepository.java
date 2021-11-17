package com.lidaxia.springbootsecurity.repository;

import com.lidaxia.springbootsecurity.common.CommonRepository;
import com.lidaxia.springbootsecurity.pojo.SysAuthority;
import org.springframework.stereotype.Repository;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 9:35（
 */
@Repository
public interface SysAuthorityRepository extends CommonRepository<SysAuthority, String> {
}
