- 要想使用Spring Security框架，配置类需要继承WebSecurityConfigurerAdapter类，并通过注解@EnableWebSecurity来启用Spring Security
- 查询用户信息并封装成认证用户对象的过程是在UserDetailsService接口的实现类（需要用户自己实现）中完成的


# 自定义用户认证逻辑
- 继承UserDetailsService 接口，实现loadUserByUsername()方法
- 通过UserDetails 的4个Boolean 可实现冻结删除账号等逻辑
- 加密认证，继承PasswordEncoder 接口

# 个性化用户认证流程
- 自定义登录成功页面
- 自定义登录成功处理
- 自定义登录失败处理