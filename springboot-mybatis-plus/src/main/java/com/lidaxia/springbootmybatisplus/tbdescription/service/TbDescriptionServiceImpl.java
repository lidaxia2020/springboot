package com.lidaxia.springbootmybatisplus.tbdescription.service;

import com.lidaxia.springbootmybatisplus.common.service.CommonServiceImpl;
import com.lidaxia.springbootmybatisplus.tbdescription.entity.TbDescription;
import com.lidaxia.springbootmybatisplus.tbdescription.entity.TbDescriptionVo;
import com.lidaxia.springbootmybatisplus.tbdescription.mapper.TbDescriptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户描述表 服务实现类
 * </p>
 *
 * @author huanzi-qch
 * @since 2020-08-25
 */
@Service
public class TbDescriptionServiceImpl  extends CommonServiceImpl<TbDescriptionVo, TbDescription> implements TbDescriptionService {

    @Autowired
    private TbDescriptionMapper tbdescriptionMapper;
}
