package com.zhiyu.controller;

import com.zhiyu.util.ResponseData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wengzhiyu
 * @date 2020/1/14
 */
@RestController
@RequestMapping("web")
public class TestController {


    @GetMapping("hello")
    public ResponseData webTest() {
        return ResponseData.success("hello");
    }
}
