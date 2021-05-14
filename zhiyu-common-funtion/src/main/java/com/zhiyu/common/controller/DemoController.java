package com.zhiyu.common.controller;

import com.zhiyu.common.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wengzhiyu
 * @since 2021/5/14 15:22
 */
@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {

    @Autowired
    private DemoService demoService;


    @GetMapping("/async")
    public void demoAsync() {
        demoService.async1();
        demoService.async2();
        demoService.async3();
        log.info("《======================================================》");
    }
}
