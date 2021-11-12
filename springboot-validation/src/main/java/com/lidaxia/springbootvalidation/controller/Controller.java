package com.lidaxia.springbootvalidation.controller;

import com.lidaxia.common.restResult.RestResult;
import com.lidaxia.common.restResult.ResultGenerator;
import com.lidaxia.springbootvalidation.vo.UserVo;
import com.lidaxia.springbootvalidation.vo.UserVoByAdd;
import com.lidaxia.springbootvalidation.vo.UserVoByEdit;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/11 15:43（
 */
@Validated
@RestController
@RequestMapping("/test/")
public class Controller {

    /**
     * 新增用户
     * @param userVo
     * @return
     */
    @RequestMapping("addUser")
    public RestResult addUser(@Validated UserVoByAdd userVo) {
        System.out.println(userVo);
        return ResultGenerator.genSuccessResult();
    }
    /**
     * 编辑用户
     * @param userVo
     * @return
     */
    @RequestMapping("editUser")
    public RestResult editUser(@Validated UserVoByEdit userVo) {
        System.out.println(userVo);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    @RequestMapping("findUserById")
    public RestResult findUserById(@Size(min = 1, max = 5, message = "id超出范围") @NotEmpty(message = "id不能为空") String id) {
        System.out.println(id);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 密码测试    -- 自定义注解
     * @param userVo
     * @return
     */
    @RequestMapping("password")
    public RestResult password(@RequestBody @Validated UserVo userVo) {
        System.out.println(userVo);
        return ResultGenerator.genSuccessResult();
    }
}