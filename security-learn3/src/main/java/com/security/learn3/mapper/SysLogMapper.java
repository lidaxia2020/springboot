package com.security.learn3.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.security.learn3.dto.SysLogExportDto;
import com.security.learn3.dto.SysLogInputDto;
import com.security.learn3.dto.SysLogOutpDto;
import com.security.learn3.entity.SysLog;
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