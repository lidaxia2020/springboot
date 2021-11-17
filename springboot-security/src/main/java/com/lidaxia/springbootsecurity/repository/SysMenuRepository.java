package com.lidaxia.springbootsecurity.repository;

import com.lidaxia.springbootsecurity.common.CommonRepository;
import com.lidaxia.springbootsecurity.pojo.SysMenu;
import org.springframework.stereotype.Repository;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 9:50（
 */
@Repository
public interface SysMenuRepository extends CommonRepository<SysMenu, String> {
}

