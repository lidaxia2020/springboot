package com.lidaxia.springbootjackson.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/11 15:28（
 */
@Data
public class UserVoByMvc implements Serializable {
    private String username;
    private String password;
    private Date createDate;
    private String captcha;
}