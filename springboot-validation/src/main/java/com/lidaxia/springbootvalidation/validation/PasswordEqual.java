package com.lidaxia.springbootvalidation.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/12 9:32（
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = PasswordValidator.class)
public @interface PasswordEqual {


    /**
     * 校验未通过时的返回信息
     */
    String message() default "passwords are not equal";

    /**
     * 以下两行为固定模板
     */
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
