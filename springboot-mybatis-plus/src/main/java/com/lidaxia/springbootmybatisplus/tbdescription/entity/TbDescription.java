package com.lidaxia.springbootmybatisplus.tbdescription.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户描述表
 * </p>
 *
 * @author huanzi-qch
 * @since 2020-08-25
 */
@Data
public class TbDescription {

    /**
     * 表id
     */
    //主键生成策略自动递增：type = IdType.AUTO，指定id回显
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户描述
     */
    private String description;
}
