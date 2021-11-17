package com.lidaxia.springbootmybatisplus.tbdescription.controller;

import com.lidaxia.springbootmybatisplus.common.controller.CommonController;
import com.lidaxia.springbootmybatisplus.tbdescription.entity.TbDescription;
import com.lidaxia.springbootmybatisplus.tbdescription.entity.TbDescriptionVo;
import com.lidaxia.springbootmybatisplus.tbdescription.service.TbDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户描述表 前端控制器
 * </p>
 *
 * @author huanzi-qch
 * @since 2020-08-25
 */
@RestController
@RequestMapping("/tbDescription/")
public class TbDescriptionController extends CommonController<TbDescriptionVo, TbDescription> {

    @Autowired
    private TbDescriptionService tbDescriptionService;

}