package com.lidaxia.common.tree;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/12 10:52（
 */
@FunctionalInterface
public interface FloorConsumer<T, K extends Integer> {

    void accept(T t, Integer tList);

}