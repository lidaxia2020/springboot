package com.lidaxia.springbootsecurity.repository;

import com.lidaxia.springbootsecurity.common.CommonRepository;
import com.lidaxia.springbootsecurity.pojo.SysShortcutMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 9:57（
 */
@Repository
public interface SysShortcutMenuRepository extends CommonRepository<SysShortcutMenu, String> {
    List<SysShortcutMenu> findByUserId(String userId);
}
