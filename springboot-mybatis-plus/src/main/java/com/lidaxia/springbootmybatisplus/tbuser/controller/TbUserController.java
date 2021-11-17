package com.lidaxia.springbootmybatisplus.tbuser.controller;

import com.lidaxia.springbootmybatisplus.common.controller.CommonController;
import com.lidaxia.springbootmybatisplus.tbuser.entity.TbUser;
import com.lidaxia.springbootmybatisplus.tbuser.entity.TbUserVo;
import com.lidaxia.springbootmybatisplus.tbuser.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author huanzi-qch
 * @since 2020-08-25
 */
@RestController
@RequestMapping("/tbUser/")
public class TbUserController extends CommonController<TbUserVo, TbUser> {

    @Autowired
    private TbUserService tbUserService;

}