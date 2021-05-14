package com.zhiyu.common.service.impl;

import com.zhiyu.common.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author wengzhiyu
 * @since 2021/5/14 15:24
 */
@Service
@Slf4j
public class DemoServiceImpl implements DemoService {

    @Override
    @Async
    public void async1() {
        log.info("runIn----async1-->"+Thread.currentThread().getName());
    }

    @Override
    @Async
    public void async2() {
        log.info("runIn----async2-->"+Thread.currentThread().getName());
    }

    @Override
    @Async
    public void async3() {
        log.info("runIn----async3-->"+Thread.currentThread().getName());
    }
}
