package com.lidaxia.common.tree;

import java.util.List;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/12 10:52（
 */
@FunctionalInterface
public interface Consumer<T> {

    void accept(T t, List<T> tList);

}