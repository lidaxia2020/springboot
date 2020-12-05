package com.security.learn3.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/23 23:57
 */
@Data
public class SysLogOutpDto implements Serializable {

    private Long id;

    /**
     * 日志类型  根据系统模块来定义日志类型
     */
    private Integer logType;

    /**
     * 操作类型： 添加-1 删除-2 更新-3 查看-4
     */
    private Integer operation;

    /**
     * 操作人员ID
     */
    private String logUser;

    /**
     * 操作人员名称
     */
    private String username;

    /**
     * 访问IP
     */
    private String logIp;

    /**
     * 请求方法
     */
    private String logMethod;

    /**
     * 请求参数
     */
    private String logParams;

    /**
     * 日志描述
     */
    private String logDesc;

    /**
     * 响应时间
     */
    private Long logTime;

    /**
     * 异常码
     */
    private String exceptionCode;

    /**
     * 异常描述
     */
    private String exceptionDetail;

    /**
     * 创建时间
     */
    private Date createTime;

}
