package com.scaffolding.learn.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.Date;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/23 23:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value="MenuRight",description="权限实体类")
public class MenuRight implements Serializable {

    @ApiModelProperty(value="权限主键ID",name="id")
    private Long id;


    @ApiModelProperty(value="父ID",name="parentId")
    private Long parentId;

    @ApiModelProperty(value="权限名称",name="name")
    private String name;

    @ApiModelProperty(value="排序",name="seq")
    private Integer seq;

    @ApiModelProperty(value="访问地址",name="url")
    private String url;

    @ApiModelProperty(value="是否启用 ",name="status",example = "1-启用,0-禁用")
    private Integer status;

    @ApiModelProperty(value="图标样式",name="icon")
    private String icon;

    @ApiModelProperty(value="方法(get、post)",name="method")
    private String method;

    @ApiModelProperty(value="层级",name="grades")
    private Integer grades;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//    @Column(name = "modify_time")
    @ApiModelProperty(value="修改时间",name="modifyTime")
    private Date modifyTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//    @Column(name = "create_time")
    @ApiModelProperty(value="创建时间",name="createTime")
    private Date createTime;
}