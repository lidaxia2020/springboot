package com.scaffolding.learn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.scaffolding.learn.dto.SysLogExportDto;
import com.scaffolding.learn.dto.SysLogInputDto;
import com.scaffolding.learn.dto.SysLogOutpDto;
import com.scaffolding.learn.entity.SysLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/23 23:26
 */
public interface SysLogMapper extends BaseMapper<SysLog> {
    List<SysLogOutpDto> selectLogByQuery(@Param("dto") SysLogInputDto inputDTO);

    List<SysLogExportDto> exportLogList(@Param("dto") SysLogInputDto inputDTO);
}