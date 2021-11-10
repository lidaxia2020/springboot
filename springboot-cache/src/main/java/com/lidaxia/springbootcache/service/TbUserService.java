package com.lidaxia.springbootcache.service;

import com.lidaxia.springbootcache.pojo.TbUser;

import java.util.List;

public interface TbUserService {
    List<TbUser> list(TbUser entityVo);

    TbUser get(Integer id);

    TbUser save(TbUser entityVo);

    Integer delete(Integer id);
}