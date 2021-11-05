package com.scaffolding.learn.result;

import com.scaffolding.learn.utils.CoreUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/24 21:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageParam {

    /**
     * 当前页码
     */
    private Integer page = 1;

    /**
     * 每页尺寸
     */
    private Integer size = 10;

    /**
     * 排序字段，默认使用ID来排序
     */
    private String sortField = "id";

    /**
     * 排序方式，默认升序
     */
    private String sortOrder = "DESC";

    public String getOrderBy(){
        return CoreUtils.getOrderBy(sortField, sortOrder);
    }

}
