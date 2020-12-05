package com.security.learn3.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.security.learn3.dto.SysLogInputDto;
import com.security.learn3.dto.SysLogOutpDto;
import com.security.learn3.entity.SysLog;
import com.security.learn3.result.PageParam;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/24 0:07
 */
public interface SysLogService extends IService<SysLog> {

    /**
     * 根据分页、排序信息和检索条件查询 @size 条 字典表数据
     * @param pageParam 分页参数
     * @param inputDTO  查询关键字
     * @return
     */
    List<SysLogOutpDto> list(PageParam pageParam, SysLogInputDto inputDTO);

    /**
     * 保存日志
     */
    void saveLog(SysLog sysLog);

    /**
     * 分页导出日志
     * @param inputDTO
     * @return
     */
    ResponseEntity<byte[]> exportLogList(SysLogInputDto inputDTO);
}
