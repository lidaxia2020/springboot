package com.scaffolding.learn.config;

import java.util.Map;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/24 19:46
 */
public interface IApplicationConfig {
    String getOrigins();
    Map<Integer,String> getUserlevel();
}
