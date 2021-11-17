package com.lidaxia.springbootsecurity.service.impl;

import com.lidaxia.springbootsecurity.common.CommonServiceImpl;
import com.lidaxia.springbootsecurity.pojo.SysMenu;
import com.lidaxia.springbootsecurity.repository.SysMenuRepository;
import com.lidaxia.springbootsecurity.service.SysMenuService;
import com.lidaxia.springbootsecurity.vo.SysMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 9:47（
 */
@Service
@Transactional
public class SysMenuServiceImpl extends CommonServiceImpl<SysMenuVo, SysMenu, String> implements SysMenuService {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private SysMenuRepository sysMenuRepository;
}
