package com.lidaxia.springbootsecurity.common;

import com.lidaxia.common.restResult.RestResult;
import com.lidaxia.springbootsecurity.common.pojo.PageInfo;

import java.util.List;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/16 15:43（
 */
public interface CommonService<V, E,T> {

    RestResult<PageInfo<V>> page(V entityVo);

    RestResult<List<V>> list(V entityVo);

    RestResult<V> get(T id);

    RestResult<V> save(V entityVo);

    RestResult<T> delete(T id);
}
