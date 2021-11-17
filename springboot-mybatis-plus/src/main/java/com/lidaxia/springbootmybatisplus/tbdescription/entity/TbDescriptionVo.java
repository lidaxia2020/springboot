package com.lidaxia.springbootmybatisplus.tbdescription.entity;


import com.lidaxia.springbootmybatisplus.common.entity.PageCondition;
import lombok.Data;

/**
 * <p>
 * 用户描述表
 * </p>
 *
 * @author huanzi-qch
 * @since 2020-08-25
 */
@Data
public class TbDescriptionVo extends PageCondition {
    private Integer id;
    private Integer userId;
    private String description;
}
