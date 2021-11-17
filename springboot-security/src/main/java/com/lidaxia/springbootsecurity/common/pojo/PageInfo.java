package com.lidaxia.springbootsecurity.common.pojo;

import com.lidaxia.common.utils.CopyUtil;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.util.Assert;

import javax.persistence.Query;
import java.util.List;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/16 15:45（
 */
@Data
public class PageInfo<M> {
    /**
     * 当前页码
     */
    private int page;
    /**
     * 页面大小
     */
    private int pageSize;
    /**
     * 排序字段
     */
    private String sidx;
    /**
     * 排序方式
     */
    private String sord;

    /**
     * 分页结果
     */
    private List<M> rows;
    /**
     * 总记录数
     */
    private int records;
    /**
     * 总页数
     */
    private int total;

    /**
     * 获取统一分页对象
     */
    public static <M> PageInfo<M> of(Page page, Class<M> entityModelClass) {
        int records = (int) page.getTotalElements();
        int pageSize = page.getSize();
        int total = records % pageSize == 0 ? records / pageSize : records / pageSize + 1;

        PageInfo<M> pageInfo = new PageInfo<>();
        pageInfo.setPage(page.getNumber() + 1);//页码
        pageInfo.setPageSize(pageSize);//页面大小
        pageInfo.setRows(CopyUtil.copyList(page.getContent(), entityModelClass));//分页结果
        pageInfo.setRecords(records);//总记录数
        pageInfo.setTotal(total);//总页数
        return pageInfo;
    }

    /**
     * 获取JPA的分页对象
     */
    public static Page readPage(Query query, Pageable pageable, Query countQuery) {
        if (pageable.isPaged()) {
            query.setFirstResult((int) pageable.getOffset());
            query.setMaxResults(pageable.getPageSize());
        }
        return PageableExecutionUtils.getPage(query.getResultList(), pageable, () -> executeCountQuery(countQuery));
    }

    private static Long executeCountQuery(Query countQuery) {
        Assert.notNull(countQuery, "TypedQuery must not be null!");

        List<Number> totals = countQuery.getResultList();
        Long total = 0L;
        for (Number number : totals) {
            if (number != null) {
                total += number.longValue();
            }
        }
        return total;
    }
}