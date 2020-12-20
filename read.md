读取用户名和密码

Spring Security提供了以下内置机制，用于从中读取用户名和密码HttpServletRequest：

表格登入

基本认证

摘要式身份验证

储存机制

用于读取用户名和密码的每种受支持的机制都可以利用任何受支持的存储机制：

具有内存内认证的简单存储

具有JDBC身份验证的关系数据库

使用UserDetailsS​​ervice的自定义数据存储

具有LDAP认证的LDAP存储