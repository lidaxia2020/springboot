package com.lidaxia.springbootsecurity.common;

import com.lidaxia.common.restResult.RestResult;
import com.lidaxia.springbootsecurity.common.pojo.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/16 15:41（
 */
public class CommonController<V, E, T> {

    @Resource
    private CommonService<V, E, T> commonService;

    /*
        CRUD、分页、排序测试
     */
    //方便测试暂时改成GetMapping
    @GetMapping("page")
//    @PostMapping("page")
    public RestResult<PageInfo<V>> page(V entityVo) {
        return commonService.page(entityVo);
    }

    //方便测试暂时改成GetMapping
    @GetMapping("list")
//    @PostMapping("list")
    public RestResult<List<V>> list(V entityVo) {
        return commonService.list(entityVo);
    }

    @GetMapping("get/{id}")
    public RestResult<V> get(@PathVariable("id") T id) {
        return commonService.get(id);
    }

    //方便测试暂时改成GetMapping
    @GetMapping("save")
//    @PostMapping("save")
    public RestResult<V> save(V entityVo) {
        return commonService.save(entityVo);
    }

    @GetMapping("delete/{id}")
    public RestResult<T> delete(@PathVariable("id") T id) {
        /*
        批量删除
        @DeleteMapping("deleteBatch")
        public Result<T> deleteBatch(@RequestBody List<String> ids){}
        前端调用：
        $.ajax({
            url: ctx + "deleteBatch",
            type: "DELETE",
            data: JSON.stringify([id1,id2]),
            dataType: "JSON",
            contentType: 'application/json',
            success: function (data) {

            }
        });
         */
        return commonService.delete(id);
    }
}
