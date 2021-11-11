package com.lidaxia.springboottimer.runnable;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/11 15:54（
 */
@Slf4j
public class MyRunnable2 implements Runnable {
    @Override
    public void run() {
        log.info("MyRunnable2  {}",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
