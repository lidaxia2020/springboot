package com.scaffolding.learn.enums;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/24 21:20
 */
/**
 * 常量
 */
public interface  Constant {

    /**
     * 时间格式化
     */
    String DATE_FORMATTER_TIME = "YYYY-MM-dd HH:mm:ss";
    String DATE_FORMATTER_DATE = "YYYY-MM-dd";

    /**
     * 公共状态： 启用、未启用
     */
    int STATUS_ENABLE = 1;
    int STATUS_DISABLE = 0;

    /**
     * JWT-token 在 Redis 中保存的key前缀
     */
    String REDIS_JWT_TOKEN_KEY_PREFIX = "security:jwt:token:";

    /**
     * JWT-refresh-token 在 Redis 中保存的key前缀
     */
    String REDIS_JWT_REFRESH_TOKEN_KEY_PREFIX = "security:jwt:refresh-token:";

}
