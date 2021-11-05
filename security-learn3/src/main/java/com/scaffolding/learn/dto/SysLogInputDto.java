package com.scaffolding.learn.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/23 23:19
 */
@Data
public class SysLogInputDto implements Serializable {

    /**
     * 日志详情
     */
    private String logDesc;

    /**
     * 操作人员
     */
    private String logType;

    /**
     * 操作类型
     */
    private String operation;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;
}
