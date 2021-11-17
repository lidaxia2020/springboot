package com.lidaxia.springbootsecurity.service.impl;

import com.lidaxia.common.restResult.RestResult;
import com.lidaxia.common.restResult.ResultGenerator;
import com.lidaxia.common.utils.CopyUtil;
import com.lidaxia.springbootsecurity.common.CommonServiceImpl;
import com.lidaxia.springbootsecurity.pojo.SysShortcutMenu;
import com.lidaxia.springbootsecurity.repository.SysShortcutMenuRepository;
import com.lidaxia.springbootsecurity.service.SysShortcutMenuService;
import com.lidaxia.springbootsecurity.vo.SysShortcutMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 9:56（
 */
@Service
@Transactional
public class SysShortcutMenuServiceImpl extends CommonServiceImpl<SysShortcutMenuVo, SysShortcutMenu, String> implements SysShortcutMenuService {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private SysShortcutMenuRepository sysShortcutMenuRepository;

    @Override
    public RestResult<List<SysShortcutMenuVo>> findByUserId(String userId) {
        return ResultGenerator.genSuccessResult(CopyUtil.copyList(sysShortcutMenuRepository.findByUserId(userId), SysShortcutMenuVo.class));
    }
}