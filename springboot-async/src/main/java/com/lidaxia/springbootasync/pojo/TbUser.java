package com.lidaxia.springbootasync.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/5 17:58（
 */
@Entity
@Table(name = "tb_user")
@Data
public class TbUser implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;//表id

    private String username;//用户名

    private String password;//密码

    private Date created;//创建时间

    private Integer descriptionId;//关联详情id
}