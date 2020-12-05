package com.security.learn3.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/23 23:17
 */
@Data
public class SysLogExportDto implements Serializable {
    private Long id;

    /**
     * 操作类型： 添加-1 删除-2 更新-3 查看-4
     */
    private String operation;

    /**
     * 操作人员名称
     */
    private String username;

    /**
     * 日志描述
     */
    private String logDesc;

    /**
     * 创建时间
     */
    private Date createTime;

}
