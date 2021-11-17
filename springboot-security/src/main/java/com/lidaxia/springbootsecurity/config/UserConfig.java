package com.lidaxia.springbootsecurity.config;

import com.lidaxia.springbootsecurity.service.SysUserAuthorityService;
import com.lidaxia.springbootsecurity.service.SysUserService;
import com.lidaxia.springbootsecurity.vo.SysUserAuthorityVo;
import com.lidaxia.springbootsecurity.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/16 15:04（
 */
@Component
public class UserConfig implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserAuthorityService sysUserAuthorityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户
        SysUserVo sysUserVo = sysUserService.findByLoginName(username).getData();
        //查询权限
        List<SysUserAuthorityVo> sysUserAuthorityVoList = sysUserAuthorityService.findByUserId(sysUserVo.getUserId()).getData();
        StringBuilder authoritys = new StringBuilder();
        for (int i = 0; i < sysUserAuthorityVoList.size(); i++) {
            SysUserAuthorityVo sysUserAuthorityVo = sysUserAuthorityVoList.get(i);
            authoritys.append(sysUserAuthorityVo.getSysAuthority().getAuthorityName());
            if (i != sysUserAuthorityVoList.size() - 1) {
                authoritys.append(",");
            }
        }
        // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
        return new User(sysUserVo.getLoginName(), sysUserVo.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList(authoritys.toString()));
    }
}