package com.lidaxia.springbootasync.service;

import java.util.concurrent.Future;

/**
 * @author lijiannan
 * @desc
 * @date 2021/11/5 17:59（
 */

public interface TestService {
    /**
     * 异步调用，无返回值
     */
    void asyncTask();

    /**
     * 异步调用，有返回值
     */
    Future<String> asyncTask(String s);

    /**
     * 异步调用，无返回值，事务测试
     */
    void asyncTaskForTransaction(Boolean exFlag);
}
