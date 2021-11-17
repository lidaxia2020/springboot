package com.lidaxia.springbootmybatisplus.tbuser.mapper;

import com.lidaxia.springbootmybatisplus.common.mapper.CommonMapper;
import com.lidaxia.springbootmybatisplus.tbuser.entity.TbUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author huanzi-qch
 * @since 2020-08-25
 */
@Mapper
public interface TbUserMapper extends CommonMapper<TbUser> {

}

