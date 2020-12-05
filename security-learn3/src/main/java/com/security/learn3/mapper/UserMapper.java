package com.security.learn3.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.security.learn3.dto.UserDto;
import com.security.learn3.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/23 23:28
 */
public interface UserMapper extends BaseMapper<User> {

    UserDto getRolesByUsername(@Param("username") String username);

}
