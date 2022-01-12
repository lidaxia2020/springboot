package com.lidaxia.springbootcsv;

import java.lang.annotation.*;

/**
 * @author lidaxia
 * @desc
 * @date 2022/1/12 11:22（
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface CsvField {
    /**
     * 字段的标题
     * @return
     */
    String value() default "";

    /**
     * 是否忽略此字段
     * @return
     */
    boolean ignore() default false;

    /**
     * 转换器，按需生成结果
     * @return
     */
    Class<? extends CsvConvertHandler> using() default CsvConvertHandler.None.class;
}