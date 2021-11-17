package com.lidaxia.springbootjackson.vo;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/11 15:28（
 */
@Data
public class UserVoByJson {

    /**
     * 序列化、反序列化时，属性的名称
     */
    @JsonProperty("userName")
    private String username;

    /**
     * 为反序列化期间要接受的属性定义一个或多个替代名称，可以与@JsonProperty一起使用
     */
    @JsonAlias({"pass_word", "passWord"})
    @JsonProperty("pwd")
    private String password;

    /**
     * 序列化、反序列化时，格式化时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    /**
     * 序列化、反序列化忽略属性
     */
    @JsonIgnore
    private String captcha;

}