package com.scaffolding.learn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scaffolding.learn.entity.User;
import com.scaffolding.learn.result.PageParam;

import java.util.List;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/24 21:23
 */
public interface UserService extends IService<User> {

    /**
     * 根据分页、排序信息和检索条件查询 @size 条 字典表数据
     * @param pageParam 分页参数
     * @param query  查询关键字
     * @return
     */
    List<User> list(PageParam pageParam, String query);

}
