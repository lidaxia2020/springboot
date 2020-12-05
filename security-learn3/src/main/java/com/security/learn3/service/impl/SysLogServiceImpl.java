package com.security.learn3.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.security.learn3.config.ApplicationConfig;
import com.security.learn3.dto.SysLogExportDto;
import com.security.learn3.dto.SysLogInputDto;
import com.security.learn3.dto.SysLogOutpDto;
import com.security.learn3.entity.SysLog;
import com.security.learn3.mapper.SysLogMapper;
import com.security.learn3.result.PageParam;
import com.security.learn3.service.SysLogService;
import com.security.learn3.utils.PoiUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/24 0:07
 */
@Slf4j
@Service
@Transactional
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {
    @Resource
    private SysLogMapper sysLogMapper;

    @Resource
    private ApplicationConfig applicationConfig;

    private static final int FIND = 4;
    /**
     * 根据分页、排序信息和检索条件查询 @size 条 字典表数据
     * @param pageParam 分页参数
     * @param inputDTO  查询关键字
     * @return
     */
    @Override
    public List<SysLogOutpDto> list(PageParam pageParam, SysLogInputDto inputDTO) {
//        PageHelper.startPage(pageParam.getPage(), pageParam.getSize(), pageParam.getOrderBy());
        return sysLogMapper.selectLogByQuery(inputDTO);
    }

    /**
     * 保存日志
     * @param sysLog
     */
    @Override
    public void saveLog(SysLog sysLog) {
        //todo 查看不做操作 Log注解上没写注释的也不保存
        Integer operation = sysLog.getOperation();
        if (operation != FIND && operation != 0){
            sysLogMapper.insert(sysLog);
        }
    }


    /**
     * 分页导出日志
     * @param inputDTO
     * @return
     */
    @Override
    public ResponseEntity<byte[]> exportLogList(SysLogInputDto inputDTO) {
        List<SysLogOutpDto> data = sysLogMapper.selectLogByQuery(inputDTO);
        Map<Integer, String> sysLogMap = applicationConfig.getLogOperation();
        List<SysLogExportDto> list = new ArrayList<>();
        Long logId=1L;
        for (SysLogOutpDto sysLog: data) {
            SysLogExportDto exportDTO = new SysLogExportDto();
            exportDTO.setId(logId);
            logId+=1L;
            exportDTO.setOperation(sysLogMap.get(sysLog.getOperation()));
            exportDTO.setUsername(sysLog.getUsername());
            exportDTO.setLogDesc(sysLog.getLogDesc());
            exportDTO.setCreateTime(sysLog.getCreateTime());
            list.add(exportDTO);
        }
        String[] headers = {"序号","操作类型","操作者","操作详情","操作时间"};
        PoiUtils poiUtils = new PoiUtils("日志列表", "日志导出模板.xls");
        poiUtils.setHeaders(headers, "日志列表");

        // 为excel表生成数据
        poiUtils.fillDataAndStyle(list,2);
        // 将内容返回响应
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            poiUtils.getWorkbook().write(bos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        // 文件名
        String filename = "日志列表";
        try {
            filename = new String(filename.getBytes("gbk"), "iso8859-1");
        } catch (UnsupportedEncodingException e) {
            log.warn("不支持编码格式");
            e.printStackTrace();

        }
        // 设置http响应头
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Disposition", "attachment;filename=" + filename + ".xls");

        return new ResponseEntity<byte[]>(bos.toByteArray(), header, HttpStatus.CREATED);
    }


}
