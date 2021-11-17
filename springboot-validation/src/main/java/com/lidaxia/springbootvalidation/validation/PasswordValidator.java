package com.lidaxia.springbootvalidation.validation;

import com.lidaxia.springbootvalidation.vo.UserVo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/12 9:35（
 */
public class PasswordValidator implements ConstraintValidator<PasswordEqual, UserVo> {

    @Override
    public boolean isValid(UserVo value, ConstraintValidatorContext context) {
        String password1 = value.getPassword1();
        String password2 = value.getPassword2();
        // 这里只是做示例用，所以简单实用了equals进行对比，实际使用可以根据业务要求做更多拓展
        boolean match = password1.equals(password2);
        return match;

    }
}
