package com.lidaxia.springbootmybatisplus.tbuser.service;

import com.lidaxia.springbootmybatisplus.common.service.CommonServiceImpl;
import com.lidaxia.springbootmybatisplus.tbuser.entity.TbUser;
import com.lidaxia.springbootmybatisplus.tbuser.entity.TbUserVo;
import com.lidaxia.springbootmybatisplus.tbuser.mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author huanzi-qch
 * @since 2020-08-25
 */
@Service
public class TbUserServiceImpl  extends CommonServiceImpl<TbUserVo, TbUser> implements TbUserService {

    @Autowired
    private TbUserMapper tbuserMapper;
}
