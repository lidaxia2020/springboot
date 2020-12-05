package com.security.learn3.config.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.security.learn3.dto.LoginUserDto;
import com.security.learn3.dto.UserDto;
import com.security.learn3.entity.MenuRight;
import com.security.learn3.entity.Role;
import com.security.learn3.mapper.MenuRightMapper;
import com.security.learn3.mapper.RoleMapper;
import com.security.learn3.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/23 22:20
 */
@Component("securityUserService")
public class SecurityUserService implements UserDetailsService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private MenuRightMapper menuRightMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDto userDto = userMapper.getRolesByUsername(username);
        // 默认用户ID为1的为管理员
        if (null != userDto){
            if(1L == userDto.getId()) {
                this.getAdminPermission(userDto);
            }
            SecurityUser securityUser = new SecurityUser(LoginUserDto.user2LoginUserDto(userDto));
            return securityUser;
        } else {
            throw new UsernameNotFoundException(username + " 用户不存在!");
        }
    }

    /**
     * 为管理员赋所有权限
     * @param userDTO
     * @return
     */
    private UserDto getAdminPermission(UserDto userDTO) {
        List<Role> roles = roleMapper.selectList(new QueryWrapper<>());
        List<MenuRight> menuRights = menuRightMapper.selectList(new QueryWrapper<>());
        userDTO.setRoles(roles);
        userDTO.setMenus(menuRights);
        return userDTO;
    }
}
