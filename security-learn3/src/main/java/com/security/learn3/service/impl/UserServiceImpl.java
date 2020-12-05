package com.security.learn3.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.security.learn3.entity.User;
import com.security.learn3.mapper.UserMapper;
import com.security.learn3.result.PageParam;
import com.security.learn3.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/24 21:23
 */
@Slf4j
@Service
@Transactional
public class UserServiceImpl  extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 根据分页、排序信息和检索条件查询 @size 条 字典表数据
     * @param pageParam 分页参数
     * @param query  查询关键字
     * @return
     */
    @Override
    public List<User> list(PageParam pageParam, String query) {
//        Example example = new Example(User.class);
//        //TODO 设置查询字段
//        //example.or().andLike("name", "%"+query+"%");
//        //example.or().andLike("code", "%"+query+"%");
//
//        PageHelper.startPage(pageParam.getPage(), pageParam.getSize(), pageParam.getOrderBy());
//        return userMapper.selectByExample(example);
        return null;
    }

}
